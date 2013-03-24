/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.model;

import java.util.ArrayList;
import java.util.List;
import org.aplikasipesantren.entiti.Kitab;
import org.aplikasipesantren.entiti.Pelajaran;
import org.aplikasipesantren.koneksi.Koneksi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author saddam
 */
public class KitabModel {
    private int idKitab;
    private String namaKitab;
    private List<Pelajaran> listPelajaran;
    
    private SessionFactory factory;
    private Session session;

    public KitabModel() {
        factory = Koneksi.getSessionFactory();
        session = factory.openSession();
    
    }
    
    
    
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
    
    
    public void insertKitab(){
        Kitab kitab = new Kitab();
        kitab.setIdKitab(idKitab);
        kitab.setNamaKitab(namaKitab);
        kitab.setListPelajaran(listPelajaran);
        
        session.beginTransaction();
        session.save(kitab);
        session.getTransaction().commit();
    }
    
    public void updateKitab(){
        Kitab kitab = new Kitab();
        kitab.setIdKitab(idKitab);
        kitab.setNamaKitab(namaKitab);
        kitab.setListPelajaran(listPelajaran);
        
        session.beginTransaction();
        session.update(kitab);
        session.getTransaction().commit();
    }
    
    public void deleteKitab(){
        Kitab kitab = new Kitab();
        kitab.setIdKitab(idKitab);
        kitab.setNamaKitab(namaKitab);
        kitab.setListPelajaran(listPelajaran);
        
        session.beginTransaction();
        session.delete(kitab);
        session.getTransaction().commit();
    }
    
    public List<Kitab> getlistKitab(){
        List<Kitab> listKitab = new ArrayList<>();
        
        session.beginTransaction();
        listKitab = session.createQuery(" from Kitab").list();
        session.getTransaction().commit();
        
        return listKitab;
    }
}
