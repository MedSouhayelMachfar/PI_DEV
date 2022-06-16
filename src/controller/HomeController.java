
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import service.AuthService;
import utils.SceneManager;

public class HomeController implements Initializable {
	
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
				AuthService.logout();
				SceneManager.changeScene(event, "login.fxml", "Login", null);
			}
		});

	}
	
	// Setting user info passed from login screen
	public void setUserInformation(int id_user, String first_name, String last_name, String email) {
		label_welcome.setText("Welcome:  " + first_name+" "+last_name);
		label_content.setText("Email: " + email);
		System.out.println(AuthService.loggedInUser);
	}
}
