/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.test;

import com.agac.gui.resourses.TripleDES;
import org.junit.Test;
import org.openide.util.Exceptions;

/**
 *
 * @author Carlos
 */
public class TestCipher {

    @Test
    public void testCipher(){
        try {
            TripleDES td = new TripleDES();
            String s = td.encriptar("a0123456789");
            System.out.println(s);
            s = td.desencriptar(s);
            System.out.println(s);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

}