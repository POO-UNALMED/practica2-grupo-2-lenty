package gui;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;



public class Gui extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Lenty");
		
		FlowPane rootNode = new FlowPane();
		Scene myScene = new Scene(rootNode, 600, 400);
		myStage.setScene(myScene);
		myStage.show();
	}	
}
	
