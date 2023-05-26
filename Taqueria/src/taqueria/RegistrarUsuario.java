/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package taqueria;

import Conexion.Conexion;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class RegistrarUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistrarUsuario
     */
    private static final int nombre_size = 25;
    private static final int apellido_size = 25;
    private static final int direccion_size = 40;
    private static final int telefono_size = 10;
    private static final int usuario_size = 15;
    private static final int password_size = 15;
    
    private Empleado empleado;
    private String puesto_empleado;
    private String id_puesto;
    private boolean puestoElegido;
    
    public RegistrarUsuario() {
        empleado = new Empleado();
        initComponents();
        this.setTitle("Registrar Usuario");
        jComboBox1.removeAllItems();
        obtenerCatalogoPuestos();
        puesto_empleado = null;
        id_puesto = null;
        puestoElegido = false;
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(64, 33, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(576, 415));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR USUARIO");

        jPanel2.setBackground(new java.awt.Color(108, 76, 60));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField1.setText("Nombre de Usuario");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setText("Nombre del Empleado");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("Apellido del Empleado");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setText("Direccion del Empleado");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setText("Telefono del Empleado");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Puesto:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Información del Empleado:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Crear Usuario:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/registrarusuarios.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 51));
        jLabel7.setText("*Direccion y telefono son opcionales");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(96, 96, 96))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(8, 8, 8)))
                .addComponent(jLabel7))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        if(jTextField1.getText().trim().length() <= usuario_size){
            if(!jTextField1.getText().isBlank()){
                empleado.setUsuario((jTextField1.getText().trim().toLowerCase()));
                jPasswordField1.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de usuario válido.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: el nombre de usuario no es válido.");
        }
        
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
 
        if(jPasswordField1.getPassword().length > 0 && jPasswordField1.getPassword().length <= password_size){
            String pass = jPasswordField1.getText();
            empleado.setPassword(pass);
            jTextField2.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Error: la contraseña no es valida.");
        }
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(!empleado.getUsuario().isBlank() && !existeNombreUsuario(empleado.getUsuario())){
            if(!empleado.getNombreEmpleado().isBlank() && !empleado.getApellidoEmpleado().isBlank()
                && !empleado.getPuestoEmpleado().isBlank() && !empleado.getUsuario().isBlank()
                   && !empleado.getPassword().isBlank()){
            guardar();
            empleado = new Empleado();
            JOptionPane.showMessageDialog(null, "Se creó el nuevo usuario correctamente.");
            }else{
                JOptionPane.showMessageDialog(null, "Error: los datos que ingresó no son válidos.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: el nombre de usuario que usted ingreso ya existe. Intente uno nuevo.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        if(!jTextField2.getText().isBlank() && jTextField2.getText().trim().length() <= nombre_size){
            empleado.setNombreEmpleado(jTextField2.getText().trim().toLowerCase());
            jTextField3.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Error: el nombre del empleado no es valido.");
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
        if(!jTextField3.getText().isBlank() && jTextField3.getText().trim().length() <= apellido_size){
            empleado.setApellidoEmpleado(jTextField3.getText().trim().toLowerCase());
            jTextField4.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Error: el apellido del empleado no es valido..");
        }
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
        if(jTextField4.getText().trim().length() <= direccion_size){
            if(!jTextField4.getText().isBlank()){
                empleado.setDireccionEmpleado(jTextField4.getText().trim().toLowerCase());
                jTextField5.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: la direccion del empleado no es valida..");
        }
        
        
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
        if(jTextField5.getText().trim().length() <= telefono_size){
            if(!jTextField5.getText().isBlank()){
                empleado.setTelefonoEmpleado(jTextField5.getText().trim().toLowerCase());
                jComboBox1.requestFocus();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error: el telefono del empleado no es valida..");
        }
        
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        puesto_empleado = String.valueOf(jComboBox1.getSelectedItem());
        puestoElegido = true;
        id_puesto = getIDPuesto();
        System.out.println(puesto_empleado);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public boolean guardar(){
        boolean respuesta = false;
        
        Connection cn = Conexion.conectar();
        String sql = "insert into empleados(nombre_empleado, apellido_empleado, direccion_empleado, telefono_empleado, usuario, password, id_puesto) "
                + "values('" + empleado.getNombreEmpleado() + "','" + empleado.getApellidoEmpleado() + "','" + empleado.getDireccionEmpleado() + "','"
                + empleado.getTelefonoEmpleado() + "','" + empleado.getUsuario() + "','" + empleado.getPassword() + "'," + id_puesto + ");";
                
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
    
    public void obtenerCatalogoPuestos(){
        Connection cn = Conexion.conectar();  

        String sql = "select puesto_empleado from catalogo_puestos;";
        Statement st;
        
        try{
            st=cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            //Asignar datos a combo box
            while(rs.next()){
                jComboBox1.addItem(rs.getString(1));
            }
            st.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al obtener el catalogo de puestos de la base de datos...");
        }
    }
    
    public String getIDPuesto(){
        Connection cn = Conexion.conectar();  

        String sql = "select id_puesto, puesto_empleado from catalogo_puestos;";
        Statement st;
        String id_puesto = null;
        try{
            st=cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            //Asignar datos a combo box
            while(rs.next()){
                if(puesto_empleado.equals(rs.getString(2))){
                    id_puesto = rs.getString(1);
                    empleado.setPuestoEmpleado(puesto_empleado);
                }
            }
            st.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al obtener el catalogo de puestos de la base de datos...");
        }
        return id_puesto;
    }
    
    public boolean existeNombreUsuario(String nombre_usuario){
        Connection cn = Conexion.conectar();  

        String sql = "select usuario from empleados where usuario = '"+nombre_usuario+"';";
        Statement st;
        boolean respuesta = false;
        try{
            st=cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            //Comparar si usuario ingresado ya existe
            while(rs.next()){
                if(nombre_usuario.equals(rs.getString(1))){
                    respuesta = true;
                }                
            }
            st.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al obtener el catalogo de puestos de la base de datos...");
        }
        return respuesta;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
