package Controller;

import General.BD;
import Modulos.Persona;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLPersona {
    @javafx.fxml.FXML
    private Button btn_guardar;
    @javafx.fxml.FXML
    private TextField txt_cedula;
    @javafx.fxml.FXML
    private TextField txt_nombre;
    @javafx.fxml.FXML
    private TextArea txt_direccion;
    @javafx.fxml.FXML
    private Button btn_cancelar;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @Deprecated
    private void acc_grabar(ActionEvent event) {
        try {
            if (fun_validar()) {
                String cedula = this.txt_cedula.getText();
                String nombres = this.txt_nombre.getText();
                String direccion = this.txt_direccion.getText();
                Persona objPersona = new Persona(cedula, nombres, direccion);
                BD.personas.add(objPersona);
                System.out.println("Se registro con exito");
                for (Persona obj : BD.personas) {
                    System.out.println("CEDULA: " + obj.getNombres());
                }

            } else {
                System.out.println("Datos sin validar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean fun_validar() {
        return !txt_cedula.getText().isEmpty() && !txt_nombre.getText().isEmpty() && !txt_direccion.getText().isEmpty();
    }

    private void acc_cancelar(ActionEvent event) {
        //cerrar el formulario actual
        Stage myStage = (Stage) this.btn_cancelar.getScene().getWindow();
        myStage.close();
    }

    @javafx.fxml.FXML
    public void acc_btnsalir(ActionEvent actionEvent) {
        acc_cancelar(actionEvent);
    }

    @javafx.fxml.FXML
    public void acc_btnguardar(ActionEvent actionEvent) {
        acc_grabar(actionEvent);
    }


    public void cerrarFormulario() {
        //cerrar el formulario actual
        Stage myStage = (Stage) this.btn_cancelar.getScene().getWindow();
        myStage.close();
    }
}


