/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package taqueria;

import Conexion.Conexion;
import Controlador.Ctrl_RegistroJornada;
import Modelo.RegistroJornada;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author 1
 */
public class RegistrarJornada extends javax.swing.JInternalFrame {

    int id_registros;

    public RegistrarJornada() {
        initComponents();
        this.setSize(new Dimension(600, 400));
        this.setTitle("Regsitro de Jornada");
        this.TablaJornada();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttonSalida = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRJ = new javax.swing.JTable();
        txtIdEmpleado = new javax.swing.JTextField();
        buttonEntrada = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(108, 76, 60));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 0, -1, 375));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/historial1.png"))); // NOI18N
        jLabel3.setText("Registro de jornada laboral");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(211, 207, 195));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonSalida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salida.png"))); // NOI18N
        buttonSalida.setText("Salida");
        buttonSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalidaActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 100, -1));

        tablaRJ.setBackground(new java.awt.Color(211, 207, 195));
        tablaRJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaRJ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_registro", "Id_empleado", "Fecha", "Hora_entrada", "Hora_Salida"
            }
        ));
        jScrollPane1.setViewportView(tablaRJ);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 550, 190));

        txtIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 161, 30));

        buttonEntrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Entrada.png"))); // NOI18N
        buttonEntrada.setText("Entrada");
        buttonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(buttonEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cliente.png"))); // NOI18N
        jLabel2.setText("Id_empleado ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntradaActionPerformed
        int idEmpleado = Integer.parseInt(txtIdEmpleado.getText());
        RegistroJornada registro = new RegistroJornada();
        registro.setId_empleado(idEmpleado);
        registro.setHora_entrada(new Time(System.currentTimeMillis()));

        Ctrl_RegistroJornada controlador = new Ctrl_RegistroJornada();
        boolean resultado = controlador.entrada(registro);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Entrada registrada correctamente");
            txtIdEmpleado.setText("");
            this.TablaJornada();
            // TablaJornada();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la entrada");
        }

    }//GEN-LAST:event_buttonEntradaActionPerformed

    private void buttonSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalidaActionPerformed
        int idEmpleado = Integer.parseInt(txtIdEmpleado.getText());
        RegistroJornada registro = new RegistroJornada();
        registro.setId_registro(id_registros);
        registro.setId_empleado(idEmpleado);
        registro.setHora_salida(new Time(System.currentTimeMillis()));

        Ctrl_RegistroJornada controlador = new Ctrl_RegistroJornada();
        boolean resultado = controlador.salida(registro);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Salida registrada correctamente");
            txtIdEmpleado.setText("");
            this.TablaJornada();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la salida");
        }


    }//GEN-LAST:event_buttonSalidaActionPerformed

    private void txtIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoActionPerformed

    }//GEN-LAST:event_txtIdEmpleadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEntrada;
    private javax.swing.JButton buttonSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaRJ;
    private javax.swing.JTextField txtIdEmpleado;
    // End of variables declaration//GEN-END:variables
private void TablaJornada() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Evitar que las celdas de la tabla sean editables
                return false;
            }
        };
        String sql = "SELECT id_registro, registro_jornada.id_empleado, e.usuario, fecha, hora_entrada, hora_salida FROM registro_jornada "
                     + " INNER JOIN empleados e ON e.id_empleado = registro_jornada.id_empleado;"; 
        Statement st;
        /*
        SELECT id_registro, registro_jornada.id_empleado, e.nombre_empleado, fecha, hora_entrada, hora_salida FROM registro_jornada
        INNER JOIN empleados e
        on e.id_empleado = registro_jornada.id_empleado;
        */

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tablaRJ.setModel(model);

            model.addColumn("Id_registro");
            model.addColumn("Id_empleado");
            model.addColumn("Usuario");
            model.addColumn("Fecha");
            model.addColumn("Hora_entrada");
            model.addColumn("Hora_salida");

            while (rs.next()) {
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de productos: ");
        }

        tablaRJ.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // Evitar que se realice alguna acción al hacer doble clic en una fila
                    return;
                }
                int fila_point = tablaRJ.rowAtPoint(e.getPoint());
                int columna_point = 2; //columna de usuario

                if (fila_point > -1) {
                    id_registros = (int) model.getValueAt(fila_point, columna_point);
                    TransferirDatosJornada(id_registros);
                }
            }
        });
    }

    private void TransferirDatosJornada(int id_Producto) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT id_empleado, fecha, hora_entrada, hora_salida FROM registro_jornada WHERE id_registro = ?");
            pst.setInt(1, id_Producto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtIdEmpleado.setText(rs.getString("id_empleado"));
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar producto: ");
        }
    }
}
