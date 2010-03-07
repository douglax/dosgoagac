/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui;

import com.agac.gui.nodes.ClienteRootNode;
import com.agac.gui.nodes.EmpresaRootNode;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.ImageUtilities;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.agac.gui//Menu//EN",
autostore = false)
public final class MenuTopComponent extends TopComponent implements ExplorerManager.Provider{

    private static MenuTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "MenuTopComponent";

    public MenuTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(MenuTopComponent.class, "CTL_MenuTopComponent"));
        setToolTipText(NbBundle.getMessage(MenuTopComponent.class, "HINT_MenuTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        Children.Array arr = new Children.Array();
        arr.add(new Node[]{new EmpresaRootNode(), new ClienteRootNode()});
        AbstractNode an = new AbstractNode(arr);
        an.setDisplayName("Opciones del Sistema");
        an.setIconBaseWithExtension("com/agac/gui/resourses/sitemap_color.png");
        manager.setRootContext(an);
        
        associateLookup(ExplorerUtils.createLookup(manager, getActionMap()));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beanTreeView1 = new org.openide.explorer.view.BeanTreeView();

        setLayout(new java.awt.BorderLayout());

        beanTreeView1.setDefaultActionAllowed(true);
        add(beanTreeView1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openide.explorer.view.BeanTreeView beanTreeView1;
    // End of variables declaration//GEN-END:variables
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized MenuTopComponent getDefault() {
        if (instance == null) {
            instance = new MenuTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the MenuTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized MenuTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(MenuTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof MenuTopComponent) {
            return (MenuTopComponent) win;
        }
        Logger.getLogger(MenuTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }
    ExplorerManager manager = new ExplorerManager();

    @Override
    public ExplorerManager getExplorerManager() {
        return manager;
    }

    public void refreshNode(){
        Children.Array arr = new Children.Array();
        arr.add(new Node[]{new EmpresaRootNode(), new ClienteRootNode()});
        AbstractNode an = new AbstractNode(arr);
        an.setDisplayName("Opciones del Sistema");
        an.setIconBaseWithExtension("com/agac/gui/resourses/sitemap_color.png");
        manager.setRootContext(an);
        beanTreeView1.expandAll();
    }
}
