package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.AuthService;
import utils.SceneManager;

public class LogInController implements Initializable{
	@FXML
	private TextField tf_email;
	
	@FXML
	private PasswordField pf_password;
	
	@FXML
	private Button button_signup;
	
	@FXML
	private Button button_login;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		button_signup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("changing window");
				SceneManager.changeScene(event, "signUp.fxml", "sign up!", null, null);
			}
		});
		
		button_login.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if(AuthService.logInUser(tf_email.getText(), pf_password.getText())) {
						SceneManager.changeScene(event, "loggedIn.fxml", "logged in!", "user", "pass");
					}else {
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("incorrect email or password !");
						alert.show();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
