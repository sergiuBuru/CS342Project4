import java.io.Serializable;
import java.util.ArrayList;


public class GameInfo {
	
	public ArrayList<ClientInfo> players = new ArrayList<ClientInfo>();
	
	public void addClient(ClientInfo c) {
		players.add(c);
	}
	
	public void removeClient(ClientInfo c) {
		players.remove(c);
	}
	
}
