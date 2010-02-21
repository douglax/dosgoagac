/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui.actions;

import com.agac.gui.ReceptorTopComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class NuevoCliente implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ReceptorTopComponent ctc = new ReceptorTopComponent();
        ctc.setDisplayName("Nuevo Cliente");
        ctc.open();
        ctc.requestActive();

    }


}
