package com.agac.gui.nodes;

import com.agac.bo.Emisor;
import java.awt.Image;
import java.lang.reflect.InvocationTargetException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.ImageUtilities;

/**
 *
 * @author Carlos Aguirre 20 de Feb 2010
 */
public class EmpresaRootNode extends AbstractNode {

    public EmpresaRootNode() {
        super(Children.create(new EmpresaNodeFactory(), true));
        setName("Empresas Emisoras");
    }

    @Override
    public Image getIcon(int i) {
        return ImageUtilities.loadImage("com/agac/gui/resourses/database.png", true);
    }

    @Override
    public Image getOpenedIcon(int i) {
        return ImageUtilities.loadImage("com/agac/gui/resourses/database_go.png", true);
    }

    @Override
    protected Sheet createSheet() {
        Sheet s = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        final int num = getLookup().lookupResult(Emisor.class).allInstances().size();
        Property numClientes = new MyProp(num);
        numClientes.setName("Clientes");
        set.put(numClientes);
        s.put(set);
        return s;
    }

    private class MyProp extends PropertySupport.ReadOnly<Integer>{
        private int num;
        public MyProp(int num) {
            super("Clientes", Integer.class, "Numero de Emisoras","Numero de empresas emisoras registradas");
            this.num = num;
        }
        @Override
        public Integer getValue() throws IllegalAccessException, InvocationTargetException {
            return new Integer(num);
        }
    }



}
