/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.test;

import com.agac.services.ZipBuilder;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Carlos
 */
public class ZipTest {

    public ZipTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testZip() {
        ZipBuilder zip = new ZipBuilder();
        zip.setSourceFolder("C:/Users/Carlos/Desktop/efactura");
        Calendar fecha = Calendar.getInstance();
        zip.zip("C:/Temp/" + fecha.get(Calendar.YEAR) + (fecha.get(Calendar.MONTH) +  1) +
                fecha.get(Calendar.DAY_OF_MONTH) + fecha.get(Calendar.HOUR_OF_DAY));


    }

}