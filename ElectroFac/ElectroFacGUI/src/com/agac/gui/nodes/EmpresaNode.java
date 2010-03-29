/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui.nodes;

import com.agac.bo.Emisor;
import com.agac.gui.ComprobanteTopComponent;
import com.agac.gui.EmisorTopComponent;
import com.agac.gui.MenuTopComponent;
import com.agac.gui.SerieTopComponent;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.ErrorManager;
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
        return new Action[]{new OpenAction(), new CrearFactura(), new adminFolios()};
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

            noExt.setName("noExterior");
            noExt.setDisplayName("Número Exterior");
            noInt.setName("noInterior");
            noInt.setDisplayName("Número Interior");

            set.put(nombre);
            set.put(rfc);
            set.setName("Datos");
            set.setDisplayName("Datos de la Empresa");

            dFiscal.put(calle);
            dFiscal.put(noExt);
            dFiscal.put(noInt);
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
            putValue(NAME, "Crear Factura");
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
                        ComprobanteTopComponent ctc = new ComprobanteTopComponent();
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

    private class adminFolios extends AbstractAction {

        public adminFolios() {
            putValue(NAME, "Expediente de Folios");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("oki");
            SerieTopComponent stc = new SerieTopComponent();
            stc.componentOpened();
            stc.getExpedienteFolios().setEmisor(getLookup().lookup(Emisor.class));
            stc.setDisplayName("Administración de Folios");
            stc.open();
            stc.requestActive();

        }
    }
}
