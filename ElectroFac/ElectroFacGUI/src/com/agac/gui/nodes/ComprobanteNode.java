package com.agac.gui.nodes;

import com.agac.bo.Comprobante;
import com.agac.bo.Receptor;
import com.agac.gui.ComprobanteTopComponent;
import com.agac.gui.MenuTopComponent;
import com.agac.services.DbServices;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.util.prefs.Preferences;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.openide.DialogDisplayer;
import org.openide.ErrorManager;
import org.openide.NotifyDescriptor;
import org.openide.NotifyDescriptor.Confirmation;
import org.openide.NotifyDescriptor.Message;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;
import org.openide.util.Utilities;
import org.openide.util.lookup.Lookups;
import org.openide.windows.WindowManager;

/**
 *
 * @author Carlos Aguirre
 */
public class ComprobanteNode extends AbstractNode {

    public ComprobanteNode(Comprobante c) {
        super(Children.LEAF, Lookups.singleton(c));


        setDisplayName(c.getAnoAprobacion() + c.getSerie() + c.getFolio());
        setIconBaseWithExtension("com/agac/gui/resourses/Comprobante24.png");
    }

    @Override
    public Action[] getActions(boolean bln) {
        return new Action[]{
                    new OpenAction(),
                    new CancelFolio(),
                    null,
                    new GenerarXML()
                };
    }

    @Override
    public String getHtmlDisplayName() {

        //When painting, the Explorer component showing the nodes calls getHtmlDisplayName() first.
        //If it gets a non-null value back, then it will use the HTML string it received and a fast,
        //lightweight HTML renderer to render it. If it is null, then it will fall back to
        //whatever is returned by getDisplayName().

        Comprobante c = getLookup().lookup(Comprobante.class);
        if (c != null && c.getStatus() == 0) {
            // comprobante cancelado aparece en gris
            return "<font color='666666'>" + c.getAnoAprobacion() + c.getSerie() + c.getFolio() + "</font>";
        } else {
            //return null;
            return "<strong>" + c.getAnoAprobacion() + c.getSerie() + c.getFolio() + "</strong>";
        }
    }

    @Override
    protected Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        Sheet.Set receptor = Sheet.createPropertiesSet();

        Comprobante c = getLookup().lookup(Comprobante.class);
        Receptor r = c.getReceptor();

        try {

            Property folio = new PropertySupport.Reflection(c, Integer.class, "getFolio", null);
            Property serie = new PropertySupport.Reflection<String>(c, String.class, "getSerie", null);
            Property fecha = new PropertySupport.Reflection(c, java.sql.Date.class, "getFecha", null);
            Property total = new PropertySupport.Reflection(c, java.math.BigDecimal.class, "getTotal", null);
            Property metodo = new PropertySupport.Reflection<String>(c, String.class, "getMetodoDePago", null);
            Property condiciones = new PropertySupport.Reflection<String>(c, String.class, "getCondicionesDePago", null);


            folio.setName("folio");
            folio.setDisplayName("Folio");
            serie.setName("serie");
            serie.setDisplayName("Serie");
            fecha.setName("fecha");
            fecha.setDisplayName("Fecha de emisión");
            total.setName("total");
            total.setDisplayName("Total");
            metodo.setName("metodoDePago");
            metodo.setDisplayName("Método de Pago");
            condiciones.setName("condicionesDePago");
            condiciones.setDisplayName("Condiciones de Pago");


            set.put(folio);
            set.put(serie);
            set.put(fecha);
            set.put(total);
            set.put(metodo);
            set.put(condiciones);
            set.setName("Datos");
            set.setDisplayName("Datos del Comprobante");


            Property nombre = new PropertySupport.Reflection<String>(r, String.class,
                    "getNombre", null);
            Property rfc = new PropertySupport.Reflection<String>(r, String.class,
                    "getRfc", null);
            Property calle = new PropertySupport.Reflection<String>(r.getDomicilio(), String.class,
                    "getCalle", null);
            Property noExt = new PropertySupport.Reflection<String>(r.getDomicilio(), String.class,
                    "getNoExterior", null);
            Property noInt = new PropertySupport.Reflection<String>(r.getDomicilio(), String.class,
                    "getNoInterior", null);
            Property localidad = new PropertySupport.Reflection<String>(r.getDomicilio(), String.class,
                    "getLocalidad", null);
            Property municipio = new PropertySupport.Reflection<String>(r.getDomicilio(), String.class,
                    "getMunicipio", null);
            Property estado = new PropertySupport.Reflection<String>(r.getDomicilio(), String.class,
                    "getEstado", null);
            Property pais = new PropertySupport.Reflection<String>(r.getDomicilio(), String.class,
                    "getPais", null);

            nombre.setName("nombre");
            nombre.setDisplayName("Nombre del Cliente");
            rfc.setName("rfc");
            rfc.setDisplayName("R.F.C.");
            calle.setName("calle");
            calle.setDisplayName("Calle");
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
            receptor.put(nombre);
            receptor.put(rfc);
            receptor.put(calle);
            receptor.put(noExt);
            receptor.put(noInt);
            receptor.put(localidad);
            receptor.put(municipio);
            receptor.put(estado);
            receptor.put(pais);
            receptor.setName("Receptor");
            receptor.setDisplayName("Datos del Cliente");

        } catch (NoSuchMethodException ex) {
            ErrorManager.getDefault();
        }
        sheet.put(set);
        sheet.put(receptor);
        return sheet;
    }

    @Override
    public Action getPreferredAction() {
        return new OpenAction();
    }

    private class OpenAction extends AbstractAction {

        public OpenAction() {
            putValue(NAME, "Abrir Comprobante");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            final MenuTopComponent frm =
                    (MenuTopComponent) WindowManager.getDefault().findTopComponent("MenuTopComponent");
            try {
                frm.getBeanTreeView1().setCursor(Utilities.createProgressCursor(frm));
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        Comprobante c = getLookup().lookup(Comprobante.class);
                        ComprobanteTopComponent ctc = new ComprobanteTopComponent();
                        ctc.setIsNew(false);
                        ctc.setComprobante(c);
                        ctc.setDisplayName(c.getAnoAprobacion() + c.getSerie() + c.getFolio());
                        ctc.componentOpened();
                        ctc.open();
                        ctc.requestActive();
                        ctc.enablePrint();
                        frm.getBeanTreeView1().setCursor(null);
                    }
                });
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    //
    private class CancelFolio extends AbstractAction {

        public CancelFolio() {
            putValue(NAME, "Cancelar Folio");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Comprobante comprobante = getLookup().lookup(Comprobante.class);
            Confirmation msg = new NotifyDescriptor.Confirmation(
                    "El cambio que está a punto de efectuar es irreversible \nEstá seguro de cancelar el folio?", "Confirmar cancelación",
                    NotifyDescriptor.OK_CANCEL_OPTION,
                    NotifyDescriptor.QUESTION_MESSAGE);
            Object result = DialogDisplayer.getDefault().notify(msg);
            if (NotifyDescriptor.YES_OPTION.equals(result)) {
                //Cancelar folio
                try {
                    comprobante.setStatus(0);
                    comprobante = DbServices.saveObject(comprobante, true);
                } catch (Exception ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    } //class CancelFolio

    private class GenerarXML extends AbstractAction {

        public GenerarXML() {
            putValue(NAME, "Generar Archivo XML ...");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Comprobante c = (Comprobante) getLookup().lookup(Comprobante.class);

                JAXBContext ctx = JAXBContext.newInstance(Comprobante.class);
                Marshaller m = ctx.createMarshaller();
                m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


                // Preferences pref = NbPreferences.forModule(OpcionesdelSistemaPanel.class);

                //            String ruta = pref.get("COMPROBANTE","DEFAULT" );

                String filename;
                String ruta = NbPreferences.forModule(ComprobanteNode.class).get("COMPROBANTE", "");

                if (!ruta.equals("")) {
                    filename = ruta + "/" + c.getEmisor().getRfc() + c.getSerie() + c.getFolio() + ".xml";
                } else {

                    Message msg = new NotifyDescriptor.Message(
                            "No existe ruta predeterminada para guardar comprobantes\nregistrada en las opciones del sistema."
                            + "\n\nLe sugerimos ingresar la ruta para mayor comodidad en el futuro.",
                            NotifyDescriptor.INFORMATION_MESSAGE);
                    DialogDisplayer.getDefault().notify(msg);

                    final JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fc.showOpenDialog(null);
                    filename = fc.getSelectedFile().toString() + "/" + c.getEmisor().getRfc() + c.getSerie() + c.getFolio() + ".xml";

                }

                /*FileWriter writer = new FileWriter(
                NbPreferences.forModule(ComprobanteNode.class).get("COMPROBANTE", "")
                + "/" + c.getEmisor().getRfc() + c.getSerie() + c.getFolio() + ".xml");
                 */
                FileWriter writer = new FileWriter(filename);
                m.marshal((Comprobante) getLookup().lookup(Comprobante.class), writer);
                writer.flush();
                writer.close();
                DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(
                        "Archivo generado con exito"));
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
}
