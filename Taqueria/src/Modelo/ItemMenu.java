package Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author diego
 */
public class ItemMenu {
    private String nombre;
    private int precio;
    
    public ItemMenu(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public ItemMenu(){
        this.nombre = "";
        this.precio = 0;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPrecio(int precio_unit){
        this.precio = precio_unit;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getPrecio(){
        return precio;
    }
}
