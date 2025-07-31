package Modulos;

import java.util.ArrayList;

public class Telefono {
    private String cedula;
    private String nombres;
    private String direccion;
    private ArrayList<Telefono>telefonos= new ArrayList<Telefono>();
}

public Persona(String cedula, String nombres, String direccion) {
    this.cedula = cedula;
    this.nombres = nombres;
    this.direccion = direccion;

}
public String getCedula() {
    return cedula;
}
public void setCedula(String cedula) {
    this.cedula = cedula;
}
public String getNombres() {
    return nombres;
}
public void setNombres(String nombres) {
    this.nombres = nombres;
}
public String getDireccion() {
    return direccion;
}
public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public ArrayList<Telefono> getTelefonos() {
    return telefonos;
}
public void setTelefonos(ArrayList<Telefono> telefonos) {
    this.telefonos = telefonos;
}

