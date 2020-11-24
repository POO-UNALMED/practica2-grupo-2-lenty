package gui;
import javafx.application.*;
import javafx.stage.Stage;



public class Gui extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Adios Mundo");
		
		myStage.show();
	}	
}
	
