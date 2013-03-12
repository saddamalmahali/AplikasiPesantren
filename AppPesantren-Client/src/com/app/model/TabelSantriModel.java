/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Santri;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author saddam
 */
public class TabelSantriModel extends AbstractTableModel{
    private List<Santri> listSantri = new ArrayList<>();

    public void setListSantri(List<Santri> listSantri) {
        this.listSantri = listSantri;
    }
    
    
    
    @Override
    public int getRowCount() {
        return listSantri.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return listSantri.get(rowIndex).getId();
            case 1 : return listSantri.get(rowIndex).getNamaDepan();
            case 2 : return listSantri.get(rowIndex).getNamaBelakang();
            case 3 : return listSantri.get(rowIndex).isJenisKelamin();
            case 4 : return listSantri.get(rowIndex).getTempatLahir();
            case 5 : return listSantri.get(rowIndex).getTanggalLahir();
            case 6 : return listSantri.get(rowIndex).getAlamat();
            case 7 : return listSantri.get(rowIndex).getNoTelp();
            case 8 : return listSantri.get(rowIndex).getEmail();
            case 9 : return listSantri.get(rowIndex).getAsalSekolah();
            case 10 : return listSantri.get(rowIndex).getLulusanTerakhir();
            default : return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "ID";
            case 1 : return "Nama Depan";
            case 2 : return "Nama Belakang";
            case 3 : return "Jenis Kelamin";
            case 4 : return "Tempat Lahir";
            case 5 : return "Tanggal Lahir";
            case 6 : return "Alamat";
            case 7 : return "No Telepon";
            case 8 : return "Email";
            case 9 : return "Asal Sekolah";
            case 10 : return "Lulusan Terakhir";
            default : return null;
        }
    }

    public boolean add(Santri e) {
        try{
            return listSantri.add(e);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Santri get(int index) {
        return listSantri.get(index);
    }

    public Santri set(int index, Santri element) {
        try{
            return listSantri.set(index, element);
        }finally{
            fireTableRowsUpdated(index, index);
        }
    }

    public Santri remove(int index) {
        try{
            return listSantri.remove(index);
        }finally{
            fireTableRowsDeleted(index, index);
        }
    }
    
    
}
