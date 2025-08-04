package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private ComboBox cbo_lista;

    @javafx.fxml.FXML
    public void initialize() {
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
                String numero = this.txt_num.getText();
                String operador = this.txt_ope.getText();
                // Aquí se debería agregar el código para guardar el teléfono
                System.out.println("Teléfono guardado: " + numero + " - " + operador);
            } else {
                System.out.println("Datos sin validar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean fun_validar() {
        return !txt_num.getText().isEmpty() && !txt_ope.getText().isEmpty();
    }

    @javafx.fxml.FXML
    public void acc_lista(ActionEvent actionEvent) {

    }
}