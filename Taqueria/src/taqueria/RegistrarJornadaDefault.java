/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package taqueria;

import Controlador.Ctrl_RegistroJornada;
import Modelo.RegistroJornada;
import Modelo.Usuario;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class RegistrarJornadaDefault extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistrarJornadaDefault
     */
    private Usuario usuarioLoggedIn;
    public RegistrarJornadaDefault() {
        initComponents();
        this.setSize(500,300);
        this.setResizable(false);
        this.setClosable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonSalida = new javax.swing.JButton();
        buttonEntrada = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        jPanel1.add(buttonSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 100, -1));

        buttonEntrada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Entrada.png"))); // NOI18N
        buttonEntrada.setText("Entrada");
        buttonEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(buttonEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cliente.png"))); // NOI18N
        jLabel2.setText("Bienvenido!");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/historial1.png"))); // NOI18N
        jLabel3.setText("Registro de jornada laboral");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalidaActionPerformed
        RegistroJornada registro = new RegistroJornada();
        registro.setUsuario(usuarioLoggedIn.getUsuario());
        //registro.setHora_entrada(new Time(System.currentTimeMillis()));
        registro.setHora_salida(new Time(System.currentTimeMillis()));
        Ctrl_RegistroJornada controlador = new Ctrl_RegistroJornada();
        registro.setId_empleado(controlador.getIDEmpleado(registro));
        registro.setId_registro(controlador.getIDRegistro(registro));
        boolean respuesta = controlador.salida(registro);
        if(respuesta){
            JOptionPane.showMessageDialog(null, "Salida registrada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la salida");
        }
    }//GEN-LAST:event_buttonSalidaActionPerformed

    private void buttonEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntradaActionPerformed
        RegistroJornada registro = new RegistroJornada();
        registro.setUsuario(usuarioLoggedIn.getUsuario());
        registro.setHora_entrada(new Time(System.currentTimeMillis()));
        
        Ctrl_RegistroJornada controlador = new Ctrl_RegistroJornada();
        registro.setId_empleado(controlador.getIDEmpleado(registro));
        
        boolean resultado = false;
        try{
            resultado = controlador.entrada(registro);
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(resultado){
            JOptionPane.showMessageDialog(null, "Entrada registrada correctamente");
        }
    }//GEN-LAST:event_buttonEntradaActionPerformed

    public void setUsuarioLoggedIn(Usuario usuario){
        this.usuarioLoggedIn = usuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEntrada;
    private javax.swing.JButton buttonSalida;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}