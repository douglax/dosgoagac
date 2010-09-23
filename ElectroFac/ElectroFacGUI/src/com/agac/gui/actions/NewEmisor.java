/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui.actions;

import com.agac.gui.EmisorTopComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//import com.agac.libraries.StringEncrypter;

public final class NewEmisor implements ActionListener {



    // Original
    @Override
    public void actionPerformed(ActionEvent e) {
        EmisorTopComponent top = new EmisorTopComponent();
        top.open();
        top.requestActive();
    }


    // prueba

//        @Override
//    public void actionPerformed(ActionEvent e) {
//
//        System.out.println();
//        System.out.println("+----------------------------------------+");
//        System.out.println("|  -- Test Using Pass Phrase Method --   |");
//        System.out.println("+----------------------------------------+");
//        System.out.println();
//
//        String secretString = "Attack at dawn!";
//        String passPhrase   = "My Pass Phrase";
//
//        // Create encrypter/decrypter class
//        StringEncrypter desEncrypter = new StringEncrypter(passPhrase);
//
//        // Encrypt the string
//        String desEncrypted       = desEncrypter.encrypt(secretString);
//
//        // Decrypt the string
//        String desDecrypted       = desEncrypter.decrypt(desEncrypted);
//
//        // Print out values
//        System.out.println("PBEWithMD5AndDES Encryption algorithm");
//        System.out.println("    Original String  : " + secretString);
//        System.out.println("    Encrypted String : " + desEncrypted);
//        System.out.println("    Decrypted String : " + desDecrypted);
//        System.out.println();
//
//    }

}
