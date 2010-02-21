/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.nodes;

import java.awt.Image;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.ImageUtilities;

/**
 *
 * @author PRISCILA
 */
public class ClienteRootNode extends AbstractNode{

    public ClienteRootNode() {
        super(Children.create(new ClienteNodeFactory(), true));
        setName("Clientes");
    }

    @Override
    public Image getIcon(int i) {
        return ImageUtilities.loadImage("com/agac/gui/resourses/database.png", true);
    }

    @Override
    public Image getOpenedIcon(int i) {
        return ImageUtilities.loadImage("com/agac/gui/resourses/database_go.png", true);
    }
}
