/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImpuestoPanel.java
 *
 * Created on Mar 6, 2010, 9:33:04 AM
 */
package com.agac.gui;


import com.agac.bo.Impuesto;
import com.agac.bo.Retencion;
import com.agac.bo.Traslado;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class ImpuestosPanel extends javax.swing.JPanel {

    /** Creates new form InformacionAduaneraPanel */
    public ImpuestosPanel() {
        initComponents();
        this.txtTotalRetenidos.setText(totRetenciones.toString());
        this.txtTotalTrasladados.setText(totTraslados.toString());
    }

    public ImpuestosPanel(Impuesto imp) {

        // Este constructor se utiliza cuando previamente se creo un
        // objeto impuesto para el objeto comprobante

        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();


        // Agregar retenciones a la tabla
        ArrayList<Retencion> retencionList = new ArrayList<Retencion>();

        retencionList = (ArrayList) imp.getRetenciones();

        for(Retencion r : retencionList )
        modelo.addRow(new Object[]{"Retencion", r.getImpuesto() , r.getImporte()  ,null});

        // Agregar traslados a la tabla
        ArrayList<Traslado> trasladoList = new ArrayList<Traslado>();

        trasladoList = (ArrayList) imp.getTraslados();

        for(Traslado t : trasladoList )
        modelo.addRow(new Object[]{"Traslado", t.getImpuesto() , t.getImporte() , t.getTasa()});


        // agregar totales a los textboxes
        this.txtTotalRetenidos.setText(imp.getTotalImpuestosRetenidos().toString());
        this.txtTotalTrasladados.setText(imp.getTotalImpuestosTrasladados().toString());


    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboTipoImpuesto = new javax.swing.JComboBox();
        cboImpuesto = new javax.swing.JComboBox();
        txtImporte = new javax.swing.JTextField();
        txtTasa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTotalRetenidos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotalTrasladados = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();

        jLabel6.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.jLabel6.text")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.jPanel1.border.title"))); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.jLabel1.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.jLabel2.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.jLabel3.text")); // NOI18N

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/agac/gui/resourses/add.png"))); // NOI18N
        btnAdd.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.btnAdd.text")); // NOI18N
        btnAdd.setMaximumSize(new java.awt.Dimension(49, 20));
        btnAdd.setMinimumSize(new java.awt.Dimension(49, 20));
        btnAdd.setPreferredSize(new java.awt.Dimension(49, 20));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.jLabel4.text")); // NOI18N

        cboTipoImpuesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Retención", "Traslado" }));
        cboTipoImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoImpuestoActionPerformed(evt);
            }
        });

        cboImpuesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "I.V.A.", "I.S.R." }));
        cboImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboImpuestoActionPerformed(evt);
            }
        });

        txtImporte.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.txtImporte.text")); // NOI18N

        txtTasa.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.txtTasa.text")); // NOI18N
        txtTasa.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboImpuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTasa, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTipoImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Impuesto", "Importe", "Tasa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.jLabel5.text")); // NOI18N

        txtTotalRetenidos.setEditable(false);
        txtTotalRetenidos.setFont(new java.awt.Font("DejaVu Sans", 1, 11));
        txtTotalRetenidos.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.txtTotalRetenidos.text")); // NOI18N

        jLabel7.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.jLabel7.text")); // NOI18N

        txtTotalTrasladados.setEditable(false);
        txtTotalTrasladados.setFont(new java.awt.Font("DejaVu Sans", 1, 11));
        txtTotalTrasladados.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.txtTotalTrasladados.text")); // NOI18N

        btnLimpiar.setText(org.openide.util.NbBundle.getMessage(ImpuestosPanel.class, "ImpuestosPanel.btnLimpiar.text")); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalTrasladados)
                            .addComponent(txtTotalRetenidos, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(btnLimpiar)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotalRetenidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalTrasladados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
//  *****************************************************************


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        if (cboTipoImpuesto.getSelectedIndex()==0) {
            // Retencion
            model.addRow(new Object[]{"Retención", cboImpuesto.getSelectedItem() , Double.parseDouble(txtImporte.getText()) ,null});
             totRetenciones += Double.parseDouble(txtImporte.getText());
             txtTotalRetenidos.setText(totRetenciones.toString());

        } else if (cboTipoImpuesto.getSelectedIndex()==1) {
            // Traslado
            model.addRow(new Object[]{"Traslado", cboImpuesto.getSelectedItem() , Double.parseDouble(txtImporte.getText()) , Double.parseDouble(txtTasa.getText())});
            totTraslados += Double.parseDouble(txtImporte.getText());
            txtTotalTrasladados.setText(totTraslados.toString());
        }
}//GEN-LAST:event_btnAddActionPerformed

    private void cboImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboImpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboImpuestoActionPerformed

    private void cboTipoImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoImpuestoActionPerformed
        // TODO add your handling code here:
        

        if (cboTipoImpuesto.getSelectedIndex()==0) {
            cboImpuesto.removeAllItems();
            cboImpuesto.addItem(new String("I.V.A."));
            cboImpuesto.addItem(new String("I.S.R."));
            txtTasa.setEnabled(false);
        } else if (cboTipoImpuesto.getSelectedIndex()==1) {
            cboImpuesto.removeAllItems();
            cboImpuesto.addItem(new String("I.V.A."));
            cboImpuesto.addItem(new String("I.E.P.S."));
            txtTasa.setEnabled(true);
        }

    }//GEN-LAST:event_cboTipoImpuestoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        while (modelo.getRowCount() > 0)
              {
                    modelo.removeRow(0);
              }
        
        totRetenciones = 0.0;
        totTraslados = 0.0;

        txtTotalRetenidos.setText("0.0");
        txtTotalTrasladados.setText("0.0");
        
        this.impuesto = null;
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private static Double totRetenciones = 0.0 ;
    private static Double totTraslados  = 0.0 ;

    private Impuesto impuesto = new Impuesto();



    public Impuesto getImpuesto() {


       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for(int c=0;c<model.getRowCount();c++) {

            if(model.getValueAt(c,0) == "Retención") {
                Retencion retencion = new Retencion();
                retencion.setImpuesto(model.getValueAt(c, 1).toString());
                retencion.setImporte(new BigDecimal(model.getValueAt(c, 2).toString()));
                impuesto.getRetenciones().add(retencion);
            }

            if(model.getValueAt(c,0) == "Traslado") {
                Traslado traslado = new Traslado();
                traslado.setImpuesto(model.getValueAt(c, 1).toString());
                traslado.setImporte(new BigDecimal(model.getValueAt(c, 2).toString()));
                traslado.setTasa(new BigDecimal(model.getValueAt(c, 3).toString()));
                impuesto.getTraslados().add(traslado);
            }


        } //for

        if(impuesto != null) {
            impuesto.setTotalImpuestosRetenidos(BigDecimal.valueOf(totRetenciones));
            impuesto.setTotalImpuestosTrasladados(BigDecimal.valueOf(totTraslados));
        }

        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cboImpuesto;
    private javax.swing.JComboBox cboTipoImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtTasa;
    private javax.swing.JTextField txtTotalRetenidos;
    private javax.swing.JTextField txtTotalTrasladados;
    // End of variables declaration//GEN-END:variables
}
