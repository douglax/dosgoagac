/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui.nodes;

import com.agac.bo.Comprobante;
import com.agac.bo.Emisor;
import com.agac.bo.Serie;
import com.agac.gui.ArticulosPanel;
import com.agac.gui.ComprobanteTopComponent;
import com.agac.gui.EmisorTopComponent;
import com.agac.gui.FoliosPanel;
import com.agac.gui.MenuTopComponent;
import com.agac.gui.ReporteMensualPanel;
import com.agac.services.DbServices;
import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.ErrorManager;
import org.openide.NotifyDescriptor;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;
import org.openide.util.Utilities;
import org.openide.util.lookup.Lookups;
import org.openide.windows.WindowManager;

/**
 *
 * @author Carlos
 */
public class EmpresaNode extends AbstractNode {

    public EmpresaNode(Emisor e) {
        super(Children.create(new ComprobanteNodeFactory(e), true), Lookups.singleton(e));
        setDisplayName(e.getNombre());
        setIconBaseWithExtension("com/agac/gui/resourses/filenew.png");
    }

    @Override
    public Action[] getActions(boolean bln) {
        return new Action[]{new OpenAction(),
                    new CrearFactura(),
                    new AdminFolios(),
                    new CatalogoArticulos(),
                    new AddLogo(),
                    new VerLogo(),
                    new ReporteMensual()
                };
    }

    @Override
    public Action getPreferredAction() {
        return new OpenAction();
    }

    @Override
    protected Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        Sheet.Set dFiscal = Sheet.createPropertiesSet();

        Emisor e = getLookup().lookup(Emisor.class);
        try {
            Property nombre = new PropertySupport.Reflection<String>(e, String.class, "getNombre", null);
            Property rfc = new PropertySupport.Reflection<String>(e, String.class, "getRfc", null);
            nombre.setName("nombre");
            nombre.setDisplayName("Nombre");
            rfc.setName("rfc");
            rfc.setDisplayName("R.F.C.");

            Property calle = new PropertySupport.Reflection<String>(e.getDomicilioFiscal(), String.class,
                    "getCalle", null);
            calle.setName("calle");
            calle.setDisplayName("Calle");

            Property noExt = new PropertySupport.Reflection<String>(e.getDomicilioFiscal(), String.class,
                    "getNoExterior", null);
            Property noInt = new PropertySupport.Reflection<String>(e.getDomicilioFiscal(), String.class,
                    "getNoInterior", null);
            Property localidad = new PropertySupport.Reflection<String>(e.getDomicilioFiscal(), String.class,
                    "getLocalidad", null);
            Property municipio = new PropertySupport.Reflection<String>(e.getDomicilioFiscal(), String.class,
                    "getMunicipio", null);
            Property estado = new PropertySupport.Reflection<String>(e.getDomicilioFiscal(), String.class,
                "getEstado", null);
            Property pais = new PropertySupport.Reflection<String>(e.getDomicilioFiscal(), String.class,
                "getPais", null);

            noExt.setName("noExterior");
            noExt.setDisplayName("Número Exterior");
            noInt.setName("noInterior");
            noInt.setDisplayName("Número Interior");
            localidad.setName("localidad");
            localidad.setDisplayName("Localidad");
            municipio.setName("municipio");
            municipio.setDisplayName("Municipio ó Delegación:");
            estado.setName("estado");
            estado.setDisplayName("Estado");
            pais.setName("pais");
            pais.setDisplayName("País");

       

            set.put(nombre);
            set.put(rfc);
            set.setName("Datos");
            set.setDisplayName("Datos de la Empresa");

            dFiscal.put(calle);
            dFiscal.put(noExt);
            dFiscal.put(noInt);
            dFiscal.put(localidad);
            dFiscal.put(municipio);
            dFiscal.put(estado);
            dFiscal.put(pais);
            dFiscal.setName("DomicilioFiscal");
            dFiscal.setDisplayName("Domicilio Fiscal");


        } catch (NoSuchMethodException ex) {
            ErrorManager.getDefault();
        }
        sheet.put(set);
        sheet.put(dFiscal);
        return sheet;
    }

    private class OpenAction extends AbstractAction {

        public OpenAction() {
            putValue(NAME, "Abrir Empresa Emisora");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            EmisorTopComponent etc = new EmisorTopComponent();
            etc.setEmisor(getLookup().lookup(Emisor.class));
            etc.open();
            etc.requestActive();
        }
    }

    private class CrearFactura extends AbstractAction {

        public CrearFactura() {
            putValue(NAME, "Crear Comprobante de Ingreso");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            final ProgressHandle ph = ProgressHandleFactory.createHandle("");
//            ph.start();
//            ph.switchToIndeterminate();
//            ph.setDisplayName("Creando Factura...");
            final MenuTopComponent frm =
                    (MenuTopComponent) WindowManager.getDefault().findTopComponent("MenuTopComponent");
            try {
                frm.getBeanTreeView1().setCursor(Utilities.createProgressCursor(frm));
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        Comprobante c = new Comprobante();
                        c.setTipoDeComprobante("Ingreso");
                        ComprobanteTopComponent ctc = new ComprobanteTopComponent();
                        ctc.setComprobante(c);
                        ctc.setDisplayName("Nuevo Comprobante");
                        ctc.componentOpened();
                        ctc.getComprobante().setEmisor(getLookup().lookup(Emisor.class));
                        ctc.open();
                        ctc.requestActive();
                        frm.getBeanTreeView1().setCursor(null);
                    }
                });
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private class AdminFolios extends AbstractAction {

        public AdminFolios() {
            putValue(NAME, "Expediente de Folios");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Emisor emisor = getLookup().lookup(Emisor.class);
            List<Serie> series = new ArrayList<Serie>();
            if (emisor.getSeries() != null) {
                series.addAll(emisor.getSeries());
            }
            FoliosPanel folPan = new FoliosPanel();
            folPan.setSeries(series);
            DialogDescriptor dd = new DialogDescriptor(folPan, "Folios", true, null);
            Object result = DialogDisplayer.getDefault().notify(dd);
            if (NotifyDescriptor.OK_OPTION.equals(result)) {
                try {
                    emisor.setSeries(series);
                    emisor = DbServices.saveObject(emisor, true);
                } catch (Exception ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }

    private class AddLogo extends AbstractAction {

        public AddLogo() {
            putValue(NAME, "Agregar Logotipo de la empresa");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            FileDialog fd = new FileDialog(WindowManager.getDefault().getMainWindow(),
                    "Logotipo Empresa Emisora");
            fd.setVisible(true);
            if (fd.getFile() != null) {
                try {
                    String fn = fd.getFile();
                    String ext = fn.substring(fn.indexOf(".") + 1, fn.length());
                    InputStream in = new FileInputStream(new File(fd.getDirectory() + fn));
                    BufferedImage i = ImageIO.read(in);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] b = null;
                    ImageIO.write(i, ext, bos);
                    b = bos.toByteArray();
                    bos.close();
                    Emisor emisor = getLookup().lookup(Emisor.class);
                    emisor.setLogo(b);
                    emisor = DbServices.saveObject(emisor, true);
                    DialogDisplayer.getDefault().notify(
                            new NotifyDescriptor.Message(
                            "El logotipo del emisor se guardo correctamente"));
                } catch (Exception ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }

    private class VerLogo extends AbstractAction {

        public VerLogo() {
            putValue(NAME, "Ver logotipo de la empresa");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                JLabel logo = new JLabel();
                Emisor emisor = getLookup().lookup(Emisor.class);
                if(emisor.getLogo() == null){
                    DialogDisplayer.getDefault().notify(
                        new NotifyDescriptor.Message("No existe imagen para este emisor"));
                    return;
                }
                InputStream in = new ByteArrayInputStream(emisor.getLogo());
                Image img = ImageIO.read(in);
                if(img == null){
                    DialogDisplayer.getDefault().notify(
                        new NotifyDescriptor.Message("No existe imagen para este emisor"));
                    return;
                }
                logo.setIcon(new ImageIcon(img));
                panel.add(logo, BorderLayout.CENTER);
                DialogDisplayer.getDefault().notify(
                        new NotifyDescriptor.Message(panel));
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private class CatalogoArticulos extends AbstractAction{

        public CatalogoArticulos(){
            putValue(NAME, "Catálogo de artículos...");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            ArticulosPanel ap = new ArticulosPanel();
            ap.setEmisor(getLookup().lookup(Emisor.class));
            DialogDisplayer.getDefault().notify(
                        new DialogDescriptor(ap,
                        "Artículos", true, null));
        }
    }


    private class ReporteMensual extends AbstractAction {
        public ReporteMensual(){
            putValue(NAME, "Generar Reporte Mensual");
        }
        @Override
        public void actionPerformed(ActionEvent e){
            ReporteMensualPanel rm = new ReporteMensualPanel();
            rm.setEmisor(getLookup().lookup(Emisor.class));
            DialogDisplayer.getDefault().notify(
                        new DialogDescriptor(rm,
                        "Reporte Mensual", true, null));
        }
    }


}
