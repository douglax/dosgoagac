/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.nodes;

import com.agac.bo.Emisor;
import com.agac.services.DbServices;
import java.util.List;
import java.util.Vector;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

/**
 *
 * @author Carlos
 */
public class YearNodeFactory extends ChildFactory<Integer>{

    Emisor emisor;

    public YearNodeFactory(Emisor e) {
        emisor = e;
    }
    
    @Override
    protected boolean createKeys(List<Integer> list) {
        List<Vector> lista = DbServices.getNativeQueryResult(
                "Select distinct year(fecha) from comprobante where emisor_id = " + emisor.getId().toString()
                + " order by year(fecha) desc");
        for(Vector i : lista){
            
            list.add((Integer)i.get(0));
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(Integer key) {
        return new YearNode(key, emisor);
    }
}
