import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.control.ListView;


public class Server{

	int count = 1;	
	int port;
	ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	TheServer server;
	private Consumer<Serializable> callback;
	
	Server(int port) {
		this.port = port;
	}
	
	void setConsumer(Consumer<Serializable> call) {
		callback = call;
		callback.accept("Waiting for clients...");
		server = new TheServer();
		server.start();
	}
	
	
	public class TheServer extends Thread{
		
		public void run() {
		    try {
		    	
			ServerSocket mySocket = new ServerSocket(port);
		    System.out.println("Server is waiting for a client!");
		  
			
		    while(true) {
		
				ClientThread c = new ClientThread(mySocket.accept(), count);
				callback.accept("client has connected to server: " + "client #" + count);
				clients.add(c);
				c.start();
				
				count++;
				
			    }
			}//end of try
				catch(Exception e) {
					callback.accept("Server socket did not launch");
				}
			}//end of while
		}
	

		class ClientThread extends Thread{
			
		
			Socket connection;
			int count;
			ObjectInputStream in;
			ObjectOutputStream out;

			private GameInfo info = new GameInfo();
			
			ClientThread(Socket s, int count){
				this.connection = s;
				this.count = count;	
			}
			
			/*
			 * When all clients need to recieve a message
			 */
			public void updateClients(String message) {
				for(int i = 0; i < clients.size(); i++) {
					ClientThread t = clients.get(i);
					try {
					 t.out.writeObject(message);
					}
					catch(Exception e) {}
				}
			}
			
			//send objects to all clients
			
			public void updateClients2(Serializable data) {
				for(int i = 0; i < clients.size(); i++) {
					
					ClientThread t = clients.get(i);
					
					try {
						t.out.writeObject(data);
					}catch(Exception e) {}
				}
			}
			
			public void run(){
					
				try {
					out = new ObjectOutputStream(connection.getOutputStream());
					in = new ObjectInputStream(connection.getInputStream());
					connection.setTcpNoDelay(true);	
					
					out.writeObject(info);
				}
				catch(Exception e) {
					System.out.println("Streams not open");
				}
				
				updateClients("new client on server: client #"+count);
					
				 while(true) {
					    try {
					    	
					    	info = (GameInfo) in.readObject();
					    	
					    	info.checkGuess(info.guessLetter);
					    	
					    	out.writeObject(info);
					    	
					    	}
					    catch(Exception e) {
					    	
					    	callback.accept("Client #" + count + " has left the server");
					    	
					    	updateClients("Client #"+count+" has left the server!");
					    	
					    	clients.remove(this);
					    	break;
					    }
					}
				}//end of run
			
			
		}//end of client thread
}


	
	