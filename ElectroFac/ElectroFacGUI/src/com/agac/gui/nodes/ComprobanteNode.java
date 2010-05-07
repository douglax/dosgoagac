package com.agac.gui.nodes;

import com.agac.bo.Comprobante;
import com.agac.bo.Emisor;
import com.agac.gui.ComprobanteTopComponent;
import com.agac.gui.MenuTopComponent;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.Exceptions;
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
    public Action getPreferredAction() {
        return new OpenAction();
    }

    private class OpenAction extends AbstractAction {

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
}
