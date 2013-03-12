/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Santri;
import com.app.api.Exception.SantriException;
import com.app.api.services.SantriDao;
import com.app.koneksi.KlienKoneksi;
import com.app.model.listener.SantriListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author saddam
 */
public class SantriModel {
    private int id;
    private int idKelas;
    private String namaDepan;
    private String namaBelakang;
    private boolean jeniskelamin;
    private String tempatLahir;
    private Date tanggalLahir;
    private String alamat;
    private int idOrangTua;
    private String noTelp;
    private String noHp;
    private String email;
    private int idKamar;
    private String asalSekolah;
    private String lulusanTerakhir;
    private Blob foto;
    private SantriDao dao;
    private KlienKoneksi koneksi;
    private String host;
    private int port;
    private SantriListener listener;

    public SantriModel() {
        koneksi = new KlienKoneksi();
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
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

    public boolean isJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(boolean jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
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

    public int getIdOrangTua() {
        return idOrangTua;
    }

    public void setIdOrangTua(int idOrangTua) {
        this.idOrangTua = idOrangTua;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public String getLulusanTerakhir() {
        return lulusanTerakhir;
    }

    public void setLulusanTerakhir(String lulusanTerakhir) {
        this.lulusanTerakhir = lulusanTerakhir;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public SantriDao getDao() {
        return dao;
    }

    public void setDao(SantriDao dao) {
        this.dao = dao;
    }

    public KlienKoneksi getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(KlienKoneksi koneksi) {
        this.koneksi = koneksi;
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

    public SantriListener getListener() {
        return listener;
    }

    public void setListener(SantriListener listener) {
        this.listener = listener;
    }
    
    
    
    public void insertSantri() throws RemoteException, NotBoundException, SantriException{
        dao = (SantriDao) koneksi.getKoneksi(host, port).lookup("santri");
        Santri santri = new Santri();
        santri.setId(id);
        santri.setIdKelas(idKelas);
        santri.setNamaDepan(namaDepan);
        santri.setNamaBelakang(namaBelakang);
        santri.setJenisKelamin(jeniskelamin);
        santri.setTempatLahir(tempatLahir);
        santri.setTanggalLahir(tanggalLahir);
        santri.setAlamat(alamat);
        santri.setIdOrangTua(idOrangTua);
        santri.setNoTelp(noTelp);
        santri.setNoHp(noHp);
        santri.setEmail(email);
        santri.setIdKamar(idKamar);
        santri.setAsalSekolah(asalSekolah);
        santri.setLulusanTerakhir(lulusanTerakhir);
        santri.setFoto(foto);
        dao.insertSantri(santri);
        
        System.out.println("Santri Berhasil ditambahkan...");
    }
    
    public void updateSantri() throws RemoteException, NotBoundException, SantriException{
        dao = (SantriDao) koneksi.getKoneksi(host, port).lookup("santri");
        Santri santri = new Santri();
        santri.setId(id);
        santri.setIdKelas(idKelas);
        santri.setNamaDepan(namaDepan);
        santri.setNamaBelakang(namaBelakang);
        santri.setJenisKelamin(jeniskelamin);
        santri.setTempatLahir(tempatLahir);
        santri.setTanggalLahir(tanggalLahir);
        santri.setAlamat(alamat);
        santri.setIdOrangTua(idOrangTua);
        santri.setNoTelp(noTelp);
        santri.setNoHp(noHp);
        santri.setEmail(email);
        santri.setIdKamar(idKamar);
        santri.setAsalSekolah(asalSekolah);
        santri.setLulusanTerakhir(lulusanTerakhir);
        santri.setFoto(foto);
        dao.updateSantri(id, santri);
        System.out.println("Santri berhasil diupdate..");
        
    }
    
    public void deleteSantri() throws RemoteException, NotBoundException, SantriException{
        dao = (SantriDao) koneksi.getKoneksi(host, port).lookup("santri");
        
        dao.deleteSantri(id);
        System.out.println("Santri berhasil didelete...");
    }
    
    public List<Santri> getAllSantri() throws RemoteException, NotBoundException, SantriException{
        dao = (SantriDao) koneksi.getKoneksi(host, port).lookup("santri");
        List<Santri> listSantri = new ArrayList<>();
        listSantri = dao.getAllSantri();
        
        return listSantri;
    }
    
}
