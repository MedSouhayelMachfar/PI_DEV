package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import utils.SceneManager;

public class ParametreController implements Initializable  {
	
	@FXML
	private Button button_back;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		button_back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SceneManager.changeScene(event, "home.fxml", "Login", null);
			}
		});
	}
}
