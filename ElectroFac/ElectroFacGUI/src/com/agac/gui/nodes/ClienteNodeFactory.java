package com.agac.gui.nodes;

import com.agac.bo.Receptor;
import com.agac.services.DbServices;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Carlos Aguirre
 */
public class ClienteNodeFactory extends ChildFactory<Receptor> {

    @Override
    protected boolean createKeys(List<Receptor> list) {
        List<Receptor> l = DbServices.getList("Select r from Receptor r");
        for (Receptor r : l) {
            list.add(r);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(Receptor t) {
        AbstractNode n = new AbstractNode(Children.LEAF, Lookups.singleton(t));
        n.setDisplayName(t.getNombre());
        n.setIconBaseWithExtension("com/agac/gui/resourses/user_suit.png");
        return n;
    }
}
