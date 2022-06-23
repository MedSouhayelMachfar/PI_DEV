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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import service.AuthService;
import service.EventDAOImp;
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
    @FXML
    private Text label_content;
    @FXML
    private Button addEvent;

    @FXML
    private TableColumn<Event, String> TrancheAge;

    @FXML
    private TableColumn<Event, String> adresseEvent;

    @FXML
    private TableColumn<Event, Date> dateDebut;

    @FXML
    private TableColumn<Event, Date> dateFin;

    @FXML
    private TableColumn<Event, String> descp;

    @FXML
    private TableColumn<Event, String> eventName;
    @FXML

    private TableView<Event> TableEventList;

    ObservableList<Event> listEvent;

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
                label_content.setText(AuthService.loggedInUser.toString());
            }
        });

        //add Melek
        addEvent.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.changeScene(event, "ajouteEvent.fxml", "Event", null);
            }
        });
     
        
            
             //add melek
        EventDAOImp e1 = new EventDAOImp();
            List<Event> list = new ArrayList<>();
            try {
                list = e1.getAll();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            listEvent = FXCollections.observableArrayList(list);
            System.out.println(list);

            eventName.setCellValueFactory(new PropertyValueFactory<>("eventName"));
            dateDebut.setCellValueFactory(new PropertyValueFactory<>("eventStartDate"));
            dateFin.setCellValueFactory(new PropertyValueFactory<>("eventEndDate"));
            TrancheAge.setCellValueFactory(new PropertyValueFactory<>("eventAgeRange"));
            adresseEvent.setCellValueFactory(new PropertyValueFactory<>("eventAddress"));
            descp.setCellValueFactory(new PropertyValueFactory<>("eventDescription"));
           
              TableEventList.setItems(FXCollections.observableArrayList(listEvent));

        

    }

    // Setting user info passed from login screen
    public void setUserInformation(int id_user, String first_name, String last_name, String email) {
        label_welcome.setText(last_name);
        System.out.println(AuthService.loggedInUser);
    }
}
