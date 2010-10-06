/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.nodes;

import com.agac.bo.Emisor;
import com.agac.services.DbServices;
import java.util.Iterator;
import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

/**
 *
 * @author Carlos
 */
public class YearNodeFactory extends ChildFactory<String>{

    Emisor emisor;

    public YearNodeFactory(Emisor e) {
        emisor = e;
    }
    
    @Override
    protected boolean createKeys(List<String> list) {
        List lista = DbServices.getNativeQueryResult(
                "select distinct year(fecha) from comprobante where emisor_id = 53");
        for(Iterator i = lista.iterator(); i.hasNext();){
            list.add(i.next().toString());
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(String key) {
        return new YearNode(key);
    }
}
