/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.model;

import java.util.ArrayList;
import java.util.List;
import org.aplikasipesantren.entiti.Gedung;
import org.aplikasipesantren.entiti.Kamar;
import org.aplikasipesantren.koneksi.Koneksi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author saddam
 */
public class KamarModel {
    SessionFactory factory;
    Session session;
    int id;
    Gedung gedung;
    String nama;
    String jumlah;
    
    public KamarModel() {
        factory = Koneksi.getSessionFactory();
        session = factory.openSession();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gedung getGedung() {
        return gedung;
    }

    public void setGedung(Gedung gedung) {
        this.gedung = gedung;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
    
    
    public void insertKamar(){
        Kamar kamar = new Kamar();
        kamar.setId(id);
        kamar.setNama(nama);
        kamar.setJumlah(jumlah);
        kamar.setGedung(gedung);
        
        session.beginTransaction();
        session.save(kamar);
        session.getTransaction().commit();
    }
    
    public void updatekamar(){
        Kamar kamar = new Kamar();
        kamar.setId(id);
        kamar.setNama(nama);
        kamar.setJumlah(jumlah);
        kamar.setGedung(gedung);
        
        session.beginTransaction();
        session.update(kamar);
        session.getTransaction().commit();
        
    }
    public void deleteKamar(){
        Kamar kamar = new Kamar();
        
        kamar.setId(id);
        kamar.setNama(nama);
        kamar.setGedung(gedung);
        kamar.setJumlah(jumlah);
        
        
        session.beginTransaction();
        session.delete(kamar);
        session.getTransaction().commit();
        
    }
    
    public List<Kamar> getAllKamar(){
        List<Kamar> listKamar = new ArrayList<>();
        
        session.beginTransaction();
        listKamar = session.createQuery(" from Kamar").list();
        session.getTransaction().commit();
        
        return listKamar;
    }
}
