package controller;

import entity.Event;

import entity.User;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.AuthService;
import service.EventDAOImp;
import utils.AlertModal;
import utils.SceneManager;

public class addEventeController implements Initializable {

    
    @FXML
    private Button back_Home;

    @FXML
    private TextField nameEvent;

    @FXML
    private TextField nb_participant;

    @FXML
    private TextField tanche_Age;

    @FXML
    private TextField nbReservation;

    @FXML
    private TextField despEvent;

    @FXML
    private DatePicker date_debut;

    @FXML
    private DatePicker date_Fin;

        @FXML
    private TextField adresseEvent;
    
    @FXML
    private Button ajoute_Event;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        back_Home.setOnAction((ActionEvent event) -> {
            SceneManager.changeScene(event, "Bib.fxml", "Bibliotheque", null);
        });

        ajoute_Event.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)  {
                if (nameEvent.getText().trim().isEmpty() || nb_participant.getText().trim().isEmpty() || despEvent.getText().trim().isEmpty()
                        || tanche_Age.getText().trim().isEmpty() || nbReservation.getText().trim().isEmpty() || adresseEvent.getText().trim().isEmpty()) {
                    AlertModal.showErrorAlert(null, "Please fill in all information to add event!");
                } else {
                    {
                        try {
                        Event e;
                        e = new Event.EventBuilder().eventName(nameEvent.getText()).eventStartDate( Date.valueOf(date_debut.getValue())).eventEndDate( Date.valueOf(date_Fin.getValue())).eventAgeRange(tanche_Age.getText()).eventAddress(adresseEvent.getText())
                                .eventMaxNumberParticipant (Integer.parseInt(nb_participant.getText())).eventNumberReservation(Integer.parseInt(nbReservation.getText())).eventDescription(despEvent.getText()).userId(AuthService.loggedInUser.getUserId()).build();
                        
                        
                        EventDAOImp eventService = new EventDAOImp();


                            eventService.insert(e);
                        } catch (SQLException e) {
                            			e.printStackTrace();

                             
                        }
                        
                        
                        AlertModal.showInfoAlert("! evenement ajouté avec succès ", "   evenement ajouté avec succès!");
                       
                    }
               }
           }

        });
    }

}
