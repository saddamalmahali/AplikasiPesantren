/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.entiti;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author saddam
 */
@Entity
@Table(name = "orang_tua")
public class OrangTua implements Serializable{
    
    
    private int id;
    private String nama_depan;
    private String nama_belakang;
    private boolean alm;
    private String tempat_lahir;
    private Date tanggal_lahir;
    private String alamat;
    private String pekerjaan;
    private String noTelp;
    private List<Santri> listSantri;
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "nama_depan")
    public String getNama_depan() {
        return nama_depan;
    }

    public void setNama_depan(String nama_depan) {
        this.nama_depan = nama_depan;
    }
    @Column(name = "nama_belakang")
    public String getNama_belakang() {
        return nama_belakang;
    }

    public void setNama_belakang(String nama_belakang) {
        this.nama_belakang = nama_belakang;
    }
    @Basic
    @Column(name = "almarhum")
    public boolean isAlm() {
        return alm;
    }

    public void setAlm(boolean alm) {
        this.alm = alm;
    }
    @Column(name = "tempat_lahir")
    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_lahir")
    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }
    @Column(name = "alamat")
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    @Column(name = "pekerjaan")
    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
    @Column(name = "no_telp")
    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    @OneToMany(targetEntity = Santri.class, mappedBy = "idOrangTua")
    public List<Santri> getListSantri() {
        return listSantri;
    }

    public void setListSantri(List<Santri> listSantri) {
        this.listSantri = listSantri;
    }
    
    
    
}
