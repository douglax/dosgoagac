/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui;





import java.awt.FileDialog;
import org.openide.util.NbPreferences;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.openide.windows.WindowManager;




final class OpcionesdelSistemaPanel extends javax.swing.JPanel {

    private final OpcionesdelSistemaOptionsPanelController controller;

    OpcionesdelSistemaPanel(OpcionesdelSistemaOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPlantillas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        optReporte1 = new javax.swing.JRadioButton();
        optReporte2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReporte = new javax.swing.JTextArea();
        picLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtIEPS = new javax.swing.JTextField();
        txtISR = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtRutaReportes = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jLabel4.text")); // NOI18N

        txtLocalidad.setText(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.txtLocalidad.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jLabel5.text")); // NOI18N

        txtMunicipio.setText(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.txtMunicipio.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jLabel6.text")); // NOI18N

        txtEstado.setText(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.txtEstado.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jPanel2.border.title"))); // NOI18N

        btnGroupPlantillas.add(optReporte1);
        optReporte1.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(optReporte1, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.optReporte1.text")); // NOI18N

        btnGroupPlantillas.add(optReporte2);
        org.openide.awt.Mnemonics.setLocalizedText(optReporte2, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.optReporte2.text")); // NOI18N
        optReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optReporte2ActionPerformed(evt);
            }
        });

        txtReporte.setColumns(20);
        txtReporte.setRows(5);
        jScrollPane1.setViewportView(txtReporte);

        org.openide.awt.Mnemonics.setLocalizedText(picLabel, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.picLabel.text")); // NOI18N
        picLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optReporte2)
                    .addComponent(optReporte1))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(optReporte1)
                        .addGap(18, 18, 18)
                        .addComponent(optReporte2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(picLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jPanel3.border.title"))); // NOI18N

        txtIEPS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIEPS.setText(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.txtIEPS.text")); // NOI18N

        txtISR.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtISR.setText(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.txtISR.text")); // NOI18N
        txtISR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISRActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jLabel2.text")); // NOI18N

        txtIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIVA.setText(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.txtIVA.text")); // NOI18N
        txtIVA.setToolTipText(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.txtIVA.toolTipText")); // NOI18N
        txtIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIVAActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIEPS)
                    .addComponent(txtISR)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(336, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtISR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIEPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jPanel4.border.title"))); // NOI18N

        txtRutaReportes.setEditable(false);
        txtRutaReportes.setText(org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.txtRutaReportes.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(OpcionesdelSistemaPanel.class, "OpcionesdelSistemaPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRutaReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRutaReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtISRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISRActionPerformed

    private void txtIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIVAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIVAActionPerformed

    private void optReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optReporte2ActionPerformed
        // TODO add your handling code here:

        BufferedImage image;




        if (optReporte2.isSelected()) {

            txtReporte.setText("Hoja tamaño carta\n\nLogo cuadrado de 100x100\norientación superior izquierda  ");
            
          try {

            image = ImageIO.read(new File("com/agac/gui/resourses/report1_thumb.jpg"));
            picLabel.setIcon(new ImageIcon( image ));
          }
          catch (IOException e) {
                System.out.println(e.getMessage() + " - " + e.getLocalizedMessage());
          }


        }

    }//GEN-LAST:event_optReporte2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        FileDialog fd = new FileDialog(WindowManager.getDefault().getMainWindow(),
                "Archivo de reporte", FileDialog.SAVE);
        fd.setFile("*.txt");
        fd.setVisible(true);



        txtRutaReportes.setText(fd.getDirectory() );



    }//GEN-LAST:event_jButton1ActionPerformed

    void load() {
        // TODO read settings and initialize GUI
        // Example:        
        // someCheckBox.setSelected(Preferences.userNodeForPackage(OpcionesdelSistemaPanel.class).getBoolean("someFlag", false));
        // or for org.openide.util with API spec. version >= 7.4:
        // someCheckBox.setSelected(NbPreferences.forModule(OpcionesdelSistemaPanel.class).getBoolean("someFlag", false));
        // or:
        // someTextField.setText(SomeSystemOption.getDefault().getSomeStringProperty());

        //txtIVA.setText(Preferences.systemNodeForPackage(OpcionesdelSistemaPanel.class).get("IVA","0.16" ));
        //txtISR.setText(Preferences.systemNodeForPackage(OpcionesdelSistemaPanel.class).get("ISR","0.30" ));
        //txtIEPS.setText(Preferences.systemNodeForPackage(OpcionesdelSistemaPanel.class).get("IVA","0.50" ));

        txtIVA.setText(NbPreferences.forModule(OpcionesdelSistemaPanel.class).get("IVA","0.16"));
        txtISR.setText(NbPreferences.forModule(OpcionesdelSistemaPanel.class).get("ISR","0.30"));
        txtIEPS.setText(NbPreferences.forModule(OpcionesdelSistemaPanel.class).get("IEPS","0.50"));
        txtLocalidad.setText(
                NbPreferences.forModule(OpcionesdelSistemaPanel.class).get("LOCALIDAD", ""));
        txtMunicipio.setText(
                NbPreferences.forModule(OpcionesdelSistemaPanel.class).get("MUNICIPIO", ""));
        txtEstado.setText(
                NbPreferences.forModule(OpcionesdelSistemaPanel.class).get("ESTADO", ""));
        txtRutaReportes.setText(
                NbPreferences.forModule(OpcionesdelSistemaPanel.class).get("RUTAREPORTES", ""));

    }

    void store() {
        // TODO store modified settings
        // Example:
        // Preferences.userNodeForPackage(OpcionesdelSistemaPanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or for org.openide.util with API spec. version >= 7.4:
        // NbPreferences.forModule(OpcionesdelSistemaPanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or:
        // SomeSystemOption.getDefault().setSomeStringProperty(someTextField.getText());

      //  Preferences.userNodeForPackage(OpcionesdelSistemaPanel.class).put("IVA", txtIVA.getText() );
      //  Preferences.userNodeForPackage(OpcionesdelSistemaPanel.class).put("ISR", txtISR.getText() );
      //  Preferences.userNodeForPackage(OpcionesdelSistemaPanel.class).put("IEPS", txtIEPS.getText() );

        NbPreferences.forModule(OpcionesdelSistemaPanel.class).put("IVA", txtIVA.getText());
        NbPreferences.forModule(OpcionesdelSistemaPanel.class).put("ISR", txtISR.getText());
        NbPreferences.forModule(OpcionesdelSistemaPanel.class).put("IEPS", txtIEPS.getText());
        NbPreferences.forModule(OpcionesdelSistemaPanel.class).put("LOCALIDAD", txtLocalidad.getText());
        NbPreferences.forModule(OpcionesdelSistemaPanel.class).put("MUNICIPIO", txtMunicipio.getText());
        NbPreferences.forModule(OpcionesdelSistemaPanel.class).put("ESTADO", txtEstado.getText());
        NbPreferences.forModule(OpcionesdelSistemaPanel.class).put("RUTAREPORTES", txtRutaReportes.getText());

    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupPlantillas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton optReporte1;
    private javax.swing.JRadioButton optReporte2;
    private javax.swing.JLabel picLabel;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIEPS;
    private javax.swing.JTextField txtISR;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextArea txtReporte;
    private javax.swing.JTextField txtRutaReportes;
    // End of variables declaration//GEN-END:variables
}
