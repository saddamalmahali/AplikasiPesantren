/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.entiti;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author saddam
 */
@Entity
@Table(name = "kitab")
public class Kitab implements Serializable{
    @Id
    @Column(name = "id")
    private int idKitab;
    @Column(name = "nama_kitab")
    private String namaKitab;
    
    @OneToMany(targetEntity = Pelajaran.class, mappedBy = "idKitab")
    private List<Pelajaran> listPelajaran;

    public int getIdKitab() {
        return idKitab;
    }

    public void setIdKitab(int idKitab) {
        this.idKitab = idKitab;
    }

    public String getNamaKitab() {
        return namaKitab;
    }

    public void setNamaKitab(String namaKitab) {
        this.namaKitab = namaKitab;
    }

    public List<Pelajaran> getListPelajaran() {
        return listPelajaran;
    }

    public void setListPelajaran(List<Pelajaran> listPelajaran) {
        this.listPelajaran = listPelajaran;
    }    
    
    
}
