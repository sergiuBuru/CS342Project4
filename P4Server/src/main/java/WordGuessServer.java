import java.io.FileNotFoundException;
import java.util.HashMap;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WordGuessServer extends Application {

	private Button startServer;
	private TextField portText;
	private Label label;
	private ListView<String> listView;
	private HashMap<String, Scene> sceneMap;
	private ObservableList<String> listContents;
	private Server serverConnection;
	private PauseTransition pause = new PauseTransition(Duration.seconds(.75));

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		GameInfo game = new GameInfo();
		game.countries.forEach(c -> System.out.println(c));
		game.presidents.forEach(c -> System.out.println(c));
		game.superheroes.forEach(c -> System.out.println(c));
		
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("(Server) Let's Play Word Guess!");
		
		//Add the 2 scenes to the scene map
		sceneMap = new HashMap<String, Scene>();
		sceneMap.put("start", createStartScene());
		sceneMap.put("info", createInfoScene());
		
		//Add functionality to the start server button
		startServer.setOnAction(e -> pause.play());
		pause.setOnFinished(e -> {
			//Implement action only if the user enters a port #!!!
			if(portText.getText() != null) {
				
				primaryStage.setScene(sceneMap.get("info"));
				primaryStage.setTitle("Game Info Page");
				
				serverConnection = new Server(Integer.parseInt(portText.getText()));
				serverConnection.setConsumer(data -> {
					Platform.runLater(() -> {
						listView.getItems().add(data.toString());
					});
				});
				
			}
		});
		
			
		primaryStage.setScene(sceneMap.get("start"));
		primaryStage.show();
	}
	
	
	
	//Initialize the starting scene and return it
	public Scene createStartScene() {
		
		label = new Label("Enter a port number.");
		portText = new TextField();
	
		startServer = new Button("Start Server");
		
		VBox box = new VBox(70, label, portText, startServer);
		
		box.setAlignment(Pos.CENTER);
		
		return new Scene(box, 500,500);
		
	}
	
	public Scene createInfoScene() {
		
		listView = new ListView<String>();
		listContents = FXCollections.observableArrayList();
		
		VBox box = new VBox(listView);
		
		box.setAlignment(Pos.CENTER);
		
		return new Scene(box,500,500);
	}
	
}