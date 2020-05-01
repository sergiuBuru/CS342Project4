import java.net.Socket;
import java.util.HashMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WordGuessClient extends Application {
	
	Button b1, b2, b3;
	TextField text1, text2, text3;
	HashMap<String, Scene> sceneMap;
	HBox clientStart;
	BorderPane start;
	Image pic,pic2, pic3, pic4, pic5, pic6;
	ImageView imagePic, imagePic2, imagePic3, imagePic4, imagePic5,imagePic6;
	ListView<String> listItems;
	Client clientConnection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		b1 = new Button("Connect");

		text1 = new TextField();
		text1.setPromptText("Enter port number");
		text3 = new TextField();
		text3.setPromptText("Enter ip address");
		
		
		b1.setOnAction(e-> {primaryStage.setScene(sceneMap.get("game"));
							primaryStage.setTitle("Game Screen");
							
							String ip = text3.getText();
							String port = text1.getText();
							int parsePort = Integer.parseInt(port);
							
							clientConnection = new Client(ip, parsePort);
							clientConnection.start();
							
		});
		
		clientStart = new HBox(20, text3, text1, b1);
		clientStart.setAlignment(Pos.BOTTOM_CENTER);
		
		listItems = new ListView<String>();
		
		
		text2 = new TextField();
		text2.setPromptText("Enter letter");
		
		b3 = new Button("Send Guess");
		  
		
		sceneMap = new HashMap<String, Scene>();
		sceneMap.put("game",  createGameScene());
		sceneMap.put("end", endGameScene());
		
		primaryStage.setTitle("(Client) Let's Play Word Guess!!!");
		
		Scene scene = new Scene(clientStart,500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public Scene createGameScene() {
		
		HBox h1 = new HBox(20);
		h1.setAlignment(Pos.CENTER);
		
		VBox v1 = new VBox(listItems, text2, b3);
		v1.setPrefWidth(200);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(h1);
		pane.setLeft(v1);
		pane.setStyle("-fx-background-color:#000000;");

		return new Scene(pane, 800, 400);
	}
	
	public Scene endGameScene() { 
		
		BorderPane pane = new BorderPane();
	
		return new Scene(pane, 500, 400);
	}

}
