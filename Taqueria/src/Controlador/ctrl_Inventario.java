package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import Modelo.MInventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ctrl_Inventario {

    //metodo para registar producto
    public boolean guardar(MInventario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into inventario(nombre, descripcion, cantidad, proovedor) values (?,?,?,?)");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setString(4, objeto.getProovedor());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto: " + e);
        }
        return respuesta;
    }

    //consultar si ya se ha registrado el producto
    public boolean existeProducto(String objeto) {
        boolean respuesta = false;
        String sql = "select nombre, descripcion, cantidad, provedor from inventario where nombre = ? and descripcion = ? and cantidad = ? and proovedor = ?";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;

            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el producto: " + e);
        }
        return respuesta;
    }
//metodo para actualizar el invdntario

    public boolean actualizarInventario(MInventario objeto, int id_producto) {
        boolean respuesta = false;
        Connection con = Conexion.conectar();
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE inventario SET nombre = ?, descripcion = ?, cantidad = ?, proovedor = ? WHERE id_producto = ?");
            pst.setString(1, objeto.getNombre());
            pst.setString(2, objeto.getDescripcion());
            pst.setInt(3, objeto.getCantidad());
            pst.setString(4, objeto.getProovedor());
            pst.setInt(5, id_producto);

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e);
        }
        return respuesta;
    }

    //metodo para eliminar un producto del inventario
    public boolean eliminarProducto(int id_producto) {
        boolean respuesta = false;
        Connection con = Conexion.conectar();
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM inventario WHERE id_producto = ?");
            pst.setInt(1, id_producto);

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e);
        }
        return respuesta;
    }

}
