/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LicenciasPanel.java
 *
 * Created on 23/09/2010, 01:43:59 PM
 */
package com.agac.gui;

import com.agac.bo.Emisor;
import com.agac.bo.Licencia;
import javax.swing.table.DefaultTableModel;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

import com.agac.services.StringEncrypter;
import com.agac.services.FileEncrypter;
import java.io.ByteArrayOutputStream;

import com.agac.services.DbServices;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejandro.acosta
 */
public class LicenciasPanel extends javax.swing.JPanel {

    Licencia licencia = new Licencia();

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    /** Creates new form LicenciasPanel */
    public LicenciasPanel() {
        initComponents();
        LlenaCampos();

        //validaLicencias();

        //prueba();
    }

    private void prueba() {
        //StringEncrypter.testUsingPassPhrase();
        FileEncrypter.Encrypt("c:\\pruebas\\clave2.txt", "pasguord");

    }

    private void LlenaCampos() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Preferences pref = NbPreferences.forModule(OpcionesdelSistemaPanel.class);

        String archivo = pref.get("LICENCIA", "DEMO");
        String password = pref.get("PASSWORD", "DEMO");


        System.out.println("Archivo-> " + archivo + " || clave-> " + password);
        //Desencriptar archivo

        ByteArrayOutputStream baos = FileEncrypter.Decrypt(archivo, password);


        if (baos != null) {

            System.out.println(baos.toString());
            String cadena = baos.toString();
            String remain;

            //Extraemos el folio
            String folio = cadena.substring(0, cadena.indexOf("\n")).trim();
            licencia.setFolio(folio);
            remain = cadena.substring(cadena.indexOf("\n") + 1, cadena.length());
            cadena = remain;

            //Extraemos la fecha
            String fecha = cadena.substring(0, cadena.indexOf("\n")).trim();
            txtFecha.setText(fecha);

            licencia.setFecha(new Date(System.currentTimeMillis()));
            licencia.setFecha(Date.valueOf(fecha));
            licencia.setId(Long.valueOf("1"));



            remain = cadena.substring(cadena.indexOf("\n") + 1, cadena.length());
            System.out.println("Remain-> " + remain);

            cadena = remain;



            //Extraemos el número de comprobantes
            String numero = cadena.substring(0, cadena.indexOf("\n")).trim();



            if (numero.equals("-1")) {
                txtComprobantes.setText("ilimitado");
            } else {
                txtComprobantes.setText(numero);
            }
            licencia.setAutorizados(Long.parseLong(numero.trim()));

            remain = cadena.substring(cadena.indexOf("\n") + 1, cadena.length());
            System.out.println("Remain-> " + remain.trim());

            cadena = remain;

            //Extraemos los RFC y los agregamos a la tabla

            // La cadena remanente debe tener una longitud multiplo de 14
            // ya que cada RFC ocupa 13 posiciones + \n
            // ej.
            // AAAA010101XXX\n
            // BBBB020202YYY\n
            // CCCC030303ZZZ\n
            // El algoritmo se basa en extraer subcadenas de 14 caractéres
            // y sustraer el último

            String rfc;


            while (true) {
                remain = cadena;
                rfc = remain.substring(0, remain.indexOf("\n"));
                cadena = cadena.substring(cadena.indexOf("\n") + 1, cadena.length());
                model.addRow(new Object[]{rfc});
                System.out.println("RFC-> " + rfc.trim());
                System.out.println("cadena " + cadena.trim());
                System.out.println("caracteres restante " + cadena.length());

                if (cadena.length() < 1) {
                    break;
                }
            }



            //checar si existe la licencia y obtener el valor previo de
            //los comprobantes autorizado
            List<Licencia> lic = null;

            String qry = "Select l from Licencia l where l.folio = ?1";
            lic = DbServices.getListWithParameters(qry, folio);

            if (lic.size() > 0) {
                // Existe licencia previa

                licencia.setEmitidos(lic.get(0).getEmitidos());
            } else {
                licencia.setEmitidos(Long.valueOf("0"));
            }




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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtComprobantes = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emisores Autorizados"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(LicenciasPanel.class, "LicenciasPanel.jTable1.columnModel.title0")); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(LicenciasPanel.class, "LicenciasPanel.jLabel1.text")); // NOI18N

        txtFecha.setEditable(false);
        txtFecha.setText(org.openide.util.NbBundle.getMessage(LicenciasPanel.class, "LicenciasPanel.txtFecha.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(LicenciasPanel.class, "LicenciasPanel.jLabel2.text")); // NOI18N

        txtComprobantes.setEditable(false);
        txtComprobantes.setText(org.openide.util.NbBundle.getMessage(LicenciasPanel.class, "LicenciasPanel.txtComprobantes.text")); // NOI18N

        jScrollPane2.setBorder(null);

        jTextPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jTextPane1.setText(org.openide.util.NbBundle.getMessage(LicenciasPanel.class, "LicenciasPanel.jTextPane1.text")); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/agac/gui/resourses/pencil.png"))); // NOI18N
        jButton1.setText(org.openide.util.NbBundle.getMessage(LicenciasPanel.class, "LicenciasPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtComprobantes))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(87, 87, 87)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtComprobantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        List<Emisor> lista = null;
        String qry;

        // Si hay registros en la tabla y además hay un renglón seleccionado
        if (model.getRowCount() != 0 && jTable1.getSelectedRow() != -1) {


            qry = "Select e from Emisor e where UPPER(e.rfc) = ?1";
            lista = DbServices.getListWithParameters(qry, model.getValueAt(jTable1.getSelectedRow(), 0).toString());
            if (lista.size() > 0) {
                // La clave existe, solo modificar
                EmisorTopComponent etc = new EmisorTopComponent();
                etc.setEmisor(lista.get(0));
                etc.open();
                etc.requestActive();
                this.setVisible(false);
            } else {
                //No existe, agregar
                EmisorTopComponent etc = new EmisorTopComponent(model.getValueAt(jTable1.getSelectedRow(), 0).toString().trim());
                etc.open();
                etc.requestActive();
            }


        } //if

    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField txtComprobantes;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
