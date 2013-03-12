/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Gedung;
import com.app.api.Exception.GedungException;
import com.app.api.services.GedungDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saddam
 */
public class GedungDaoImpl extends UnicastRemoteObject implements GedungDao{
    private Connection conn = null;
    private String qInsert = "insert into gedung(id, nama) values(?,?)";
    private String qUpdate = "update gedung set nama=? where id=?";
    private String qDelete = "delete from gedung where id=?";
    private String qSelectAll = "select * from gedung";
    private String qSelectByName = "select * from gedung where nama=?";
    
    public GedungDaoImpl()throws SQLException, RemoteException{
        
    }
    
    @Override
    public void insertGedung(Gedung gedung) throws RemoteException, GedungException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, gedung.getId());
            pstat.setString(2, gedung.getNamaGedung());
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(SQLException ex1){
                
            }
            throw  new GedungException("Gagal menambahkan Gedung dengan pesan : "+ex.getMessage());
        }finally{
            try{
                conn.setAutoCommit(true);
                pstat.close();
            }catch(SQLException ex){
                
            }
            
        }
    }

    @Override
    public void updateGedung(int id, Gedung gedung) throws RemoteException, GedungException {
        PreparedStatement pstat = null;
        
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            pstat.setString(1, gedung.getNamaGedung());
            pstat.setInt(2, id);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(SQLException ex1){
                
            }
            throw new GedungException("Gagal update Gedung dengan pesan : "+ex.getMessage());
            
        }
    }

    @Override
    public void deleteGedung(int id) throws RemoteException, GedungException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, id);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(SQLException ex1){
                
            }
            throw new GedungException("Gagal menghapus Gedung dengan pesan : "+ex.getMessage());
        }finally{
            try{
                conn.setAutoCommit(true);
                pstat.close();
                conn.close();
            }catch(SQLException ex){
                
            }
        }
    }

    @Override
    public List<Gedung> getAllGedung() throws RemoteException, GedungException {
        Statement s = null;
        List<Gedung> listGedung = null;
        ResultSet rs = null;
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qSelectAll);
            Gedung gedung = new Gedung();
            while(rs.next()){
                gedung.setId(rs.getInt("id"));
                gedung.setNamaGedung(rs.getString("nama"));
                listGedung.add(gedung);
            }
            conn.commit();
            return listGedung;
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(SQLException ex1){
                
            }
            throw new GedungException("Gagal mengambil List Gedung dengan Pesan : "+ex.getMessage());              
        }finally{
            try{
                conn.setAutoCommit(true);
                rs.close();
                s.close();
                conn.close();
            }catch(SQLException ex){
                
            }
        }
    }

    @Override
    public Gedung getIdGedung(String namaGedung) throws RemoteException, GedungException {
        Statement s = null;
        ResultSet rs = null;
        List<Gedung> listGedung = new ArrayList<Gedung>();
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qSelectByName+"'"+namaGedung+"'");
            Gedung gedung = new Gedung();
            while(rs.next()){
                gedung.setId(rs.getInt("id"));
                gedung.setNamaGedung(rs.getString("nama"));
            }            
            conn.commit();
            return gedung;
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(SQLException ex1){
                
            }
            throw new GedungException("Gagal mengambil id dengan nama = "+namaGedung+ " dengan pesan = "+ex.getMessage());
        }finally{
            try{
                conn.setAutoCommit(true);
                s.close();
                rs.close();
                conn.close();
            }catch(SQLException ex){
                
            }
        }
    }
}
