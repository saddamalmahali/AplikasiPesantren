/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.aplikasipesantren.entiti.Kamar;
import org.aplikasipesantren.entiti.Kelas;
import org.aplikasipesantren.entiti.OrangTua;
import org.aplikasipesantren.entiti.Santri;
import org.aplikasipesantren.koneksi.Koneksi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author saddam
 */
public class SantriModel {
    private int id;
    private String namaDepan;
    private String namaBelakang;
    private boolean jenisKelamin;
    private String tempatLahir;
    private Date tanggalLahir;
    private String alamat;
    private String asalSekolah;
    private String email;
    private byte[] foto;
    private String lulusanTrk;
    private String noHp;
    private String noTelp;
    private Kelas idKelas;
    private OrangTua idOrangTua;
    private Kamar idKamar;
    
    private SessionFactory factory;
    private Session session;

    public SantriModel() {
        factory = Koneksi.getSessionFactory();
        session = factory.openSession();
    }

    public int getId() {
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

    public boolean isJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
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

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getLulusanTrk() {
        return lulusanTrk;
    }

    public void setLulusanTrk(String lulusanTrk) {
        this.lulusanTrk = lulusanTrk;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public Kelas getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Kelas idKelas) {
        this.idKelas = idKelas;
    }

    public OrangTua getIdOrangTua() {
        return idOrangTua;
    }

    public void setIdOrangTua(OrangTua idOrangTua) {
        this.idOrangTua = idOrangTua;
    }

    public Kamar getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(Kamar idKamar) {
        this.idKamar = idKamar;
    }
    
    public void insertSantri(){
        Santri santri = new Santri();
        
        santri.setId(id);
        santri.setNamaDepan(namaDepan);
        santri.setNamaBelakang(namaBelakang);
        santri.setJenisKelamin(jenisKelamin);
        santri.setTempatLahir(tempatLahir);
        santri.setTanggalLahir(tanggalLahir);
        santri.setAlamat(alamat);
        santri.setNoHp(noHp);
        santri.setNoTelp(noTelp);
        santri.setEmail(email);
        santri.setFoto(foto);
        santri.setLulusanTrk(lulusanTrk);
        santri.setAsalSekolah(asalSekolah);
        santri.setIdKelas(idKelas);
        santri.setIdOrangTua(idOrangTua);
        santri.setKamar(idKamar);
        
        session.beginTransaction();
        session.save(santri);
        session.getTransaction().commit();
    }
    
    public void updateSantri(){
        Santri santri = new Santri();
        
        santri.setId(id);
        santri.setNamaDepan(namaDepan);
        santri.setNamaBelakang(namaBelakang);
        santri.setJenisKelamin(jenisKelamin);
        santri.setTempatLahir(tempatLahir);
        santri.setTanggalLahir(tanggalLahir);
        santri.setAlamat(alamat);
        santri.setNoHp(noHp);
        santri.setNoTelp(noTelp);
        santri.setEmail(email);
        santri.setFoto(foto);
        santri.setLulusanTrk(lulusanTrk);
        santri.setAsalSekolah(asalSekolah);
        santri.setIdKelas(idKelas);
        santri.setIdOrangTua(idOrangTua);
        santri.setKamar(idKamar);
        
        session.beginTransaction();
        session.update(santri);
        session.getTransaction().commit();
    }
    
    public void deleteSantri(){
        Santri santri = new Santri();
        
        santri.setId(id);
        santri.setNamaDepan(namaDepan);
        santri.setNamaBelakang(namaBelakang);
        santri.setJenisKelamin(jenisKelamin);
        santri.setTempatLahir(tempatLahir);
        santri.setTanggalLahir(tanggalLahir);
        santri.setAlamat(alamat);
        santri.setNoHp(noHp);
        santri.setNoTelp(noTelp);
        santri.setEmail(email);
        santri.setFoto(foto);
        santri.setLulusanTrk(lulusanTrk);
        santri.setAsalSekolah(asalSekolah);
        santri.setIdKelas(idKelas);
        santri.setIdOrangTua(idOrangTua);
        santri.setKamar(idKamar);
        
        session.beginTransaction();
        session.delete(santri);
        session.getTransaction().commit();
    }
    
    public List<Santri> getListSantri(){
        List<Santri> listSantri = new ArrayList<>();
        session.beginTransaction();
        listSantri = session.createQuery(" from Santri").list();
        session.getTransaction().commit();
        
        return listSantri;
    }
    
}
