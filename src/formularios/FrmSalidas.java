/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import accesodatos.BarcosBD;
import accesodatos.SalidasBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetosnegocio.Barco;
import objetosnegocio.Salida;


/**
 *
 * @author laura
 */
public class FrmSalidas extends javax.swing.JFrame {
    private final SalidasBD SALIDASBD; 
    /**
     * Creates new form FrmBarcos
     */
    BarcosBD BARCOSBD;
    public FrmSalidas(JFrame padre) {
        initComponents();
        this.setTitle("Salidas");
        this.setLocationRelativeTo(null);
        SALIDASBD = new SalidasBD();
        jTextIdSalida.setEnabled(false);
        this.cargarTabla();
        BARCOSBD = new BarcosBD();
        agregarBarcos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtHora = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        lblBarco = new javax.swing.JLabel();
        jTextIdSalida = new javax.swing.JTextField();
        jTextDestino = new javax.swing.JTextField();
        jComboBoxBarco = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jTextBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaSalidas = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtSalidas = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        lblFormato = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblId.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        lblId.setText("ID");

        lblFecha.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        lblFecha.setText("FECHA");

        txtHora.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N

        lblDestino.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        lblDestino.setText("DESTINO");

        lblBarco.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        lblBarco.setText("BARCO");

        jTextIdSalida.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jTextIdSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdSalida(evt);
            }
        });

        jTextDestino.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jTextDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDestino(evt);
            }
        });

        jComboBoxBarco.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jComboBoxBarco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jTextBuscar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jTextBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscar(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblListaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FECHA - HORA", "DESTINO", "ID BARCO", "NOMBRE BARCO", "NOMBRE SOCIO"
            }
        ));
        tblListaSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaSalidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaSalidas);

        btnEditar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtSalidas.setFont(new java.awt.Font("Calibri Light", 3, 20)); // NOI18N
        txtSalidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSalidas.setText("SALIDAS");

        txtDate.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDate(evt);
            }
        });

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/340 (2).png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        lblFormato.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        lblFormato.setForeground(new java.awt.Color(153, 153, 153));
        lblFormato.setText("yyyy-MM-dd HH:mm:ss");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblFormato)
                                        .addGap(129, 129, 129))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(350, 350, 350))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId)
                                .addGap(9, 9, 9)
                                .addComponent(txtHora))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDestino)
                                .addGap(18, 18, 18)
                                .addComponent(jTextDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblBarco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(jComboBoxBarco, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFecha)
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                                            .addComponent(jTextIdSalida))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(txtSalidas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(jTextIdSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha))
                        .addGap(23, 23, 23)
                        .addComponent(lblFormato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDestino, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextDestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxBarco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBarco))
                        .addGap(118, 118, 118))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEditar)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnCancelar)
                                    .addComponent(btnGuardar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnMenu)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextIdSalida(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdSalida
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdSalida

    private void jTextDestino(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDestino
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDestino

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        if(jTextIdSalida.getText().isEmpty() && !jTextDestino.getText().isEmpty()){
            guardar();
        }else if (!jTextDestino.getText().isEmpty()){
            actualizar();
        }else{
            JOptionPane.showMessageDialog(this, "Debes llenar los campos", "Información", JOptionPane.ERROR_MESSAGE);
        }
        limpiar();
        cargarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
        cargarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jTextBuscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscar
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscar

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar(jTextBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
        cargarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblListaSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaSalidasMouseClicked
        mostrarInfo();
    }//GEN-LAST:event_tblListaSalidasMouseClicked

    private void txtDate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDate

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        Menu menu = new Menu();
        menu.show();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void buscar(String texto){
       SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       ArrayList<Salida> salidas = SALIDASBD.buscar(texto);        
        DefaultTableModel modelo = (DefaultTableModel)tblListaSalidas.getModel();        
        modelo.setRowCount(0);
        for (Salida salida: salidas) {
            Object[] fila = new Object[4];
            fila[0] = salida.getIdSalida();
            fila[1] = formater.format(salida.getFechaHora());
            fila[2] = salida.getDestino();
            fila[3] = salida.getIdBarco().getIdBarco();
            modelo.addRow(fila);
        }
    }
    private void guardar(){  
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String destino = jTextDestino.getText();
        Barco barco = (Barco)jComboBoxBarco.getSelectedItem();
        
        Salida salida = new Salida(destino, barco);
        try{
            salida.setFechaHora(new java.sql.Date(formater.parse(txtDate.getText()).getTime()));
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(this, "Fecha incorrecta", "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        SALIDASBD.guardar(salida);
    }
    
    private void actualizar(){
        int idSalida = Integer.parseInt(jTextIdSalida.getText());
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String destino = jTextDestino.getText();
        Barco barco = (Barco)jComboBoxBarco.getSelectedItem();
        Salida salida = new Salida(idSalida, barco, destino);
        
        try{
            salida.setFechaHora(new java.sql.Date(formater.parse(txtDate.getText()).getTime()));
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(this, "Fecha incorrecta", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        SALIDASBD.actualizar(salida);
    }
    
    private void mostrarInfo(){
        int indiceFila = tblListaSalidas.getSelectedRow();
        int idsalida = (Integer)tblListaSalidas.getValueAt(indiceFila, 0);
            Salida salida = SALIDASBD.consultar(idsalida);
            jTextIdSalida.setText(String.valueOf(salida.getIdSalida()));
            
            jComboBoxBarco.setSelectedItem(SALIDASBD.obtenerBarco(salida.getIdBarco().getIdBarco()));            
            jTextDestino.setText(salida.getDestino());
            
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            txtDate.setText(formater.format(salida.getFechaHora()));
            jTextIdSalida.setEnabled(false);
            txtDate.setEnabled(false);
            jTextDestino.setEnabled(false);
            jComboBoxBarco.setEnabled(false);
    }
    
    private void eliminar(){
        int indiceFila = tblListaSalidas.getSelectedRow();
        if(indiceFila == -1){
            JOptionPane.showMessageDialog(this, "Debes seleccionar una salida", "Información", JOptionPane.ERROR_MESSAGE);
        }else{
            int idsalida = (Integer)tblListaSalidas.getValueAt(indiceFila, 0);
            Salida salida = SALIDASBD.consultar(idsalida);
            SALIDASBD.eliminar(idsalida);
            limpiar();
        }
        
    }
    
    private void editar(){
        int indiceFila = tblListaSalidas.getSelectedRow();
        if(indiceFila == -1){
            JOptionPane.showMessageDialog(this, "Debes seleccionar una salida", "Información", JOptionPane.ERROR_MESSAGE);
        }else{
            mostrarInfo();
//            txtId.setEnabled(true);
            txtDate.setEnabled(true);
            jTextDestino.setEnabled(true);
            jComboBoxBarco.setEnabled(true);
        }
    }
    
    private void limpiar(){
        jTextIdSalida.setText("");
        jTextDestino.setText("");
        txtDate.setText("");
        txtDate.setEnabled(true);
        jTextDestino.setEnabled(true);
        jComboBoxBarco.setEnabled(true);
    }    
    
    private void cargarTabla(){
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList<Salida> salidas = SALIDASBD.consultar();        
        DefaultTableModel modelo = (DefaultTableModel)tblListaSalidas.getModel();        
        modelo.setRowCount(0);
        for (Salida salida: salidas) {
            Object[] fila = new Object[8];
            fila[0] = salida.getIdSalida();
            fila[1] = formater.format(salida.getFechaHora());
            fila[2] = salida.getDestino();
            fila[3] = salida.getIdBarco().getIdBarco();
            fila[4] = salida.getIdBarco().getNombre();
            fila[5] = salida.getIdBarco().getIdSocio().getNombre();
            modelo.addRow(fila);
        }
    }

    public void agregarBarcos(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        ArrayList<Barco> barcos = BARCOSBD.consultar();
        for (Barco barco: barcos) {
            modelo.addElement(barco);
            
        }
        jComboBoxBarco.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> jComboBoxBarco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextDestino;
    private javax.swing.JTextField jTextIdSalida;
    private javax.swing.JLabel lblBarco;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFormato;
    private javax.swing.JLabel lblId;
    private javax.swing.JTable tblListaSalidas;
    private javax.swing.JTextField txtDate;
    private javax.swing.JLabel txtHora;
    private javax.swing.JLabel txtSalidas;
    // End of variables declaration//GEN-END:variables
}
