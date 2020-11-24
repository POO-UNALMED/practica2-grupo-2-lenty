package gui;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;



public class Gui extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Lenty");
		
		MenuBar barraMenu=new MenuBar();
		Menu menu1=new Menu("Salir");
		Menu menu2=new Menu("Descripcion");
		barraMenu.getMenus().add(menu1);
		barraMenu.getMenus().add(menu2);
		
		
		
	    VBox vb1 = new VBox(10);
	    vb1.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    vb1.setStyle("-fx-border-color: black");
	    
	    
	    
	    VBox vb2 = new VBox(10);
	    vb2.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    
	    Label lb1 = new Label("Bienvenido a Lenty, aplicacion para la gestion de envios");
	    Label lb2 = new Label("Hojas de vida");
	    Label lb3=new Label("Fotos de los creadores");
	    Label lb4=new Label("Descripcion de la aplicacion, solo cuando se presiona el menu");
	    Button b1=new Button("Entrar");
	    
	    vb1.getChildren().add(lb1);
	    vb1.getChildren().add(b1);
	    vb2.getChildren().add(lb2);
	    vb2.getChildren().add(lb3);
	    vb2.getChildren().add(lb4);
	    
	    BorderPane root=new BorderPane();
	    root.setTop(barraMenu);
	    root.setLeft(vb1);
	    root.setRight(vb2);
	    VBox.setMargin(vb1, new Insets(50, 50, 50, 50));
	    
	   
	    
		Scene myScene = new Scene(root, 700, 400);
		
		myStage.setScene(myScene);
		myStage.show();
	}	
}
	
