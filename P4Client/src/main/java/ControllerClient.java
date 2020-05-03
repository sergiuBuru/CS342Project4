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
	
	public void startClient(ActionEvent e) throws IOException  {
		System.out.println("Start Client pressed");
		//get instance of the loader class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/categorySelect.fxml"));
        Parent root2 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root2.getStylesheets().add("/styles/categorySelect.css");//set style      
        root.getScene().setRoot(root2);//update scene graph
	}
	
	public void categoryOne(ActionEvent e) throws IOException {
		System.out.print("Selected category 1");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/wordGuess.fxml"));
        Parent root3 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root3.getStylesheets().add("/styles/wordGuess.css");//set style      
        root2.getScene().setRoot(root3);//update scene graph
	}
	
	public void categoryTwo(ActionEvent e) throws IOException {
		System.out.print("Selected category 2");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/wordGuess.fxml"));
        Parent root3 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root3.getStylesheets().add("/styles/wordGuess.css");//set style      
        root2.getScene().setRoot(root3);//update scene graph
	}
	
	public void categoryThree(ActionEvent e) throws IOException {
		System.out.print("Selected category 3");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/wordGuess.fxml"));
        Parent root3 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root3.getStylesheets().add("/styles/wordGuess.css");//set style      
        root2.getScene().setRoot(root3);//update scene graph
	}
	
	public void categorySelect(ActionEvent e) throws IOException {
		System.out.print("Selected category select");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/categorySelect.fxml"));
        Parent root2 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root2.getStylesheets().add("/styles/wordGuess.css");//set style      
        root3.getScene().setRoot(root2);//update scene graph
	}
	
	public void submitLetterGuess(ActionEvent e) throws IOException {
		System.out.print("Selected submit letter guess");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/gameOver.fxml"));
        Parent root4 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root4.getStylesheets().add("/styles/wordGuess.css");//set style      
        root3.getScene().setRoot(root4);//update scene graph
	}
	
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
