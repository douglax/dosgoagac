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
public class MonthNodeFactory extends ChildFactory<Integer>{

    Integer year;
    Emisor emisor;

    public MonthNodeFactory(Integer year, Emisor emisor) {
        this.year = year;
        this.emisor = emisor;
    }

    @Override
    protected boolean createKeys(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("Select distinct month(fecha) from comprobante where emisor_id = ");
        sb.append(emisor.getId()).append(" and year(fecha) = ").append(year);

        List<Vector> lista = DbServices.getNativeQueryResult(sb.toString());

        for (Vector i : lista) {
            list.add((Integer)i.get(0));
        }

        return true;
    }

    @Override
    protected Node createNodeForKey(Integer key) {
        return new MonthNode(year, key, emisor);
    }

}
