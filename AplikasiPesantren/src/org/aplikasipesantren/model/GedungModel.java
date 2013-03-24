/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.model;

import java.util.ArrayList;
import java.util.List;
import org.aplikasipesantren.entiti.Gedung;
import org.aplikasipesantren.koneksi.Koneksi;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author saddam
 */
public class GedungModel {
    private SessionFactory factory;
    private Session session;
    private int idGedung;
    private String namaGedung;
    
    public GedungModel() {
        factory = Koneksi.getSessionFactory();  
        session = factory.openSession();
    }
    
    public int getIdGedung() {
        return idGedung;
    }

    public void setIdGedung(int idGedung) {
        this.idGedung = idGedung;
    }

    public String getNamaGedung() {
        return namaGedung;
    }

    public void setNamaGedung(String namaGedung) {
        this.namaGedung = namaGedung;
    }
     
    public void insertGedung(){
                
        
        
        Gedung gedung = new Gedung();
        
        gedung.setId(idGedung);
        gedung.setNamaGedung(namaGedung);
        
        session.beginTransaction();
        
        session.save(gedung);
        
        session.getTransaction().commit();
        
    }
    
    public void updateGedung(){
        Gedung gedung = new Gedung();
        gedung.setId(idGedung);
        gedung.setNamaGedung(namaGedung);
        
        
        
        session.beginTransaction();        
        session.update(gedung);
        
        session.getTransaction().commit();
    }
    
    public void deleteGedung(){
        Gedung gedung = new Gedung();
        gedung.setId(idGedung);
        gedung.setNamaGedung(namaGedung);
        
        
        session.beginTransaction();
        
        session.delete(gedung);
        
        session.getTransaction().commit();
    }
    
    public List<Gedung> getAllGedung(){
        List<Gedung> list = new ArrayList<Gedung>();
        
        session.beginTransaction();
        
        list = (List<Gedung>) session.createQuery("from Gedung").list();
        
        session.getTransaction().commit();
        
        return list;
    }
}
