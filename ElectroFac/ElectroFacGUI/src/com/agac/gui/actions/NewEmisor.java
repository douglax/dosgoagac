/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agac.gui.actions;

import com.agac.gui.EmisorTopComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class NewEmisor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        EmisorTopComponent top = new EmisorTopComponent();
        top.open();
        top.requestActive();
    }
}
