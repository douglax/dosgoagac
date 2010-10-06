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
public class MonthNode extends AbstractNode{
    
    public MonthNode(String mes){
        super(Children.LEAF);
        setDisplayName(mes);
        setIconBaseWithExtension("com/agac/gui/resourses/folder.png");
    }

}
