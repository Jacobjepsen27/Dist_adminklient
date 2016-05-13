package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SampleController {

	public ArrayList<PSpot> PSpots = new ArrayList<PSpot>();
	public ArrayList<Spot> Spots = new ArrayList<Spot>();
	
	private Stage currentStage;

	@FXML
	private TextField pass_text;

	@FXML
	private Button login_btn;

	@FXML
	private TextField username_text;
	
	RestClient rc = new RestClient();
	
	@FXML
	void loginAdmin(ActionEvent event) throws Exception {
		String token = rc.login(username_text.getText(), pass_text.getText());
		if(!token.equals("Bruger findes ikke på serveren eller password er forkert")){
			loadTestSpotsFromTestServer();
			createTableView(token);
			}
	}

	//Gemmer den nuværende scene
	public void setCurrentStage(Stage stage){
		this.currentStage = stage;
	}
	
	public void loadTestSpotsFromTestServer(){
		Spots = rc.hentJsonFraServer();
		for(Spot s: Spots){
			PSpots.add(new PSpot(s.getId(),s.getAddBlue(),s.getFood(),s.getWc(),s.getBed(),s.getBath(), s.getFuel(),s.getRoadtrain(),s.getLongitude(),s.getLatitude()
					,s.getName(),s.getLastUpdated(),s.getDeleted()));
		}
	}

	public void createTableView(String token) throws IOException{
		Stage stage = new Stage();
		FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Spots2.fxml"));
		AnchorPane myPane = (AnchorPane)myLoader.load();
		TableController controller = (TableController) myLoader.getController();
		controller.setCurrentStage(stage);
		controller.setToken(token);
		controller.setObservableData(PSpots);
		Scene scene = new Scene(myPane,1250,700);
		currentStage.close();
		setCurrentStage(stage);
		stage.setScene(scene);
		stage.show();
	}
}
