
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoggedInController implements Initializable{
	
	@FXML
	private Button button_logout;
	
	@FXML
	private Label label_welcome;
	
	@FXML
	private Label label_content;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		button_logout.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		
	}

	// Sign up
	public static void signUpUser(ActionEvent event, String firstname, String lastname, String email, String password) {

		
	}
}


