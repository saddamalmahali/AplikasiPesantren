/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.Entitas;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Saddam
 */
public class OrangTua implements Serializable{
    private int id;
    private String namaDepan;
    private String namaBelakang;
    private boolean alm;
    private String tempatLahir;
    private Date tanggalLahir;
    private String alamat;
    private String pekerjaan;
    private String noTelp;

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

    public boolean isAlm() {
        return alm;
    }

    public void setAlm(boolean alm) {
        this.alm = alm;
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
    
    
}
