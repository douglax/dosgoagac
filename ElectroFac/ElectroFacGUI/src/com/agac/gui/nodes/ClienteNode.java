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
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
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
