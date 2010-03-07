package com.agac.gui.nodes;

import com.agac.bo.Receptor;
import com.agac.services.DbServices;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

/**
 *
 * @author Carlos Aguirre
 */
public class ClienteNodeFactory extends ChildFactory<Receptor> {

    @Override
    protected boolean createKeys(List<Receptor> list) {
        List<Receptor> l = DbServices.getList("Select r from Receptor r order by r.nombre");
        for (Receptor r : l) {
            list.add(r);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(Receptor t) {
        return new ClienteNode(t);
    }
}
