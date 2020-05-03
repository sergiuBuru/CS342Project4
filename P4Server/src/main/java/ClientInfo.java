import java.io.Serializable;

public class ClientInfo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	public Thread thread;
	public int id;
	public int points;
	public Serializable guessLetter;
	public boolean inGame;
	
	
	ClientInfo(Thread thread, int id) {
		this.thread = thread;
		this.id = id;
	}
	
	public Serializable guessLetter() {
		return guessLetter;
	}
	
	public void setGuessLetter(Serializable letter) {
		this.guessLetter = letter;
		System.out.println("This is a test -> " + this.guessLetter);
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean inGame() {
		return inGame;
	}
	
}
