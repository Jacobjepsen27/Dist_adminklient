package application;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import org.json.JSONException;

import com.sun.prism.impl.Disposer.Record;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

public class TableController implements Initializable{

	public HashMap<Integer,Object> map = new HashMap<Integer,Object>();
	public PSpot spot;
	public RestClient rc = new RestClient();
	public String token=null;
	AddressCompleter ac = new AddressCompleter();

	@FXML
	private TextField name_text;

	@FXML
	private ListView suggestions;

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
	private CheckBox fuelCheck;

	@FXML
	private Button addSpot_btn;

	@FXML
	private Button gem_btn;

	@FXML
	private TableColumn<PSpot,Integer> idCol;

	@FXML
	private TableColumn<PSpot, Boolean> foodCol;

	@FXML
	private TableColumn<PSpot, Boolean> bathCol;

	@FXML
	private TableColumn<PSpot, Boolean> bedCol;

	@FXML
	private TableColumn<PSpot, String> nameCol;

	@FXML
	private TableColumn<PSpot, Long> updCol;

	@FXML
	private TableColumn<PSpot, Float> latCol;

	@FXML
	private TableColumn<PSpot, Boolean> roadtrainCol;

	@FXML
	private TableColumn<PSpot, Float> longCol;

	@FXML
	private TableView<PSpot> tableViewId;

	@FXML
	private TableColumn<PSpot, Boolean> addBlueCol;

	@FXML
	private TableColumn<PSpot, Boolean> wcCol;

	@FXML
	private TableColumn<PSpot, Boolean> delCol;

	@FXML
	private TableColumn<PSpot, Boolean> fuelCol;

	@FXML
	private TableColumn retCol;

	private Stage currentStage;

	public final ObservableList<PSpot> data =  FXCollections.observableArrayList();
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
		idCol.setCellValueFactory(new PropertyValueFactory<PSpot,Integer>("id"));

		addBlueCol.setPrefWidth(70);
		addBlueCol.setCellValueFactory(
				new Callback<CellDataFeatures<PSpot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<PSpot, Boolean> param) {
						return param.getValue().getAddBlue();
					}   
				});
		addBlueCol.setCellFactory(CheckBoxTableCell.<PSpot>forTableColumn(addBlueCol));
		addBlueCol.setOnEditCommit(
				(CellEditEvent<PSpot, Boolean> t) -> {
					((PSpot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setAddBlue(t.getNewValue());
				});

		foodCol.setPrefWidth(70);
		foodCol.setCellValueFactory(
				new Callback<CellDataFeatures<PSpot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<PSpot, Boolean> param) {
						return param.getValue().getFood();
					}   
				});
		foodCol.setCellFactory(CheckBoxTableCell.<PSpot>forTableColumn(foodCol));
		foodCol.setOnEditCommit(
				(CellEditEvent<PSpot, Boolean> t) -> {
					((PSpot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setFood(t.getNewValue());
				});

		wcCol.setPrefWidth(70);
		wcCol.setCellValueFactory(
				new Callback<CellDataFeatures<PSpot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<PSpot, Boolean> param) {
						return param.getValue().getWc();
					}   
				});
		wcCol.setCellFactory(CheckBoxTableCell.<PSpot>forTableColumn(wcCol));
		wcCol.setOnEditCommit(
				(CellEditEvent<PSpot, Boolean> t) -> {
					((PSpot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setWc(t.getNewValue());
				});

		bedCol.setPrefWidth(70);
		bedCol.setCellValueFactory(
				new Callback<CellDataFeatures<PSpot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<PSpot, Boolean> param) {
						return param.getValue().getBed();
					}   
				});
		bedCol.setCellFactory(CheckBoxTableCell.<PSpot>forTableColumn(bedCol));
		bedCol.setOnEditCommit(
				(CellEditEvent<PSpot, Boolean> t) -> {
					((PSpot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setBed(t.getNewValue());
				});

		bathCol.setPrefWidth(70);
		bathCol.setCellValueFactory(
				new Callback<CellDataFeatures<PSpot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<PSpot, Boolean> param) {
						return param.getValue().getBath();
					}   
				});
		bathCol.setCellFactory(CheckBoxTableCell.<PSpot>forTableColumn(bathCol));
		bathCol.setOnEditCommit(
				(CellEditEvent<PSpot, Boolean> t) -> {
					((PSpot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setBath(t.getNewValue());
				});

		fuelCol.setCellValueFactory(
				new Callback<CellDataFeatures<PSpot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<PSpot, Boolean> param) {
						return param.getValue().getFuel();
					}   
				});
		fuelCol.setCellFactory(CheckBoxTableCell.<PSpot>forTableColumn(fuelCol));
		fuelCol.setOnEditCommit(
				(CellEditEvent<PSpot, Boolean> t) -> {
					((PSpot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setFuel(t.getNewValue());
				});

		roadtrainCol.setPrefWidth(70);
		roadtrainCol.setCellValueFactory(
				new Callback<CellDataFeatures<PSpot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<PSpot, Boolean> param) {
						return param.getValue().getRoadtrain();
					}   
				});
		roadtrainCol.setCellFactory(CheckBoxTableCell.<PSpot>forTableColumn(roadtrainCol));

		longCol.setPrefWidth(125);
		longCol.setCellValueFactory(new PropertyValueFactory<PSpot,Float>("longitude"));

		latCol.setPrefWidth(125);
		latCol.setCellValueFactory(new PropertyValueFactory<PSpot,Float>("latitude"));

		nameCol.setPrefWidth(125);
		nameCol.setCellValueFactory(new PropertyValueFactory<PSpot,String>("name"));
		nameCol.setCellFactory(TextFieldTableCell.<PSpot>forTableColumn());
		nameCol.setOnEditCommit(
				(CellEditEvent<PSpot, String> t) -> {
					((PSpot) t.getTableView().getItems().get(
							t.getTablePosition().getRow())
							).setName(t.getNewValue());
					int id = t.getRowValue().getId();
				});

		updCol.setPrefWidth(125);
		updCol.setCellValueFactory(new PropertyValueFactory<PSpot,Long>("lastUpdated"));


		delCol.setCellValueFactory(
				new Callback<CellDataFeatures<PSpot,Boolean>,ObservableValue<Boolean>>()
				{
					public ObservableValue<Boolean> call(CellDataFeatures<PSpot, Boolean> param) {
						return param.getValue().getDeleted();
					}   
				});
		delCol.setCellFactory(CheckBoxTableCell.<PSpot>forTableColumn(delCol));
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
	void getAddresses(KeyEvent event) throws JSONException {
		if(event.getCode() != KeyCode.ENTER){
			if(name_text.getText().length() > 3){
				Task<Void> task = new Task<Void>(){

					@Override
					protected Void call() throws Exception {
						final ObservableList<String> ol = FXCollections.observableArrayList(ac.getAddresses(name_text.getText()));
						
						Platform.runLater(()  -> {
							suggestions.getItems().clear();
							suggestions.setVisible(true);
							suggestions.getItems().addAll(ol);
							foodCheck.setVisible(false);
							addBlueCheck.setVisible(false);
							wcCheck.setVisible(false);
							fuelCheck.setVisible(false);
							bedCheck.setVisible(false);
							bathCheck.setVisible(false);
							roadtrainCheck.setVisible(false);
							long_text.setVisible(false);
							lat_text.setVisible(false);


						});
						return null;
					}
				};
				new Thread(task).start();
			}
		}
		if(event.getCode() == KeyCode.ENTER){
			fillLatAndLong();
			
		}
	}

	@FXML
	void picksAddress(MouseEvent event) throws JSONException {
	name_text.setText((String)suggestions.getSelectionModel().getSelectedItem());
	fillLatAndLong();
	}

	@FXML
	private void addSpotAction(ActionEvent event) throws IOException{	
		Spot spot = new Spot(0,addBlueCheck.isSelected(), foodCheck.isSelected(), wcCheck.isSelected(), bedCheck.isSelected(), bathCheck.isSelected(), fuelCheck.isSelected(),roadtrainCheck.isSelected(), Float.parseFloat(long_text.getText()), Float.parseFloat(lat_text.getText()), name_text.getText(), System.currentTimeMillis(), false);
		rc.saveNewSpotToServer(spot);
		setObservableData(ParseArray.Spot2PSpot(rc.hentJsonFraServer()));
	}

	@FXML
	private void gemAction(ActionEvent event){
		//Spots der hentes fra server og sættes som dataArray
		ArrayList<Spot> nyeSpots = new ArrayList<Spot>();
		ArrayList<PSpot> saveSpot = new ArrayList<PSpot>();

		//Nedenstående kode finder spots der er rettet i:
		HashMap<Integer,PSpot> map2 = new HashMap<Integer,PSpot>();
		for (PSpot spot : data) {
			int id = spot.getId();
			map2.put(id, spot);
		}
		Set keys = map.keySet();
		for (Object object : keys) {
			int key = (Integer) object;
			saveSpot.add(map2.get(key));
		}

		//Laver RestClient objekt
		//		RestClient rc = new RestClient();
		map.clear();
		setObservableData(rc.saveChangedSpots(saveSpot, token));
	}

	public void setObservableData(ArrayList<PSpot> list){
		data.clear();
		for(int i=0; i<list.size();i++){
			data.add(list.get(i));
		}
		//		System.out.println(data.get(0).getAddBlue());
	}

	//Gemmer den nuværende scene
	public void setCurrentStage(Stage stage){
		this.currentStage = stage;
	}

	public void rettedeSpots(int id){
		//		int[] tal = new int[data.size()+1];
		map.put(id,null);
	}

	public void setToken(String token){
		this.token=token;
	}

	public String getToken(){
		return this.token;
	}

	private void fillLatAndLong() throws JSONException{
		foodCheck.setVisible(true);
		addBlueCheck.setVisible(true);
		wcCheck.setVisible(true);
		bedCheck.setVisible(true);
		bathCheck.setVisible(true);
		roadtrainCheck.setVisible(true);
		fuelCheck.setVisible(true);
		long_text.setVisible(true);
		lat_text.setVisible(true);
		lat_text.setText((Double)ac.getGeoLocation(name_text.getText())[1]+"");
		long_text.setText((Double)ac.getGeoLocation(name_text.getText())[0]+"");
		suggestions.setVisible(false);
	}

}


