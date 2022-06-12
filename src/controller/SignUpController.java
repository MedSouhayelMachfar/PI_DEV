package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entity.User;
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

public class SignUpController implements Initializable {

	@FXML
	private TextField tf_firstname;

	@FXML
	private TextField tf_lastname;

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

		button_signup.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!tf_firstname.getText().trim().isEmpty() && !tf_lastname.getText().trim().isEmpty()
						&& !tf_email.getText().trim().isEmpty() && !pf_password.getText().trim().isEmpty()) {
					try {
						if (AuthService.signUp(new User(tf_firstname.getText(), tf_lastname.getText(),
								tf_email.getText(), pf_password.getText())) == 2) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("User already exists!");
							alert.show();
						} else {
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setHeaderText("Account has been created!");
							alert.setContentText("You can now login");
							alert.show();
							SceneManager.changeScene(event, "login.fxml", "log in!", "Souhayel", "Machfar");

						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Please fill in all information to sign up!");
					alert.show();

				}
			}
		});

		button_login.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SceneManager.changeScene(event, "login.fxml", "log in!", null, null);
			}
		});

	}

}
