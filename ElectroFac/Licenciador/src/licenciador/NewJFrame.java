/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 30-sep-2010, 12:05:32
 */

package licenciador;

import java.awt.FileDialog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class NewJFrame extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
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
        txtFuente = new javax.swing.JTextField();
        btnLoad = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPassphrase = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Archivo Fuente:");

        btnLoad.setText("...");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        jLabel2.setText("Archivo Destino (Encriptado)");

        btnSave.setText("...");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Frase secreta:");

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoad))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPassphrase, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDestino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSave))
                    .addComponent(btnGenerar))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassphrase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerar)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        try {
            Encrypt(txtFuente.getText(),txtDestino.getText(),txtPassphrase.getText());
        } catch (Exception e) {

        }
}//GEN-LAST:event_btnGenerarActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

        FileDialog fd = new FileDialog(this,
                "Archivo fuente", FileDialog.LOAD);
        fd.setFile("*.txt");
        fd.setVisible(true);



        txtFuente.setText(fd.getDirectory() + fd.getFile() );
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        FileDialog fd = new FileDialog(this,
                "Archivo fuente", FileDialog.SAVE);
        fd.setFile("*.des");
        fd.setVisible(true);



        txtDestino.setText(fd.getDirectory() + fd.getFile() );
    }//GEN-LAST:event_btnSaveActionPerformed


       public static void Encrypt(String fuente, String destino, String password) {

    FileInputStream inFile;
    FileOutputStream outFile;

        try {
            inFile = new FileInputStream(fuente);
            outFile = new FileOutputStream(destino);
            password.concat("starbucks");

            // Use PBEKeySpec to create a key based on a password.
            // The password is passed as a character array

            PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
            SecretKeyFactory keyFactory =
                    SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey passwordKey = keyFactory.generateSecret(keySpec);

            // PBE = hashing + symmetric encryption.  A 64 bit random
            // number (the salt) is added to the password and hashed
            // using a Message Digest Algorithm (MD5 in this example.).
            // The number of times the password is hashed is determined
            // by the interation count.  Adding a random number and
            // hashing multiple times enlarges the key space.

            byte[] salt = new byte[8];
            Random rnd = new Random();
            rnd.nextBytes(salt);
            int iterations = 100;

            //Create the parameter spec for this salt and interation count

            PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, iterations);

            // Create the cipher and initialize it for encryption.

            Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
            cipher.init(Cipher.ENCRYPT_MODE, passwordKey, parameterSpec);

            // Need to write the salt to the (encrypted) file.  The
            // salt is needed when reconstructing the key for decryption.

            outFile.write(salt);

            // Read the file and encrypt its bytes.

            byte[] input = new byte[64];
            int bytesRead;
            while ((bytesRead = inFile.read(input)) != -1) {
                byte[] output = cipher.update(input, 0, bytesRead);
                if (output != null) {
                    outFile.write(output);
                }
            }

            byte[] output = cipher.doFinal();
            if (output != null) {
                outFile.write(output);
            }

            inFile.close();
            outFile.flush();
            outFile.close();


        JOptionPane.showMessageDialog(null, "Archivo generado exitosamente!");
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocurrio un error al generar el archivo",
                "Error",JOptionPane.ERROR_MESSAGE);
        
        }

    }//encrypt


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtFuente;
    private javax.swing.JTextField txtPassphrase;
    // End of variables declaration//GEN-END:variables

}
