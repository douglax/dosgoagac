package com.agac.gui.nodes;

import com.agac.bo.Comprobante;
import com.agac.bo.Emisor;
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
public class ComprobanteNodeFactory extends ChildFactory<Comprobante> {

    private Emisor emisor;

    public ComprobanteNodeFactory(Emisor e) {
        emisor = e;
    }

    @Override
    protected boolean createKeys(List<Comprobante> list) {
        List<Comprobante> l = DbServices.getListWithParameters(
                "Select c from Comprobante c where c.emisor = ?1", emisor);
        for (Comprobante e : l) {
            list.add(e);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(Comprobante t) {
        AbstractNode an = new AbstractNode(Children.LEAF, Lookups.singleton(t));
        an.setDisplayName(t.getSerie() + " - " + t.getFolio());
        an.setIconBaseWithExtension("com/agac/gui/resourses/Comprobante24.png");
        return an;
    }
}
