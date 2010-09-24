/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.actions;

import com.agac.gui.LicenciasPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;

/**
 *
 * @author alejandro.acosta
 */
public class LicenseMan implements ActionListener {

    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        LicenciasPanel lic = new LicenciasPanel();
        DialogDescriptor d2 = new DialogDescriptor(lic, "Información sobre Licencias", true, null);

        Object result = DialogDisplayer.getDefault().notify(d2);

        if (DialogDescriptor.OK_OPTION.equals(result)) {
          
        }


    }

}
