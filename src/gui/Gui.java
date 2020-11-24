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
	    //vb1.setStyle("-fx-border-color: black");
	    
	    
	    
	    VBox vb2 = new VBox(10);
	    vb2.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    
	    Label lb1 = new Label("Bienvenido a Lenty, aplicacion para la gestion de envios");
	    
	    Label lb3=new Label("Fotos de los creadores");
	    Label lb4=new Label("Descripcion de la aplicacion, solo cuando se presiona el menu");
	    Button b1=new Button("Entrar");
	    
	  //Hoja de vida
	    Label lab = new Label("Hoja de Vida");
	    Label lab1 = new Label("Nombre:");
	    Label lab2 = new Label("E-mail:");
	    Label lab3 = new Label("Profesion:");
	    Label lab4 = new Label("Referencias:");
	    GridPane hojaVida = new GridPane();
	    hojaVida.setPadding(new Insets(10,10,10,10));
	    hojaVida.setVgap(5);
	    hojaVida.setHgap(5);
	    
	    hojaVida.add(lab,1, 0);
	    hojaVida.add(lab1,0, 1);
	    hojaVida.add(lab2,0, 2);
	    hojaVida.add(lab3,0, 3);
	    hojaVida.add(lab4,0, 4);
	    
	    vb1.getChildren().add(lb1);
	    vb2.getChildren().add(hojaVida);
	    vb2.getChildren().add(lb3);
	    vb2.getChildren().add(lb4);
	    
	    
	    BorderPane root=new BorderPane();
	    root.setTop(barraMenu);
	    root.setLeft(vb1);
	    root.setRight(vb2);
	    root.setBottom(b1);
	    BorderPane.setMargin(vb1, new Insets(50,20,20,20));
	    BorderPane.setMargin(vb2, new Insets(50,20,20,20));
	    
	    
	    
	    
	   
	    
		Scene myScene = new Scene(root, 700, 400);
		
		myStage.setScene(myScene);
		myStage.show();
	}	
}
	
