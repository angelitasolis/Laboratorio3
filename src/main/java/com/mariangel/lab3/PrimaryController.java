package com.mariangel.lab3;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void cambiarRegistroPaciente() throws IOException {
        App.setRoot("modificar-pacientes");
    }
    
    @FXML
    private void cambiarBuscarPaciente() throws IOException {
        App.setRoot("buscar-paciente");
    }
    
    
     @FXML
    private void cambiarEdicionPaciente() throws IOException {
        App.setRoot("modificar-pacientes");
    }
    
}
