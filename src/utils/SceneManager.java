package utils;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	
	public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, String email) {
		
		Parent root = null;
		fxmlFile = "/view/"+fxmlFile;
		if (username != null && email != null) {
			try {
				FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlFile));
				root = loader.load();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				root = FXMLLoader.load(SceneManager.class.getResource(fxmlFile));
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(title);
		stage.setScene(new Scene(root, 1000, 700));
		stage.show();
	}
	
}
