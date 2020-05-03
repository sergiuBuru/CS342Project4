package clientApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WordGuessClient extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/FXML/clientStart.fxml"));
            primaryStage.setTitle("Client");
         Scene s1 = new Scene(root, 800,600);
         s1.getStylesheets().add("/styles/clientStart.css");
            primaryStage.setScene(s1);
            primaryStage.show();
         
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
		/*
		primaryStage.setTitle("(Client) Word Guess!!!");
		
		Scene scene = new Scene(new HBox(),600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		*/
	}

}
