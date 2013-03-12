/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Kamar;
import com.app.api.Exception.KamarException;
import com.app.api.services.KamarDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saddam
 */
public class KamarDaoImpl extends UnicastRemoteObject implements KamarDao{
    private Connection conn = null;
    private final String qInsert = "insert into kamar(id, id_gedung, nama, jumlah) values(?,?,?,?)";
    private final String qUpdate = "update from kamar set id_gedung=?, blok=?, jumlah=? where id=?";
    private final String qDelete = "delete from kamar where id=?";
    private final String qSelectAll = "select * from kamar";
    private final String qSelectFromNama = "select * from kamar where nama=";
    
    public KamarDaoImpl()throws RemoteException{
        
    }
    
    @Override
    public void insertKamar(Kamar kamar) throws RemoteException, KamarException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, kamar.getId());
            pstat.setInt(2, kamar.getIdGedung());
            pstat.setString(3, kamar.getNama());
            pstat.setString(4, kamar.getJumlah());
            conn.commit();            
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(SQLException ex1){
                
            }
            throw new KamarException("Gagal menambahkan kamar dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void deleteKamar(int id) throws RemoteException, KamarException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KamarException("Gagal menghapus kamar dengan id="+id+" dengan pesan = "+ex.getMessage());
        }
    }

    @Override
    public List<Kamar> getAllKamar() throws RemoteException, KamarException {
        Statement s = null;
        ResultSet rs = null;
        List<Kamar> listKamar = new ArrayList<Kamar>();
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qSelectAll);
            Kamar kamar = new Kamar();
             while(rs.next()){
                 kamar.setId(rs.getInt("id"));
                 kamar.setIdGedung(rs.getInt("id_gedung"));
                 kamar.setNama(rs.getString("nama"));
                 kamar.setJumlah(rs.getString("jumlah"));
                 listKamar.add(kamar);
             }
            
            conn.commit();
            return listKamar;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KamarException("Gagal mengambil list kamar dengan pesan = "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                s.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KamarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Kamar getIdKamar(String namaKamar) throws RemoteException, KamarException {
            Statement s = null;
            ResultSet rs = null;
            Kamar kamar = new Kamar();
        try {
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qSelectFromNama+"'"+"'");
            while(rs.next()){
                kamar.setId(rs.getInt("id"));
                kamar.setIdGedung(rs.getInt("id_gedung"));
                kamar.setNama(rs.getString("nama"));
                kamar.setJumlah(rs.getString("jumlah"));
            }
            
            conn.commit();
            return kamar;
        } catch (SQLException ex) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    
                }
                throw new KamarException("Gagal mengambil list kamar dengan pesan : "+ex.getMessage());        
        }finally{
                try {
                    conn.setAutoCommit(true);
                    s.close();
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KamarDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }            
        }
    }
    
}
