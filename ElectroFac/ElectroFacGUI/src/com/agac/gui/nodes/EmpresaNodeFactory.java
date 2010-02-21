

package com.agac.gui.nodes;

import com.agac.bo.Emisor;
import com.agac.services.DbServices;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Carlos Aguirre
 */
public class EmpresaNodeFactory extends ChildFactory<Emisor>{

    @Override
    protected boolean createKeys(List<Emisor> list) {
        List<Emisor> l = DbServices.getList("Select e from Emisor e");
        for(Emisor e : l)
            list.add(e);
        return true;
    }

    @Override
    protected Node createNodeForKey(Emisor t) {
        try {
            AbstractNode n = new AbstractNode(Children.LEAF, Lookups.singleton(t));
            n.setDisplayName(t.getNombre());
            n.setIconBaseWithExtension("com/agac/gui/resourses/filenew.png");
            return n;
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

}
