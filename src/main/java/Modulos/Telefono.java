package Modulos;


public class Telefono {
    private String operadora;
    private String telefono;


    public Telefono(String operadora, String telefono) {
        this.operadora = operadora;
        this.telefono = telefono;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}