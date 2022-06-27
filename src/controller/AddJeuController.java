package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import entity.Jeu;
import service.AuthService;
import service.JeuDAOImpl;
import utils.Datasource;
import utils.SceneManager;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javafx.stage.Stage;

public class AddJeuController implements Initializable {

	@FXML
	private TableView<Jeu> jeu;

	@FXML
	private TableColumn<Jeu, Integer> id;

	@FXML
	private TableColumn<Jeu, String> name;

	@FXML
	private TableColumn<Jeu, String> cat;

	@FXML
	private TableColumn<Jeu, String> picture;

	@FXML
	private Button add;

	@FXML
	private Button upload;

	@FXML
	private Button next;

	@FXML
	private Button afficher;

	@FXML
	private Button update;

	@FXML
	private Button delete;

	@FXML
	private Label lab_url;

	@FXML
	private ComboBox<String> cbcat;

	@FXML
	private ImageView img;

	@FXML
	private TextField nametxt;

	@FXML
	private TextField txt_id;

	@FXML
	private TextField Search;

	@FXML
	private Label label_welcome;
	
	@FXML
    private Button button_logout;

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
	void GoJeux(MouseEvent event) {

	}

	@FXML
	void DeleteJeu(ActionEvent event) {

	}

	@FXML
	void Update(ActionEvent event) {

	}

	ObservableList<Jeu> list;

	public ObservableList<Jeu> data = FXCollections.observableArrayList();
	int index = -1;
	public void setUserInformation(int id_user, String first_name, String last_name, String email) {
		label_welcome.setText(last_name);
		System.out.println(AuthService.loggedInUser);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		label_welcome.setText(AuthService.loggedInUser.getFirstName());

		search();

		next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("test");
				try {
					// FXMLLoader loader=new FXMLLoader();
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("/view/MesJeux.fxml"));
					Parent root = (Parent) loader.load();
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}

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
		
		button_nav_bib.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SceneManager.changeScene(event, "AddJeu.fxml", "Jeu", null);
			}
		});
		
		button_logout.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				AuthService.logout();
				SceneManager.changeScene(event, "login.fxml", "Login", null);
			}
		});
		update.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int id = Integer.parseInt(txt_id.getText());
				System.out.println(id + "" + nametxt.getText() + "" + cbcat.getValue() + "" + lab_url.getText());
				Jeu j = new Jeu(id, nametxt.getText(), cbcat.getValue(), lab_url.getText());
				JeuDAOImpl ps = new JeuDAOImpl();

				try {
					ps.update(j);
					search();
					JOptionPane.showMessageDialog(null, "Update");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int id = Integer.parseInt(txt_id.getText());
				System.out.println(id + "" + nametxt.getText() + "" + cbcat.getValue() + "" + lab_url.getText());
				Jeu j = new Jeu(id, nametxt.getText(), cbcat.getValue(), lab_url.getText());
				JeuDAOImpl ps = new JeuDAOImpl();

				try {
					ps.delete(j);
					search();
					JOptionPane.showMessageDialog(null, "delete");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

	@FXML
	void Addimg(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("image Files", "*.jpg", "*.png"));
		File f = fc.showOpenDialog(null);
		if (f != null) {
			//lab_url.setText(f.getAbsolutePath());
			lab_url.setText(f.getPath());
			Image image = new Image(f.toURI().toString(), 270, 225, true, true);
			img.setImage(image);
		}

	}

	
	@FXML
	void AddJeux(ActionEvent event) throws SQLException {
		int IdU = AuthService.loggedInUser.getUserId();
		
		System.out.println(nametxt.getText() +""+ cbcat.getValue() +""+ lab_url.getText()+""+IdU);
		Jeu j=new Jeu.JeuBuilder().Title(nametxt.getText()).Categorie(cbcat.getValue()).url(lab_url.getText()).userId(IdU).build();
		
		JeuDAOImpl ps = new JeuDAOImpl();
		SceneManager.changeScene(event, "AddJeu.fxml", null, null);
		ps.insert(j);
		search();

	}

	@FXML
	void addCat(MouseEvent event) {
		Connection con = Datasource.getConnection();

		String sql = "SELECT categorie FROM categorie_jeux";
		List<String> categories = new ArrayList<>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				categories.add(rs.getString("categorie"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(categories.get(0));

		ObservableList<String> list = FXCollections.observableArrayList(categories);

		cbcat.setItems(list);

	}

	@FXML
	public void ViewJeu() {
		JeuDAOImpl ps = new JeuDAOImpl();
		ObservableList<Jeu> datax = ps.data();
		id.setCellValueFactory(new PropertyValueFactory<>("ID"));
		name.setCellValueFactory(new PropertyValueFactory<>("Title"));
		cat.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
		picture.setCellValueFactory(new PropertyValueFactory<>("url"));
		picture.setCellValueFactory(new PropertyValueFactory<>("url"));
		jeu.setItems(datax);
		search();
	}

	@FXML
	void getSelected(MouseEvent event) {
		index = jeu.getSelectionModel().getSelectedIndex();
		if (index <= -1) {

			return;
		}
		txt_id.setText(id.getCellData(index).toString());
		nametxt.setText(name.getCellData(index).toString());
		cbcat.setPromptText(cat.getCellData(index).toString());
		lab_url.setText(picture.getCellData(index).toString());
		
		
	}

	@FXML
	public void search() {
		JeuDAOImpl ps = new JeuDAOImpl();
		ObservableList<Jeu> datas = ps.data();
		id.setCellValueFactory(new PropertyValueFactory<>("ID"));
		name.setCellValueFactory(new PropertyValueFactory<>("Title"));
		cat.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
		picture.setCellValueFactory(new PropertyValueFactory<>("url"));
		jeu.setItems(datas);
		FilteredList<Jeu> filteredData = new FilteredList<>(datas, b -> true);
		Search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate((Jeu je) -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (je.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (je.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (je.getUrl().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else {
					return false;
				}
			});
		});
		SortedList<Jeu> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(jeu.comparatorProperty());
		jeu.setItems(sortedData);
	}

}
