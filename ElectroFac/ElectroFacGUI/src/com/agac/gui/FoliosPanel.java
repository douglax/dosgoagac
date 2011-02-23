package com.agac.gui;

import com.agac.bo.Comprobante;
import com.agac.bo.Emisor;
import com.agac.bo.Serie;
import com.agac.services.DbServices;
import java.awt.FileDialog;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.Message;
import org.openide.util.lookup.Lookups;
import org.openide.windows.WindowManager;

/**
 *
 * @author Alex
 */
public class FoliosPanel extends javax.swing.JPanel {

    /** Creates new form InformacionAduaneraPanel */
    public FoliosPanel() {

        initComponents();
    }

    public FoliosPanel(Emisor em) {
        initComponents();
        this.emisor = em;
    }
    private Serie serie = new Serie();

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
        firePropertyChange("serie", null, serie);
    }
    private Emisor emisor = new Emisor();

    public Emisor getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtFolioInicial = new javax.swing.JTextField();
        txtFolioFinal = new javax.swing.JTextField();
        txtAnoAprob = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        txtNumAprob = new javax.swing.JFormattedTextField();
        btnEliminar = new javax.swing.JButton();
        btnAddCbb = new javax.swing.JButton();
        btnVerCbb = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.jPanel1.border.title"))); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.jLabel2.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.jLabel3.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.jLabel4.text")); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.jLabel5.text")); // NOI18N

        jLabel6.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.jLabel6.text")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${serie.numSerie}"), txtSerie, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${serie.folioInicial}"), txtFolioInicial, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${serie.folioFinal}"), txtFolioFinal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${serie.anoAprob}"), txtAnoAprob, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serie", "Folio Inicial", "Folio Final", "No. Aprobación", "Año Aprobación", "Activa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/agac/gui/resourses/add.png"))); // NOI18N
        btnAdd.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.btnAdd.text")); // NOI18N
        btnAdd.setMaximumSize(new java.awt.Dimension(49, 20));
        btnAdd.setMinimumSize(new java.awt.Dimension(49, 20));
        btnAdd.setPreferredSize(new java.awt.Dimension(49, 20));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtNumAprob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtNumAprob.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.txtNumAprob.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${serie.numAutorización}"), txtNumAprob, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/agac/gui/resourses/delete.png"))); // NOI18N
        btnEliminar.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.btnEliminar.text")); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAddCbb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/agac/gui/resourses/cbb_add.png"))); // NOI18N
        btnAddCbb.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.btnAddCbb.text")); // NOI18N
        btnAddCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCbbActionPerformed(evt);
            }
        });

        btnVerCbb.setText(org.openide.util.NbBundle.getMessage(FoliosPanel.class, "FoliosPanel.btnVerCbb.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFolioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFolioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtNumAprob, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAnoAprob, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnAddCbb, 0, 0, Short.MAX_VALUE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE))
                            .addComponent(btnVerCbb, 0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFolioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFolioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAnoAprob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumAprob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[6];
        row[0] = serie.getNumSerie();
        row[1] = serie.getFolioInicial();
        row[2] = serie.getFolioFinal();
        row[3] = serie.getNumAutorización();
        row[4] = serie.getAnoAprob();
        row[5] = serie.isActiva();
        model.addRow(row);
        serieList.add(serie);
        setSerie(new Serie());
        txtSerie.setText("");
        txtFolioFinal.setText("");
        txtFolioInicial.setText("");
        txtNumAprob.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        JTable tbl = (JTable) evt.getSource();
        if (tbl.getSelectedRow() == -1) {
            return;
        }
        Serie s = serieList.get(tbl.getSelectedRow());
        System.out.println(s.getNumAutorización());
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        s.setActiva(Boolean.parseBoolean(model.getValueAt(tbl.getSelectedRow(), 5).toString()));

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed


        if (jTable1.getSelectedRow() != -1) {
            List<Comprobante> lista = new ArrayList<Comprobante>();
            //Emisor emisor = getLookup().lookup(Emisor.class);
            String ser = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();

            String qry = "Select c from Comprobante c where c.emisor=?1 and c.serie=?2";
            lista = DbServices.getListWithParameters(qry, this.getEmisor(), ser);
            if (lista.isEmpty()) {

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                int posicion = jTable1.getSelectedRow();

                if (posicion >= 0) {



                    for (int c = 0; c < jTable1.getRowCount(); c++) {
                        if (c == posicion) {
                            model.removeRow(c);
                        }
                    }


                    this.getSeries().remove(posicion);

                }

            } else {
                Message msg = new NotifyDescriptor.Message("Esta serie cuenta con comprobantes emitidos\ny no puede ser eliminada! ", NotifyDescriptor.ERROR_MESSAGE);
                DialogDisplayer.getDefault().notify(msg);
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAddCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCbbActionPerformed

            FileDialog fd = new FileDialog(WindowManager.getDefault().getMainWindow(),
                    "Código de Barras Bidimensional");
            fd.setVisible(true);
            if (fd.getFile() != null) {
                try {
                    String fn = fd.getFile();
                    String ext = fn.substring(fn.indexOf(".") + 1, fn.length());
                    InputStream in = new FileInputStream(new File(fd.getDirectory() + fn));
                    BufferedImage i = ImageIO.read(in);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] b = null;
                    ImageIO.write(i, ext, bos);
                    b = bos.toByteArray();
                    bos.close();

                    //aqui me quedé
                    Emisor emisor = getLookup().lookup(Emisor.class);
                    emisor.setLogo(b);
                    emisor = DbServices.saveObject(emisor, true);
                    DialogDisplayer.getDefault().notify(
                            new NotifyDescriptor.Message(
                            "El logotipo del emisor se guardo correctamente"));
                } catch (Exception ex) {
                    Exceptions.printStackTrace(ex);
                }
            }

    }//GEN-LAST:event_btnAddCbbActionPerformed
    private List<Serie> serieList;

    public List<Serie> getSeries() {
        return serieList;
    }

    public void setSeries(List<Serie> serieList) {
        this.serieList = serieList;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (Serie s : serieList) {
            Object[] row = new Object[6];
            row[0] = s.getNumSerie();
            row[1] = s.getFolioInicial();
            row[2] = s.getFolioFinal();
            row[3] = s.getNumAutorización();
            row[4] = s.getAnoAprob();
            row[5] = serie.isActiva();
            model.addRow(row);
        }
    }
//  *****************************************************************
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddCbb;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVerCbb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAnoAprob;
    private javax.swing.JTextField txtFolioFinal;
    private javax.swing.JTextField txtFolioInicial;
    private javax.swing.JFormattedTextField txtNumAprob;
    private javax.swing.JTextField txtSerie;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
