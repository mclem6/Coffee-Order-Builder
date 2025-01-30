import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;



public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		//load the scene
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/firstScene.fxml"));
			primaryStage.setTitle("Th Coffee Shop");
			Scene homeScene = new Scene(root, 750, 1000);
			homeScene.getStylesheets().add("/styles/styleFirst.css");
			

			//show
			primaryStage.setScene(homeScene);
			primaryStage.show();

		} catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}


		
	}

}
