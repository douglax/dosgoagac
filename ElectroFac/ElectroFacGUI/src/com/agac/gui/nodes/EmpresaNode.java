/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui.nodes;

import com.agac.bo.Emisor;
import com.agac.bo.UbicacionFiscal;
import com.agac.gui.EmisorTopComponent;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.ErrorManager;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Carlos
 */
public class EmpresaNode extends AbstractNode {

    public EmpresaNode(Emisor e) {
        super(Children.LEAF, Lookups.singleton(e));
        setDisplayName(e.getNombre());
        setIconBaseWithExtension("com/agac/gui/resourses/filenew.png");
    }

    @Override
    public Action[] getActions(boolean bln) {
        return new Action[]{new OpenAction()};
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
            noExt.setDisplayName("Número Exterioir");
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
}
