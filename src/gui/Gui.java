package gui;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.event.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;





public class Gui extends Application {
	static File ruta = new File("");
	static Label descripcion; 
	static Label nombre;
	static Label email;
	static Label profesion;
	static ImageView image1;
	static ImageView image2;
	static ImageView image3;
	static ImageView image4;
	static ImageView imagenRotativa;
	static int contador = 0;
	static int contadorx = 0;
	static int contadorx2 = 0;
	

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Lenty");
		//myStage.setResizable(false);
		
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
		
		//Barra menu2
		MenuBar barraMenu2=new MenuBar();
		Menu archivo=new Menu("Archivo");
		Menu proYCon=new Menu("Procesos y consultas");
		Menu ayuda=new Menu("Ayuda");
		MenuItem nombreLenty=new MenuItem("Lenty");
		MenuItem MenUsu=new MenuItem("Menu Usuarios");
		MenuItem MenOrd=new MenuItem("Menu Ordenes");
		MenuItem MenPro=new MenuItem("Menu Productos");
		MenuItem MenVeh=new MenuItem("Menu Vehiculos");
		MenuItem MenSed=new MenuItem("Menu Sedes");
		archivo.getItems().add(nombreLenty);
		proYCon.getItems().addAll(MenUsu,MenOrd,MenPro,MenVeh,MenSed);
		barraMenu2.getMenus().addAll(archivo,proYCon,ayuda);
		
		
		AyudaHandler ayuda1=new AyudaHandler();
		ayuda.setOnAction(ayuda1);
		MenuUsuariosHandler MenUsu1=new MenuUsuariosHandler();
		MenUsu.setOnAction(MenUsu1);
		MenuOrdenesHandler MenOrd1=new MenuOrdenesHandler();
		MenUsu.setOnAction(MenOrd1);
		MenuProductosHandler MenPro1=new MenuProductosHandler();
		MenUsu.setOnAction(MenPro1);
		MenuVehiculosHandler MenVeh1=new MenuVehiculosHandler();
		MenUsu.setOnAction(MenVeh1);
		MenuSedesHandler MenSed1=new MenuSedesHandler();
		MenUsu.setOnAction(MenSed1);
		
		//Scene2
		BorderPane rootScene2=new BorderPane();
		rootScene2.setTop(barraMenu2);
		
	    VBox vb1 = new VBox(10);
	    vb1.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    //vb1.setStyle("-fx-border-color: black");
	    
	    
	    
	    VBox vb2 = new VBox(10);
	    vb2.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    
	    //Bienvenida
	    Label lb1 = new Label("Bienvenido a Lenty, aplicacion para la gestion de envios");
	    lb1.setTextFill(Color.web("#19164a"));
	    lb1.setPrefWidth(200);
	    lb1.setWrapText(true);
	    lb1.setFont(new Font("Times New Roman Bold",20));
	    
	    descripcion =new Label("");
	    descripcion.setTextFill(Color.web("#000FFF"));
	    descripcion.setPrefWidth(200);
	    descripcion.setWrapText(true);
	    descripcion.setFont(new Font("Berlin Sans FB",15)); 

	    Button b1=new Button("Entrar");
	    b1.setFont(new Font("Berlin Sans FB",25));
	    b1.setMaxSize(200, Double.MAX_VALUE);
	    b1.setTextFill(Color.web("#FF0000"));;
	    //EntrarHandler entrar1=new EntrarHandler();
	    //b1.setOnAction(entrar1);
	  //Hoja de vida
	    Label lab = new Label("Hoja de Vida");
	    Label lab1 = new Label("Nombre:");
	    nombre = new Label("Juan Camilo Zuluaga");
	    Label lab2 = new Label("E-mail:");
	    email = new Label("juaczuluagamon@unal.edu.co");
	    Label lab3 = new Label("Profesion: ");
	    profesion = new Label("Ciencias de la computación");
	    GridPane hojaVida = new GridPane();
	    hojaVida.setPadding(new Insets(10,10,10,10));
	    hojaVida.setVgap(5);
	    hojaVida.setHgap(5);
	    
	    hojaVida.add(lab,1, 0);
	    hojaVida.add(lab1,0, 1);
	    hojaVida.add(lab2,0, 2);
	    hojaVida.add(lab3,0, 3);
	    hojaVida.add(nombre,1, 1);
	    hojaVida.add(email,1, 2);
	    hojaVida.add(profesion,1, 3);
	    
	  //Imagenes
		   
	    GridPane fotos = new GridPane();
	    
	    //Label lb3=new Label("Fotos de los creadores");
	    //fotos.add(lb3,1, 0);
	    
	    
	    
	    File fileA = new File(ruta.getAbsolutePath()+"\\src\\1.png"); 
	    image1 = new ImageView(new Image(fileA.toURI().toString())); 
	    image1.setFitHeight(150);
	    image1.setFitWidth(150);
	    File fileB = new File(ruta.getAbsolutePath()+"\\src\\2.png"); 
	    image2 = new ImageView(new Image(fileB.toURI().toString()));
	    image2.setFitHeight(150);
	    image2.setFitWidth(150);
	    File fileC = new File(ruta.getAbsolutePath()+"\\src\\3.png"); 
	    image3 = new ImageView(new Image(fileC.toURI().toString()));
	    image3.setFitHeight(150);
	    image3.setFitWidth(150);
	    File fileD = new File(ruta.getAbsolutePath()+"\\src\\4.png"); 
	    image4 = new ImageView(new Image(fileD.toURI().toString()));
	    image4.setFitHeight(150);
	    image4.setFitWidth(150);
	    
	    fotos.add(image1 ,0 ,0);
	    fotos.add(image2 ,1 ,0);
	    fotos.add(image3 ,0 ,1);
	    fotos.add(image4 ,1 ,1);
	    
	    
	    //Evento Hoja de vida
	    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
	    	
	    	

			@Override
			public void handle(MouseEvent arg0) {
				
				if (contador == 4) {
		    		contador = 1;	
		    	}
		    	else {
		    		contador++;
		    	}
				
				if (contador == 1) {
					nombre.setText("Danilo Giraldo Lopez");
				    email.setText("Dgiraldolo@unal.edu.co");
				    profesion.setText("Ingenier�a de sistemas e informatica");
				    
				    File fileA = new File(ruta.getAbsolutePath()+"\\src\\Danilo.jpg"); 
				    image1.setImage(new Image(fileA.toURI().toString())); 
				    image1.setFitHeight(150);
				    image1.setFitWidth(150);
				    File fileB = new File(ruta.getAbsolutePath()+"\\src\\Danilo2.jpg"); 
				    image2.setImage(new Image(fileB.toURI().toString()));
				    image2.setFitHeight(150);
				    image2.setFitWidth(150);
				    File fileC = new File(ruta.getAbsolutePath()+"\\src\\Danilo3.jpg"); 
				    image3.setImage(new Image(fileC.toURI().toString()));
				    image3.setFitHeight(150);
				    image3.setFitWidth(150);
				    File fileD = new File(ruta.getAbsolutePath()+"\\src\\Danilo4.jpg"); 
				    image4.setImage(new Image(fileD.toURI().toString()));
				    image4.setFitHeight(150);
				    image4.setFitWidth(150);
				}
				
				else if (contador == 2) {
					nombre.setText("Manuel Alejandro Escobar Mira");
				    email.setText("Maaescobarmi@unal.edu.co");
				    profesion.setText("Ingenier�a de sistemas e informatica");
				    
				    File fileA = new File(ruta.getAbsolutePath()+"\\src\\Manuel1.jpg"); 
				    image1.setImage(new Image(fileA.toURI().toString())); 
				    image1.setFitHeight(150);
				    image1.setFitWidth(150);
				    File fileB = new File(ruta.getAbsolutePath()+"\\src\\Manuel2.jpg"); 
				    image2.setImage(new Image(fileB.toURI().toString()));
				    image2.setFitHeight(150);
				    image2.setFitWidth(150);
				    File fileC = new File(ruta.getAbsolutePath()+"\\src\\Manuel3.jpg"); 
				    image3.setImage(new Image(fileC.toURI().toString()));
				    image3.setFitHeight(150);
				    image3.setFitWidth(150);
				    File fileD = new File(ruta.getAbsolutePath()+"\\src\\Manuel4.jpg"); 
				    image4.setImage(new Image(fileD.toURI().toString()));
				    image4.setFitHeight(150);
				    image4.setFitWidth(150);
				}
				else if (contador == 3) {
					nombre.setText("Michael Stiwar Zapata Agudelo");
				    email.setText("mizapataa@unal.edu.co");
				    profesion.setText("Ingenier�a de sistemas e informatica");
				    
				    File fileA = new File(ruta.getAbsolutePath()+"\\src\\Michael1.jpg"); 
				    image1.setImage(new Image(fileA.toURI().toString())); 
				    image1.setFitHeight(150);
				    image1.setFitWidth(150);
				    File fileB = new File(ruta.getAbsolutePath()+"\\src\\Michael2.jpg"); 
				    image2.setImage(new Image(fileB.toURI().toString()));
				    image2.setFitHeight(150);
				    image2.setFitWidth(150);
				    File fileC = new File(ruta.getAbsolutePath()+"\\src\\Michael3.jpg"); 
				    image3.setImage(new Image(fileC.toURI().toString()));
				    image3.setFitHeight(150);
				    image3.setFitWidth(150);
				    File fileD = new File(ruta.getAbsolutePath()+"\\src\\Michael4.jpg"); 

				    image4.setImage(new Image(fileD.toURI().toString()));
				    image4.setFitHeight(150);
				    image4.setFitWidth(150);
				}
				else if (contador == 4) {
					nombre.setText("Juan Camilo Zuluaga");
					email.setText("juaczuluagamon@unal.edu.co");
					profesion.setText("Ciencias de la computaci�n");
				    
				    File fileA = new File(ruta.getAbsolutePath()+"\\src\\1.png"); 
				    image1.setImage(new Image(fileA.toURI().toString())); 
				    image1.setFitHeight(150);
				    image1.setFitWidth(150);
				    File fileB = new File(ruta.getAbsolutePath()+"\\src\\2.png"); 
				    image2.setImage(new Image(fileB.toURI().toString()));
				    image2.setFitHeight(150);
				    image2.setFitWidth(150);
				    File fileC = new File(ruta.getAbsolutePath()+"\\src\\3.png"); 
				    image3.setImage(new Image(fileC.toURI().toString()));
				    image3.setFitHeight(150);
				    image3.setFitWidth(150);
				    File fileD = new File(ruta.getAbsolutePath()+"\\src\\4.png"); 
				    image4.setImage(new Image(fileD.toURI().toString()));
				    image4.setFitHeight(150);
				    image4.setFitWidth(150);
				}
				
				
				
			}
		};
		
	   
	    hojaVida.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
	    
	    //Imagen rotativa
	    File filee = new File(ruta.getAbsolutePath()+"\\src\\1.png"); 
	    imagenRotativa = new ImageView(new Image(filee.toURI().toString()));
	    imagenRotativa.setFitHeight(200);
	    imagenRotativa.setFitWidth(200);
	    
	    //Evento imagen rotativa
	    EventHandler<MouseEvent> eventHandlerx2 = new EventHandler<MouseEvent>() {
	    	
	    	

			@Override
			public void handle(MouseEvent arg0) {
				
				if (contadorx2 == 4) {
		    		contadorx2 = 1;	
		    	}
		    	else {
		    		contadorx2++;
		    	}
				
				if (contadorx2 == 1) {
					
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\3.png"); 
				    imagenRotativa.setImage(new Image(filee.toURI().toString())); 
				    imagenRotativa.setFitHeight(200);
				    imagenRotativa.setFitWidth(200);
				}
				else if (contadorx2 == 2) {
					
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\2.png"); 
				    imagenRotativa.setImage(new Image(filee.toURI().toString()));
				    imagenRotativa.setFitHeight(200);
				    imagenRotativa.setFitWidth(200);
				}
				else if (contadorx2 == 3) {
					
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\5.jpg"); 
				    imagenRotativa.setImage(new Image(filee.toURI().toString()));
				    imagenRotativa.setFitHeight(200);
				    imagenRotativa.setFitWidth(200);
				    
				}
				else if (contadorx2 == 4) {
				    
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\4.png"); 
				    imagenRotativa.setImage(new Image(filee.toURI().toString()));
				    imagenRotativa.setFitHeight(200);
				    imagenRotativa.setFitWidth(200);
				
			}
			
			}
	    };
	    
	    
	    imagenRotativa.addEventFilter(MouseEvent.MOUSE_ENTERED, eventHandlerx2);
	    
	    
	    
	    //Panel vertical 2
	    vb2.getChildren().add(hojaVida);

	    vb2.getChildren().add(fotos);
	    vb1.getChildren().add(lb1);
	    vb1.getChildren().add(imagenRotativa);
	    vb1.getChildren().add(descripcion);
	    //descripcion.setTranslateY(200);
	    
	    BorderPane root=new BorderPane();
	    BackgroundImage myBI= new BackgroundImage(new Image("https://i.ibb.co/whb3W46/Background.jpg",600,600,true,true),
	            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	              BackgroundSize.DEFAULT);
	    root.setBackground(new Background(myBI));
	    root.setTop(barraMenu);
	    root.setLeft(vb1);
	    root.setRight(vb2);
	    root.setBottom(b1);
	    BorderPane.setMargin(vb1, new Insets(50,20,20,20));
	    BorderPane.setMargin(vb2, new Insets(50,20,20,20));
	    
	    //Ingreso al sistema
	    
	    
	   
	    
	    Scene myScene = new Scene(root, 600, 600);
		myStage.setScene(myScene);
		myStage.show();
		
		EventHandler<MouseEvent> stageChange = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("entre");
				Scene mySceneDos = new Scene(rootScene2, 600, 600);
				myStage.setScene(mySceneDos);
				myStage.show();
				
			}

		
			
			
		};
		b1.addEventHandler(MouseEvent.MOUSE_CLICKED, stageChange);
	}

	class SalirHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			Platform.exit();
		}
		
	}
	/*class EntrarHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
			
		}
	}*/
			
	class DescripcionHandler implements EventHandler<ActionEvent>{
	
		@Override
		public void handle(ActionEvent event) {
			
			if (contadorx == 0) {
				contadorx++;
				descripcion.setText("Lenty es una aplicacion que te permitira, como administrador de un despacho de envios, registrar usuarios, "
			    		+ "repartidos, con sus respectivos vehiculos, productos y, con todo esto, hacer ordenes que permitan una organizacion "
			    		+ "eficaz.");
					descripcion.setTextFill(Color.web("#19164a"));
				    descripcion.setPrefWidth(200);
				    descripcion.setWrapText(true);
				    descripcion.setFont(new Font("Berlin Sans FB",15));
			}
			else {
				contadorx = 0;
				descripcion.setText("");
			}
			
			
		    
		}
	}
	class AyudaHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Imprimir los nombres de los creadores en una ventana emergente");
			
		}
	}
	class MenuUsuariosHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//Menu de usuarios
			
			Button btnClientes = new Button();
			Button btnRepartidores = new Button();
			
			try {
				//imagen clientes
				Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\clientes.png"));
				ImageView im1 = new ImageView(image1);
				im1.setFitHeight(120);
				im1.setFitWidth(120);
				Button btn1 = new Button("Clientes", im1);
				btn1.setStyle("-fx-base: blue;");
				btn1.setContentDisplay(ContentDisplay.TOP);
				btn1.setMaxSize(100, 50);
				btnClientes = btn1;
				
				//imagen repartidores
				Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\repartidores.png"));
				ImageView im2 = new ImageView(image2);
				im2.setFitHeight(120);
				im2.setFitWidth(120);
				Button btn2 = new Button("Repartidores", im2);
				btn2.setStyle("-fx-base: orange;");
				btn2.setContentDisplay(ContentDisplay.TOP);
				btn2.setMaxSize(120, 50);
				btnRepartidores = btn2;
			} catch (FileNotFoundException e) {
				Alert info = new Alert(AlertType.ERROR);
				info.setHeaderText("Error");
				info.setTitle("No se pudo encontrar la imagen");
				info.setContentText("");
				info.show();
			}
			
			btnClientes.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event){
					System.out.println("Clientes");
				}
			});
			
			btnRepartidores.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event){
					System.out.println("Repartidores");
				}
			});
		}
	}
	class MenuOrdenesHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Menu de Ordenes");
			
		}
	}
	class MenuProductosHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Menu de Productos");
			
		}
	}
	class MenuVehiculosHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Menu de Vehiculos");
			
		}
	}
	class MenuSedesHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Menu de Sedes");
			
		}
	}
		
		
	}
		

	
