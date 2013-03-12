/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.Entitas;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author saddam
 */
public class Santri implements Serializable{
    private int id;
    private int idKelas;
    private String namaDepan;
    private String namaBelakang;
    private boolean jenisKelamin;
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
    
    
}
