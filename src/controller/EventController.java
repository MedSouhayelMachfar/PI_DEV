/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import service.EventDAOImp;
import utils.AlertModal;
import utils.SceneManager;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EventController implements Initializable {
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
    private TextField filterFiled;

    @FXML
    private TableColumn<Event, Event> action;
    @FXML
    private TableColumn<Event, String> eventName;
    @FXML

    private TableView<Event> TableEventList;
    Event eventselected;

    ObservableList<Event> listEvent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         //add Melek
        addEvent.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.changeScene(event, "ajouteEvent.fxml", "ADDEvent", null);
            }
        });
        buildTableAndData();
    }    
     private void buildTableAndData() {
        //add melek
        EventDAOImp e1 = new EventDAOImp();
        eventName.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        dateDebut.setCellValueFactory(new PropertyValueFactory<>("eventStartDate"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("eventEndDate"));
        TrancheAge.setCellValueFactory(new PropertyValueFactory<>("eventAgeRange"));
        adresseEvent.setCellValueFactory(new PropertyValueFactory<>("eventAddress"));
  

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

        TableEventList.setItems(FXCollections.observableArrayList(listEvent));

        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Event> filteredData = new FilteredList<>(listEvent, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterFiled.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(event -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (event.getEventName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                }
            else if (event.getEventAddress().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(event.getEventAgeRange()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
        });
    }
    );
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Event> sortedData = new SortedList<>(filteredData);

    // 4. Bind the SortedList comparator to the TableView comparator.
    // 	  Otherwise, sorting the TableView would have no effect.
    sortedData.comparatorProperty ()

    .bind(TableEventList.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
    TableEventList.setItems (sortedData);

    Callback<TableColumn<Event, Event>, TableCell<Event, Event>> cellFactory = new Callback<TableColumn<Event, Event>, TableCell<Event, Event>>() {
        @Override
        public TableCell call(final TableColumn<Event, Event> param) {
            final TableCell<Event, Event> cell = new TableCell<Event, Event>() {

                @Override
                public void updateItem(Event item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        final Button editBtn = new Button("UPDATE");
                        final Button dltBtn = new Button("DELETE");
                        editBtn.setOnAction(event -> {
                             SceneManager.changeScene(event, "updateEvent.fxml", "UpdateEvent", null);
                           //  saveButton.setText("UPDATE");
                            //  selectedRegisterModel = getTableView().getItems().get(getIndex());
                            //  usernameField.setText( selectedRegisterModel.getUsername());
                            //  passwordField.setText( selectedRegisterModel.getPassword());
                            //  System.out.println("selected"+ selectedRegisterModel.getId()+ selectedRegisterModel.getRegisterModelname());

                        });
                        dltBtn.setOnAction(event -> {
                            try {
                                eventselected = getTableView().getItems().get(getIndex());

                                System.out.println("aliiiii" + eventselected);
                                e1.delete(eventselected);
                                TableEventList.setItems(FXCollections.observableArrayList(e1.getAll()));

                                AlertModal.showErrorAlert(null, "your event is delete!");

                            } catch (SQLException ex) {
                                Logger.getLogger(BibController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });

                        HBox hb = new HBox();
                        hb.setSpacing(2);
                        hb.getChildren().addAll(editBtn, dltBtn);
                        setGraphic(hb);
                        setText(null);
                    }
                }
            };
            return cell;

        }
    };

    action.setCellFactory (cellFactory);

}
}
