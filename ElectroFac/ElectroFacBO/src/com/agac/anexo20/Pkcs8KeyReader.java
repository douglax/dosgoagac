package com.agac.anexo20;

/*
 * KeyReader.java 
 * Clase para leer la llave privada formato DER PKCS 8
 * Utilizamos las librerias de not-yet-commmon-SSL
 *
 *
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import org.apache.commons.ssl.PKCS8Key;

/**
 * @author Carlos Aguirre
 */
public class Pkcs8KeyReader {

    /** No se pueden crear instancias de esta clase*/
    private Pkcs8KeyReader() {
    }

    public static PrivateKey loadKey(File fileName, char[] password) throws FileNotFoundException,
            GeneralSecurityException, IOException{

        InputStream in = new BufferedInputStream(new FileInputStream(fileName));
        PKCS8Key pkcs8 = new PKCS8Key(in, password);
        byte[] decrypted = pkcs8.getDecryptedBytes();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decrypted);
        PrivateKey pk = null;
        if (pkcs8.isDSA()) {
            pk = KeyFactory.getInstance("DSA").generatePrivate(spec);
        } else if (pkcs8.isRSA()) {
            pk = KeyFactory.getInstance("RSA").generatePrivate(spec);
        }
        return pk;
    }
}
