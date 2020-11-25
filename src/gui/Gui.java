package gui;
import java.io.File;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class Gui extends Application {
	static File ruta = new File("");
	Label descripcion; 
	Label nombre;
	Label email;
	Label profesion;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Lenty");
		myStage.setResizable(false);
		
		//Baras menu
		MenuBar barraMenu=new MenuBar();
		Menu inicio=new Menu("Inicio");
		MenuItem desc=new MenuItem("Descripcion");
		MenuItem salir=new MenuItem("Salir");
		inicio.getItems().add(desc);
		inicio.getItems().add(salir);
		barraMenu.getMenus().add(inicio);
		DescripcionHandler desc1 = new DescripcionHandler();
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
	    lb1.setTextFill(Color.web("#000FFF"));
	    lb1.setPrefWidth(200);
	    lb1.setWrapText(true);
	    lb1.setFont(new Font("Berlin Sans FB",20));
	    
	    descripcion =new Label("");
	    descripcion.setTextFill(Color.web("#000FFF"));
	    descripcion.setPrefWidth(200);
	    descripcion.setWrapText(true);
	    descripcion.setFont(new Font("Berlin Sans FB",15)); 

	    Button b1=new Button("Entrar");
	    b1.setFont(new Font("Berlin Sans FB",25));
	    b1.setMaxSize(200, Double.MAX_VALUE);
	    b1.setTextFill(Color.web("#FF0000"));;
	    EntrarHandler entrar1=new EntrarHandler();
	    b1.setOnAction(entrar1);
	  //Hoja de vida
	    Label lab = new Label("Hoja de Vida");
	    Label lab1 = new Label("Nombre:");
	    nombre = new Label("Juan Camilo Zuluaga");
	    Label lab2 = new Label("E-mail:");
	    email = new Label("juaczuluagamon@unal.edu.co");
	    Label lab3 = new Label("Profesion: Ciencias de la computación");
	    GridPane hojaVida = new GridPane();
	    hojaVida.setPadding(new Insets(10,10,10,10));
	    hojaVida.setVgap(5);
	    hojaVida.setHgap(5);
	    
	    hojaVida.add(lab,1, 0);
	    hojaVida.add(lab1,0, 1);
	    hojaVida.add(lab2,0, 2);
	    hojaVida.add(lab3,0, 3);
	    
	    
	    //Imagenes
	   
	    GridPane fotos = new GridPane();
	    
	    //Label lb3=new Label("Fotos de los creadores");
	    //fotos.add(lb3,1, 0);
	    
	    File fileA = new File(ruta.getAbsolutePath()+"\\src\\1.png"); 
	    ImageView image1 = new ImageView(new Image(fileA.toURI().toString())); 
	    image1.setFitHeight(150);
	    image1.setFitWidth(150);
	    File fileB = new File(ruta.getAbsolutePath()+"\\src\\2.png"); 
	    ImageView image2 = new ImageView(new Image(fileB.toURI().toString()));
	    image2.setFitHeight(150);
	    image2.setFitWidth(150);
	    File fileC = new File(ruta.getAbsolutePath()+"\\src\\3.png"); 
	    ImageView image3 = new ImageView(new Image(fileC.toURI().toString()));
	    image3.setFitHeight(150);
	    image3.setFitWidth(150);
	    File fileD = new File(ruta.getAbsolutePath()+"\\src\\4.png"); 
	    ImageView image4 = new ImageView(new Image(fileD.toURI().toString()));
	    image4.setFitHeight(150);
	    image4.setFitWidth(150);
	    
	    fotos.add(image1 ,0 ,0);
	    fotos.add(image2 ,1 ,0);
	    fotos.add(image3 ,0 ,1);
	    fotos.add(image4 ,1 ,1);
	    
	    //Panel vertical 2
	    vb2.getChildren().add(hojaVida);

	    vb2.getChildren().add(fotos);
	    vb1.getChildren().add(lb1);
	    vb1.getChildren().add(descripcion);
	    descripcion.setTranslateY(200);
	    
	    BorderPane root=new BorderPane();
	    root.setTop(barraMenu);
	    root.setLeft(vb1);
	    root.setRight(vb2);
	    root.setBottom(b1);
	    BorderPane.setMargin(vb1, new Insets(50,20,20,20));
	    BorderPane.setMargin(vb2, new Insets(50,20,20,20));
	    
	    
	    
	   
	    
		Scene myScene = new Scene(root, 600, 600);
		myStage.setScene(myScene);
		myStage.show();
	}
	/*class DescripcionHandler implements EventHandler<ActionEvent>{
		boolean event=false;
		@Override
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if(control instanceof MenuItem) {
			}
			System.out.println("Descripcion");
		}
		public boolean getEvent() {
			return this.event;
		}
		
	}*/
	class SalirHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			Platform.exit();
		}
		
	}
	class EntrarHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Cambiar de escena");
			
		}
	}
			
	class DescripcionHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			descripcion.setText("Lenty es una aplicacion que te permitira, como administrador un despacho de envios, registrar usuarios, "
	    		+ "repartidos, con sus respectivos vehiculos, productos y, con todo esto, hacer ordenes que permitan una organizacion "
	    		+ "eficaz.");
			descripcion.setTextFill(Color.web("#000FFF"));
		    descripcion.setPrefWidth(200);
		    descripcion.setWrapText(true);
		    descripcion.setFont(new Font("Berlin Sans FB",15));
			
		}
		
		}
		
	}
		

	
