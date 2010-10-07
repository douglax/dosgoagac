/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.nodes;

import com.agac.bo.Emisor;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author Carlos
 */
public class MonthNode extends AbstractNode{

    private final String[] MESES = {"dummy",
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre"
    };
    
    public MonthNode(int year, int mes, Emisor e){
        super(Children.create(new ComprobanteNodeFactory(year, mes, e), true));
        setDisplayName(MESES[mes]);
        setIconBaseWithExtension("com/agac/gui/resourses/folder.png");
    }

}
