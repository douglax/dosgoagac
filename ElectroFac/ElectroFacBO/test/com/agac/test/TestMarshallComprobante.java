/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.test;

import com.agac.anexo20.CadenaOriginal;
import com.agac.anexo20.Pkcs8KeyReader;
import com.agac.anexo20.SelloDigital;
import com.agac.bo.Comprobante;
import com.agac.bo.Concepto;
import com.agac.bo.CuentaPredial;
import com.agac.bo.Emisor;
import com.agac.bo.InformacionAduanera;
import com.agac.bo.Parte;
import com.agac.bo.Receptor;
import com.agac.bo.Ubicacion;
import com.agac.bo.UbicacionFiscal;
import com.agac.bo.Impuesto;
import com.agac.bo.Retencion;
import com.agac.bo.Traslado;
import com.agac.bo.Complemento;
import com.agac.services.DbServices;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFrame;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author caguirre
 */
public class TestMarshallComprobante {

    Comprobante c = new Comprobante();
    static String sello = "";
    static String cadena = "";

    @Before
    public void setUp() {
        c.setVersion("2.0");
        c.setAnoAprobacion(2010);
        c.setCertificado("XYZ");
        c.setCondicionesDePago("Efectivo");
        c.setDescuento(new BigDecimal(0.23));
        c.setFolio("XYZ");
        c.setFormaDePago("Pago en una sola exibicion");
        c.setMetodoDePago("tarjetazo");
        c.setMotivoDescuento("XYZ");
        c.setNoAprobacion(123);
        c.setNoCertificado("XYZ");
        c.setSello("EEE");
        c.setSerie("321321321321");
        c.setTipoDeComprobante("INGRESO");
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
        con.setCantidad(5.23);
        con.setDescripcion("Cuaderno Scribe");
        con.setImporte(new BigDecimal(52.30));
        con.setNoIdentificacion("123465A");
        con.setUnidad("PZ");
        con.setValorUnitario(new BigDecimal(23.50));
        c.getConceptos().add(con);

        /* aqui me quedé */
        Impuesto imp = new Impuesto();

        Retencion rete = new Retencion();
        rete.setImpuesto("IVA");
        rete.setImporte(new BigDecimal(12.34));
        imp.getRetenciones().add(rete);

        rete.setImpuesto("ISR");
        rete.setImporte(new BigDecimal(56.78));
        imp.getRetenciones().add(rete);

        Traslado tras = new Traslado();
        tras.setImpuesto("IVA");
        tras.setTasa(new BigDecimal(.0123));
        tras.setImporte(new BigDecimal(1000));
        imp.getTraslados().add(tras);

        tras.setImpuesto("IEPS");
        tras.setTasa(new BigDecimal(.4567));
        tras.setImporte(new BigDecimal(2000.34298766));
        imp.getTraslados().add(tras);

        imp.setTotalImpuestosRetenidos(new BigDecimal(10.101));
        imp.setTotalImpuestosTrasladados(new BigDecimal(20.202));

        Complemento compl = new Complemento();
        compl.getAny().add(new String("complemento1"));
        compl.getAny().add(new String("complemento2"));
        compl.getAny().add(new String("complemento3"));
        c.setImpuesto(imp);
        System.out.println(c.getSubTotal());
    }

    @Test
    public void testMarshall() throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Comprobante.class);
        Marshaller m = ctx.createMarshaller();
        StringWriter writer = new StringWriter();
        m.marshal(c, writer);
        System.out.println(writer);
    }

    @Test
    public void testJpa() {
        try {
            DbServices.saveObject(c);
            DbServices.closeDbServices();
        } catch (Exception ex) {
            Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testCadenaOriginal() {
        cadena = new CadenaOriginal(c).toString();
        System.out.println(cadena);
    }

    @Test
    public void testSelloDigital() {
        FileDialog fd = new FileDialog(new JFrame(), "Llave Privada", FileDialog.LOAD);
        fd.setFile("*.key");
        fd.setVisible(true);
        if (fd.getFile() != null) {

            String pass = "a0123456789";
            PrivateKey pk = null;
            try {
                pk = Pkcs8KeyReader.loadKey(new File(fd.getDirectory() + fd.getFile()), pass.toCharArray());
                System.out.println(pk);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (GeneralSecurityException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            }
            cadena = new CadenaOriginal(c).toString();
            SelloDigital sd = new SelloDigital();
            sd.cargarLlavePrivada(pk);
            try {
                System.out.println("\n===== SELLO DIGITAL =====\n");
                sello = sd.generar(cadena);
                System.out.println(sello);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Test
    public void verificaFactura() {
        FileDialog fd = new FileDialog(new JFrame(), "Llave Privada", FileDialog.LOAD);
        fd.setFile("*.cer");
        fd.setVisible(true);
        SelloDigital sd = new SelloDigital();
        if (fd.getFile() != null) {
            try {
                sd.cargarLlavePublicaDeCertificado(fd.getDirectory() + fd.getFile());
                try {
                    if (sd.verificar(sello, cadena)) {
                        System.out.println("\nSe verifico la factura con exito!!!\n");
                    } else {
                        System.out.println("\nNo se pudo verificar la factura\n");
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchPaddingException ex) {
                    Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalBlockSizeException ex) {
                    Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadPaddingException ex) {
                    Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CertificateException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestMarshallComprobante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
