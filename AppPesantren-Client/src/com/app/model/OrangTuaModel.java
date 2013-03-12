/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.OrangTua;
import com.app.api.Exception.OrangTuaException;
import com.app.api.services.OrangTuaDao;
import com.app.koneksi.KlienKoneksi;
import com.app.model.listener.OrangTuaListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author saddam
 */
public class OrangTuaModel {
    private int id;
    private String namaDepan;
    private String namaBelakang;
    private boolean almarhum;
    private String tempatLahir;
    private Date tanggalLahir;
    private String alamat;
    private String pekerjaan;
    private String noTelp;
    private KlienKoneksi koneksi;
    private OrangTuaDao dao;
    private OrangTuaListener listener;
    private String host;
    private int port;
            
    public int getId(String namaDepan, String namaBelakang) throws RemoteException, NotBoundException, OrangTuaException {
        dao = (OrangTuaDao) koneksi.getKoneksi(host, port).lookup("orangtua");
        
        int id = dao.getIdOrangTua(namaDepan, namaBelakang);     
        
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public boolean isAlmarhum() {
        return almarhum;
    }

    public void setAlmarhum(boolean almarhum) {
        this.almarhum = almarhum;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
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

    public void setKoneksi(KlienKoneksi koneksi) {
        this.koneksi = koneksi;
    }

    public void setDao(OrangTuaDao dao) {
        this.dao = dao;
    }

    public void setListener(OrangTuaListener listener) {
        this.listener = listener;
    }
    
    
    public void insertOrangTua() throws RemoteException, NotBoundException, OrangTuaException{
        dao = (OrangTuaDao) koneksi.getKoneksi(host, port).lookup("orangtua");
        OrangTua orangTua = new OrangTua();
        
        orangTua.setId(id);
        orangTua.setNamaDepan(namaDepan);
        orangTua.setNamaBelakang(namaBelakang);
        orangTua.setAlm(almarhum);
        orangTua.setTempatLahir(tempatLahir);
        orangTua.setTanggalLahir(tanggalLahir);
        orangTua.setAlamat(alamat);
        orangTua.setPekerjaan(pekerjaan);
        orangTua.setNoTelp(noTelp);
        dao.insertOrangTua(orangTua);
        System.out.println("Orang Tua Berhasil ditambahkan...");
    }
    
    public void updateOrangTua()throws RemoteException, NotBoundException, OrangTuaException{
        dao = (OrangTuaDao) koneksi.getKoneksi(host, port).lookup("orangtua");
        OrangTua orangTua = new OrangTua();
        
        int id = getId(namaDepan, namaBelakang);
        orangTua.setNamaDepan(namaDepan);
        orangTua.setNamaBelakang(namaBelakang);
        orangTua.setAlm(almarhum);
        orangTua.setTempatLahir(tempatLahir);
        orangTua.setTanggalLahir(tanggalLahir);
        orangTua.setAlamat(alamat);
        orangTua.setPekerjaan(pekerjaan);
        orangTua.setNoTelp(noTelp);
        dao.updateOrangTua(id, orangTua);
        System.out.println("Orang Tua berhasil diupdate...");
               
    }
    
    public void deleteOrangTua() throws RemoteException, NotBoundException, OrangTuaException{
        dao = (OrangTuaDao) koneksi.getKoneksi(host, port).lookup("orangtua");
        
        int id = getId(namaDepan, namaBelakang);
        dao.deleteOrangTua(id);
        System.out.println("Orang Tua berhasil di delete...");
    }
    
    public List<OrangTua> getAllOrangTua() throws RemoteException, NotBoundException, OrangTuaException{
        dao = (OrangTuaDao) koneksi.getKoneksi(host, port).lookup("orangtua");
        List<OrangTua> listOrangTua = new ArrayList<OrangTua>();
        listOrangTua = dao.getAllOrangTua();
        
        return listOrangTua;
    }
    
}
