package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class FXMLagenda {
    @javafx.fxml.FXML
    private Button btn_salir;
    @javafx.fxml.FXML
    private Button btn_persona;
    @javafx.fxml.FXML
    private Button btn_telefono;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void acc_btntelefono(ActionEvent actionEvent) {
        try {
            //abrir formulario principal
            String directorio="/Vistas/";
            String formulario=directorio+"FXMLTelefono.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void acc_btnsalir(ActionEvent actionEvent) {
        //cerrar el formulario actual
        Stage myStage = (Stage) this.btn_salir.getScene().getWindow();
        myStage.close();
    }

    @javafx.fxml.FXML
    public void acc_btnpersona(ActionEvent actionEvent) throws IOException {
        //abrir formulario principal
        String directorio="/Vistas/";
        String formulario=directorio + "FXMLPersona.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
        Parent root=loader.load();
        //asociar con la pantalla Personas
        FXMLPersona controlador=loader.getController();
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
        Stage myStage=(Stage) this.btn_salir.getScene().getWindow();
        myStage.close();
        stage.show();
//        try {
//            //abrir formulario principal
//            String directorio="/Vistas/";
//            String formulario=directorio+"FXMLagenda.fxml";
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setOnCloseRequest(eh -> controlador.cerrarFormulario());
//            this.btn_salir
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


}





