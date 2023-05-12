package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Conexión local
    public static Connection conectar() {
        Connection cn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/taqueria_la_glorieta";
            String user = "root";
            //String password = "Jk01091997";
            String password = "D@gb282828";
            cn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error en la conexión local: " + e.getMessage());
        }
        return cn;
    }
}
