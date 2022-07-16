package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import service.AuthService;
import utils.SceneManager;

public class HomeController implements Initializable {

	@FXML
	private Menu customMenu;

	@FXML
	private MenuBar menubar;

	@FXML
	private MenuItem item_annonce;

	@FXML
	private MenuItem item_event;

	@FXML
	private MenuItem item_compte;

	@FXML
	private MenuItem item_parametre;

	@FXML
	private MenuItem item_logout;

	@FXML
	private Label label_welcome;

	@FXML
	private Button button_nav_accueil;

	@FXML
	private Button button_nav_bib;

	@FXML
	private Button button_nav_forum;

	@FXML
	private Button button_nav_notif;
        	@FXML
	private Button go_event;
        

	@FXML
	private ComboBox<String> dropdownmenu;

        
        @FXML
	private Menu customMenu2;

	@FXML
	private MenuBar menubar2;

	@FXML
	private MenuItem event;
        
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Hide functionality for simple users
		if(!AuthService.loggedInUser.getRole().equals("admin")) {
			item_annonce.setVisible(false);
			item_event.setVisible(false);
			item_compte.setVisible(false);
		}
		
		customMenu.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String targetElement = event.getTarget().toString();
				if (targetElement.contains("item_annonce")) {
					return;
				}
				if (targetElement.contains("item_event")) {
                                    SceneManager.changeSceneForMenuBar((Stage) menubar.getScene().getWindow(), "gererEvent.fxml",
							"event");

					return;
				}
				if (targetElement.contains("item_compte")) {
					return;
				}
				if (targetElement.contains("item_parametre")) {
					SceneManager.changeSceneForMenuBar((Stage) menubar.getScene().getWindow(), "Parametre.fxml",
							"Login");
					return;
				}
				if (targetElement.contains("item_logout")) {
					AuthService.logout();
					SceneManager.changeSceneForMenuBar((Stage) menubar.getScene().getWindow(), "login.fxml", "Login");
					return;
				}
			}
		});

		button_nav_forum.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SceneManager.changeScene(event, "forum.fxml", "Forum", null);
			}
		});

		button_nav_bib.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	
                            SceneManager.changeScene(event, "bib.fxml", "Bibliotheque", null);
			}
		});

		button_nav_notif.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SceneManager.changeScene(event, "notif.fxml", "Notification", null);
			}
		});
                	go_event.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SceneManager.changeScene(event, "EventListAccueil.fxml", "EventListAccueil", null);
			}
		});
                customMenu2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String targetElement = event.getTarget().toString();
			
				if (targetElement.contains("event")) {
					SceneManager.changeSceneForMenuBar((Stage) menubar2.getScene().getWindow(), "Event.fxml",
							"event");
					return;
				}
			
			}
		});
	}

	// Setting user info passed from login screen
	public void setUserInformation(int id_user, String first_name, String last_name, String email) {
		label_welcome.setText(last_name);
		System.out.println(AuthService.loggedInUser);
	}
}
