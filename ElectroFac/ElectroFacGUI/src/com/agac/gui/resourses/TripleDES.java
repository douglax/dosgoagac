package com.agac.gui.resourses;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Carlos Aguirre
 */
public class TripleDES {

    private byte[] key = new byte[]{
        (byte) 87, (byte) 83, (byte) 185, (byte) 222,
        (byte) 14, (byte) 1, (byte) 98, (byte) 233,
        (byte) 47, (byte) 214, (byte) 32, (byte) 2,
        (byte) 7, (byte) 88, (byte) 36, (byte) 42,
        (byte) 202, (byte) 68, (byte) 11, (byte) 77,
        (byte) 208, (byte) 147, (byte) 109, (byte) 61
    };
    private byte[] iv = new byte[]{
        (byte) 47, (byte) 214, (byte) 32, (byte) 2,
        (byte) 7, (byte) 88, (byte) 36, (byte) 42,};

    public String encriptar(String txt) throws Exception {
        SecretKey keyLocal = new SecretKeySpec(this.key, "DESede");
        IvParameterSpec ivLocal = new IvParameterSpec(this.iv);
        Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keyLocal, ivLocal);
        byte[] enc = c.doFinal(txt.getBytes("utf-8"));
        return new String(enc);
    }
}
