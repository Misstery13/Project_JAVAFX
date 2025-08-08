package Controller;

import General.BD;
import Modelos.Persona;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLContactos
{
    @javafx.fxml.FXML
    private TableView<Persona> cod_tabla;
    @javafx.fxml.FXML
    private TableColumn cod_direccion;
    @javafx.fxml.FXML
    private TableColumn cod_cedula;
    @javafx.fxml.FXML
    private TableColumn cod_nombres;
    @javafx.fxml.FXML
    private Button btn_salir;

    @javafx.fxml.FXML
    public void initialize() {
        this.cod_cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        this.cod_nombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        this.cod_direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
    }
    @FXML
    public void acc_cancelar {
    //cerrar el formulario actual
    Stage myStage = (Stage) this.btn_cancelar.getScene().getWindow();
    myStage.close();
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLcontactos.fxml"));
        Parent root = loader.load();
        Stage agendaStage = new Stage();
        agendaStage.setScene(new Scene(root));
        agendaStage.show();
    }catch (IOException e) {
        e.printStackTrace();
    }
        }

    public void fun_cargarPersonas() {
        try{
            //1. Limpiar el tableview
            this.cod_tabla.getItems().clear();
            //2. Cargar la informacion en el tableview
            this.cod_tabla.getItems().addAll(BD.personas);

        } catch (Exception e) {
            General.Mod_general.fun_mensajeError(e.getMessage());
        }
    }
}
