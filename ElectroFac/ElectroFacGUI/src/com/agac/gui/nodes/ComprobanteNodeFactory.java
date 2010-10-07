package com.agac.gui.nodes;

import com.agac.bo.Comprobante;
import com.agac.bo.Emisor;
import com.agac.services.DbServices;
import java.util.List;
import java.util.Vector;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

/**
 *
 * @author Carlos Aguirre
 */
public class ComprobanteNodeFactory extends ChildFactory<Comprobante> {

    private Emisor emisor;
    private Integer year;
    private Integer month;

    public ComprobanteNodeFactory(Integer year, Integer month, Emisor e) {
        emisor = e;
        this.year = year;
        this.month = month;
    }

    @Override
    protected boolean createKeys(List<Comprobante> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("Select ID from comprobante where emisor_id = ").append(emisor.getId()).append(
                " and year(fecha) = ").append(year).append(" and month(fecha) = ").append(month);
        List<Vector> l = DbServices.getNativeQueryResult(sb.toString());
        for (Vector v : l) {
            Long id = (Long)v.get(0);
            Comprobante c = DbServices.find(Comprobante.class, id);
            list.add(c);
        }
        return true;
    }

    @Override
    protected Node createNodeForKey(Comprobante t) {
        return new ComprobanteNode(t);
    }
}
