package Modelo;

public class Inventario {

    private int id_Producto;
    private String nombre;
    private int estado;

    public Inventario() {
        this.id_Producto = 0;
        this.nombre = "";
        this.estado = 0;
    }

    public Inventario(int id_Producto, String nombre, int estado) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
