/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author diego
 */
public class Empleado {
    private String nombre_empleado;
    private String apellido_empleado;
    
    public Empleado(String nombre, String apellido){
        nombre_empleado = nombre;
        apellido_empleado = apellido;
    }
    
    public void setNombreEmpleado(String nombre_empleado){
        this.nombre_empleado = nombre_empleado;
    }
    
    public void setApellidoEmpleado(String apellido_empleado){
        this.apellido_empleado = apellido_empleado;
    }
    
    public String getNombreEmpleado(){
        return nombre_empleado;
    }
    
    public String getApellidoEmpleado(){
        return apellido_empleado;
    }
}
