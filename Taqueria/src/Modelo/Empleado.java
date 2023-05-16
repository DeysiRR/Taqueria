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
    private String direccion_empleado;
    private String telefono_empleado;
    private String usuario;
    private String password;
    private String puesto_empleado;
    
    public Empleado(String nombre_empleado, String apellido_empleado,
                    String direccion_empleado, String telefono_empleado,
                    String usuario, String password, String puesto_empleado){
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.direccion_empleado = direccion_empleado;
        this.telefono_empleado = telefono_empleado;
        this.usuario = usuario;
        this.password = password;
        this.puesto_empleado = puesto_empleado;
    }

    public Empleado(){
        this.nombre_empleado = "";
        this.apellido_empleado = "";
        this.direccion_empleado = "";
        this.telefono_empleado = "";
        this.usuario = "";
        this.password = "";
        this.puesto_empleado = "";
    };
    
    public void setNombreEmpleado(String nombre_empleado){
        this.nombre_empleado = nombre_empleado;
    }
    
    public void setApellidoEmpleado(String apellido_empleado){
        this.apellido_empleado = apellido_empleado;
    }

    public void setDireccionEmpleado(String direccion_empleado){
        this.direccion_empleado = direccion_empleado;
    }

    public void setTelefonoEmpleado(String telefono_empleado){
        this.telefono_empleado = telefono_empleado;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPuestoEmpleado(String puesto_empleado){
        this.puesto_empleado = puesto_empleado;
    }
    
    public String getNombreEmpleado(){
        return nombre_empleado;
    }
    
    public String getApellidoEmpleado(){
        return apellido_empleado;
    }

    public String getDireccionEmpleado(){
        return direccion_empleado;
    }

    public String getTelefonoEmpleado(){
        return telefono_empleado;
    }

    public String getUsuario(){
        return usuario;
    }

    public String getPassword(){
        return password;
    }

    public String getPuestoEmpleado(){
        return puesto_empleado;
    }
}
