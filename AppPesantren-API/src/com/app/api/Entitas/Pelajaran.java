/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.Entitas;

import java.io.Serializable;

/**
 *
 * @author Saddam
 */
public class Pelajaran implements Serializable{
    private int id;
    private int idKelas;
    private int idKitab;
    private String namaKelas;
    private String namaKitab;

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

    public int getIdKitab() {
        return idKitab;
    }

    public void setIdKitab(int idKitab) {
        this.idKitab = idKitab;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaKitab() {
        return namaKitab;
    }

    public void setNamaKitab(String namaKitab) {
        this.namaKitab = namaKitab;
    }
    
    
}
