
package controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import service.AuthService;
import utils.SceneManager;

public class NotifController implements Initializable {
	
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
    private PieChart pieChart;
        
        
        
        
        
        
        
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                        
                        //for()
    			new PieChart.Data("zzzz",13),
    			new PieChart.Data("Mercy",22),
    			new PieChart.Data("Tracer",15),
    			new PieChart.Data("Widowmaker",10));
                        
    	pieChart.setData(pieChartData);
        pieChart.setStartAngle(90);
        
   

         
        
        
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
				SceneManager.changeScene(event, "home.fxml", "Home", null);
			}
		});
		
		button_nav_bib.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SceneManager.changeScene(event, "bib.fxml", "Bibliotheque", null);
			}
		});
		
		button_nav_forum.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SceneManager.changeScene(event, "forum.fxml", "Forum", null);
			}
		});

	}
	
           
       

                   
	
	
        
        
}
