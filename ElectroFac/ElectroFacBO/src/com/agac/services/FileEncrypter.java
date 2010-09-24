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

    public static void Encrypt(String filename, String password) {

        try {
            inFile = new FileInputStream(filename);
            outFile = new FileOutputStream(filename + ".des");

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


        } catch (Exception e) {
        }

    }//encrypt

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

