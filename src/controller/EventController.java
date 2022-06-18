/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.Event;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import sun.util.calendar.LocalGregorianCalendar.Date;


/**
 * FXML Controller class
 *
 * @author user
 */
public class EventController implements Initializable {

    Event e;
    @FXML
    private TextField NomEvent;
    @FXML
    private DatePicker DateEvent;
    @FXML
    private TextField Duree;
    @FXML
    private TextField Tranche_Age;
    @FXML
    private TextField lien_Serveur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
