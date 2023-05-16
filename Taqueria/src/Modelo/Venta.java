/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author diego
 */
public class Venta {
    private int item_id;
    private int id_empleado;
    private int cantidad;
    
    public Venta(int item_id, int id_empleado, int cantidad){
        this.item_id = item_id;
        this.id_empleado = id_empleado;
        this.cantidad = cantidad;
    }

    public Venta() {
        this.item_id = 0;
        this.id_empleado = 0;
        this.cantidad = 0;
    }
    
    public void setItemID(int item_id){
        this.item_id = item_id;
    }
    
    public void setIdEmpleado(int id_empleado){
        this.id_empleado = id_empleado;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public int getItemID(){
        return item_id;
    }
    
    public int getIdEmpleado(){
        return id_empleado;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
}
