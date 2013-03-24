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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author saddam
 */
@Entity
@Table(name = "gedung")
public class Gedung implements Serializable{
    
    private int id;
    private String namaGedung;
    private List<Kamar> listKamar;
    
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "nama")
    public String getNamaGedung() {
        return namaGedung;
    }

    public void setNamaGedung(String namaGedung) {
        this.namaGedung = namaGedung;
    }
    @OneToMany(targetEntity = Kamar.class, mappedBy = "gedung")
    public List<Kamar> getListKamar() {
        return listKamar;
    }

    public void setListKamar(List<Kamar> listKamar) {
        this.listKamar = listKamar;
    }
    
    
}
