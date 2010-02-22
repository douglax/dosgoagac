/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.nodes;

import com.agac.bo.Receptor;
import com.agac.gui.ReceptorTopComponent;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Carlos
 */
public class ClienteNode extends AbstractNode{

    public ClienteNode(Receptor r) {
        super(Children.LEAF, Lookups.singleton(r));
        setDisplayName(r.getNombre());
        setIconBaseWithExtension("com/agac/gui/resourses/user_suit.png");
    }

    @Override
    public Action getPreferredAction() {
        return new OpenAction();
    }

    @Override
    public Action[] getActions(boolean bln) {
        return new Action[]{new OpenAction()};
    }

    private class OpenAction extends AbstractAction{

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
    

}
