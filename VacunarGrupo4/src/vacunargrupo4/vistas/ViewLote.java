/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.vistas;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import vacunargrupo4.control.Conexion;
import vacunargrupo4.control.LabData;
import vacunargrupo4.control.VacunaData;
import vacunargrupo4.modelos.Laboratorio;
import vacunargrupo4.modelos.Localidad;
import vacunargrupo4.modelos.Vacuna;

/**
 *
 * @author Maxi
 */
public class ViewLote extends javax.swing.JInternalFrame {

    Conexion conexion;
    ArrayList<Laboratorio> laboratorios;
    LabData ld;
    VacunaData vd;
    Border border;
    public ViewLote(Conexion conexion) {
        initComponents();
        border = new LineBorder(Color.getHSBColor(0, 87, 100), 3, true);
        this.conexion=conexion;
        ld = new LabData(conexion);
        vd = new VacunaData(conexion);
        laboratorios = (ArrayList<Laboratorio>) ld.obtenerLaboratorios();
        cargarLab();
    }

    public void cargarLab(){
        for(Laboratorio item:laboratorios){
            cbLab.addItem(item);
        }    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbLab = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtCargar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtSerie = new javax.swing.JTextField();
        jTtamanio = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(51, 35, 76));

        cbLab.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        cbLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLabActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tamaño del Lote");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Laboratorio");

        jtCargar.setBackground(new java.awt.Color(51, 35, 76));
        jtCargar.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jtCargar.setForeground(new java.awt.Color(255, 255, 255));
        jtCargar.setText("Cargar");
        jtCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCargarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("N° Serie Inicial");

        jtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtSerieActionPerformed(evt);
            }
        });
        jtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtSerieKeyTyped(evt);
            }
        });

        jTtamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTtamanioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jtCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTtamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbLab, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTtamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jtCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCargarActionPerformed
        int cantidad,nroSerie;
        Laboratorio laboratorio;
        Vacuna vacuna;
        
        try{
            nroSerie = Integer.parseInt(jtSerie.getText());
            try{
                cantidad = Integer.parseInt(jTtamanio.getText());
                if (cantidad<=0){
                    JOptionPane.showMessageDialog(cbLab, "Debe ingresar un numero mayor a 0");
                    jTtamanio.setBorder(border);
                    jTtamanio.requestFocus();
                }else{
                    laboratorio = (Laboratorio)cbLab.getSelectedItem();
                    vacuna = new Vacuna(nroSerie,laboratorio);
                    vd.ingresarLote(vacuna,cantidad,vacuna.getNroSerie());
                    JOptionPane.showMessageDialog(cbLab, "Lote Ingresado correctamente");
                    jtSerie.setText(null);
                    jTtamanio.setText(null);
                }
            }catch(NumberFormatException c){
                JOptionPane.showMessageDialog(cbLab, "Formato de numero incorrecto");
                jTtamanio.setBorder(border);
                jTtamanio.requestFocus();
            }
        
        
        }catch(NumberFormatException c){
            JOptionPane.showMessageDialog(cbLab, "Formato de nro. de serie incorrecto");
            jtSerie.setBorder(border);
            jtSerie.requestFocus();
        }    
       
    }//GEN-LAST:event_jtCargarActionPerformed

    private void jtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSerieKeyTyped
        jtSerie.setBorder(null);
    }//GEN-LAST:event_jtSerieKeyTyped

    private void sCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sCantidadKeyTyped
        jTtamanio.setBorder(null);
    }//GEN-LAST:event_sCantidadKeyTyped

    private void jtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtSerieActionPerformed

    private void cbLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLabActionPerformed

    private void jTtamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTtamanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTtamanioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Laboratorio> cbLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTtamanio;
    private javax.swing.JButton jtCargar;
    private javax.swing.JTextField jtSerie;
    // End of variables declaration//GEN-END:variables

}
