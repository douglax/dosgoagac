/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.nodes;

import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

/**
 *
 * @author Carlos
 */
public class MonthNodeFactory extends ChildFactory<String>{

    @Override
    protected boolean createKeys(List<String> list) {
        list.add("Enero");
        list.add("Febrero");
        list.add("Marzo");
        list.add("Abril");
        list.add("Mayo");
        return true;
    }

    @Override
    protected Node createNodeForKey(String key) {
        return new MonthNode(key);
    }

}
