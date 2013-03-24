/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.model;

import java.util.ArrayList;
import java.util.List;
import org.aplikasipesantren.entiti.Kelas;
import org.aplikasipesantren.entiti.Pelajaran;
import org.aplikasipesantren.entiti.Santri;
import org.aplikasipesantren.koneksi.Koneksi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author saddam
 */
public class KelasModel {
    private int idKelas;
    private String namaKelas;
    private SessionFactory factory;
    private Session session;
    private List<Pelajaran> listPelajaran;
    private List<Santri> listSantri;
    public KelasModel() {
        factory = Koneksi.getSessionFactory();
        session = factory.openSession();
    }
    
    
    
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
    
    public void insertKelas(){
        Kelas kelas = new Kelas();
        kelas.setIdKelas(idKelas);
        kelas.setNamaKelas(namaKelas);
        kelas.setListPelajaran(listPelajaran);
        kelas.setListSantri(listSantri);
        session.beginTransaction();
        session.save(kelas);
        session.getTransaction().commit();
    }
    
    public void updateKelas(){
        Kelas kelas = new Kelas();
        kelas.setIdKelas(idKelas);
        kelas.setNamaKelas(namaKelas);
        kelas.setListPelajaran(listPelajaran);
        kelas.setListSantri(listSantri);
        session.beginTransaction();
        session.update(kelas);
        session.getTransaction().commit();
    }
    
    public void deleteKelas(){
        Kelas kelas = new Kelas();
        kelas.setIdKelas(idKelas);
        kelas.setNamaKelas(namaKelas);
        kelas.setListPelajaran(listPelajaran);
        kelas.setListSantri(listSantri);
        session.beginTransaction();
        session.delete(kelas);
        session.getTransaction().commit();
    }
    
    public List<Kelas> getAllKelas(){
        List<Kelas> listKelas = new ArrayList<>();
        
        session.beginTransaction();
        listKelas = session.createQuery(" from Kelas").list();
        session.getTransaction().commit();
        return listKelas;
    }
}
