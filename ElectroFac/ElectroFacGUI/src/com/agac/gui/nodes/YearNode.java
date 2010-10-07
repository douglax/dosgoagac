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
public class YearNode extends AbstractNode{  

    public YearNode(Integer year, Emisor e) {
        super(Children.create(new MonthNodeFactory(year,e), true));
        setDisplayName(year.toString());
        setIconBaseWithExtension("com/agac/gui/resourses/folder_database.png");
    }

}
