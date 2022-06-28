package controller;

import entity.Event;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import service.AuthService;
import service.EventDAOImp;
import utils.AlertModal;
import utils.SceneManager;

public class BibController implements Initializable {

    @FXML
    private Button button_logout;

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
    private Button getmetheuser;
  
 

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        button_logout.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AuthService.logout();
                SceneManager.changeScene(event, "login.fxml", "Login", null);
            }
        });

        button_nav_accueil.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.changeScene(event, "home.fxml", "Forum", null);
            }
        });

        button_nav_notif.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.changeScene(event, "notif.fxml", "Notification", null);
            }
        });

        button_nav_forum.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.changeScene(event, "forum.fxml", "Forum", null);
            }
        });

        getmetheuser.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.changeScene(event, "Event.fxml", "Event", null);
            }
        });

        //add Melek
      
     
    }

   

// Setting user info passed from login screen
public void setUserInformation(int id_user, String first_name, String last_name, String email) {
        label_welcome.setText(last_name);
        System.out.println(AuthService.loggedInUser);
    }
}
