/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;


import com.app.api.Entitas.Kelas;
import com.app.api.Exception.KelasException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author saddam
 */
public class cboKelasModel extends AbstractListModel implements ComboBoxModel{
    private String[] namaKelas = new String[100];
    private String selection = null;

    public cboKelasModel() {
        namaKelas = getAllNamaKelas();
    }
    
    
    
    @Override
    public int getSize() {
        return namaKelas.length;
    }

    @Override
    public Object getElementAt(int index) {
        return namaKelas[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }
    
    public String[] getAllNamaKelas(){
        KelasModel model = new KelasModel();
        model.setHost("localhost");
        model.setPort(4444);
        
        String[] namaKelas = new String[100];
        try {
            namaKelas = model.getAllNamaKelas();
        } catch (RemoteException ex) {
            Logger.getLogger(cboKelasModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(cboKelasModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KelasException ex) {
            Logger.getLogger(cboKelasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return namaKelas;
    }
}
