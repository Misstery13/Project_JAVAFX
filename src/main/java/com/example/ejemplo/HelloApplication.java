package com.example.ejemplo;

import Modulos.Persona;
import Modulos.Telefono;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Vistas/FXMLagenda.fxml"));
            Pane ventana = (Pane) fxmlLoader.load();
            Scene scene = new Scene(ventana);
//        stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch();
        Persona objPersona = new Persona("0101010101", "Jaime", "Salinas");
        System.out.println("Cédula: " + objPersona.getCedula());
        System.out.println("Nombres: " + objPersona.getNombres());
        System.out.println("Dirección: " + objPersona.getDireccion());
        Telefono objTelefono = new Telefono("CNT", "987654321");
        objPersona.addTelefonos(objTelefono);
        System.out.println("TELEFONO: "+ objPersona.getTelefonos());
    }
}
