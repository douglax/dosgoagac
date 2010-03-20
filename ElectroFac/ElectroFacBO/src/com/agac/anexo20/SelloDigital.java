package com.agac.anexo20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Carlos Aguirre
 */
public class SelloDigital {    
    
    
    private PrivateKey mPrivateKey;
    private PublicKey mPublicKey;
    
    public SelloDigital() {
        super();        
    }
    
    public void cargarLlavePrivada(String fileName, String password) throws FileNotFoundException, GeneralSecurityException, IOException {
        mPrivateKey = Pkcs8KeyReader.loadKey(new File(fileName), password.toCharArray());
    }

     public void cargarLlavePrivada(PrivateKey pk){
        mPrivateKey = pk;
    }
    
    public void cargarLlavePublicaDeCertificado(String fileName) throws FileNotFoundException, CertificateException, 
        IOException{
        InputStream in = new FileInputStream(fileName);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate crl = cf.generateCertificate(in);
        mPublicKey = crl.getPublicKey();        
        in.close();        
    }
    
    public String generar(String cadenaOriginal) throws NoSuchAlgorithmException, NoSuchPaddingException, 
        InvalidKeyException, IllegalBlockSizeException, BadPaddingException{                
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] msg = md.digest(cadenaOriginal.getBytes()); 
        Cipher c = Cipher.getInstance("RSA");
        c.init(Cipher.ENCRYPT_MODE, mPrivateKey);
        byte[] b = c.doFinal(msg);
        return new sun.misc.BASE64Encoder().encode(b);       
    }
    
    public boolean verificar(String sello, String cadenaOriginal) throws IOException, 
        NoSuchAlgorithmException,  NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,  
            BadPaddingException{
        byte[] b = new sun.misc.BASE64Decoder().decodeBuffer(sello);
        Cipher c = Cipher.getInstance("RSA");
        c.init(Cipher.DECRYPT_MODE, mPublicKey); 
        byte[] dec = c.doFinal(b);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] msg = md.digest(cadenaOriginal.getBytes()); 
        for(int i=0; i<dec.length; i++)
            if(dec[i] != msg[i])    
                return false;
        return true;        
    }
}
