/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CatalogoArticulosPanel.java
 *
 * Created on 10/05/2010, 03:21:40 PM
 */

package com.agac.gui;

import com.agac.bo.Articulo;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caguirre
 */
public class CatalogoArticulosPanel extends javax.swing.JPanel {

    /** Creates new form CatalogoArticulosPanel */
    public CatalogoArticulosPanel() {
        initComponents();
    }

    public void setArticulos(List<Articulo> arts){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(Articulo a : arts){
            Object o[] = new Object[3];
            o[0] = a.getId().getIdentificador();
            o[1] = a.getDescripcion();
            o[2] = NumberFormat.getCurrencyInstance().format(a.getPrecio().doubleValue());
            model.addRow(o);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(org.openide.util.NbBundle.getMessage(CatalogoArticulosPanel.class, "CatalogoArticulosPanel.jLabel1.text")); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1, java.awt.BorderLayout.NORTH);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Artículo", "Descripción", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(CatalogoArticulosPanel.class, "CatalogoArticulosPanel.jTable1.columnModel.title0")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(CatalogoArticulosPanel.class, "CatalogoArticulosPanel.jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(CatalogoArticulosPanel.class, "CatalogoArticulosPanel.jTable1.columnModel.title2")); // NOI18N

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
