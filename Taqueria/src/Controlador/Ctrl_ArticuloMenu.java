/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.ItemMenu;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class Ctrl_ArticuloMenu {
    private JComboBox jc = null;
    private JTextField tf = null;
    
    public Ctrl_ArticuloMenu(){}
    public Ctrl_ArticuloMenu(JComboBox jc){
        this.jc = jc;
    }
    public Ctrl_ArticuloMenu(JTextField tf){
        this.tf = tf;
    }
    public Ctrl_ArticuloMenu(JComboBox jc, JTextField tf){
        this.jc = jc;
        this.tf = tf;
    }
    
    /*Para registrar un articulo al menu*/
    public boolean guardar (ItemMenu itemMenu){
        boolean respuesta = false;
        
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "insert into menu_catalogo(nombre, precio_unit) values('" + itemMenu.getNombre() + "', " + itemMenu.getPrecio() + ");";
        Statement st;
        try{
            st = cn.createStatement();
            st.executeUpdate(sql);
            respuesta = true;
            
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return respuesta; 
    }
    
    /*Para obtener los articulos del menu de la BD*/
    public boolean getArticulos(){
        boolean respuesta = false;
        
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select nombre from menu_catalogo";
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                jc.addItem(rs.getString(1));
            }
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return respuesta; 
    }
    
    public boolean getPrecioUnitario(String nombre){
        boolean respuesta = false;
        
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select precio_unit from menu_catalogo where nombre = '" + nombre + "';";
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                tf.setText(rs.getString(1));
            }
            respuesta = true;
            
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return respuesta; 
    }
    
    /*Para modificar los articulos del menu de la BD*/
    public boolean modificar(ItemMenu itemMenu, String nombre){
        boolean respuesta = false;
        
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "update menu_catalogo "
                    + "set nombre = '" + itemMenu.getNombre() + "', precio_unit = '" + itemMenu.getPrecio() + "'"
                    + " where nombre = '" + nombre + "';";
        Statement st;
        try{
            st = cn.createStatement();
            st.executeUpdate(sql);
            respuesta = true;

        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        
        return respuesta; 
    }
    
    /*Para eliminar un articulo del menu de la BD*/
    public boolean eliminar(String nombre){
        boolean respuesta = false;
        int item_id = getItemID(nombre);
        
        //Para eliminar las ventas que referencean al articulo que se quiere eliminar
        if(!eliminarVenta(nombre)){
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }

        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "delete from menu_catalogo where item_id = " + getItemID(nombre) + ";";

        Statement st;
        try{
            st = cn.createStatement();
            st.executeUpdate(sql);
            respuesta = true;
            
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return respuesta; 
    }
    
    public boolean eliminarVenta(String nombre){
        boolean respuesta = false;
        int item_id = getItemID(nombre);
       
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "delete from ventas where item_id = " + getItemID(nombre) + ";";

        Statement st;
        try{
            st = cn.createStatement();
            st.executeUpdate(sql);
            respuesta = true;
            
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return respuesta; 
    }
    
    public int getItemID(String nombre){
        int itemID = 0;
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select item_id from menu_catalogo where nombre = '" + nombre + "';";
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String aux = rs.getString(1);
                itemID = Integer.parseInt(aux);
            }
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return itemID;
    }
    
    /*Para checar si hay duplicado*/
    public boolean hayDuplicado(String nombre){
        boolean hayDuplicado = false;
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select nombre from menu_catalogo where nombre = '" + nombre + "';";
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(1).equals(nombre)){
                    hayDuplicado = true;
                    System.out.println(rs.getString(1));
                }
            }
            
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        
        return hayDuplicado; 
    }
    
    /*Para referenciar el combo box / text field de la respectiva ventana para agregar o eliminar elementos*/
    public void setComboBox(JComboBox jc){
        this.jc = jc;
    }
    
    public void setTextField(JTextField tf){
        this.tf = tf;
    }
}
