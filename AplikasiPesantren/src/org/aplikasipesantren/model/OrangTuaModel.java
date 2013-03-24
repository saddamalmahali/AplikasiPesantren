/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.aplikasipesantren.entiti.OrangTua;
import org.aplikasipesantren.entiti.Santri;
import org.aplikasipesantren.koneksi.Koneksi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author saddam
 */
public class OrangTuaModel {
    private int idOrangTua;
    private String namaDepan;
    private String namaBelakang;
    private boolean almarhum;
    private String tempatLahir;
    private Date tanggalLahir;
    private String alamat;
    private String pekerjaan;
    private String noTelp;
    private List<Santri> listSantri;
    private SessionFactory factory;
    private Session session;

    public OrangTuaModel() {
        factory = Koneksi.getSessionFactory();
        session =  factory.openSession();
    }
    
    
    
    public int getIdOrangTua() {
        return idOrangTua;
    }

    public void setIdOrangTua(int idOrangTua) {
        this.idOrangTua = idOrangTua;
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

    public List<Santri> getListSantri() {
        return listSantri;
    }

    public void setListSantri(List<Santri> listSantri) {
        this.listSantri = listSantri;
    }
    
    public void insertOrangTua(){
        OrangTua ortu = new OrangTua();
        ortu.setId(idOrangTua);
        ortu.setNama_depan(namaDepan);
        ortu.setNama_belakang(namaBelakang);
        ortu.setAlm(almarhum);
        ortu.setTempat_lahir(tempatLahir);
        ortu.setTanggal_lahir(tanggalLahir);
        ortu.setAlamat(alamat);
        ortu.setPekerjaan(pekerjaan);
        ortu.setNoTelp(noTelp);
        
        session.beginTransaction();
        session.save(ortu);
        session.getTransaction().commit();
    }
    
    public void updateOrangTua(){
        OrangTua ortu = new OrangTua();
        ortu.setId(idOrangTua);
        ortu.setNama_depan(namaDepan);
        ortu.setNama_belakang(namaBelakang);
        ortu.setAlm(almarhum);
        ortu.setTempat_lahir(tempatLahir);
        ortu.setTanggal_lahir(tanggalLahir);
        ortu.setAlamat(alamat);
        ortu.setPekerjaan(pekerjaan);
        ortu.setNoTelp(noTelp);
        
        session.beginTransaction();
        session.update(ortu);
        session.getTransaction().commit();
    }
    
    public void deleteOrangTua(){
        OrangTua ortu = new OrangTua();
        ortu.setId(idOrangTua);
        ortu.setNama_depan(namaDepan);
        ortu.setNama_belakang(namaBelakang);
        ortu.setAlm(almarhum);
        ortu.setTempat_lahir(tempatLahir);
        ortu.setTanggal_lahir(tanggalLahir);
        ortu.setAlamat(alamat);
        ortu.setPekerjaan(pekerjaan);
        ortu.setNoTelp(noTelp);
        
        session.beginTransaction();
        session.delete(ortu);
        session.getTransaction().commit();
    }
    
    public List<OrangTua> getListOrangTua(){
        List<OrangTua> listOrangTua = new ArrayList<>();
        session.beginTransaction();
        listOrangTua = session.createQuery(" from OrangTua").list();
        session.getTransaction().commit();
        
        return listOrangTua;
    }
}
