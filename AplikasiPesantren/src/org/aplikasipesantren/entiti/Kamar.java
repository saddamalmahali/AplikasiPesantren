/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.entiti;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author saddam
 */
@Entity
@Table(name = "kamar")
public class Kamar implements Serializable{
    private int id;
    private  Gedung gedung;
    private String nama;
    private String jumlah;
    private List<Santri> listSantri;
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "id_gedung")
    public Gedung getGedung() {
        return gedung;
    }

    public void setGedung(Gedung gedung) {
        this.gedung = gedung;
    }
    @Column(name = "nama")
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    @Column(name = "jumlah")
    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    @OneToMany(targetEntity = Santri.class, mappedBy = "kamar")
    public List<Santri> getListSantri() {
        return listSantri;
    }

    public void setListSantri(List<Santri> listSantri) {
        this.listSantri = listSantri;
    }
    
    
    
}
