package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

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
	    
	    @FXML
	    private TableColumn<Spot, Boolean> delCol;
	    
	    final ObservableList<Spot> data = FXCollections.observableArrayList(
				new Spot(1, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694, false),
				new Spot(2, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 2", 240694, false),
				new Spot(3, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 3", 240694, false),
				new Spot(4, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 4", 240694, false),
				new Spot(5, false, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 5", 240694, false)
			);

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			tableViewId.setEditable(true);
			
			idCol.setCellValueFactory(new PropertyValueFactory<Spot,Integer>("id"));
			
			addBlueCol.setCellValueFactory(
					new Callback<CellDataFeatures<Spot,Boolean>,ObservableValue<Boolean>>()
					{
						public ObservableValue<Boolean> call(CellDataFeatures<Spot, Boolean> param) {
							return param.getValue().getAddBlue();
						}   
					});
			addBlueCol.setCellFactory(CheckBoxTableCell.<Spot>forTableColumn(addBlueCol));
			addBlueCol.setOnEditCommit(
			    (CellEditEvent<Spot, Boolean> t) -> {
			        ((Spot) t.getTableView().getItems().get(
			            t.getTablePosition().getRow())
			            ).setAddBlue(t.getNewValue());
			});
			
			foodCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("food"));
			wcCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("wc"));
			bedCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("bed"));
			bathCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("bath"));
			roadtrainCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("roadtrain"));
			longCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("longitude"));
			latCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("latitude"));
			
			nameCol.setCellValueFactory(new PropertyValueFactory<Spot,String>("name"));
			nameCol.setCellFactory(TextFieldTableCell.<Spot>forTableColumn());
			nameCol.setOnEditCommit(
			    (CellEditEvent<Spot, String> t) -> {
			        ((Spot) t.getTableView().getItems().get(
			            t.getTablePosition().getRow())
			            ).setName(t.getNewValue());
			});
			
			updCol.setCellValueFactory(new PropertyValueFactory<Spot,Long>("lastUpdated"));
//			updCol.setCellFactory(TextFieldTableCell.<Spot>forTableColumn());
//			updCol.setOnEditCommit(
//			    (CellEditEvent<Spot, Long> t) -> {
//			        ((Spot) t.getTableView().getItems().get(
//			            t.getTablePosition().getRow())
//			            ).setLastUpdated(t.getNewValue());
//			});
			
			delCol.setCellValueFactory(new PropertyValueFactory<Spot,Boolean>("deleted"));
			
			tableViewId.setItems(data);
			
		}

	}
