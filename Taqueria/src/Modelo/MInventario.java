package Modelo;

public class MInventario {

     private int id_Producto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String proovedor;

    public MInventario() {
        this.id_Producto = 0;
        this.nombre = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.proovedor = "";

    }

    public MInventario(int id_Producto, String nombre, String descripcion, int cantidad, String proovedor) {
        this.id_Producto = id_Producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.proovedor = proovedor;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProovedor() {
        return proovedor;
    }

    public void setProovedor(String proovedor) {
        this.proovedor = proovedor;
    }

  
    

}
