package gui;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;



public class Gui extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Lenty");
		
		HBox root = new HBox(10);
	    VBox vb1 = new VBox(10);
	    VBox vb2 = new VBox(10);
	    Label lb1 = new Label("this is p1");
	    Label lb2 = new Label("this is p2");
	    
	    root.setSpacing(230);
	    
	    
	    root.getChildren().add(vb1);
	    root.getChildren().add(vb2);
		
	    vb1.getChildren().add(lb1);
	    vb2.getChildren().add(lb2);
		

		Scene myScene = new Scene(root, 600, 400);
		myStage.setScene(myScene);
		myStage.show();
	}	
}
	
