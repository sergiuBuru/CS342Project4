package clientApp;
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
import clientApp.ControllerClient;

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
	private Button letterA, letterB, letterC, letterD, letterE, letterF, letterG, letterH, letterI, letterJ, letterK,
			letterL, letterM;

	@FXML
	private Button letterN, letterO, letterP, letterQ, letterR, letterS, letterT, letterU, letterV, letterW, letterX,
			letterY, letterZ;
	
	@FXML
	private Text lettersGuessedText;
	
	@FXML
	private Text guessCountText;
	
	@FXML
	private Button playAgainButton;
	
	@FXML
	private Button quitButton;
	
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
	
	
	public void letterAMethod (ActionEvent e) throws IOException {
		System.out.print("A");
	}
	

	public void letterBMethod (ActionEvent e) throws IOException {
		System.out.print("B");
	}
	

	public void letterCMethod (ActionEvent e) throws IOException {
		System.out.print("C");
	}
	

	public void letterDMethod (ActionEvent e) throws IOException {
		System.out.print("D");
	}
	

	public void letterEMethod (ActionEvent e) throws IOException {
		System.out.print("E");
	}
	

	public void letterFMethod (ActionEvent e) throws IOException {
		System.out.print("F");
	}
	

	public void letterGMethod (ActionEvent e) throws IOException {
		System.out.print("G");
	}
	

	public void letterHMethod (ActionEvent e) throws IOException {
		System.out.print("H");
	}
	

	public void letterIMethod (ActionEvent e) throws IOException {
		System.out.print("I");
	}
	

	public void letterJMethod (ActionEvent e) throws IOException {
		System.out.print("J");
	}
	

	public void letterKMethod (ActionEvent e) throws IOException {
		System.out.print("K");
	}
	

	public void letterLMethod (ActionEvent e) throws IOException {
		System.out.print("L");
	}
	

	public void letterMMethod (ActionEvent e) throws IOException {
		System.out.print("M");
	}
	

	public void letterNMethod (ActionEvent e) throws IOException {
		System.out.print("N");
	}
	

	public void letterOMethod (ActionEvent e) throws IOException {
		System.out.print("O");
	}
	

	public void letterPMethod (ActionEvent e) throws IOException {
		System.out.print("P");
	}
	

	public void letterQMethod (ActionEvent e) throws IOException {
		System.out.print("Q");
	}
	

	public void letterRMethod (ActionEvent e) throws IOException {
		System.out.print("R");
	}
	

	public void letterSMethod (ActionEvent e) throws IOException {
		System.out.print("S");
	}
	

	public void letterTMethod (ActionEvent e) throws IOException {
		System.out.print("T");
	}
	

	public void letterUMethod (ActionEvent e) throws IOException {
		System.out.print("U");
	}
	

	public void letterVMethod (ActionEvent e) throws IOException {
		System.out.print("V");
	}
	

	public void letterWMethod (ActionEvent e) throws IOException {
		System.out.print("W");
	}
	

	public void letterXMethod (ActionEvent e) throws IOException {
		System.out.print("X");
	}
	

	public void letterYMethod (ActionEvent e) throws IOException {
		System.out.print("Y");
	}
	

	public void letterZMethod (ActionEvent e) throws IOException {
		System.out.print("Z");
	}
	
	public void playAgain(ActionEvent e) throws IOException {
		System.out.print("Selected play again");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/categorySelect.fxml"));
        Parent root2 = loader.load(); //load view into parent
        ControllerClient myctr = loader.getController();//get controller created by FXMLLoader        
        root2.getStylesheets().add("/styles/categorySelect.css");//set style      
        root4.getScene().setRoot(root2);//update scene graph
	}
	
	public void quitGame(ActionEvent e) throws IOException {
		System.out.print("Selected quit game");
		System.exit(1);
	}
}
