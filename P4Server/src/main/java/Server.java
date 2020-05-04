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
		//callback.accept("Waiting for clients...");
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
				callback.accept("client " + count + " has connected to server");
				count++;
				clients.add(c);
				c.start();
				
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
			GameInfo data;
			
			ClientThread(Socket s, int count){
				this.connection = s;
				this.count = count;	
			}
			
			
			public void run(){
					
				try {
					in = new ObjectInputStream(connection.getInputStream());
					out = new ObjectOutputStream(connection.getOutputStream());
					connection.setTcpNoDelay(true);	
				}
				catch(Exception e) {
					System.out.println("Streams not open");
				}
				
				//updateClients("new client on server: client #"+count);
					
				 while(true) {
					    try {
					    	data = (GameInfo)in.readObject();
					    	
					    	//check if the client sent the category
					    	if(data.getCategory() != "") {
					    		out.writeObject(data);
					    		callback.accept("Client " + count + " picked " + data.getCategory());
					    		data.setCategory("");
					    	}
					    	else if(data.getGuess() != "")//the client guessed a letter. Check it
					    	{
					    		data.checkGuess();
					    		out.writeObject(data);
					    		callback.accept("Client guessed " + data.getGuess());
					    	}

					    	}
					    catch(Exception e) {
					    	//callback.accept("OOOOPPs...Something wrong with the socket from client: " + count + "....closing down!");
					    	e.printStackTrace();
					    	clients.remove(this);
					    	break;
					    }
					}
				}//end of run
			
			
		}//end of client thread
}


	
	