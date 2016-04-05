package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Starter JavaFX Scene fra Sample.fxml
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
			BorderPane myPane = (BorderPane)myLoader.load();
			SampleController controller = (SampleController) myLoader.getController();
			controller.setCurrentStage(primaryStage);
			Scene myScene = new Scene(myPane,600,400);        
			primaryStage.setScene(myScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
