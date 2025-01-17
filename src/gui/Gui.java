package gui;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import gestorAplicacion.orden.Producto;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

import java.util.*;

import baseDatos.Escritor;
import baseDatos.Lector;
import gestorAplicacion.gestionHumana.*;
import gestorAplicacion.orden.*;
import gestorAplicacion.sede.*;
import gestorAplicacion.vehiculo.*;



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
		Lector.Leer();
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
		Menu archivo=new Menu("Lenty");
		Menu proYCon=new Menu("Procesos y consultas");
		Menu ayuda=new Menu("Ayuda");
		MenuItem MenUsu=new MenuItem("Menu Usuarios");
		MenuItem MenOrd=new MenuItem("Menu Ordenes");
		MenuItem MenPro=new MenuItem("Menu Productos");
		MenuItem MenVeh=new MenuItem("Menu Vehiculos");
		MenuItem MenSed=new MenuItem("Menu Sedes");
		MenuItem acercaDe = new MenuItem("Acerca de");
		MenuItem salirB = new MenuItem("Guardar y Salir");
		archivo.getItems().add(salirB);
		ayuda.getItems().add(acercaDe);
		proYCon.getItems().addAll(MenUsu,MenOrd,MenPro,MenVeh,MenSed);
		barraMenu2.getMenus().addAll(archivo,proYCon,ayuda);
		
		//Scene2
		BorderPane rootScene2 = new BorderPane();
		rootScene2.setTop(barraMenu2);
		VBox ingreso=new VBox();

		Label ingreso1=new Label("Bienvenido a Lenty, aplicacion para la gestion eficaz de "
				+ "envios, arriba de la ventana vera dos menus, en Ayuda podra ver los desarrolladores "
				+ "de esta aplicacion por si cuenta con alguna dida al respecto, al lado izquierdo "
				+ "de esto se encuentra el menu Procesos y Consultas, el cual despliega las opciones "
				+ "necesarias para poder despachar ordenes de manera efectiva, en cada uno de esas opciones"

				+ "se encontrara una breve descripcion de las acciones que podra realizar dentro."
				+ "\nEn la pesta�a Lenty hay un boton para guardar y salir.");
		ingreso1.setTextFill(Color.web("#19164a"));
	    ingreso1.setPrefWidth(400);
	    ingreso1.setWrapText(true);
	    ingreso1.setFont(new Font("Berlin Sans FB",25));
		ingreso.getChildren().add(ingreso1);
		ingreso.setAlignment(Pos.CENTER);
		rootScene2.setCenter(ingreso);
		
		salirB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Escritor.Escribir();
				Platform.exit();
			}
			
		});
		
		acercaDe.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert dialog = new Alert(AlertType.NONE);
				dialog.setAlertType(AlertType.INFORMATION);
				dialog.setTitle("Acerca de");
				dialog.setHeaderText("Esta aplicacion fue creada por:\n\n"
						+ "-Michael Zapata\n"
						+ "-Danilo Garcia\n"
						+ "-Juan Zuluaga\n"
						+ "-Manuel Escobar");
				dialog.setContentText("Universidad Nacional de Colombia, 2020");
				dialog.show();
			}
			
		});
		
		
		
		MenUsu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Label a = new Label("Gestion Humana");
				Label b = new Label("En este menu podras seleccionar los sub Menu de Clientes y Repartidores para acceder \n a cada una de las opciones por tipo de usuario");
				
				// Pane de Gestion Humana
				GridPane gestionHumana = new GridPane();
				gestionHumana.setPadding(new Insets(10,10,10,10));
				gestionHumana.setVgap(5);
				gestionHumana.setHgap(5);
				gestionHumana.setAlignment(Pos.CENTER);
				
				GridPane clientes = new GridPane();
				clientes.setPadding(new Insets(10,10,10,10));
				clientes.setVgap(5);
				clientes.setHgap(5);
				clientes.setAlignment(Pos.CENTER);
				
				
				GridPane repartidores = new GridPane();
				repartidores.setPadding(new Insets(10,10,10,10));
				repartidores.setVgap(5);
				repartidores.setHgap(5);
				repartidores.setAlignment(Pos.CENTER);
				
				
				Button btnClientes = new Button();
				Button btnRepartidores = new Button();
				
				try {
					//imagen clientes
					Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\Imagenes\\clientes.png"));
					ImageView im1 = new ImageView(image1);
					im1.setFitHeight(120);
					im1.setFitWidth(120);
					Button btn1 = new Button("Clientes", im1);
					btn1.setStyle("-fx-base: blue;");
					btn1.setContentDisplay(ContentDisplay.TOP);
					btn1.setMaxSize(100, 50);
					btnClientes = btn1;
					
					clientes.add(btnClientes, 0, 0);
					
					//imagen repartidores
					Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\Imagenes\\repartidores.png"));
					ImageView im2 = new ImageView(image2);
					im2.setFitHeight(120);
					im2.setFitWidth(120);
					Button btn2 = new Button("Repartidores", im2);
					btn2.setStyle("-fx-base: orange;");
					btn2.setContentDisplay(ContentDisplay.TOP);
					btn2.setMaxSize(120, 50);
					btnRepartidores = btn2;
					
					repartidores.add(btnRepartidores, 0, 0);
					
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
						gestionHumana.getChildren().remove(clientes);
						gestionHumana.getChildren().remove(repartidores);
						
						a.setText("Menu de Clientes");
						b.setText("En este menu podras visualizar el listado de clientes, consultar el cliente que mas productos ha comprado y agregar nuevos clientes");
						
						//Pane de Clientes
						GridPane menuClientes = new GridPane();
						menuClientes.setPadding(new Insets(10,10,10,10));
						menuClientes.setVgap(5);
						menuClientes.setHgap(5);
						menuClientes.setAlignment(Pos.CENTER);
						
						Label regi = new Label("Registrar un Cliente");
						Label docu = new Label("Documento (Long)");
						TextField documento=new TextField();
						Label nom = new Label("Nombre (String)=");
						TextField nombre = new TextField();
						Label tel = new Label("Telefono (String)=");
						TextField telefono = new TextField();
						Label gen = new Label("Genero (M/F)=");
						TextField genero = new TextField();
						Label dir = new Label("Direccion (Sin espacios)=");
						TextField direccion = new TextField();
						Label metodo = new Label("Metodo de pago");
						Label tarj = new Label("Numero de tarjeta (Sin espacios)=");
						TextField tarjeta = new TextField();
						
						ChoiceBox<String> cb = new ChoiceBox<String>(FXCollections.observableArrayList(
							    "Efectivo", "Tarjeta")
						);
						cb.setTooltip(new Tooltip("Selecciona un metodo de pago"));
						
						VBox RegClie = new VBox(regi,docu,documento,nom,nombre,tel,telefono,gen,genero,dir,direccion,metodo,cb);
						
						cb.getSelectionModel().selectedIndexProperty().addListener(
						         (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
						            if(new_val.intValue() == 0) {
						            	tarjeta.setText("00000000000");
						            	RegClie.getChildren().remove(tarj);
						            	RegClie.getChildren().remove(tarjeta);
						            } else {
						            	RegClie.getChildren().add(13,tarj);
						            	RegClie.getChildren().add(14,tarjeta);
						            };
						      });
						Button registrar = new Button("Registrar");
						registrar.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent arg0) {
								try {
									Long documento1 = Long.parseLong(documento.getText());
									String nombre1 = nombre.getText();
									String telefono1 = telefono.getText();
									String genero1 = genero.getText();
									String direccion1=direccion.getText();
									String metPag1="";
									if(tarjeta.getText().equals("00000000000")) {
										metPag1="efectivo";
									}
									else {
										metPag1="tarjeta";
									}
									int tarjeta1 = Integer.parseInt(tarjeta.getText());
									Alert confir = new Alert(AlertType.CONFIRMATION);
									confir.setTitle("Confirmar registro cliente");
									confir.setHeaderText("Se requiere confirmacion para crear el cliente o se descartara");
									confir.setContentText("Esta seguro de que quiere registrar el cliente con documento= "
											+ documento1+", direccion= "+direccion1+", nombre= " + nombre1+", telefono= "+telefono1+", genero= "+genero1
											+", metodo de pago= "+metPag1);
									Optional<ButtonType> result=confir.showAndWait();
									if(result.get()==ButtonType.OK) {
										Alert mens=new Alert(AlertType.INFORMATION);
										mens.setTitle("Registro cliente");
										mens.setHeaderText("Se registro al cliente");
										mens.show();
										new Cliente(direccion1,metPag1,tarjeta1,documento1,nombre1,genero1,telefono1);
										documento.setText("");
										nombre.setText("");
										telefono.setText("");
										genero.setText("");
										tarjeta.setText("");
										direccion.setText("");
									}
									else {
										Alert mens=new Alert(AlertType.INFORMATION);
										mens.setTitle("No se registro el cliente");
										mens.setHeaderText("Se cancelo el registro del cliente");
										mens.show();
									}
									
								}
								catch(Exception e) {
									Alert error=new Alert(AlertType.ERROR);
									error.setTitle("ERROR");
									error.setTitle("No se pudo registrar cliente");
									error.setContentText("Verifique los datos, que pertenezcan al tipo de dato requerido");
									error.show();
								}
							}
							
						});
						RegClie.getChildren().add(registrar);
						
						// Consultar
						Button consultar = new Button("Ver Clientes");
						consultar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
						consultar.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								String aux="";
								for(int i=0;i<Cliente.getClientes().size();i++) {
									aux+="\n Nombre= "+Cliente.getClientes().get(i).getNombre()+", ID= "+Cliente.getClientes().get(i).getId();
								}
								Alert confir = new Alert(AlertType.INFORMATION);
								confir.setTitle("Cliente registrados");
								confir.setHeaderText("Nombre, ID de los clientes registrados");
								confir.setContentText(aux);
								confir.show();
							}
							
						});
						gestionHumana.add(consultar, 1, 0);
						
						// Cliente con mayores compras
						Button mayoresCompras = new Button("Cliente que mas ha comprado");
						mayoresCompras.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
						mayoresCompras.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {
								try {
									Alert confir = new Alert(AlertType.INFORMATION);
									confir.setTitle("Cliente que mas ha comprado");
									confir.setHeaderText("El cliente con mayores compras ha sido");
									confir.setContentText("Nombre= "+Cliente.clienteMayorVentas().getNombre()+", Numero de compras= "+Cliente.clienteMayorVentas().getCantVentas());
									confir.show();
								}
								catch(Exception a) {
									Alert confir = new Alert(AlertType.ERROR);
									confir.setTitle("Cliente que mas ha comprado");
									confir.setHeaderText("No hay cliente con mayor ventas");
									confir.show();
								}
							}
							
						});
						gestionHumana.add(mayoresCompras, 1, 1);
						
						// Regresar
						Button regresar = new Button("Regresar");
						regresar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
						gestionHumana.add(regresar, 0, 1);
						regresar.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent arg0) {
								gestionHumana.getChildren().remove(consultar);
								gestionHumana.getChildren().remove(mayoresCompras);
								gestionHumana.getChildren().remove(regresar);
								gestionHumana.getChildren().remove(RegClie);
								a.setText("Gestion Humana");
								b.setText("En este menu podras seleccionar los sub Menu de Clientes y Repartidores para acceder \n a cada una de las opciones por tipo de usuario");
								gestionHumana.add(clientes, 0, 0);
								gestionHumana.add(repartidores, 1, 0);
							}
						});
						
						gestionHumana.add(RegClie, 0, 0);
					}
				});
				
				btnRepartidores.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event){
						gestionHumana.getChildren().remove(clientes);
						gestionHumana.getChildren().remove(repartidores);
						
						a.setText("Menu de Repartidores");
						b.setText("En este menu podras visualizar el listado de Repartidores, consultar el repartidor que ha realizado mas envios y agregar nuevos repartidores");
						
						//Pane de Repartidores
						GridPane menuRepartidores = new GridPane();
						menuRepartidores.setPadding(new Insets(10,10,10,10));
						menuRepartidores.setVgap(5);
						menuRepartidores.setHgap(5);
						menuRepartidores.setAlignment(Pos.CENTER);
						
						Label regi = new Label("Registrar un Repartidor");
						Label docu = new Label("Documento (Long)=");
						TextField documento=new TextField();
						Label nom = new Label("Nombre (String)=");
						TextField nombre = new TextField();
						Label tel = new Label("Telefono (String)=");
						TextField telefono = new TextField();
						Label gen = new Label("Genero (M/F)=");
						TextField genero = new TextField();
						Label ent = new Label("Entidad de Salud (Sin espacios)=");
						TextField entidad = new TextField();
						Label sal = new Label("Salario (Sin signos)=");
						TextField salario = new TextField();
						
						VBox RegRepart = new VBox(regi,docu,documento,nom,nombre,tel,telefono,gen,genero,ent,entidad,sal,salario);
						Button registrar = new Button("Registrar");
						registrar.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent arg0) {
								try {
									long documento1=Long.parseLong(documento.getText());
									String nombre1 = nombre.getText();
									String telefono1 = telefono.getText();
									String genero1 = genero.getText();
									String entidad1 = entidad.getText();
									int salario1 = Integer.parseInt(salario.getText());
									Alert confir = new Alert(AlertType.CONFIRMATION);
									confir.setTitle("Confirmar registro repartidor");
									confir.setHeaderText("Se requiere confirmacion para crear el repartidor o se descartara");
									confir.setContentText("Esta seguro de que quiere registrar el repartidor con documento= "
											+ documento1+", nombre= " + nombre1+", telefono= "+telefono1+", genero= "+genero1+", salario= "+salario1);
									Optional<ButtonType> result=confir.showAndWait();
									if(result.get()==ButtonType.OK) {
										Alert mens=new Alert(AlertType.INFORMATION);
										mens.setTitle("Registro repartidor");
										mens.setHeaderText("Se registro al repartidor");
										mens.show();
										new Repartidor(entidad1,salario1,true,documento1,nombre1,genero1,telefono1);
										documento.setText("");
										nombre.setText("");
										telefono.setText("");
										genero.setText("");
										entidad.setText("");
										salario.setText("");
									}
									else {
										Alert mens=new Alert(AlertType.INFORMATION);
										mens.setTitle("No se registro el repartidor");
										mens.setHeaderText("Se cancelo el registro del repartidor");
										mens.show();
									}

								}
								catch(Exception e) {
									Alert error=new Alert(AlertType.ERROR);
									error.setTitle("ERROR");
									error.setTitle("No se pudo registrar repartidor");
									error.setContentText("Verifique los datos, que pertenezcan al tipo de dato requerido");
									error.show();
								}
							}
							
						});
						RegRepart.getChildren().add(registrar);
						
						// Consultar
						Button consultar = new Button("Ver Repartidores");
						consultar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
						consultar.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								String aux="";
								for(int i=0;i<Repartidor.getRepartidores().size();i++) {
									aux+="\n Nombre= "+Repartidor.getRepartidores().get(i).getNombre()+", ID= "+Repartidor.getRepartidores().get(i).getId();
								}
								Alert confir = new Alert(AlertType.INFORMATION);
								confir.setTitle("Repartidores registrados");
								confir.setHeaderText("Nombre, ID de los repartidores registrados");
								confir.setContentText(aux);
								confir.show();
							}
							
						});
						gestionHumana.add(consultar, 1, 0);
						
						// Repartidor con mas pedidos
						Button mayoresPedidos = new Button("Repartidor con mas pedidos");
						mayoresPedidos.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
						mayoresPedidos.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {
								Alert confir = new Alert(AlertType.INFORMATION);
								confir.setTitle("Repartidor con mas pedidos");
								confir.setHeaderText("El repartidor que mas pedidos ha realizado");
								confir.setContentText("Nombre= "+Repartidor.repartidorMasPedidos().getNombre()+", Numero de pedidos= "+Repartidor.repartidorMasPedidos().getCantVentas());
								confir.show();
							}
							
						});
						gestionHumana.add(mayoresPedidos, 1, 1);
						
						// Regresar
						Button regresar = new Button("Regresar");
						regresar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
						gestionHumana.add(regresar, 0, 1);
						regresar.setOnMouseClicked(new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent arg0) {
								gestionHumana.getChildren().remove(consultar);
								gestionHumana.getChildren().remove(mayoresPedidos);
								gestionHumana.getChildren().remove(regresar);
								gestionHumana.getChildren().remove(RegRepart);
								a.setText("Gestion Humana");
								b.setText("En este menu podras seleccionar los sub Menu de Clientes y Repartidores para acceder \n a cada una de las opciones por tipo de usuario");
								gestionHumana.add(clientes, 0, 0);
								gestionHumana.add(repartidores, 1, 0);
							}
						});
						
						gestionHumana.add(RegRepart, 0, 0);
					}
				});
				
				gestionHumana.add(clientes, 0, 0);
				gestionHumana.add(repartidores, 1, 0);
				
				BorderPane border = new BorderPane();
				
				VBox t = new VBox(10);
				t.getChildren().add(a);
				t.getChildren().add(b);
				border.setCenter(gestionHumana);
				border.setTop(t);
			    b.setWrapText(true);
			    b.setAlignment(Pos.CENTER);
			    b.setStyle(" -fx-border-color:black; -fx-border-width: 1; -fx-border-style: solid;");
			    t.setAlignment(Pos.CENTER);
			    
			    BorderPane.setMargin(t, new Insets(50,20,20,20));
				rootScene2.setCenter(border);
			}
		});
		
		
		MenOrd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
			GridPane Orden1=new GridPane();
			Orden1.setAlignment(Pos.CENTER);
			//Crear Orden
			ArrayList<String> pruebaClientes=new ArrayList<>();
			for(int i=0;i<Cliente.getClientes().size();i++) {
				pruebaClientes.add(Cliente.getClientes().get(i).getNombre());
			}
			ArrayList<String> pruebaSedes=new ArrayList<>();
			for(int i=0;i<Sede.getSede().size();i++) {
				pruebaSedes.add(Sede.getSede().get(i).getDireccion());
			}
			ArrayList<String> pruebaRepartidores=new ArrayList<>();
			for(int i=0;i<Repartidor.getRepartidores().size();i++) {
				pruebaRepartidores.add(Repartidor.getRepartidores().get(i).getNombre());
			}
			ArrayList<String> pruebaProductos=new ArrayList<>();
			for(int i=0;i<Producto.getProductos().size();i++) {
				pruebaProductos.add(Producto.getProductos().get(i).getNombre());
			}
			
			
			Label lbOr1=new Label("Crear Orden");
			ComboBox<String> eliCli=new ComboBox<String>(FXCollections.observableArrayList(pruebaClientes));
			eliCli.setPromptText("Seleccione un Cliente");
			TextField cliente=new TextField();
			eliCli.valueProperty().addListener(new ChangeListener<String>(){

				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					cliente.setText(arg2);
				}
				
			});
			ComboBox<String> eliSede=new ComboBox<String>(FXCollections.observableArrayList(pruebaSedes));
			eliSede.setPromptText("Seleccione la Sede");
			TextField sede=new TextField();
			eliSede.valueProperty().addListener(new ChangeListener<String>(){

				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					sede.setText(arg2);
				}
				
			});
			ComboBox<String> eliRep=new ComboBox<String>(FXCollections.observableArrayList(pruebaRepartidores));
			eliRep.setPromptText("Seleccione un repartidor");
			TextField repartidor=new TextField();
			eliRep.valueProperty().addListener(new ChangeListener<String>(){

				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					repartidor.setText(arg2);
				}
				
			});
			ComboBox<String> eligPro=new ComboBox<String>(FXCollections.observableArrayList(pruebaProductos));
			eligPro.setPromptText("Seleccione el Producto");
			TextField producto=new TextField();
			eligPro.valueProperty().addListener(new ChangeListener<String>(){

				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
					producto.setText(arg2);
				}
				
			});
			ArrayList<Producto> listaAux =new ArrayList<>();
			Button agregar=new Button("agregar");
			agregar.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					for(int i=0;i<Producto.getProductos().size();i++) {
						if(producto.getText().equals(Producto.getProductos().get(i).getNombre())) {
							listaAux.add(Producto.getProductos().get(i));
						}
					}
				}
				
			});
			Label pso=new Label("Peso de la orden=");
			TextField peso=new TextField();
			Button crear=new Button("Crear Orden");
			crear.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					try{
						String prod1="";
						Cliente cliente1=null;
						for(int i=0; i<Cliente.getClientes().size();i++) {
							if(Cliente.getClientes().get(i).getNombre().equals(cliente.getText())) {
								cliente1=Cliente.getClientes().get(i);
							}
						}
						Sede sede1 = null;
						for(int i=0;i<Sede.getSede().size();i++) {
							if(Sede.getSede().get(i).getDireccion().equals(sede.getText())) {
								sede1=Sede.getSede().get(i);
							}
						}
						Repartidor repartidor1 = null;
						for(int i=0;i<Repartidor.getRepartidores().size();i++) {
							if(Repartidor.getRepartidores().get(i).getNombre().equals(repartidor.getText())) {
								repartidor1=Repartidor.getRepartidores().get(i);
							}
						}
						int valor = 0;
						ArrayList<Producto> productos=listaAux;
						for (int i = 0; i<productos.size();i++) {
							valor+= productos.get(i).getPrecio();
						}
						for(int i=0;i<productos.size();i++) {
							prod1+=productos.get(i).getNombre()+", ";
						}
						float peso1=Float.parseFloat(peso.getText());
						Alert dialog = new Alert(AlertType.NONE);
						dialog.setAlertType(AlertType.CONFIRMATION);
						dialog.setTitle("Creacion Orden");
						dialog.setHeaderText("Se requiere confimacion para crear la orden para el Cliente "+cliente1.getNombre()
								+"\nen la Sede "+sede1.getDireccion()+" que se enviara con el Repartidor "+repartidor1.getNombre()+" con peso de "+peso1
								+"\ncon los productos "+prod1);
						Optional<ButtonType> result=dialog.showAndWait();
						if(result.get()==ButtonType.OK) {
							Alert mens=new Alert(AlertType.INFORMATION);
							mens.setTitle("Creacion de la Orden");
							mens.setHeaderText("Se creo la Orden");
							mens.show();
							new Orden(cliente1,sede1,repartidor1,valor,productos,peso1,"Aceptada");
							eliCli.setValue("Seleccione un Cliente");
							eliSede.setValue("Seleccion la sede");
							eliRep.setValue("Seleccione el repartidor");
							eligPro.setValue("Seleccione el Producto");
							cliente.setText("");
							sede.setText("");
							repartidor.setText("");
							producto.setText("");
							peso.setText("");
							listaAux.clear();
						}
						else {
							Alert mens=new Alert(AlertType.INFORMATION);
							mens.setTitle("No se creo la Orden");
							mens.setHeaderText("Se cancelo la creacion de la Orden");
							mens.show();
						}
					}
					catch(Exception e) {
						Alert error=new Alert(AlertType.ERROR);
						error.setTitle("ERROR");
						error.setTitle("No se pudo crear la Orden");
						error.setContentText("Verifique los datos, que pertenezcan al tipo de dato requerido");
						error.show();
					}
				}
				
			});
			VBox CreOrden=new VBox(lbOr1,eliCli,cliente,eliSede,sede,eliRep,repartidor,eligPro,producto,agregar,pso,peso,crear);
			Orden1.add(CreOrden, 0, 0);
			//Ver ordenes activas
			Button ordenesAct=new Button("Ver ordenes activas");
			ordenesAct.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			
			ordenesAct.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					Alert dialog = new Alert(AlertType.NONE);
					String aux7="";
					for(int i=0;i<Orden.getOrdenes().size();i++) {
						if(Orden.getOrdenes().get(i).getEstado().equals("Aceptada") || Orden.getOrdenes().get(i).getEstado().equals("Activa") ) {
							aux7+="\nId de orden : "+Orden.getOrdenes().get(i).getId()+", cliente : "+Orden.getOrdenes().get(i).getCliente().getNombre()+" ";
						}
					}
					dialog.setAlertType(AlertType.INFORMATION);
					dialog.setTitle("Ordenes Activas");
					dialog.setHeaderText("ID de la orden, Cliente de la orden");
					dialog.setContentText(aux7);
					dialog.show();
				}
				
			});
			Orden1.add(ordenesAct, 1, 0);
			Orden1.setVgap(5);
			Orden1.setHgap(5);
			//Eliminar Orden

			Label eliminarOrden=new Label("Eliminar Orden");
			ComboBox<Integer> eliAEli=new ComboBox<Integer>();
			for(int i=0;i<Orden.getOrdenes().size();i++) {
				eliAEli.getItems().add(Orden.getOrdenes().get(i).getId());
			}
			eliAEli.setPromptText("ID de Orden a Eliminar");
			TextField eliminacion=new TextField();
			eliAEli.valueProperty().addListener(new ChangeListener<Integer>(){
				@Override
				public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
					// TODO Auto-generated method stub
					eliminacion.setText(String.valueOf(arg2));
				}
				
			});
			Button eliminar=new Button("Eliminar Orden");
			eliminar.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					try {
						String id = eliminacion.getText();
						int aux = eliAEli.getSelectionModel().getSelectedIndex();
						Alert dialog = new Alert(AlertType.NONE);
						dialog.setAlertType(AlertType.INFORMATION);
						dialog.setTitle("Orden eliminada");
						dialog.setHeaderText("Se elimino la orden correctamente");
						dialog.setContentText("ID de la orden eliminada: "+(id));
						dialog.show();
					
						Orden.getOrdenes().remove(aux);
						eliAEli.getItems().clear();
						for(int i=0;i<Orden.getOrdenes().size();i++) {
							eliAEli.getItems().add(Orden.getOrdenes().get(i).getId());
						}
						eliminacion.setText("");
					}
					catch(Exception e) {
						Alert error=new Alert(AlertType.ERROR);
						error.setTitle("ERROR");
						error.setTitle("No se eliminara la Orden");
						error.setContentText("Verifique que el indice pertenezca a una orden");
						error.show();
					}
				}
				
			});
			VBox El=new VBox(eliminarOrden,eliAEli,eliminacion,eliminar);
			Orden1.add(El, 0, 1);
			//Modificar Orden
			
			

			BorderPane border = new BorderPane();
			VBox t = new VBox(10);
			Label a = new Label("Menu de Ordenes");
			Label b =new Label("En este menu puede crear y eliminar ordenes, asi como consultar las ordenes activas");
			t.getChildren().add(a);
			t.getChildren().add(b);
			border.setCenter(Orden1);
			border.setTop(t);
		    b.setWrapText(true);
		    b.setAlignment(Pos.CENTER);
		    b.setStyle(" -fx-border-color:black; -fx-border-width: 1; -fx-border-style: solid;");
		    t.setAlignment(Pos.CENTER);

			BorderPane.setMargin(t, new Insets(50,20,20,20));
			rootScene2.setCenter(border);
			}
			
		});
		
		
		
		MenPro.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				GridPane producto = new GridPane();
				producto.setPadding(new Insets(10,10,10,10));
				producto.setVgap(5);
				producto.setHgap(5);
				producto.setAlignment(Pos.CENTER);
				
				
				GridPane agregar = new GridPane();
				agregar.setPadding(new Insets(10,10,10,10));
				agregar.setVgap(5);
				agregar.setHgap(5);
				agregar.setAlignment(Pos.CENTER);
				
				agregar.add(new Label("Agregar Producto"), 0, 0);
				agregar.add(new Label("Nombre"), 0, 1);
				agregar.add(new Label("Descripcion"), 0, 2);
				agregar.add(new Label("Precio"), 0, 3);
				TextField nombreP = new TextField();
				TextField descripcionP = new TextField();
				TextField precioP = new TextField();
				agregar.add(nombreP, 1, 1);
				agregar.add(descripcionP, 1, 2);
				agregar.add(precioP, 1, 3);
				System.out.println(nombreP.getText());
				Button agregarB = new Button("Agregar");
				agregarB.setMinSize(100, 0);
				agregar.add(agregarB, 0, 4);
				
				GridPane eliminarG = new GridPane();

				eliminarG.setPadding(new Insets(10,10,10,10));
				eliminarG.setVgap(5);
				eliminarG.setHgap(5);
				eliminarG.setAlignment(Pos.CENTER);
				Button eliminarB = new Button("Eliminar");
				eliminarB.setMinSize(100, 0);
				eliminarG.add(eliminarB, 0, 14);
				ComboBox<String> eliminar = new ComboBox<String>();
				LinkedList<String> productos = Producto.verProductos();
				for (int i = 0; i<productos.size();i++) {
					eliminar.getItems().add(productos.get(i));
				}
				
				eliminar.setPromptText("Productos");
				eliminar.valueProperty().addListener(new ChangeListener<String>(){
					
					public void changed(ObservableValue ov, String t, String t1) {
						String productoAEliminar = t1;
						int indice = eliminar.getSelectionModel().getSelectedIndex();
						Alert dialog = new Alert(AlertType.NONE);

						eliminarB.setOnMouseClicked(new EventHandler<MouseEvent>() {
							public void handle(MouseEvent event) {
						
									if(productoAEliminar == "Productos") {
										dialog.setAlertType(AlertType.ERROR);
										dialog.setTitle("Eliminar producto");
										dialog.setHeaderText("No se selecciono ningun producto");
										dialog.setContentText("Por favor seleccione uno");
										dialog.show();
									}
									else {
										
										dialog.setAlertType(AlertType.INFORMATION);
										dialog.setTitle("Eliminar producto");
										dialog.setHeaderText("Se elimino el producto con exito");
										dialog.setContentText("El producto "+productoAEliminar+" se elimino");
										dialog.show();
										Producto.getProductos().remove(indice);
										eliminar.getItems().clear();
										LinkedList<String> productos = Producto.verProductos();
										for (int i = 0; i<productos.size();i++) {
											eliminar.getItems().add(productos.get(i));
										}
										eliminar.setValue("Productos");
									}
									
									
								
							
							}

						});
					}});
				eliminar.setMinSize(250, 0);

				eliminarG.add(eliminar, 0, 3);
				eliminarG.add(new Label("Eliminar producto"), 0, 0);
				
				
				
				producto.add(agregar, 0, 0);
				producto.add(eliminarG, 1, 0);
				Button productoV = new Button("Productos mas vendidos");
				productoV.setMinHeight(100);
				productoV.setMinWidth(250);
				producto.add(productoV, 0, 20);
				Button productoE = new Button("Productos en existencia");
				productoE.setMinHeight(100);
				productoE.setMinWidth(250);
				producto.add(productoE, 1, 20);
				
				
				productoV.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						try {
							Alert dialog = new Alert(AlertType.NONE);
							dialog.setAlertType(AlertType.INFORMATION);
							dialog.setTitle("Producto mas vendido");
							dialog.setHeaderText("El producto que mas se ha vendido es "+Producto.productoMayorVentas().getNombre());
							dialog.setContentText("Informacion completa:\n"+(Producto.productoMayorVentas().toString())+"\nSe ha vendido "+Producto.productoMayorVentas().getCantVentas()+" veces");
							dialog.show();
						}
						catch(Exception a) {
							Alert dialog = new Alert(AlertType.NONE);
							dialog.setAlertType(AlertType.ERROR);
							dialog.setTitle("Producto mas vendido");
							dialog.setHeaderText("No hay un producto mas vendido");
							dialog.show();
						}
					}

				});
				
				productoE.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						if(Producto.getProductos().size() != 0) {	
							Alert dialog = new Alert(AlertType.NONE);
							String s = "";
							for(String a : Producto.verProductos()) {
								s += a+"\n";
							}
							dialog.setAlertType(AlertType.INFORMATION);
							dialog.setTitle("Productos en existencia");
							dialog.setHeaderText("Los productos en existencia son los siguientes:");
							dialog.setContentText(s);
							dialog.show();
						}
						else {
							Alert dialog = new Alert(AlertType.NONE);
							dialog.setAlertType(AlertType.ERROR);
							dialog.setTitle("Productos en existencia");
							dialog.setHeaderText("No hay productos en existencia");
							dialog.show();
							
						}
					}

				});
				
				
				Alert dialog = new Alert(AlertType.NONE);
				agregarB.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						String nombre = nombreP.getText();
						String precio = precioP.getText();
						String descripcion = descripcionP.getText();
						if (nombre.isEmpty()) {
							dialog.setAlertType(AlertType.ERROR);
							dialog.setTitle("Falta el nombre");
							dialog.setHeaderText("No se puede crear un producto sin nombre");
							dialog.setContentText("Por favor ingrese un nombre");
							dialog.show();
						}
						else if(precio.isEmpty()) {
							dialog.setAlertType(AlertType.ERROR);
							dialog.setTitle("Falta el precio");
							dialog.setHeaderText("No se puede crear un producto sin precio");
							dialog.setContentText("Por favor ingrese un precio");
							dialog.show();
						}
						else if(descripcion.isEmpty()){
							dialog.setAlertType(AlertType.INFORMATION);
							dialog.setTitle("Agregar Producto");
							dialog.setHeaderText("Se agrego el producto con exito");
							dialog.setContentText("El producto "+nombre+" se guardo con el precio "+precio);
							dialog.show();
							
							Producto.agregarProducto(nombre, "", Integer.parseInt(precio));
							eliminar.getItems().clear();
							LinkedList<String> productos = Producto.verProductos();
							for (int i = 0; i<productos.size();i++) {
								eliminar.getItems().add(productos.get(i));
							}
							nombreP.setText("");
							descripcionP.setText("");
							precioP.setText("");
						}
						else {
							dialog.setAlertType(AlertType.INFORMATION);
							dialog.setTitle("Agregar Producto");
							dialog.setHeaderText("Se agrego el producto con exito");
							dialog.setContentText("El producto "+nombre+" se guardo con el precio "+precio);
							dialog.show();
							
							Producto.agregarProducto(nombre, descripcion, Integer.parseInt(precio));
							
							

							eliminar.getItems().clear();
							LinkedList<String> productos = Producto.verProductos();
							for (int i = 0; i<productos.size();i++) {
								eliminar.getItems().add(productos.get(i));
							}
							nombreP.setText("");
							descripcionP.setText("");
							precioP.setText("");
						}
					}
				});
				BorderPane border = new BorderPane();
				VBox t = new VBox(10);
				Label a = new Label("Menu de Productos");
				Label b =new Label("En este menu puede agregar, eliminar o consultar tanto los productos en inventario como el producto mas vendido\n"
						+ "La descripcion es opcional.");
				t.getChildren().add(a);
				t.getChildren().add(b);
				border.setCenter(producto);
				border.setTop(t);
			    b.setWrapText(true);
			    b.setAlignment(Pos.CENTER);
			    b.setStyle(" -fx-border-color:black; -fx-border-width: 1; -fx-border-style: solid;");
			    t.setAlignment(Pos.CENTER);

				BorderPane.setMargin(t, new Insets(50,20,20,20));
				rootScene2.setCenter(border);
				
			}
			
		});
		
		MenSed.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				GridPane sede = new GridPane();
				sede.setPadding(new Insets(10,10,10,10));
				sede.setVgap(5);
				sede.setHgap(5);
				sede.setAlignment(Pos.CENTER);
				
				GridPane registrarS = new GridPane();
				registrarS.setPadding(new Insets(10,10,10,10));
				registrarS.setVgap(5);
				registrarS.setHgap(5);
				registrarS.setAlignment(Pos.CENTER);
				
				registrarS.add(new Label("Registrar sede"), 0, 0);
				registrarS.add(new Label("Direccion"), 0, 1);
				registrarS.add(new Label("Telefono"), 0, 2);
				TextField direccion = new TextField();
				TextField telefono = new TextField();
				registrarS.add(direccion, 1, 1);
				registrarS.add(telefono, 1, 2);
				

				Button registrarB = new Button("Registrar");
				registrarS.setMinSize(100, 0);
				registrarS.add(registrarB, 0, 3);
				
				Button consulta = new Button("Consultar sedes registradas");
				consulta.setMinSize(250,100);
				
				Button sedeV = new Button("Consultar sede con mayores ventas");
				sedeV.setMinSize(250, 100);
				
				
				GridPane eliminarGS = new GridPane();
				eliminarGS.setPadding(new Insets(10,10,10,10));
				eliminarGS.setVgap(5);
				eliminarGS.setHgap(5);
				eliminarGS.setAlignment(Pos.CENTER);
				
				
				ComboBox<String> eliminarS = new ComboBox<String>();
				LinkedList<Sede> sedes = Sede.consultarSedes();
				for (Sede s: sedes) {
					eliminarS.getItems().add(s.toString());
				}
				eliminarS.setPromptText("Sedes");
				Button eliminarBS = new Button("Eliminar");
				eliminarGS.add(eliminarBS, 0, 8);
				eliminarS.valueProperty().addListener(new ChangeListener<String>(){
					
					public void changed(ObservableValue ov, String t, String t1) {
						String sede = t1;
						int indice = eliminarS.getSelectionModel().getSelectedIndex();

						Alert dialog = new Alert(AlertType.NONE);
						eliminarBS.setOnMouseClicked(new EventHandler<MouseEvent>() {
							public void handle(MouseEvent event) {
								try {
									dialog.setAlertType(AlertType.INFORMATION);
									dialog.setTitle("Eliminar sede");
									dialog.setHeaderText("Se elimino la sede con exito");
									dialog.setContentText("La sede ubicada en "+sede+" se elimino");
									dialog.show();
									Sede.getSede().remove(indice);
									eliminarS.getItems().clear();
									LinkedList<Sede> sedes = Sede.consultarSedes();
									for (Sede s: sedes) {
										eliminarS.getItems().add(s.toString());
									}
									
									eliminarS.setValue("Sedes");
								}
								catch(Exception a) {
									dialog.setAlertType(AlertType.ERROR);
									dialog.setTitle("Eliminar sede");
									dialog.setHeaderText("No selecciono una sede");
									dialog.setContentText("Seleccione una sede");
									dialog.show();
								}
							}

						});
					}});
				eliminarS.setMinSize(250, 0);
				
				eliminarGS.add(eliminarS, 0, 4);
				eliminarGS.add(new Label("Eliminar sede"), 0, 0);
				
				sede.add(consulta, 0, 10);
				sede.add(sedeV, 1, 10);
				sede.add(registrarS, 0, 0);
				sede.add(eliminarGS, 1,0);
				
				registrarB.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						Alert dialog = new Alert(AlertType.NONE);
						String direccionS = direccion.getText();
						String telefonoS = telefono.getText();
						if (direccionS.isEmpty()) {
							dialog.setAlertType(AlertType.ERROR);
							dialog.setTitle("Falta la direccion");
							dialog.setHeaderText("No se puede registrar una sede sin direccion");
							dialog.setContentText("Por favor ingrese una direccion");
							dialog.show();
						}
						else if (telefonoS.isEmpty()) {
							dialog.setAlertType(AlertType.ERROR);
							dialog.setTitle("Falta el telefono");
							dialog.setHeaderText("No se puede registrar una sede sin telefono");
							dialog.setContentText("Por favor ingrese un telefono");
							dialog.show();
						}
						else {
							try {
								dialog.setAlertType(AlertType.INFORMATION);
								dialog.setTitle("Registrar sede");
								dialog.setHeaderText("Se registro la sede con exito");
								dialog.setContentText("La sede ubicada en "+direccionS+" se guardo con el telefono "+telefonoS);
								dialog.show();
								
								Sede sede = new Sede(direccionS, Integer.parseInt(telefonoS));
								Sede.adicionarSede(sede);
								eliminarS.getItems().clear();
								LinkedList<Sede> sedes = Sede.consultarSedes();
								for (Sede s: sedes) {
									eliminarS.getItems().add(s.toString());
								}
								
								direccion.setText("");
								telefono.setText("");
							}
							catch(Exception a) {
								dialog.setAlertType(AlertType.ERROR);
								dialog.setTitle("Registrar sede");
								dialog.setHeaderText("El telefono debe ser un numero");
								dialog.setContentText("Por favor ingrese un numero");
								dialog.show();
							}
						}
					}
				});
				
				sedeV.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						Alert dialog = new Alert(AlertType.NONE);
						try {	
							dialog.setAlertType(AlertType.INFORMATION);
							dialog.setTitle("Sede con mas ventas");
							dialog.setHeaderText("La sede que mas ventas ha realizado es:");
							dialog.setContentText(Sede.sedeMayorVentas().toString()+" \nVentas: "+ Sede.sedeMayorVentas().getCantVentas());
							dialog.show();
						}
						catch(Exception a) {
							dialog.setAlertType(AlertType.ERROR);
							dialog.setTitle("Sede con mas ventas");
							dialog.setHeaderText("No hay una sede con mayor ventas");
							dialog.show();
						}
					}

				});
				
				consulta.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						Alert dialog = new Alert(AlertType.NONE);
						if(Sede.getSede().size() == 0){
							dialog.setAlertType(AlertType.ERROR);
							dialog.setTitle("Sedes registradas");
							dialog.setHeaderText("No hay sedes registradas");
							dialog.show();
						}
						else{
							dialog.setAlertType(AlertType.INFORMATION);
							dialog.setTitle("Sedes registradas");
							String s = "";
							for (Sede sede : Sede.consultarSedes()) {
								s += sede.toString()+"\n\n";
							}
							dialog.setHeaderText("Las sedes registradas son las siguientes:");
							dialog.setContentText(s);
							dialog.show();
						}
						
					}

				});
				BorderPane border = new BorderPane();
				VBox t = new VBox(10);
				Label a = new Label("Menu de Sedes");
				Label b =new Label("En este menu puede registrar y eliminar sedes, asi como consultar cuales sedes hay registradas y cual es la sede que mas ha vendido");
				t.getChildren().add(a);
				t.getChildren().add(b);
				border.setCenter(sede);
				border.setTop(t);
			    b.setWrapText(true);
			    b.setAlignment(Pos.CENTER);
			    b.setStyle(" -fx-border-color:black; -fx-border-width: 1; -fx-border-style: solid;");
			    t.setAlignment(Pos.CENTER);

				BorderPane.setMargin(t, new Insets(50,20,20,20));
				rootScene2.setCenter(border);
				
			}
			
		});
		
		
		
		
		
		MenVeh.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				//Menu Vehiculos
				GridPane Veh=new GridPane();
				//Registrar
				Label regi=new Label("Registrar un Vehiculo");
				Label pla=new Label("Placa (String)=");
				TextField placa=new TextField();
				Label mod=new Label("Modelo (String)=");
				TextField modelo=new TextField();
				Label matri=new Label("Matricula (Int)=");
				TextField matricula=new TextField();
				Label seg=new Label("Seguro (true o false)=");
				TextField seguro=new TextField();
				Button registrar=new Button("Registrar");
				VBox RegVeh=new VBox(regi,pla,placa,mod,modelo,matri,matricula,seg,seguro,registrar);
				Veh.add(RegVeh, 0, 0);
				//Eliminar
				ArrayList<String> veh=new ArrayList<>();
				for(int i=0;i<Vehiculo.getVehiculos().size();i++) {
					veh.add(Vehiculo.getVehiculos().get(i).getPlaca());
				}
				Label eli=new Label("Eliminar vehiculo");
				ComboBox<String> eliVeh=new ComboBox<String>(FXCollections.observableArrayList(veh));
				eliVeh.setPromptText("Seleccione la placa de vehiculo a eliminar");
				TextField vehAEli=new TextField();
				eliVeh.valueProperty().addListener(new ChangeListener<String>(){

					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
						vehAEli.setText(arg2);
					}
					
				});
				Button eliminar=new Button("Eliminar");
				VBox elimi=new VBox(eli,eliVeh,vehAEli,eliminar);
				Veh.add(elimi, 0, 1);
				//Consultar
				Button consultar=new Button("Consultar Vehiculos");
				Veh.add(consultar, 1, 0);
				consultar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				consultar.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						Alert error=new Alert(AlertType.INFORMATION);
						error.setTitle("Vehiculos creados");
						error.setHeaderText("Placas de los vehiculos registrados en el sistema");
						String veh="";
						for(int i=0;i<Vehiculo.getVehiculos().size();i++) {
							if(i==Vehiculo.getVehiculos().size()-1) {
								veh+=Vehiculo.getVehiculos().get(i).getPlaca();
							}
							else {
								veh+=Vehiculo.getVehiculos().get(i).getPlaca();
								veh+=", ";
							}
						}
						error.setContentText(veh);
						error.show();
					}
					
				});
				Veh.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				Veh.setVgap(15);
				Veh.setHgap(15);
				Veh.setAlignment(Pos.CENTER);
				registrar.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent arg0) {
						try {
							String placa1=placa.getText();
							String modelo1=modelo.getText();
							int matricula1=Integer.parseInt(matricula.getText());
							boolean seguro1=Boolean.parseBoolean(seguro.getText());
							
							Alert confir=new Alert(AlertType.CONFIRMATION);
							confir.setTitle("Confirmar registrar vehiculo");
							confir.setHeaderText("Se requiere confirmacion para crear el vehiculo o se descartara");
							confir.setContentText("Esta seguro de que quiere registrar el vehiculo con placa= "
									+ placa1+" modelo= " + modelo1+" matricula= "+matricula1+" seguro= "+seguro1);
							Optional<ButtonType> result=confir.showAndWait();
							if(result.get()==ButtonType.OK) {
								Alert mens=new Alert(AlertType.INFORMATION);
								mens.setTitle("Se registro");
								mens.setHeaderText("Se registro del vehiculo");
								mens.show();
								Vehiculo aux=new Vehiculo(placa1,modelo1,matricula1,seguro1,null);
								Vehiculo.adicionarVehiculo(aux);
								eliVeh.getItems().clear();
								ArrayList<String> veh=new ArrayList<>();
								for(int i=0;i<Vehiculo.getVehiculos().size();i++) {
									eliVeh.getItems().add(Vehiculo.getVehiculos().get(i).getPlaca());
								}
								placa.setText("");
								modelo.setText("");
								matricula.setText("");
								seguro.setText("");
							}
							else {
								Alert mens=new Alert(AlertType.INFORMATION);
								mens.setTitle("No registro");
								mens.setHeaderText("Se cancelo el registro del vehiculo");
								mens.show();
							}
						
						}
						catch(Exception e) {
							Alert error=new Alert(AlertType.ERROR);
							error.setTitle("ERROR");
							error.setTitle("No se pudo registrar vehiculo");
							error.setContentText("Verifique los datos, que pertenezcan al tipo de dato requerido");
							error.show();
						}
					}
					
				});
				eliminar.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						try {
							String aux=vehAEli.getText();
							Alert confir=new Alert(AlertType.CONFIRMATION);
							confir.setTitle("Confirmar eliminacion de vehiculo");
							confir.setHeaderText("Se requiere confirmacion para eliminar un vehiculo");
							confir.setContentText("�Esta seguro de que quiere eliminar el vehiculo con placa= "+aux+"?");
							Optional<ButtonType> result=confir.showAndWait();
							if(result.get()==ButtonType.OK) {
								Alert mens=new Alert(AlertType.INFORMATION);
								mens.setTitle("Se elimino");
								mens.setHeaderText("Se elimino el vehiculo");
								mens.show();
								for(int i=0;i<Vehiculo.getVehiculos().size();i++) {
									if(Vehiculo.getVehiculos().get(i).getPlaca().equals(aux)) {
										Vehiculo.getVehiculos().remove(i);
									}
								}
								eliVeh.getItems().clear();
								ArrayList<String> veh=new ArrayList<>();
								for(int i=0;i<Vehiculo.getVehiculos().size();i++) {
									eliVeh.getItems().add(Vehiculo.getVehiculos().get(i).getPlaca());
								}
								
							}
							else {
								Alert mens=new Alert(AlertType.INFORMATION);
								mens.setTitle("No se elimino");
								mens.setHeaderText("Se cancelo el eliminado del vehiculo");
								mens.show();
							}
						}
						catch(Exception e) {
							Alert error=new Alert(AlertType.ERROR);
							error.setTitle("ERROR");
							error.setTitle("No se pudo Eliminar vehiculo");
							error.setContentText("Verifique que hayan vehiculos a eliminar y seleccione la placa de uno");
							error.show();
						}
					}
					
				});
				BorderPane border = new BorderPane();
				VBox t = new VBox(10);
				Label c = new Label("Menu de Vehiculos");
				Label b =new Label("En este menu podra agregar y eliminar vehiculos, asi como consultar los vehiculos registrados");
				t.getChildren().add(c);
				t.getChildren().add(b);
				border.setCenter(Veh);
				border.setTop(t);
			    b.setWrapText(true);
			    b.setAlignment(Pos.CENTER);
			    b.setStyle(" -fx-border-color:black; -fx-border-width: 1; -fx-border-style: solid;");
			    t.setAlignment(Pos.CENTER);

				BorderPane.setMargin(t, new Insets(50,20,20,20));
				rootScene2.setCenter(border);
			}
		});
		
		
		
    
	  
		
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
	    profesion = new Label("Ciencias de la computacion");
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
	    
	    
	    
	    File fileA = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\JuanC1.jpg"); 
	    image1 = new ImageView(new Image(fileA.toURI().toString())); 
	    image1.setFitHeight(150);
	    image1.setFitWidth(150);
	    File fileB = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\JuanC2.jpg"); 
	    image2 = new ImageView(new Image(fileB.toURI().toString()));
	    image2.setFitHeight(150);
	    image2.setFitWidth(150);
	    File fileC = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\JuanC3.jpg"); 
	    image3 = new ImageView(new Image(fileC.toURI().toString()));
	    image3.setFitHeight(150);
	    image3.setFitWidth(150);
	    File fileD = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\JuanC4.jpg"); 
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
				    profesion.setText("Ingenieria de sistemas e informatica");
				    
				    File fileA = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Danilo.jpg"); 
				    image1.setImage(new Image(fileA.toURI().toString())); 
				    image1.setFitHeight(150);
				    image1.setFitWidth(150);
				    File fileB = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Danilo2.jpg"); 
				    image2.setImage(new Image(fileB.toURI().toString()));
				    image2.setFitHeight(150);
				    image2.setFitWidth(150);
				    File fileC = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Danilo3.jpg"); 
				    image3.setImage(new Image(fileC.toURI().toString()));
				    image3.setFitHeight(150);
				    image3.setFitWidth(150);
				    File fileD = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Danilo4.jpg"); 
				    image4.setImage(new Image(fileD.toURI().toString()));
				    image4.setFitHeight(150);
				    image4.setFitWidth(150);
				}
				
				else if (contador == 2) {
					nombre.setText("Manuel Alejandro Escobar Mira");
				    email.setText("Maaescobarmi@unal.edu.co");
				    profesion.setText("Ingenieria de sistemas e informatica");
				    
				    File fileA = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Manuel1.jpg"); 
				    image1.setImage(new Image(fileA.toURI().toString())); 
				    image1.setFitHeight(150);
				    image1.setFitWidth(150);
				    File fileB = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Manuel2.jpg"); 
				    image2.setImage(new Image(fileB.toURI().toString()));
				    image2.setFitHeight(150);
				    image2.setFitWidth(150);
				    File fileC = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Manuel3.jpg"); 
				    image3.setImage(new Image(fileC.toURI().toString()));
				    image3.setFitHeight(150);
				    image3.setFitWidth(150);
				    File fileD = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Manuel4.jpg"); 
				    image4.setImage(new Image(fileD.toURI().toString()));
				    image4.setFitHeight(150);
				    image4.setFitWidth(150);
				}
				else if (contador == 3) {
					nombre.setText("Michael Stiwar Zapata Agudelo");
				    email.setText("mizapataa@unal.edu.co");
				    profesion.setText("Ingenieria de sistemas e informatica");
				    
				    File fileA = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Michael1.jpg"); 
				    image1.setImage(new Image(fileA.toURI().toString())); 
				    image1.setFitHeight(150);
				    image1.setFitWidth(150);
				    File fileB = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Michael2.jpg"); 
				    image2.setImage(new Image(fileB.toURI().toString()));
				    image2.setFitHeight(150);
				    image2.setFitWidth(150);
				    File fileC = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Michael3.jpg"); 
				    image3.setImage(new Image(fileC.toURI().toString()));
				    image3.setFitHeight(150);
				    image3.setFitWidth(150);
				    File fileD = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Michael4.jpg"); 

				    image4.setImage(new Image(fileD.toURI().toString()));
				    image4.setFitHeight(150);
				    image4.setFitWidth(150);
				}
				else if (contador == 4) {
					nombre.setText("Juan Camilo Zuluaga");
					email.setText("juaczuluagamon@unal.edu.co");
					profesion.setText("Ciencias de la computacion");
				    
				    File fileA = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\JuanC1.jpg"); 
				    image1.setImage(new Image(fileA.toURI().toString())); 
				    image1.setFitHeight(150);
				    image1.setFitWidth(150);
				    File fileB = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\JuanC2.jpg"); 
				    image2.setImage(new Image(fileB.toURI().toString()));
				    image2.setFitHeight(150);
				    image2.setFitWidth(150);
				    File fileC = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\JuanC3.jpg"); 
				    image3.setImage(new Image(fileC.toURI().toString()));
				    image3.setFitHeight(150);
				    image3.setFitWidth(150);
				    File fileD = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\JuanC4.jpg"); 
				    image4.setImage(new Image(fileD.toURI().toString()));
				    image4.setFitHeight(150);
				    image4.setFitWidth(150);
				}
				
				
				
			}
		};
		
	   
	    hojaVida.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
	    
	    //Imagen rotativa
	    File filee = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Sistema5.png"); 
	    imagenRotativa = new ImageView(new Image(filee.toURI().toString()));
	    imagenRotativa.setFitHeight(200);
	    imagenRotativa.setFitWidth(200);
	    
	    //Evento imagen rotativa
	    EventHandler<MouseEvent> eventHandlerx2 = new EventHandler<MouseEvent>() {
	    	
	    	

			@Override
			public void handle(MouseEvent arg0) {
				
				if (contadorx2 == 5) {
		    		contadorx2 = 1;	
		    	}
		    	else {
		    		contadorx2++;
		    	}
				
				if (contadorx2 == 1) {
					
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Sistema1.png"); 
				    imagenRotativa.setImage(new Image(filee.toURI().toString())); 
				    imagenRotativa.setFitHeight(200);
				    imagenRotativa.setFitWidth(200);
				}
				else if (contadorx2 == 2) {
					
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Sistema2.png"); 
				    imagenRotativa.setImage(new Image(filee.toURI().toString()));
				    imagenRotativa.setFitHeight(200);
				    imagenRotativa.setFitWidth(200);
				}
				else if (contadorx2 == 3) {
					
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Sistema3.png"); 
				    imagenRotativa.setImage(new Image(filee.toURI().toString()));
				    imagenRotativa.setFitHeight(200);
				    imagenRotativa.setFitWidth(200);
				    
				}
				else if (contadorx2 == 4) {
				    
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Sistema4.png"); 
				    imagenRotativa.setImage(new Image(filee.toURI().toString()));
				    imagenRotativa.setFitHeight(200);
				    imagenRotativa.setFitWidth(200);
				
			}	
				else if (contadorx2 == 5) {
				    
				    File filee = new File(ruta.getAbsolutePath()+"\\src\\Imagenes\\Sistema5.png"); 
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
	    BackgroundImage myBI2= new BackgroundImage(new Image("https://i.ibb.co/whb3W46/Background.jpg",600,600,true,true),
	            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	              BackgroundSize.DEFAULT);
	    rootScene2.setBackground(new Background(myBI2));
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
				//System.out.println("entre");
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
			Object control=event.getSource();
			if(control instanceof Menu) {
				System.out.println("Imprimir los nombres de los creadores en una ventana emergente");	
			}
		}
	}
	public class FieldPanel extends Pane {

		String tituloCriterios;
		ArrayList<String> criterios;
		String tituloValores;
		ArrayList<String> valoresIniciales;
		ArrayList<Boolean> habilitado;
		GridPane definitivo;
		public FieldPanel(String tituloCriterios, ArrayList<String> criterios, String tituloValores, ArrayList<String> valores, ArrayList<Boolean> habilitado) {
			this.tituloCriterios=tituloCriterios;
			this.criterios=criterios;
			this.tituloCriterios=tituloCriterios;
			this.valoresIniciales=valores;
			this.habilitado=habilitado;
			GridPane aux=new GridPane();
			aux.add(new Label(tituloCriterios), 0, 0);
			for(int i=1;i<=this.criterios.size();i++) {
				aux.add(new Label(this.criterios.get(i-1)), i, 0);
				TextField aux1=new TextField();
				aux1.setText(this.valoresIniciales.get(i-1));
				if(habilitado.get(i-1)==true) {
					aux1.setEditable(habilitado.get(i-1));
				}
				else {
					aux1.setEditable(false);
				}
			}
			this.definitivo=aux;
		}
		public String getTituloCriterios() {
			return this.tituloCriterios;
		}
		public ArrayList<String> getCriterios(){
			return this.criterios;
		}
		public String getTituloValores() {
			return this.tituloValores;
		}
		public ArrayList<String> getValoresIniciales(){
			return this.valoresIniciales;
		}
		public ArrayList<Boolean> getHabilitado(){
			return this.habilitado;
		}
	}

}
		

	
