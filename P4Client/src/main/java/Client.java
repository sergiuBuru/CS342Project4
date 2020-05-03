import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread{

	Socket clientSocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	Consumer<Serializable> callback;
	String ip;
	int port;
	GameInfo data;
	
	
	
	Client(String ip, int port){	
		this.ip = ip;
		this.port = port;
	}
	
	public void callBack(Consumer<Serializable> call) {
		callback = call;
	}
	
	public void run() {
		
		try {
			clientSocket= new Socket(ip,port);
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			clientSocket.setTcpNoDelay(true);
			GameInfo temp = new GameInfo();
			out.writeObject(temp);
		}
		catch(Exception e) {}
		
		while(true) {
			 
			try {
			data = (GameInfo)in.readObject();
			callback.accept(data);
			}
			catch(Exception e) {}
		}
	
    }
	
	public void send(String message) {
		
		try {
			out.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
