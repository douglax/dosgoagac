/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.test;

import com.agac.bo.Comprobante;
import com.agac.bo.Emisor;
import com.agac.bo.Receptor;
import com.agac.bo.Ubicacion;
import com.agac.bo.UbicacionFiscal;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author caguirre
 */
public class TestMarshallComprobante {

    public TestMarshallComprobante() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testMarshall() throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Comprobante.class);
        Emisor e = new Emisor();
        e.setNombre("EMPRESA XYZ");
        e.setRfc("FYAC010101AAA");
        Ubicacion u = new Ubicacion();
        u.setCalle("Calle 25");
        u.setCodigoPostal("31170");
        u.setColonia("Colonia Centro");
        u.setEstado("Chihuahua");
        u.setLocalidad("Chihuahua");
        u.setMunicipio("Chihuahua");
        u.setNoExterior("2255");
        u.setNoInterior("A");
        u.setPais("Mexico");
        u.setReferencia("Entre calle X y calle Y");
        e.setExpedidoEn(u);
        
        UbicacionFiscal uf = new UbicacionFiscal();
        uf.setCalle("Calle 123");
        uf.setCodigoPostal("31000");
        uf.setColonia("Colonia Centro");
        uf.setEstado("Chihuahua");
        uf.setLocalidad("Chihuahua");
        uf.setMunicipio("Chihuahua");
        uf.setNoExterior("100");
        uf.setNoInterior("100-A");
        uf.setPais("Mexico");
        uf.setReferencia("Entre calle X y calle Y");
        e.setDomicilioFiscal(uf);
        Receptor r = new Receptor();
        r.setNombre("Cliente XYZ");
        r.setRfc("ABCD010101AAA");
        r.setDomicilio(u);
        
        Comprobante c = new Comprobante();
        c.setEmisor(e);
        c.setReceptor(r);

        Marshaller m = ctx.createMarshaller();
        StringWriter writer = new StringWriter();
        m.marshal(c, writer);
        System.out.println(writer);

    }

}