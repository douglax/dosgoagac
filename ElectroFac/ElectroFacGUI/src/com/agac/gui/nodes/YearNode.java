/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.nodes;

import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

/**
 *
 * @author Carlos
 */
public class YearNode extends AbstractNode{  

    public YearNode(String mes) {
        super(Children.create(new MonthNodeFactory(), true));
        setDisplayName(mes);
        setIconBaseWithExtension("com/agac/gui/resourses/folder_database.png");
    }

}
