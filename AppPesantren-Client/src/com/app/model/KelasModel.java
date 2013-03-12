/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Kelas;
import com.app.api.Exception.KelasException;
import com.app.api.services.KelasDao;
import com.app.koneksi.KlienKoneksi;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saddam
 */
public class KelasModel {
    private int id;
    private String namaKelas;
    private String host;
    private int port;
    private KelasDao dao;
    private KlienKoneksi koneksi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public KelasDao getDao() {
        return dao;
    }

    public void setDao(KelasDao dao) {
        this.dao = dao;
    }

    public KlienKoneksi getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(KlienKoneksi koneksi) {
        this.koneksi = koneksi;
    }
    
    public void insertKelas() throws RemoteException, KelasException, NotBoundException{
        dao = (KelasDao) koneksi.getKoneksi(host, port).lookup("kelas");
        
        Kelas kelas = new Kelas();
        kelas.setId(id);
        kelas.setNamaKelas(namaKelas);
        dao.insertKelas(kelas);
        System.out.println("Kelas berhasil ditambahkan....");
    }
    
    public void updateKelas() throws RemoteException, NotBoundException, KelasException{
        dao = (KelasDao) koneksi.getKoneksi(host, port).lookup("kelas");
        Kelas kelas = new Kelas();
        kelas.setId(id);
        kelas.setNamaKelas(namaKelas);
        dao.updateKelas(id, kelas);
        System.out.println("Kelas Berhasil Diupdate...");
    }
    
    public void deleteKelas() throws RemoteException, NotBoundException, KelasException{
        dao = (KelasDao) koneksi.getKoneksi(host, port).lookup("kelas");
        dao.deleteKelas(id);
        System.out.println("Kelas berhasil dihapus...");
    }
    
    public String[] getAllNamaKelas() throws RemoteException, NotBoundException, KelasException{
        dao = (KelasDao) koneksi.getKoneksi(host, port).lookup("kelas");
        String[] namaKelas = new String[100];
        List<Kelas> listKelas = new ArrayList<Kelas>();
        listKelas = dao.getAllKelas();
        for(int i=0; i<=listKelas.size(); i++){
            namaKelas[i] = listKelas.get(i).getNamaKelas();
        }
        
        return namaKelas;
    }
    
    public int getIdKelas(String namaKelas) throws RemoteException, NotBoundException, KelasException{
        dao = (KelasDao) koneksi.getKoneksi(host, port).lookup("kelas");
        int idKelas = 0;
        idKelas = dao.getIdKelas(namaKelas);
        return idKelas;
    }
}
