package Controller;

import General.BD;
import General.Mod_general;
import Modelos.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class FXMLPersona {
    @FXML
    private Button btn_guardar;
    @FXML
    private TextField txt_cedula;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextArea txt_direccion;
    @FXML
    private Button btn_cancelar;
    @FXML
    private CheckBox check_ced;

    @FXML
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
                Mod_general.fun_mensajeInformacion("Se registro con exito");
                for (Persona obj : BD.personas) {
                    System.out.println("CEDULA: " + obj.getNombres());
                }

            } else {
                fun_validar();
            }
        } catch (Exception e) {
            Mod_general.fun_mensajeInformacion(e.getMessage());
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
                Mod_general.fun_mensajeInformacion("Cedula no puede estar vacio");
                this.txt_cedula.requestFocus();
                return false;
            }
            if (this.txt_nombre.getText().isEmpty()) {
                Mod_general.fun_mensajeInformacion("Nombre no puede estar vacio");
                this.txt_nombre.requestFocus();
                return false;
            }
            if (this.txt_direccion.getText().isEmpty()) {
                Mod_general.fun_mensajeInformacion("Dirección no puede estar vacio");
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLagenda.fxml"));
            Parent root = loader.load();
            Stage agendaStage = new Stage();
            agendaStage.setScene(new Scene(root));
            agendaStage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void acc_btnsalir(ActionEvent actionEvent) {
        acc_cancelar(actionEvent);
    }

    @FXML
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

    @FXML
    public void acc_checkced(ActionEvent actionEvent) {
        if (check_ced.isSelected()) {
            this.txt_cedula.setDisable(false);
            if (validarCedula()) {
                Mod_general.fun_mensajeInformacion("Cédula válida.");
            }else {
                Mod_general.fun_mensajeInformacion("Cédula inválida.");
            }

        } else {
//            this.txt_cedula.clear();
        }
    }
    public boolean validarCedula() {
        String cedula = this.txt_cedula.getText();
        if (cedula == null || cedula.length() != 10) {
            Mod_general.fun_mensajeInformacion("La cédula debe tener 10 dígitos.");
            return false;
        }
        int region = Integer.parseInt(cedula.substring(0, 2));
        if (!((region >= 1 && region <= 24) || region == 30)) { //01 al 24 son las provincias | 30 es para ciudadanos que viven en el exterior
            Mod_general.fun_mensajeInformacion("La cédula debe pertenecer a una región válida (01-24 o 30).");
            return false;
        }
        int ultimoDigito = Integer.parseInt(cedula.substring(9, 10));
        int pares = Integer.parseInt(cedula.substring(1, 2))
                + Integer.parseInt(cedula.substring(3, 4))
                + Integer.parseInt(cedula.substring(5, 6))
                + Integer.parseInt(cedula.substring(7, 8));

        int[] impares = new int[5];
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(cedula.substring(i * 2, i * 2 + 1)) * 2;
            if (num > 9) num -= 9;
            impares[i] = num;
        }
        int sumaTotal = pares + impares[0] + impares[1] + impares[2] + impares[3] + impares[4];
        int decena = ((sumaTotal / 10) + 1) * 10;
        int digitoValidador = decena - sumaTotal;
        if (digitoValidador == 10) digitoValidador = 0;
        return digitoValidador == ultimoDigito;
    }

}


