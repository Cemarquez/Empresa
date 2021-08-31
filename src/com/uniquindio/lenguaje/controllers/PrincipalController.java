package com.uniquindio.lenguaje.controllers;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.uniquindio.lenguaje.exceptions.MaxVocalException;
import com.uniquindio.lenguaje.exceptions.MinYearException;
import com.uniquindio.lenguaje.exceptions.PersonRepitException;
import com.uniquindio.lenguaje.mundo.Cliente;
import com.uniquindio.lenguaje.mundo.Empleado;
import com.uniquindio.lenguaje.mundo.Empresa;
import com.uniquindio.lenguaje.mundo.Persona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class PrincipalController {

	private Persona selec;
	private Empresa empresa = new Empresa();
	@FXML
    private Label lbNombreSelec;

    @FXML
    private TextField tfNombreSelec;

    @FXML
    private Label lbCedulaSelec;

    @FXML
    private TextField tfCedulaSelec;

    @FXML
    private Label lbDato41;

    @FXML
    private Label lbEdadSelec;

    @FXML
    private TextField tfEdad11;

    @FXML
    private Label lbDato4Selec;

    @FXML
    private TextField tfDato4Selec;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnBorrar;

	@FXML
	private ResourceBundle resources;

	private Tipo tipo;
	@FXML
	private Button btnClientes;

	@FXML
	private Button btnPersonas;

	@FXML
	private Button btnEmpleados;

	@FXML
	private HBox panelSuperior;

	@FXML
	private AnchorPane panelDatos;

	@FXML
	private Label lbNombre;

	@FXML
	private TextField tfNombre;

	@FXML
	private Label lbCedula;

	@FXML
	private TextField tfCedula;

	@FXML
	private Label lbEdad;

	@FXML
	private TextField tfEdad;

	@FXML
	private Label lbDato4;
	
	@FXML
	private TextField tfBuscar;
	
	@FXML
	private TextField tfDato4;

	@FXML
	private Button btnAgregar;

	@FXML
	private Button btnLimpiar;

	@FXML
	private Label lbSuperior;

	@FXML
	private Label labelSuperiorListado;

	@FXML
	private TableView<Persona> tablaListado;

	@FXML
	private TableColumn<Persona, String> columNombreCliente;

	@FXML
	private TableColumn<Persona, String> columCedulaCliente;

	@FXML
	private TableColumn<Persona, Integer> columEdadCliente;

	@FXML
	private TableColumn<Persona, String> columEmailCliente;

	@FXML
	private AnchorPane panelTabla;
	
	
	@FXML
	void actionListener(ActionEvent event) {
		if (event.getSource() == btnClientes) {
			tablaListado.setRowFactory(null);
			llenarTablaClientes();
			panelSuperior.setVisible(true);
			panelDatos.setVisible(true);
			panelTabla.setVisible(true);
			tfDato4.setVisible(true);
			lbDato4.setText("Email:");
			tfDato4.setPromptText("Email");
			lbSuperior.setText("Gestión de clientes");
			labelSuperiorListado.setText("Lista de clientes");
			btnClientes.setStyle("-fx-background-color: #90EE90");
			btnEmpleados.setStyle("-fx-background-color: #D8DEE5");
			btnPersonas.setStyle("-fx-background-color: #D8DEE5");
			tipo = Tipo.CLIENTE;
			lbCedulaSelec.setVisible(false);
			lbDato4Selec.setVisible(false);
			lbEdadSelec.setVisible(false);
			lbNombreSelec.setVisible(false);
			tfCedulaSelec.setVisible(false);
			tfDato4Selec.setVisible(false);
			tfEdad11.setVisible(false);
			tfNombreSelec.setVisible(false);
			btnBorrar.setVisible(false);
			tfDato4.setVisible(true);
			tfCedula.setVisible(true);
			lbCedula.setVisible(true);
			lbDato41.setVisible(true);
			tfEdad.setVisible(true);
			lbEdad.setVisible(true);
			btnAgregar.setVisible(true);
			btnLimpiar.setVisible(true);
			tfNombre.setVisible(true);
			lbNombre.setVisible(true);
			btnGuardar.setVisible(false);
		} else if (event.getSource() == btnEmpleados) {
			tablaListado.setRowFactory(null);
			llenarTablaEmpleados();
			
			columEmailCliente.setText("Sueldo");
			panelSuperior.setVisible(true);
			panelTabla.setVisible(true);
			panelDatos.setVisible(true);
			lbDato4.setText("Sueldo:");
			tfDato4.setPromptText("Sueldo");
			lbSuperior.setText("Gestión de empleados");
			labelSuperiorListado.setText("Lista de empleados");
			btnClientes.setStyle("-fx-background-color: #D8DEE5");
			btnEmpleados.setStyle("-fx-background-color: #90EE90");
			btnPersonas.setStyle("-fx-background-color: #D8DEE5");
			tipo = Tipo.EMPLEADO;
			lbCedulaSelec.setVisible(false);
			lbDato4Selec.setVisible(false);
			lbEdadSelec.setVisible(false);
			lbNombreSelec.setVisible(false);
			tfCedulaSelec.setVisible(false);
			tfDato4Selec.setVisible(false);
			tfEdad11.setVisible(false);
			tfNombreSelec.setVisible(false);
			btnBorrar.setVisible(false);
			btnGuardar.setVisible(false);

			tfDato4.setVisible(true);
			tfEdad11.setVisible(false);
			tfCedula.setVisible(true);
			lbCedula.setVisible(true);
			lbDato41.setVisible(true);
			tfEdad.setVisible(true);
			lbEdad.setVisible(true);
			btnAgregar.setVisible(true);
			btnLimpiar.setVisible(true);
			tfNombre.setVisible(true);
			lbNombre.setVisible(true);
			
		} else if (event.getSource() == btnPersonas) {
			
			tablaListado.setRowFactory(null);
			llenarTablaPersonas();
			
			columEmailCliente.setText("");
			panelSuperior.setVisible(true);
			panelTabla.setVisible(true);
			panelDatos.setVisible(true);
			lbDato4.setText("");
			tfDato4.setPromptText("");
			lbSuperior.setText("Gestión de personas");
			labelSuperiorListado.setText("Lista de personas");
			btnClientes.setStyle("-fx-background-color: #D8DEE5");
			btnPersonas.setStyle("-fx-background-color: #90EE90");
			btnEmpleados.setStyle("-fx-background-color: #D8DEE5");
			lbCedulaSelec.setVisible(false);
			lbDato4Selec.setVisible(false);
			lbEdadSelec.setVisible(false);
			lbNombreSelec.setVisible(false);
			tfCedulaSelec.setVisible(false);
			tfDato4Selec.setVisible(false);
			tfDato4.setVisible(false);
			tfEdad11.setVisible(false);
			tfCedula.setVisible(false);
			lbCedula.setVisible(false);
			lbDato41.setVisible(false);
			tfEdad.setVisible(false);
			lbEdad.setVisible(false);
			btnAgregar.setVisible(false);
			btnLimpiar.setVisible(false);
			tfNombre.setVisible(false);
			lbNombre.setVisible(false);
			tfNombreSelec.setVisible(false);
			btnBorrar.setVisible(false);
			btnGuardar.setVisible(false);
			tipo = null;
		} else if (event.getSource() == btnAgregar) {

			if(tfNombre.getText() ==null || tfNombre.getText().equals("") ||   tfCedula.getText() ==null || tfCedula.getText().equals("") ||tfEdad.getText() ==null || tfEdad.getText().equals("") ||tfDato4.getText() ==null || tfDato4.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "No deje espacios en blanco");
			}else {
				String nombre = tfNombre.getText();
				int cedula = Integer.parseInt(tfCedula.getText());
				int edad = Integer.parseInt(tfEdad.getText());
				String incog = tfDato4.getText();
				tfCedula.setText("");
				tfNombre.setText("");
				tfDato4.setText("");
				tfEdad.setText("");
				try {
					empresa.agregarPersona(nombre, cedula, edad, incog, tipo);
				}catch (PersonRepitException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}catch (MaxVocalException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}catch (MinYearException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				updateTabla();
			}
			
		} else if (event.getSource() == btnLimpiar) {

			tfCedula.setText("");
			tfNombre.setText("");
			tfDato4.setText("");
			tfEdad.setText("");
		}else if(event.getSource() == btnGuardar) {

			if(tipo == null) {
				if(tfNombreSelec.getText() ==null || tfNombreSelec.getText().equals("") ||   tfCedulaSelec.getText() ==null || tfCedulaSelec.getText().equals("") ||tfEdad11.getText() ==null || tfEdad11.getText().equals("")  ) {
					JOptionPane.showMessageDialog(null, "No deje espacios en blanco");
				}else {
					String nombre = tfNombreSelec.getText();
					int cedula = Integer.parseInt(tfCedulaSelec.getText());
					int edad = Integer.parseInt(tfEdad11.getText());
					String incog = tfDato4Selec.getText();
					
					empresa.modificarPersona(selec.getCedula(), cedula, nombre, tipo, incog, edad);
					updateTabla2();
					updateTabla();
				}
			}else {
				if(tfNombreSelec.getText() ==null || tfNombreSelec.getText().equals("") ||   tfCedulaSelec.getText() ==null || tfCedulaSelec.getText().equals("") ||tfEdad11.getText() ==null || tfEdad11.getText().equals("") ||tfDato4Selec.getText() ==null || tfDato4Selec.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "No deje espacios en blanco");
				}else {
					String nombre = tfNombreSelec.getText();
					int cedula = Integer.parseInt(tfCedulaSelec.getText());
					int edad = Integer.parseInt(tfEdad11.getText());
					String incog = tfDato4Selec.getText();
					
					empresa.modificarPersona(selec.getCedula(), cedula, nombre, tipo, incog, edad);
					updateTabla2();
					updateTabla();
				}
			}
			
			
		}else if(event.getSource() == btnBorrar) {
			empresa.borrarPersona(selec.getCedula(), selec);
			updateTabla2();
			updateTabla();
		}
	}

	public void updateTabla2() {
		ArrayList<Persona> pr = new ArrayList<Persona>();
	
			for(int i=0;i<empresa.getMisPersonas().size();i++) {
				pr.add(empresa.getMisPersonas().get(i));
			}
			
			tablaListado.getItems().clear();
			empresa.setMisPersonas(pr);
	}
	
	public void updateTabla() {
		if(tipo == Tipo.CLIENTE)
		{
			tablaListado.setItems(getListClientes());
		}else if(tipo == Tipo.EMPLEADO)
		{
			tablaListado.setItems(getListEmpleados());
		}else {
			tablaListado.setItems(getListPersonas());
		}
	}
	@FXML
	void keyListener(KeyEvent event) {
		System.out.print(event.getCharacter());
		if (tfBuscar.isFocused()) {
			if (tfBuscar.getText() != null) {

				javax.swing.Timer timer = new javax.swing.Timer(1, new ActionListener() {

					@Override
					public void actionPerformed(java.awt.event.ActionEvent arg0) {
						tablaListado.setItems(getListFound());

					}
				});
				timer.start();
				timer.setRepeats(false);

			}

		}

	}
	
	ObservableList<Persona> getListFound() {
		ObservableList<Persona> founds = FXCollections.observableArrayList();
		ObservableList<Persona> productos = FXCollections.observableArrayList();
		if(tipo == Tipo.CLIENTE) {
			productos = getListClientes();
		}else if(tipo == Tipo.EMPLEADO) {
			productos = getListEmpleados();
		}else {
			productos = getListPersonas();
		}
		

		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getNombre().toLowerCase().contains(tfBuscar.getText().toLowerCase())) {
				founds.add(productos.get(i));
			}
		}

		return founds;
	}
	
	public void colorIconos() {
		URL iconBucar = getClass().getResource("/com/uniquindio/lenguaje/imagenes/iconAgregar.png");
		URL iconLimpiar = getClass().getResource("/com/uniquindio/lenguaje/imagenes/iconLimpiar.png");
		URL iconGuardar = getClass().getResource("/com/uniquindio/lenguaje/imagenes/iconGuardar.png");
		URL iconBorrar = getClass().getResource("/com/uniquindio/lenguaje/imagenes/iconBorrar.png");
		Image imagenBuscar = new Image(iconBucar.toString(), 24, 24, false, true);
		Image imagenBorrar = new Image(iconBorrar.toString(), 24, 24, false, true);
		Image imagenGuardar = new Image(iconGuardar.toString(), 24, 24, false, true);
		Image imagenLimpiar = new Image(iconLimpiar.toString(), 24, 24, false, true);

		btnBorrar.setGraphic(new ImageView(imagenBorrar));
		btnGuardar.setGraphic(new ImageView(imagenGuardar));
		btnAgregar.setGraphic(new ImageView(imagenBuscar));
		btnLimpiar.setGraphic(new ImageView(imagenLimpiar));
	}

	@FXML
	void initialize() {
		lbCedulaSelec.setVisible(false);
		lbDato4Selec.setVisible(false);
		lbEdadSelec.setVisible(false);
		lbNombreSelec.setVisible(false);
		tfCedulaSelec.setVisible(false);
		tfDato4Selec.setVisible(false);
		tfEdad11.setVisible(false);
		tfNombreSelec.setVisible(false);
		btnBorrar.setVisible(false);
		btnGuardar.setVisible(false);
		inicializarVentana();
		colorIconos();
	}

	private void llenarTablaPersonas() {
		columCedulaCliente.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		columEdadCliente.setCellValueFactory(new PropertyValueFactory<>("edad"));
		columNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columEmailCliente.setCellValueFactory(new PropertyValueFactory<>("otros"));
		
		

		tablaListado.setRowFactory(tv -> {
			TableRow<Persona> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2) {
					Persona rowData = row.getItem();
					selec = rowData;
					if (rowData != null) {
						lbCedulaSelec.setVisible(true);
						lbDato4Selec.setVisible(false);
						lbEdadSelec.setVisible(true);
						lbNombreSelec.setVisible(true);
						tfCedulaSelec.setVisible(true);
						tfDato4Selec.setVisible(false);
						tfDato4.setVisible(false);
						tfEdad11.setVisible(true);
						tfNombreSelec.setVisible(true);
						btnBorrar.setVisible(true);
						btnGuardar.setVisible(true);
						if(tipo == Tipo.CLIENTE) {
							lbDato4Selec.setText("Email");
							tfDato4Selec.setText(((Cliente) selec).getEmail() +"");
						}else if(tipo == Tipo.EMPLEADO) {
							lbDato4Selec.setText("Sueldo");
							tfDato4Selec.setText(((Empleado) selec).getSueldo() +"");
						}else {
							lbDato4Selec.setVisible(false);
							tfDato4Selec.setVisible(false);
							tfCedulaSelec.setEditable(false);
							tfNombreSelec.setEditable(false);
							tfEdad11.setEditable(false);
							btnBorrar.setVisible(false);
							btnGuardar.setVisible(false);
						}
						
						tfCedulaSelec.setText(selec.getCedula() + "");
						tfEdad11.setText(selec.getEdad()+"");
						tfNombreSelec.setText(selec.getNombre());
						
					} else {

					}
				}
			});
			return row;
		});
		
		
		
		
		tablaListado.setItems(getListPersonas());
	}
	
	private void llenarTablaEmpleados() {
		columCedulaCliente.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		columEdadCliente.setCellValueFactory(new PropertyValueFactory<>("edad"));
		columNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columEmailCliente.setCellValueFactory(new PropertyValueFactory<>("sueldo"));

		
		

		tablaListado.setRowFactory(tv -> {
			TableRow<Persona> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2) {
					Persona rowData = row.getItem();
					selec = rowData;
					if (rowData != null) {
						lbCedulaSelec.setVisible(true);
						lbDato4Selec.setVisible(true);
						lbEdadSelec.setVisible(true);
						lbNombreSelec.setVisible(true);
						tfCedulaSelec.setVisible(true);
						tfDato4Selec.setVisible(true);
						tfEdad11.setVisible(true);
						tfNombreSelec.setVisible(true);
						btnBorrar.setVisible(true);
						btnGuardar.setVisible(true);
						if(tipo == Tipo.CLIENTE) {
							lbDato4Selec.setText("Email");
							tfDato4Selec.setText(((Cliente) selec).getEmail() +"");

							tfCedulaSelec.setEditable(true);
							tfNombreSelec.setEditable(true);
							tfEdad11.setEditable(true);
						}else if(tipo == Tipo.EMPLEADO) {
							lbDato4Selec.setText("Sueldo");
							tfDato4Selec.setText(((Empleado) selec).getSueldo() +"");

							tfCedulaSelec.setEditable(true);
							tfNombreSelec.setEditable(true);
							tfEdad11.setEditable(true);
						}else {
							lbDato4Selec.setVisible(false);
							tfDato4Selec.setVisible(false);
							tfCedulaSelec.setEditable(false);
							tfNombreSelec.setEditable(false);
							tfEdad11.setEditable(false);
							btnBorrar.setVisible(false);
							btnGuardar.setVisible(false);
						}
						
						tfCedulaSelec.setText(selec.getCedula() + "");
						tfEdad11.setText(selec.getEdad()+"");
						tfNombreSelec.setText(selec.getNombre());
						
					} else {

					}
				}
			});
			return row;
		});
		
		
		
		
		tablaListado.setItems(getListEmpleados());
	}

	private void llenarTablaClientes() {
		columCedulaCliente.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		columEdadCliente.setCellValueFactory(new PropertyValueFactory<>("edad"));
		columNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columEmailCliente.setCellValueFactory(new PropertyValueFactory<>("email"));
		tablaListado.setRowFactory(tv -> {
			
			TableRow<Persona> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2) {
					Persona rowData = row.getItem();
					selec = rowData;
					if (rowData != null) {
						lbCedulaSelec.setVisible(true);
						lbDato4Selec.setVisible(true);
						lbEdadSelec.setVisible(true);
						lbNombreSelec.setVisible(true);
						tfCedulaSelec.setVisible(true);
						tfDato4Selec.setVisible(true);
						tfEdad11.setVisible(true);
						tfNombreSelec.setVisible(true);
						btnBorrar.setVisible(true);
						btnGuardar.setVisible(true);
						if(tipo == Tipo.CLIENTE) {
							lbDato4Selec.setText("Email");
							tfDato4Selec.setText(((Cliente) selec).getEmail() +"");

							tfCedulaSelec.setEditable(true);
							tfNombreSelec.setEditable(true);
							tfEdad11.setEditable(true);
						}else if(tipo == Tipo.EMPLEADO) {
							lbDato4Selec.setText("Sueldo");
							tfDato4Selec.setText(((Empleado) selec).getSueldo() +"");

							tfCedulaSelec.setEditable(true);
							tfNombreSelec.setEditable(true);
							tfEdad11.setEditable(true);
						}else {
							lbDato4Selec.setVisible(false);
							tfDato4Selec.setVisible(false);
							tfCedulaSelec.setEditable(false);
							tfNombreSelec.setEditable(false);
							tfEdad11.setEditable(false);
							btnBorrar.setVisible(false);
							btnGuardar.setVisible(false);
						}
						
						tfCedulaSelec.setText(selec.getCedula()+"");
						
						tfEdad11.setText(selec.getEdad()+"");
						tfNombreSelec.setText(selec.getNombre());
						
					} else {

					}
				}
			});
			return row;
		});
		tablaListado.setItems(getListClientes());

	}
	
	ObservableList<Persona> getListPersonas() {
		ObservableList<Persona> list = FXCollections.observableArrayList();
		list.clear();
		for (Persona c : empresa.getPersonas()) {
			list.add(c);
		}
		return list;
	}

	ObservableList<Persona> getListEmpleados() {
		ObservableList<Persona> list = FXCollections.observableArrayList();
		list.clear();
		for (Empleado c : empresa.getEmpleados()) {
			list.add(c);
		}
		return list;
	}

	ObservableList<Persona> getListClientes() {
		ObservableList<Persona> list = FXCollections.observableArrayList();
		list.clear();
		for (Cliente c : empresa.getClientes()) {
			list.add(c);
		}
		return list;
	}

	private void inicializarVentana() {
		panelDatos.setVisible(false);
		panelSuperior.setVisible(false);
		panelTabla.setVisible(false);
		tablaListado.setRowFactory(null);
		llenarTablaEmpleados();
		
		columEmailCliente.setText("Sueldo");
		panelSuperior.setVisible(true);
		panelTabla.setVisible(true);
		panelDatos.setVisible(true);
		lbDato4.setText("Sueldo:");
		tfDato4.setPromptText("Sueldo");
		lbSuperior.setText("Gestión de empleados");
		labelSuperiorListado.setText("Lista de empleados");
		btnClientes.setStyle("-fx-background-color: #D8DEE5");
		btnEmpleados.setStyle("-fx-background-color: #90EE90");
		btnPersonas.setStyle("-fx-background-color: #D8DEE5");
		tipo = Tipo.EMPLEADO;
		lbCedulaSelec.setVisible(false);
		lbDato4Selec.setVisible(false);
		lbEdadSelec.setVisible(false);
		lbNombreSelec.setVisible(false);
		tfCedulaSelec.setVisible(false);
		tfDato4Selec.setVisible(false);
		tfEdad11.setVisible(false);
		tfNombreSelec.setVisible(false);
		btnBorrar.setVisible(false);
		btnGuardar.setVisible(false);
		
	}

	public enum Tipo {
		EMPLEADO, CLIENTE
	}
}
