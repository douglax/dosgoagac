/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.actions;

import com.agac.bo.Licencia;
import com.agac.gui.LicenciasPanel;
import com.agac.services.DbServices;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;

/**
 *
 * @author alejandro.acosta
 */
public class LicenseMan implements ActionListener {

    Licencia licencia = new Licencia();
    @Override
    public void actionPerformed(ActionEvent e) {


        
        LicenciasPanel lic = new LicenciasPanel();
        DialogDescriptor d2 = new DialogDescriptor(lic, "Información sobre Licencias", true, null);

        Object result = DialogDisplayer.getDefault().notify(d2);

        if (DialogDescriptor.OK_OPTION.equals(result)) {

            licencia = lic.getLicencia();

            try {
            DbServices.saveObject(licencia, true);
            } catch (Exception s) {

            }


        }//if
        

    }

}
