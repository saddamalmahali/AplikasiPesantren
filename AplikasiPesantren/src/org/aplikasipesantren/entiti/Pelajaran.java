/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.entiti;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author saddam
 */
@Entity
@Table(name = "pelajaran")
public class Pelajaran implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "idKitab")
    private Kitab idKitab;
    @ManyToOne
    @JoinColumn(name = "idKelas")
    private Kelas idKelas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kitab getIdKitab() {
        return idKitab;
    }

    public void setIdKitab(Kitab idKitab) {
        this.idKitab = idKitab;
    }

    public Kelas getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Kelas idKelas) {
        this.idKelas = idKelas;
    }
    
    
}
