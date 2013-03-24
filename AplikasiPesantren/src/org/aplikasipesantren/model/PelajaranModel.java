/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.model;

import java.util.ArrayList;
import java.util.List;
import org.aplikasipesantren.entiti.Kelas;
import org.aplikasipesantren.entiti.Kitab;
import org.aplikasipesantren.entiti.Pelajaran;
import org.aplikasipesantren.koneksi.Koneksi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author saddam
 */
public class PelajaranModel {
    private int id;
    private Kelas idKelas;
    private Kitab idKitab;
    
    private SessionFactory factory;
    private Session session;

    public PelajaranModel() {
        factory = Koneksi.getSessionFactory();
        session = factory.openSession();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kelas getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Kelas idKelas) {
        this.idKelas = idKelas;
    }

    public Kitab getIdKitab() {
        return idKitab;
    }

    public void setIdKitab(Kitab idKitab) {
        this.idKitab = idKitab;
    }
    
    public void insertPelajaran(){
        Pelajaran pelajaran = new Pelajaran();
        pelajaran.setId(id);
        pelajaran.setIdKelas(idKelas);
        pelajaran.setIdKitab(idKitab);
        
        session.beginTransaction();
        session.save(pelajaran);
        session.getTransaction().commit();
    }
    
    public void updatePelajaran(){
        Pelajaran pelajaran = new Pelajaran();
        pelajaran.setId(id);
        pelajaran.setIdKelas(idKelas);
        pelajaran.setIdKitab(idKitab);
        
        session.beginTransaction();
        session.update(pelajaran);
        session.getTransaction().commit();
    }
    
    public void deletePelajaran(){
        Pelajaran pelajaran = new Pelajaran();
        pelajaran.setId(id);
        pelajaran.setIdKelas(idKelas);
        pelajaran.setIdKitab(idKitab);
        
        session.beginTransaction();
        session.delete(pelajaran);
        session.getTransaction().commit();
    }
    
    public List<Pelajaran> getListPelajaran(){
        List<Pelajaran> listPelajaran = new ArrayList<>();
        session.beginTransaction();
        listPelajaran = session.createQuery(" from Pelajaran").list();
        session.getTransaction().commit();
        return listPelajaran;
    }
}
