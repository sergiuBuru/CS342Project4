import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ControllerClient implements Initializable {
	private Client client;
	
	private GameInfo game;
	
	@FXML
	private VBox root;
	
	@FXML
	private VBox root2;
	
	@FXML
	private VBox root3;
	
	@FXML
	private VBox root4;
	
	@FXML
	private TextField clientIPText;
	
	@FXML
	private TextField clientPortText;
	
	@FXML
	private Button clientStartButton;
	
	@FXML
	private Button categoryOneButton;
	
	@FXML
	private Button categoryTwoButton;
	
	@FXML
	private Button categoryThreeButton;
	
	@FXML
	private Button categorySelect;
	
	@FXML
	private TextField letterGuess;
	
	@FXML
	private Text guessCountText;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        
	}
	
	//Helps when switching between scenes
	public void setGameInfo(GameInfo g) {
		game = g;
	}
	public void setClient(Client c) {
		client = c;
	}
	
	//Starting scene for the client. Will move to the category scene
	public void startClient(ActionEvent e) throws IOException  {
		//Create the client instance and start it
		client = new Client(clientIPText.getText(), Integer.parseInt(clientPortText.getText()));
		//Create the serializable game info data
		game = new GameInfo();
		
		System.out.println("Start Client pressed");
		//get instance of the loader class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/categorySelect.fxml"));
        Parent root2 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader   
        //pass the game info and client
        myctr.setGameInfo(game);
        myctr.setClient(client);
        
        root2.getStylesheets().add("/styles/categorySelect.css");//set style      
        root.getScene().setRoot(root2);//update scene graph
        
        client.start();
	}
	
	//Client presses the countries button. Moves to game scene
	public void countriesCategory(ActionEvent e) throws IOException {
		System.out.print("Selected category 1");
		
		//Set the category to countries and the client
		game.setCategory("countries");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/wordGuess.fxml"));
        Parent root3 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        
        //Send the data from the client to the server
        client.send(game);
        //Set the client for the next scene
        myctr.setClient(client);
        
        root3.getStylesheets().add("/styles/wordGuess.css");//set style      
        root2.getScene().setRoot(root3);//update scene graph
	}
	
	//Client presses the presidents button. Moves to game scene
	public void presidentsCategory(ActionEvent e) throws IOException {
		System.out.print("Selected category 2");
		
		//Set the category to presidents
		game.setCategory("presidents");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/wordGuess.fxml"));
        Parent root3 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        
        //Send the data from the client to the server
        client.send(game);
        //Set the client for the next scene
        myctr.setClient(client);
        
        root3.getStylesheets().add("/styles/wordGuess.css");//set style      
        root2.getScene().setRoot(root3);//update scene graph
	}
	
	//Client presses the princesses button. Moves to game scene
	public void princessesCategory(ActionEvent e) throws IOException {
		System.out.print("Selected category 3");
		
		//Set the category to princesses
		game.setCategory("princesses");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/wordGuess.fxml"));
        Parent root3 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        
        //Send the data from the client to the server
        client.send(game);
        //Set the client for the next scene
        myctr.setClient(client);
        
        root3.getStylesheets().add("/styles/wordGuess.css");//set style      
        root2.getScene().setRoot(root3);//update scene graph
	}
	
	//When the client is in the game scene and wants to go back to category scene
	public void categorySelect(ActionEvent e) throws IOException {
		System.out.print("Back to selected category");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/categorySelect.fxml"));
        Parent root2 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root2.getStylesheets().add("/styles/wordGuess.css");//set style      
        root3.getScene().setRoot(root2);//update scene graph
	}
	
	//Client enters a letter then presses the send button
	public void submitLetterGuess(ActionEvent e) throws IOException {
		System.out.print("Selected submit letter guess");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/gameOver.fxml"));
        Parent root4 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root4.getStylesheets().add("/styles/wordGuess.css");//set style      
        root3.getScene().setRoot(root4);//update scene graph
	}
	
	//Player choses to play again
	public void playAgain(ActionEvent e) throws IOException {
		System.out.print("Selected play again");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/categorySelect.fxml"));
        Parent root2 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root2.getStylesheets().add("/styles/wordGuess.css");//set style      
        root4.getScene().setRoot(root2);//update scene graph
	}
	
	public void quitGame(ActionEvent e) throws IOException {
		System.out.print("Selected quit game");
		System.exit(1);
	}
}
