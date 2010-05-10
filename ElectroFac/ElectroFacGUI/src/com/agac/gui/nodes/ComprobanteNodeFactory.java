package com.agac.gui.nodes;

import com.agac.bo.Comprobante;
import com.agac.bo.Emisor;
import com.agac.services.DbServices;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

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
        return new ComprobanteNode(t);
    }
}
