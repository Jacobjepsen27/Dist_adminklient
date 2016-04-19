package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import com.sun.prism.impl.Disposer.Record;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

public class TableController implements Initializable{
	
	public HashMap<Integer,Object> map = new HashMap<Integer,Object>();
	public ArrayList<Spot> saveSpot = new ArrayList<Spot>();
	public Spot spot;

	@FXML
	private TextField name_text;

	@FXML
	private TextField long_text;

	@FXML
	private TextField lat_text;

	@FXML
	private CheckBox addBlueCheck;

	@FXML
	private CheckBox bathCheck;

	@FXML
	private CheckBox bedCheck;

	@FXML
	private CheckBox wcCheck;

	@FXML
	private CheckBox roadtrainCheck;

	@FXML
	private CheckBox foodCheck;

	@FXML
	private Button addSpot_btn;

	@FXML
	private Button gem_btn;

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
	
	@FXML
	private TableColumn retCol;

	private Stage currentStage;

	public final ObservableList<Spot> data =  FXCollections.observableArrayList();
	//			new Spot(1, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694, false),
	//			new Spot(2, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 2", 240694, false),
	//			new Spot(3, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 3", 240694, false),
	//			new Spot(4, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 4", 240694, false),
	//			new Spot(5, false, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 5", 240694, false)
	//			);

	//	    final ObservableList<Spot> data = FXCollections.observableArrayList(
	//				new Spot(1, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 1", 240694),
	//				new Spot(2, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 2", 240694),
	//				new Spot(3, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 3", 240694),
	//				new Spot(4, true, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 4", 240694),
	//				new Spot(5, false, true, true, true, true, true, (float)21.012, (float)22.012, "Spot 5", 240694)
	//			);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		tableViewId.setEditable(true);
		
//		tableViewId.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//		    if (newSelection != null) {
//		        System.out.println(tableViewId.getSelectionModel().getSelectedIndex());
//		    }
//		});
		
		idCol.setPrefWidth(25);
		idCol.setCellValueFactory(new PropertyValueFactory<Spot,Integer>("id"));

		addBlueCol.setPrefWidth(70);
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

		foodCol.setPrefWidth(70);
		foodCol.setCellValueFactory(
				new Callback<CellDataFeatures<Spot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<Spot, Boolean> param) {
						return param.getValue().getFood();
					}   
				});
		foodCol.setCellFactory(CheckBoxTableCell.<Spot>forTableColumn(foodCol));
		foodCol.setOnEditCommit(
				(CellEditEvent<Spot, Boolean> t) -> {
					((Spot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setFood(t.getNewValue());
				});

		wcCol.setPrefWidth(70);
		wcCol.setCellValueFactory(
				new Callback<CellDataFeatures<Spot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<Spot, Boolean> param) {
						return param.getValue().getWc();
					}   
				});
		wcCol.setCellFactory(CheckBoxTableCell.<Spot>forTableColumn(wcCol));
		wcCol.setOnEditCommit(
				(CellEditEvent<Spot, Boolean> t) -> {
					((Spot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setWc(t.getNewValue());
				});

		bedCol.setPrefWidth(70);
		bedCol.setCellValueFactory(
				new Callback<CellDataFeatures<Spot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<Spot, Boolean> param) {
						return param.getValue().getBed();
					}   
				});
		bedCol.setCellFactory(CheckBoxTableCell.<Spot>forTableColumn(bedCol));
		bedCol.setOnEditCommit(
				(CellEditEvent<Spot, Boolean> t) -> {
					((Spot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setBed(t.getNewValue());
				});

		bathCol.setPrefWidth(70);
		bathCol.setCellValueFactory(
				new Callback<CellDataFeatures<Spot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<Spot, Boolean> param) {
						return param.getValue().getBath();
					}   
				});
		bathCol.setCellFactory(CheckBoxTableCell.<Spot>forTableColumn(bathCol));
		bathCol.setOnEditCommit(
				(CellEditEvent<Spot, Boolean> t) -> {
					((Spot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setBath(t.getNewValue());
				});

		roadtrainCol.setPrefWidth(70);
		roadtrainCol.setCellValueFactory(
				new Callback<CellDataFeatures<Spot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<Spot, Boolean> param) {
						return param.getValue().getRoadtrain();
					}   
				});
		roadtrainCol.setCellFactory(CheckBoxTableCell.<Spot>forTableColumn(roadtrainCol));

		longCol.setPrefWidth(125);
		longCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("longitude"));

		latCol.setPrefWidth(125);
		latCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("latitude"));

		nameCol.setPrefWidth(125);
		nameCol.setCellValueFactory(new PropertyValueFactory<Spot,String>("name"));
		nameCol.setCellFactory(TextFieldTableCell.<Spot>forTableColumn());
		nameCol.setOnEditCommit(
				(CellEditEvent<Spot, String> t) -> {
					((Spot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setName(t.getNewValue());
					int id = t.getRowValue().getId();
					rettedeSpots(id);
					System.out.println("name col rettet ved id " + id);
				});

		updCol.setPrefWidth(125);
		updCol.setCellValueFactory(new PropertyValueFactory<Spot,Long>("lastUpdated"));

		
		delCol.setCellValueFactory(
				new Callback<CellDataFeatures<Spot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<Spot, Boolean> param) {
						return param.getValue().getDeleted();
					}   
				});
		delCol.setCellFactory(CheckBoxTableCell.<Spot>forTableColumn(delCol));
//		delCol.setCellFactory(col -> {
//            CheckBoxTableCell<Spot, Boolean> cell = new CheckBoxTableCell<>(index -> {
//                BooleanProperty active = new SimpleBooleanProperty();
//                active.addListener((obs, wasActive, isNowActive) -> {
//                	System.out.println("del");
//                	rettedeSpots(tableViewId.getItems().get(index).getId());
//                });
//                return active ;
//            });
//            return cell ;
//        });
		
//		retCol.setCellFactory(CheckBoxTableCell.<Spot>forTableColumn(null));

		retCol.setCellFactory(col -> {
          CheckBoxTableCell cell = new CheckBoxTableCell<>(index -> {
              BooleanProperty active = new SimpleBooleanProperty();
              active.addListener((obs, wasActive, isNowActive) -> {
              	System.out.println("ret "+ tableViewId.getItems().get(index).getId());
              	rettedeSpots(tableViewId.getItems().get(index).getId());
              });
              return active ;
          });
          return cell ;
      });
		
		tableViewId.setItems(data);
	}

	@FXML
	private void addSpotAction(ActionEvent event) throws IOException{	
//		data.add(new Spot(0,addBlueCheck.isSelected(), foodCheck.isSelected(), wcCheck.isSelected(), bedCheck.isSelected(), bathCheck.isSelected(), roadtrainCheck.isSelected(), Float.parseFloat(long_text.getText()), Float.parseFloat(lat_text.getText()), name_text.getText(), System.currentTimeMillis(), false));
	}

	@FXML
	private void gemAction(ActionEvent event){
		//her skal spots med ændringer findes og derefter sendes til server
		HashMap<Integer,Spot> map2 = new HashMap<Integer,Spot>();
		for (Spot spot : data) {
			int id = spot.getId();
			map2.put(id, spot);
		}
		
		Set keys = map.keySet();
		for (Object object : keys) {
			int key = (Integer) object;
			saveSpot.add(map2.get(key));
		}
		RestClient rc = new RestClient();
		
//		System.out.println(map.size());
//		for (Spot test : saveSpot) {
//			System.out.println("rettede spot har id "+test.getId());
//			System.out.println("navn "+test.getName());
//		}
	}

	public void setObservableData(ArrayList<Spot> list){
		data.clear();
		for(int i=0; i<list.size();i++){
			data.add(list.get(i));
		}
	}

	//Gemmer den nuværende scene
	public void setCurrentStage(Stage stage){
		this.currentStage = stage;
	}
	
	public void rettedeSpots(int id){
//		int[] tal = new int[data.size()+1];
		map.put(id,null);
	}

}


