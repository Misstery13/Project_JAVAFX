package Vistas;

import Modelos.Telefono;

public class FXMLConsultar {
    @javafx.fxml.FXML
    private Button btn_cancelar;
    @javafx.fxml.FXML
    private ComboBox cbo_contactos;
    @javafx.fxml.FXML
    private TableColumn col_numero;
    @javafx.fxml.FXML
    private TableColumn col_operadora;
    @javafx.fxml.FXML
    private TableView<Telefono> tbl_telefonos;

    @javafx.fxml.FXML
    public void acc_mostrarDetalle(ActionEvent actionEvent) {
        try {
            Object evento=event.getScource();
            if (evento.equals(this.cbo_contactos)){
                //cargar informacion
                this.fun_mostrarDetalle(
                        this.cbo_contactos.getSelectionModel().getSelectedItem().getTelefonos();
                );

            }
        }catch (Exception e) {

        }
    }
    public void cargarPersonas() {
        try {
            this.cbo_contactos.getItems
        }
    }
    public void fun_mostrarDetalle() {
        try {
            this.tbl_telefonos.getItems().clear();
            this.tbl_telefonos.getItems().addAll(listatelefonos);
        }catch (Exception e)
    }
    @javafx.fxml.FXML
    public void acc_btncancelar(ActionEvent actionEvent) {
    }
}
