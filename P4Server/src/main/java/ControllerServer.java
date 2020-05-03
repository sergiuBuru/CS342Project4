
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ControllerServer implements Initializable {
	private Server server;
	@FXML
	private ListView<String> listView = new ListView<String>();
	
	@FXML
	private VBox root;

	@FXML
	private VBox root2;

	@FXML
	private TextField serverPortText = new TextField();

	@FXML
	private Button serverStartButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void updateListView() {
		listView.getItems().add("AAAAAAAAAAA");
	}
	
	public void updateUI(Server server) {
		System.out.println("inside updateUI");
		System.out.println(server.count);
		server.setConsumer(data -> {
			Platform.runLater(() -> {
				listView.getItems().add(data.toString());
			});
        	
        });
	}
	
	public void startServer(ActionEvent e) throws IOException  {
		//Create the server
		System.out.println("inside inside start server");
		server = new Server(Integer.parseInt(serverPortText.getText()));
		System.out.println("Start Server pressed");
		//get instance of the loader class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/serverInfo.fxml"));
        Parent root2 = loader.load(); //load view into parent
        ControllerServer myctr = loader.getController();//get controller created by FXMLLoader        
        root2.getStylesheets().add("/styles/serverInfo.css");//set style      
        root.getScene().setRoot(root2);//update scene graph
       
        //myctr.updateListView();
        
        myctr.updateUI(server);
	}
	
	
	
	
	
	
	
}