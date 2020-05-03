
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

public class ControllerServer implements Initializable {

	@FXML
	private VBox root;

	@FXML
	private VBox root2;

	@FXML
	private TextField serverPortText;

	@FXML
	private Button serverStartButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void startServer(ActionEvent e) throws IOException  {
		System.out.println("Start Server pressed");
		//get instance of the loader class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/serverInfo.fxml"));
        Parent root2 = loader.load(); //load view into parent
        ControllerServer myctr = loader.getController();//get controller created by FXMLLoader        
        root2.getStylesheets().add("/styles/serverInfo.css");//set style      
        root.getScene().setRoot(root2);//update scene graph
	}
}