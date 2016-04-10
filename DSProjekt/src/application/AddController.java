package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddController {
	
	private Stage currentStage;

	@FXML
	private Label testLabel;

	@FXML
	private Button back_btn;

	@FXML
	private void backAction(ActionEvent event) throws IOException{
//		TableController tc = new TableController();
//		SampleController sc = new SampleController();
//		currentStage.close();
//		sc.createTableView();
	}

	//Gemmer den nuværende scene
	public void setCurrentStage(Stage stage){
		this.currentStage = stage;
	}

}
