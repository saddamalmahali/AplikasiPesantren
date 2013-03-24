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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saddam
 */
@Entity
@Table(name = "kelas")
public class Kelas implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private int idKelas;
    @Column(name = "nama_kelas")
    private String namaKelas;
    @OneToMany(targetEntity = Santri.class, mappedBy = "idKelas", cascade = CascadeType.ALL)
    private List<Santri> listSantri;
    @OneToMany(targetEntity = Pelajaran.class, mappedBy = "idKelas", cascade = CascadeType.ALL)
    private List<Pelajaran> listPelajaran;
    
        public int getIdKelas() {
        return idKelas;
    }
    
    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }
        public String getNamaKelas() {
        return namaKelas;
    }
    
    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
        public List<Santri> getListSantri() {
        return listSantri;
    }

    public void setListSantri(List<Santri> listSantri) {
        this.listSantri = listSantri;
    }

    public List<Pelajaran> getListPelajaran() {
        return listPelajaran;
    }

    public void setListPelajaran(List<Pelajaran> listPelajaran) {
        this.listPelajaran = listPelajaran;
    }

    
    
}
