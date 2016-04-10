package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import brugerautorisation.transport.soap.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SampleController {

	private ArrayList<Spot> testSpots = new ArrayList<Spot>();

	private Stage currentStage;
	private Connection con = new Connection();

//	@FXML
//	private AnchorPane AnchorPane1;
//
//	@FXML
//	private TableView<Spot> tableView;

	//************** Login Attributter *****************
	@FXML
	private TextField pass_text;

	@FXML
	private Button login_btn;

	@FXML
	private TextField username_text;

	//**************************************************
	
	//************** TableView Attributter *************
	
//	@FXML
//	private TableView<Spot> tableViewId;
//	@FXML
//	private TableColumn<Spot,Integer> idCol;
//	@FXML
//	private TableColumn<Spot,Boolean> addBlueCol;
//	@FXML
//	private TableColumn<Spot,Boolean> foodCol;
//	@FXML
//	private TableColumn<Spot,Boolean> wcCol;
//	@FXML
//	private TableColumn<Spot,Boolean> bedCol;
//	@FXML
//	private TableColumn<Spot,Boolean> bathCol;
//	@FXML
//	private TableColumn<Spot,Boolean> roadtrainCol;
//	@FXML
//	private TableColumn<Spot,Float> longCol;
//	@FXML
//	private TableColumn<Spot,Float> latCol;
//	@FXML
//	private TableColumn<Spot,String> nameCol;
//	@FXML
//	private TableColumn<Spot,Long> updCol;
	
	
	
	//**************************************************
	
	@FXML
	void loginAdmin(ActionEvent event) throws Exception {
		//Hvis brugerlogin lykkedes
		if(true){
//			currentStage.close();
//			Tableview tv = new Tableview();
//			tv.start(new Stage());
			
			createTableView();
		}
	}

	//Gemmer den nuværende scene
	public void setCurrentStage(Stage stage){
		this.currentStage = stage;
	}

	public Boolean getList(String un, String ps){
		try {
			con.getSpotsFromServer(un,ps);
			return true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void loadTestSpots(){
//		final ObservableList<Spot> data = FXCollections.observableArrayList(
//				new Spot(1, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694),
//				new Spot(2, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 2", 240694),
//				new Spot(3, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 3", 240694),
//				new Spot(4, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 4", 240694),
//				new Spot(5, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 5", 240694)
//			);
	}

	public void createTableView() throws IOException{
		Stage stage = new Stage();
		FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Spots2.fxml"));
		AnchorPane myPane = (AnchorPane)myLoader.load();
		Scene scene = new Scene(myPane,1000,700);
		currentStage.close();
		setCurrentStage(stage);
		stage.setScene(scene);
		stage.show();
	}
}
