/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mariangel.lab3;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class ModificarPacientesController extends Controller implements Initializable {

    private PacienteService pacienteService = new PacienteService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Button btnBuscarPacientes;

    @FXML
    private Button btnEdicionPacientes;

    @FXML
    private Button btnEliminarPaciente;

    @FXML
    private Button btnGuardarPaciente;

    @FXML
    private Button btnLimpiarPaciente;

    @FXML
    private Button btnRegistroPacientes;

    @FXML
    private DatePicker datePickerFecNac;

    @FXML
    private TextArea textAreaDireccion;

    @FXML
    private TextField textFieldCedula;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldPApellido;

    @FXML
    private TextField textFieldSApellido;

    @FXML
    void OnGuardarPaciente(ActionEvent event) {
        Pacientes nuevoPaciente = new Pacientes();
        Date date = Date.from(datePickerFecNac.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        nuevoPaciente.setPacFecnac(date);
        nuevoPaciente.setPacCedula(textFieldCedula.getText());
        nuevoPaciente.setPacNombre(textFieldNombre.getText());
        nuevoPaciente.setPacPapellido(textFieldPApellido.getText());
        nuevoPaciente.setPacSapellido(textFieldSApellido.getText());
        nuevoPaciente.setPacDirec(textAreaDireccion.getText());
        Respuesta respuesta = pacienteService.modificarGuardarPaciente(nuevoPaciente);
    }


    @FXML
    void onEliminarPaciente(ActionEvent event) {
        String cedula = textFieldCedula.getText();
        Mensaje mensaje = new Mensaje();
        if (cedula == null || cedula.isEmpty()) {
            mensaje.show(AlertType.ERROR, "Error Dialog", "La cédula está vacía.");
        } else {
            PacienteService pacienteService = new PacienteService();
            Respuesta respuesta = pacienteService.eliminarPaciente(cedula);
            if (respuesta.getEstado()) {
                mensaje.show(AlertType.INFORMATION, "Information Dialog", "Paciente eliminado exitosamente");
            } else {
                mensaje.show(AlertType.ERROR, "Error Dialog", respuesta.getMensaje());
            }
        }
    }

    @FXML
    void onLimpiarPaciente(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void onRegistroPacientes(ActionEvent event) {
        FlowController.getInstance().goView("Pacientes");
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void limpiarCampos() {
        textFieldCedula.clear();
        textFieldNombre.clear();
        textFieldPApellido.clear();
        textFieldSApellido.clear();
        textAreaDireccion.clear();
        datePickerFecNac.setValue(null);
    }
}
