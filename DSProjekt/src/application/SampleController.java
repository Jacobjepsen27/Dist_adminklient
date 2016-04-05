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

		//Overskriver login skærm med ny (Spots.fxml)
//		Stage stage = new Stage();
//		AnchorPane myPane = FXMLLoader.load(getClass().getResource("Spots2.fxml"));
//		Scene scene = new Scene(myPane,1000,700);
//		currentStage.close();
//		setCurrentStage(stage);
//		loadTestSpots();
		
		Stage stage = new Stage();
		FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Spots2.fxml"));
		AnchorPane myPane = (AnchorPane)myLoader.load();
//		TableController controller = (TableController) myLoader.getController();
		Scene scene = new Scene(myPane,1000,700);
		currentStage.close();
		setCurrentStage(stage);
		
//		final ObservableList<Spot> data = FXCollections.observableArrayList(
//				new Spot(1, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694),
//				new Spot(2, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 2", 240694),
//				new Spot(3, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 3", 240694),
//				new Spot(4, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 4", 240694),
//				new Spot(5, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 5", 240694)
//			);
		
//		idCol.setCellValueFactory(new PropertyValueFactory<Spot,Integer>("id"));
//		addBlueCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("addBlue"));
//		foodCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("food"));
//		wcCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("wc"));
//		bedCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("bed"));
//		bathCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("bath"));
//		roadtrainCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("roadtrain"));
//		longCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("longitude"));
//		latCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("latitude"));
//		nameCol.setCellValueFactory(new PropertyValueFactory<Spot,String>("name"));
//		updCol.setCellValueFactory(new PropertyValueFactory<Spot,Long>("lastUpdated"));
//		
//		tableViewId.setItems(data);
		
		stage.setScene(scene);
		stage.show();
//
////		tableView = new TableView<Spot>();
//		final ObservableList<Spot> data = FXCollections.observableArrayList();
//		data.add(new Spot(1, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694));
//		data.add(new Spot(2, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694));
//		data.add(new Spot(3, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694));
//		data.add(new Spot(4, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694));
//		data.add(new Spot(5, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694));
//		final Label label = new Label("Spot liste");
//		label.setFont(new Font("Arial", 20));
//		tableView.setEditable(true);
//		
//
//		//		TableColumn firstNameCol = new TableColumn("First Name");
//		//		TableColumn lastNameCol = new TableColumn("Last Name");
//		//		TableColumn emailCol = new TableColumn("Email");
//
//		//		tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
//		//		final VBox vbox = new VBox();
//		//		vbox.setSpacing(5);
//		//		vbox.setPadding(new Insets(10, 0, 0, 10));
//		//		vbox.getChildren().addAll(label, tableView);
//
//		//            ((BorderPane) scene.getRoot()).getChildren().
//
//		//            
//		TableColumn idCol = new TableColumn("Id");
//		idCol.setCellValueFactory(new PropertyValueFactory<Spot, Integer>("id"));
//		
//		TableColumn bol1Col = new TableColumn("bol1");
//		bol1Col.setCellValueFactory(new PropertyValueFactory<Spot, Boolean>("addBlue"));
//		
//		TableColumn bol2Col = new TableColumn("bol2");
//		bol2Col.setCellValueFactory(new PropertyValueFactory<Spot, Boolean>("food"));
//		
//		TableColumn bol3Col = new TableColumn("bol3");
//		bol3Col.setCellValueFactory(new PropertyValueFactory<Spot, Boolean>("wc"));
//		
//		TableColumn bol4Col = new TableColumn("bol4");
//		bol4Col.setCellValueFactory(new PropertyValueFactory<Spot, Boolean>("bed"));
//		
//		TableColumn bol5Col = new TableColumn("bol5");
//		bol5Col.setCellValueFactory(new PropertyValueFactory<Spot, Boolean>("bath"));
//		
//		TableColumn bol6Col = new TableColumn("bol6");
//		bol6Col.setCellValueFactory(new PropertyValueFactory<Spot, Boolean>("roadtrain"));
//		
//		TableColumn float1Col = new TableColumn("float1");
//		float1Col.setCellValueFactory(new PropertyValueFactory<Spot, Float>("longitude"));
//		
//		TableColumn float2Col = new TableColumn("float2");
//		float2Col.setCellValueFactory(new PropertyValueFactory<Spot, Float>("latitude"));
//		
//		TableColumn dateCol = new TableColumn("Dato");
//		dateCol.setCellValueFactory(new PropertyValueFactory<Spot, Long>("lastUpdated"));
//
//		tableView.setItems(data);
//		tableView.getColumns().addAll(idCol, bol1Col, bol2Col,bol3Col,bol4Col, bol5Col, bol6Col,float1Col,float2Col,dateCol);
//
//		final VBox vbox = new VBox();
//		vbox.setSpacing(5);
//		vbox.setPadding(new Insets(5, 0, 0, 5));
//		vbox.getChildren().addAll(label, tableView);
//		
//		
//		
//		stage.setScene(scene);
//		stage.show();
	}
}
