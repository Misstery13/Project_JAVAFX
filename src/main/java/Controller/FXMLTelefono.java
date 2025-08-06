package Controller;

import General.BD;
import Modelos.Persona;
import Modelos.Telefono;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLTelefono
{
    @javafx.fxml.FXML
    private TextField txt_num;
    @javafx.fxml.FXML
    private TextField txt_ope;
    @javafx.fxml.FXML
    private Button btn_salir;
    @javafx.fxml.FXML
    private Button btn_guardar;
    @javafx.fxml.FXML
    private ComboBox<Persona> cbo_lista;

    @javafx.fxml.FXML
    public void initialize() {
        // Inicializar el ComboBox con las personas
        this.cargarPersonas();
    }

    @javafx.fxml.FXML
    public void acc_btnsalir(ActionEvent actionEvent) {
        //cerrar el formulario actual
        Stage myStage = (Stage) this.btn_salir.getScene().getWindow();
        myStage.close();
    }

    @javafx.fxml.FXML
    public void acc_btnguardar(ActionEvent actionEvent) {
        try {
            if (fun_validar()) {
                Telefono objTelefono=new Telefono(this.txt_ope.getText(), this.txt_num.getText());
                // Aquí se debería agregar el código para guardar el teléfono

                this.cbo_lista.getSelectionModel().getSelectedItem().addTelefonos(objTelefono);
                General.Mod_general.fun_mensajeInformacion("Se registro con exito");
                this.fun_limpiar();
            } else {
                General.Mod_general.fun_mensajeError("Llene todos los campos");
            }
        } catch (Exception e) {
            General.Mod_general.fun_mensajeError("Seleccione una persona de la lista");
        }
    }

    private boolean fun_validar() {
        return !txt_num.getText().isEmpty() && !txt_ope.getText().isEmpty();
    }

    @javafx.fxml.FXML
    public void acc_lista(ActionEvent actionEvent) {

    }
    public void cargarPersonas() {
        try {
            //cargar las personas al combobox
            this.cbo_lista.getItems().clear();
            this.cbo_lista.getItems().addAll(BD.personas);
        } catch (Exception e) {
            General.Mod_general.fun_mensajeInformacion(e.getMessage());
        }
    }
    public void fun_limpiar() {
        this.txt_ope.clear();
        this.txt_num.clear();
        this.txt_ope.requestFocus();
        this.txt_num.requestFocus();
    }
}