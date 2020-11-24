package gui;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.event.*;



public class Gui extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Lenty");
		
		MenuBar barraMenu=new MenuBar();
		Menu inicio=new Menu("Inicio");
		MenuItem desc=new MenuItem("Descripcion");
		MenuItem salir=new MenuItem("Salir");
		inicio.getItems().add(desc);
		inicio.getItems().add(salir);
		barraMenu.getMenus().add(inicio);
		DescripcionHandler desc1=new DescripcionHandler();
		desc.setOnAction(desc1);
		SalirHandler salir1=new SalirHandler();
		salir.setOnAction(salir1);
	    VBox vb1 = new VBox(10);
	    vb1.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    //vb1.setStyle("-fx-border-color: black");
	    
	    
	    
	    VBox vb2 = new VBox(10);
	    vb2.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    
	    Label lb1 = new Label("Bienvenido a Lenty, aplicacion para la gestion de envios");
	    
	    Label lb3=new Label("Fotos de los creadores");
	    Label lb4=new Label("Lenty es una aplicacion que te permitira, como administrador de un despacho de envios, registrar usuarios, "
	    		+ "repartidos, con sus respectivos vehiculos, productos y, con todo esto, hacer ordenes que permitan una organizacion "
	    		+ "eficaz.");
	    lb4.setTextFill(Color.web("#FF0000"));
	    lb4.setPrefWidth(200);
	    lb4.setWrapText(true);
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
	    vb1.getChildren().add(lb4);
	    
	    
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
	class DescripcionHandler implements EventHandler<ActionEvent>{
		boolean event=false;
		@Override
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if(control instanceof MenuItem) {
				vb1.getchildren().add(lb4);
			}
			System.out.println("Descripcion");
		}
		public boolean getEvent() {
			return this.event;
		}
		
	}
	class SalirHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Salir");
		}
		
	}
}
	
