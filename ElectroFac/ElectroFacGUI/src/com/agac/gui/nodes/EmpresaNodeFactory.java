

package com.agac.gui.nodes;

import com.agac.bo.Emisor;
import com.agac.services.DbServices;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

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
        return new EmpresaNode(t);
    }

}
