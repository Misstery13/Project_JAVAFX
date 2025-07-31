package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLagendaController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String formulario=directorio+"FXMLPersonaController.java";
        FXMLLoader loader = new FXMLLoader(getClass());
        Parent root=loader.load();
        //asociar con la pantalla Personas
        FXMLPersonaController controlador=loader.getController();
        Scene scene=new scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
        Stage myStage=(Stage) this.btn_salir.getScene().getWindow();
        myStage.close();
        launch(Exception e); {

        }
    }
    try {
        //abrir formulario principal
        String directorio="/Vistas/";
        String formulario=directorio+"FXMLAgenda.fxml";
    }
}
