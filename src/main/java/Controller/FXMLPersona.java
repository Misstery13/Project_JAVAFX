package Controller;

import General.BD;
import Modelos.Persona;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
//                System.out.println("Se registro con exito");
                General.BD.personas.add(objPersona);
                General.Mod_general.fun_mensajeInformacion("Se registro con exito");
                for (Persona obj : BD.personas) {
                    System.out.println("CEDULA: " + obj.getNombres());
                }

            } else {
                System.out.println("Datos sin validar");
            }
        } catch (Exception e) {
            General.Mod_general.fun_mensajeInformacion(e.getMessage());
        }
    }

    private boolean fun_validar() {
        /*
        Nombre de la funcion:fun_validar
        Descripcion: Valida que los campos que ingrese no esten vacios, retorna
        Autor: Diana Melena
        Fecha de creacion: 04/08/2025
        Fecha de modificacion:
         */
        try {
            if (this.txt_cedula.getText().isEmpty()) {
                General.Mod_general.fun_mensajeInformacion("Cedula no puede estar vacio");
                this.txt_cedula.requestFocus();
                return false;
            }
            if (this.txt_nombre.getText().isEmpty()) {
                General.Mod_general.fun_mensajeInformacion("Nombre no puede estar vacio");
                this.txt_nombre.requestFocus();
                return false;
            }
            if (this.txt_direccion.getText().isEmpty()) {
                General.Mod_general.fun_mensajeInformacion("Dirección no puede estar vacio");
                this.txt_direccion.requestFocus();
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }

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

    public void fun_limpiar() {
        this.txt_cedula.clear();
        this.txt_nombre.clear();
        this.txt_direccion.clear();
        this.txt_cedula.requestFocus();
        this.txt_nombre.requestFocus();
        this.txt_direccion.requestFocus();
    }
}


