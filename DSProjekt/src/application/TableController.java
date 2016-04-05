package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable{

		@FXML
		private TableColumn<Spot,Integer> idCol;
	
	    @FXML
	    private TableColumn<Spot, Boolean> foodCol;

	    @FXML
	    private TableColumn<Spot, Boolean> bathCol;

	    @FXML
	    private TableColumn<Spot, Boolean> bedCol;

	    @FXML
	    private TableColumn<Spot, String> nameCol;

	    @FXML
	    private TableColumn<Spot, Long> updCol;

	    @FXML
	    private TableColumn<Spot, Float> latCol;

	    @FXML
	    private TableColumn<Spot, Boolean> roadtrainCol;

	    @FXML
	    private TableColumn<Spot, Float> longCol;

	    @FXML
	    private TableView<Spot> tableViewId;

	    @FXML
	    private TableColumn<Spot, Boolean> addBlueCol;

	    @FXML
	    private TableColumn<Spot, Boolean> wcCol;
	    
	    final ObservableList<Spot> data = FXCollections.observableArrayList(
				new Spot(1, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694, false),
				new Spot(2, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 2", 240694, false),
				new Spot(3, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 3", 240694, false),
				new Spot(4, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 4", 240694, false),
				new Spot(5, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 5", 240694, false)
			);

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			tableViewId.setEditable(true);
			
			idCol.setCellValueFactory(new PropertyValueFactory<Spot,Integer>("id"));
			addBlueCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("addBlue"));
			foodCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("food"));
			wcCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("wc"));
			bedCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("bed"));
			bathCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("bath"));
			roadtrainCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("roadtrain"));
			longCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("longitude"));
			latCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("latitude"));
			nameCol.setCellValueFactory(new PropertyValueFactory<Spot,String>("name"));
			updCol.setCellValueFactory(new PropertyValueFactory<Spot,Long>("lastUpdated"));
			
			tableViewId.setItems(data);
			
		}

	}
