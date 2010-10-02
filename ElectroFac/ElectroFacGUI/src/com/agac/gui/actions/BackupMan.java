/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agac.gui.actions;

import com.agac.bo.Licencia;
import com.agac.gui.BackupPanel;
import com.agac.gui.LicenciasPanel;
import com.agac.services.DbServices;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;


/**
 *
 * @author alex
 */
public class BackupMan implements ActionListener{

        @Override
    public void actionPerformed(ActionEvent e) {



        BackupPanel bac = new BackupPanel();
            //LicenciasPanel lic = new LicenciasPanel();
        DialogDescriptor d2 = new DialogDescriptor(bac, "Respaldo / Recuperación de la Base de Datos", true, null);

        Object result = DialogDisplayer.getDefault().notify(d2);

        if (DialogDescriptor.OK_OPTION.equals(result)) {



        }//if


    }


}
