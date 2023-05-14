/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mariangel.lab3;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class BuscarPacienteController extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       choiceBoxBusquedaPor.getItems().addAll("Cédula", "Nombre", "Primer Apellido", "Segundo Apellido");
    }
    @FXML
    private Button btnBuscarPaciente;

    @FXML
    private Button btnBuscarPacientes;

    @FXML
    private TextField textFieldDatoABuscar;

    @FXML
    private Button btnEdicionPacientes;

    @FXML
    private Button btnRegistroPacientes;

    @FXML
   private ChoiceBox<String> choiceBoxBusquedaPor;

    @FXML
    public GridPane gridPaneBusqueda;

    @FXML
    void onBuscarPaciente(ActionEvent event) {
        String seleccion = (String) choiceBoxBusquedaPor.getValue();
        String datoABuscar = textFieldDatoABuscar.getText();

        if (seleccion == null || datoABuscar == null || datoABuscar.isEmpty()) {
            // Mostrar un mensaje de error o alerta indicando que no se seleccionó un criterio de búsqueda o que el campo de búsqueda está vacío.
            new Mensaje().show(AlertType.ERROR, "Error de búsqueda", "No se seleccionó un criterio de búsqueda o el campo de búsqueda está vacío.");
        } else {
            PacienteService pacienteService = new PacienteService();
            List<Pacientes> resultados;
            switch (seleccion) {
                case "Cédula":
                    resultados = pacienteService.buscarPorCedula(datoABuscar);
                    break;
                case "Nombre":
                    resultados = pacienteService.buscarPorNombre(datoABuscar);
                    break;
                case "Primer Apellido":
                    resultados = pacienteService.buscarPorPrimerApellido(datoABuscar);
                    break;
                case "Segundo Apellido":
                    resultados = pacienteService.buscarPorSegundoApellido(datoABuscar);
                    break;
                default:
                    resultados = new ArrayList<>();
                    break;
            }
            // Ahora, actualizamos el gridpane con los resultados.
            gridPaneBusqueda.getChildren().clear();  // Limpiar antes de agregar nuevos resultados.
            for (Pacientes paciente : resultados) {
                // Agrega una fila al gridpane con los detalles del paciente.
                // Esta parte depende de cómo quieras mostrar los resultados en el GridPane.
            }
        }
    }

    @FXML
    void onBusquedaPor(MouseEvent event) {

    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
