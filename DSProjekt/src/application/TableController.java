package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.sun.prism.impl.Disposer.Record;

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
	
	public HashMap map = new HashMap();
	public ArrayList<Spot> list2;

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

	private Stage currentStage;

	public ObservableList<Spot> data = FXCollections.observableArrayList();
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
		roadtrainCol.setOnEditCommit(
				(CellEditEvent<Spot, Boolean> t) -> {
					((Spot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setRoadtrain(t.getNewValue());
//					saveId(t.getRowValue().getId());
				});

		longCol.setPrefWidth(125);
		longCol.setCellValueFactory(new PropertyValueFactory<Spot,Float>("longitude"));
		//			longCol.setCellFactory(TextFieldTableCell.<Spot>forTableColumn());

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
//					saveId(t.getRowValue().getId());
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
		delCol.setOnEditCommit(
				(CellEditEvent<Spot, Boolean> t) -> {
					((Spot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setDeleted(t.getNewValue());
				});
		
//		data.addListener(new ListChangeListener<Spot>(){
//
//			@Override
//			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Spot> c) {
//				// TODO Auto-generated method stub
//				while(c.next()){
//					if(c.wasUpdated()){
//						System.out.println(c.getAddedSubList().size());
//					}
//				}
//			}
//		});

		tableViewId.setItems(data);
	}

	@FXML
	private void addSpotAction(ActionEvent event) throws IOException{	
		data.add(new Spot(0,addBlueCheck.isSelected(), foodCheck.isSelected(), wcCheck.isSelected(), bedCheck.isSelected(), bathCheck.isSelected(), roadtrainCheck.isSelected(), Float.parseFloat(long_text.getText()), Float.parseFloat(lat_text.getText()), name_text.getText(), System.currentTimeMillis(), false));
	}

	@FXML
	private void gemAction(ActionEvent event){
		//her skal spots med ændringer findes og derefter sendes til server
//		for(int i=0; i<list2.size();i++){
			System.out.println("list2 size"+list2.size());
			System.out.println("data size"+data.size());
			System.out.println("Liste 2 "+list2.get(0).getDeleted());
			System.out.println("Data liste "+data.get(0).getDeleted());
//		}

	}

	public void setObservableData(ArrayList<Spot> list){
		list2 = new ArrayList<Spot>(list);
//		data = FXCollections.observableArrayList(list);
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
//		map.put(id,null);
	}

}


