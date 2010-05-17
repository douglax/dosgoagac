/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui.nodes;

import com.agac.bo.Receptor;
import com.agac.gui.ReceptorTopComponent;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
 * @author Carlos Aguirre
 */
public class ClienteNode extends AbstractNode {

    public ClienteNode(Receptor r) {
        super(Children.LEAF, Lookups.singleton(r));
        setDisplayName(r.getNombre());
        setIconBaseWithExtension("com/agac/gui/resourses/user_suit.png");
    }



        @Override
    protected Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        Sheet.Set ubicacion = Sheet.createPropertiesSet();

        Receptor r = getLookup().lookup(Receptor.class);
        try {
            Property nombre = new PropertySupport.Reflection<String>(r, String.class, "getNombre", null);
            Property rfc = new PropertySupport.Reflection<String>(r, String.class, "getRfc", null);
            nombre.setName("nombre");
            nombre.setDisplayName("Nombre");
            rfc.setName("rfc");
            rfc.setDisplayName("R.F.C.");

            Property calle = new PropertySupport.Reflection<String>(r.getDomicilio(), String.class,
                    "getCalle", null);
            calle.setName("calle");
            calle.setDisplayName("Calle");

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
            set.setDisplayName("Datos del Cliente");

            ubicacion.put(calle);
            ubicacion.put(noExt);
            ubicacion.put(noInt);
            ubicacion.put(localidad);
            ubicacion.put(municipio);
            ubicacion.put(estado);
            ubicacion.put(pais);

            ubicacion.setName("Ubicacion");
            ubicacion.setDisplayName("Ubicación");


        } catch (NoSuchMethodException ex) {
            ErrorManager.getDefault();
        }
        sheet.put(set);
        sheet.put(ubicacion);
        return sheet;
    }





    @Override
    public Transferable drag() throws IOException {
        return new TransferNode();
    }

    @Override
    public Action getPreferredAction() {
        return new OpenAction();
    }

    @Override
    public Action[] getActions(boolean bln) {
        return new Action[]{new OpenAction()};
    }

    private class OpenAction extends AbstractAction {

        public OpenAction() {
            putValue(NAME, "Abrir Cliente");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ReceptorTopComponent ctc = new ReceptorTopComponent();
            ctc.setReceptor(getLookup().lookup(Receptor.class));
            ctc.open();
            ctc.requestActive();
        }
    }
    public static final DataFlavor DATA_FLAVOR = new DataFlavor(Receptor.class, "receptor");

    private class TransferNode implements Transferable {

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{DATA_FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor == DATA_FLAVOR;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if (flavor == DATA_FLAVOR) {
                return ClienteNode.this.getLookup().lookup(Receptor.class);
            } else {
                return null;
            }
        }
    }
}
