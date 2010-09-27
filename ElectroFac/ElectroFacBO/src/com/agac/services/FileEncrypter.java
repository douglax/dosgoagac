/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.services;

import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

/**
 *
 * @author alejandro.acosta
 */
public class FileEncrypter {

    private static FileInputStream inFile;
    private static FileOutputStream outFile;

    public void FileEncrypter(){
        
    }

c
    public static ByteArrayOutputStream Decrypt(String filename, String password) {


        try {
            inFile = new FileInputStream(filename);
            //outFile = new FileOutputStream(filename + ".dcr");
            ByteArrayOutputStream outSt = new ByteArrayOutputStream();

            PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
            SecretKeyFactory keyFactory =
                    SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey passwordKey = keyFactory.generateSecret(keySpec);

            // Read in the previouly stored salt and set the iteration count.

            byte[] salt = new byte[8];
            inFile.read(salt);
            int iterations = 100;

            PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, iterations);

            // Create the cipher and initialize it for decryption.

            Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
            cipher.init(Cipher.DECRYPT_MODE, passwordKey, parameterSpec);


            byte[] input = new byte[64];
            int bytesRead;
            while ((bytesRead = inFile.read(input)) != -1) {
                byte[] output = cipher.update(input, 0, bytesRead);
                if (output != null) {
                    //outFile.write(output);
                    outSt.write(output);
                }
            }

            byte[] output = cipher.doFinal();
            if (output != null) {
                //outFile.write(output);
                outSt.write(output);
            }

            inFile.close();
            //outFile.flush();
            //outFile.close();

            return outSt;

        } catch (Exception e) {
        }

        return null;

    } //Decrypt
} //class

