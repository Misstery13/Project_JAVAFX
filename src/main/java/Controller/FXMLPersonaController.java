package Controller;

import General.BD;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class FXMLPersonaController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
    //cerrar el formulario actual
    Stage myStage=(Stage) this.btn_cancelar.getScene().getWindows();
    myStage()
    catch (Exception e) {

    }
    private void acc_grabar(ActionEvent event) {
        try {
            if (fun_validar()){
                String cedula=this.txt_cedula.getText();
                String nombres=this.txt_nombre.getText();
                String direccion=this.txt_direccion.getText();
                Persona objPersona=new Persona(cedula,nombres,direccion);
                BD.personas.add(objPersona);
                System.out.println("Se registro con exito");
                for (Persona obj : BD.personas) {
                    System.out.println("CEDULA: "+ obj.getNombres());
                }

            }else {
                System.out.println("Datos sin validar");
            }
        } catch (Exception e) {

        }
        private static boolean fun_validar() {
            return true;
        }
    } // implementar combo box en telefono
}
