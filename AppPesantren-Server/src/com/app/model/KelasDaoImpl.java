/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Kelas;
import com.app.api.Exception.KelasException;
import com.app.api.services.KelasDao;
import com.app.utils.Koneksi;
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
public class KelasDaoImpl extends UnicastRemoteObject implements KelasDao{
    private Connection conn = null;
    private final String qInsert = "insert into kelas(id, nama_kelas) values(?,?)";
    private final String qUpdate = "update from kelas set nama_kelas=? where id=?";
    private final String qDelete = "delete from kelas where id=?";
    private final String qSelectAll = "select * from kelas";
    private final String qSelectByName = "select * from kelas where nama_kelas=";
    
    public KelasDaoImpl()throws RemoteException, KelasException{
        if(conn == null){
            try {
                this.conn = Koneksi.getConn();
            } catch (SQLException ex) {
                
            }
        }
    }
    
    @Override
    public void insertKelas(Kelas kelas) throws RemoteException, KelasException {
        PreparedStatement pstat = null;
        try {
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, kelas.getId());
            pstat.setString(2, kelas.getNamaKelas());            
            pstat.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KelasException("Gagal menambah kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void updateKelas(int id, Kelas kelas) throws RemoteException, KelasException {
        PreparedStatement pstat = null;
        try {
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            pstat.setString(1, kelas.getNamaKelas());
            pstat.setInt(2, id);
            
            pstat.executeUpdate();
            
            conn.commit();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KelasException("Gagal mengupdate kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void deleteKelas(int idKelas) throws RemoteException, KelasException {
        PreparedStatement pstat = null;
        
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, idKelas);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KelasException("Gagal mengupdate kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public List<Kelas> getAllKelas() throws RemoteException, KelasException {
        Statement s = null;
        ResultSet rs = null;
        List<Kelas> listKelas = new ArrayList<Kelas>();
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qSelectAll);
            Kelas kelas = new Kelas();
            while(rs.next()) {
                kelas.setId(rs.getInt("id"));
                kelas.setNamaKelas(rs.getString("nama_kelas"));
                listKelas.add(kelas);
            }
            
            conn.commit();
            return listKelas;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KelasException("Gagal mengambil list kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public int getIdKelas(String namaKelas) throws RemoteException, KelasException {
        Statement s = null;
        ResultSet rs = null;
        Kelas kelas = new Kelas();
        
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qSelectByName+"'"+namaKelas+"'");
            while(rs.next()){
                kelas.setId(rs.getInt("id"));
                kelas.setNamaKelas(rs.getString("nama_kelas"));
            }
            conn.commit();
            return kelas.getId();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KelasException("Gagal mengambil list kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
    }
    
}
