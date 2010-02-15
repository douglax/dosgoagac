/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.test;

import com.agac.bo.Comprobante;
import com.agac.bo.Concepto;
import com.agac.bo.CuentaPredial;
import com.agac.bo.Emisor;
import com.agac.bo.InformacionAduanera;
import com.agac.bo.Parte;
import com.agac.bo.Receptor;
import com.agac.bo.Ubicacion;
import com.agac.bo.UbicacionFiscal;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Date;

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
        Comprobante c = new Comprobante();
        Emisor e = c.getEmisor();
        e.setNombre("EMPRESA XYZ");
        e.setRfc("FYAC010101AAA");
        Ubicacion u = e.getExpedidoEn();
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
        
        UbicacionFiscal uf = e.getDomicilioFiscal();
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
        
        Receptor r = c.getReceptor();
        r.setNombre("Cliente XYZ");
        r.setRfc("ABCD010101AAA");
        r.setDomicilio(u);                
        Concepto con = new Concepto();
        InformacionAduanera ia = new InformacionAduanera();        
        ia.setAduana("Aduana");
        ia.setFecha(new Date(System.currentTimeMillis()));
        ia.setNumero("ASKDH654654654");
        con.getInfoAduanera().add(ia);
        con.setCuentaPredial(new CuentaPredial("CuentaPredial"));
        Parte par = new Parte();
        par.setCantidad(new BigDecimal(1.325));
        par.setImporte(new BigDecimal(6546.6541));
        par.setNoIdentificacion("ABDCS293879824");
        par.getInfoAduanera().add(ia);
        par.setUnidad("PZ");
        par.setValorUnitario(new BigDecimal(52.36));
        con.getParte().add(par);
        con.getParte().add(par);
        con.getParte().add(par);
        con.getParte().add(par);
        con.setCantidad(5.23);
        con.setDescripcion("Cuaderno Scribe");
        con.setImporte(new BigDecimal(52.30));
        con.setNoIdentificacion("123465A");
        con.setUnidad("PZ");
        con.setValorUnitario(new BigDecimal(23.50));
        c.getConceptos().add(con);
        c.getConceptos().add(con);

        Marshaller m = ctx.createMarshaller();
        StringWriter writer = new StringWriter();
        m.marshal(c, writer);
        System.out.println(writer);

    }

}