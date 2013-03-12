/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Pelajaran;
import com.app.api.Exception.PelajaranException;
import com.app.api.services.PelajaranDao;
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

public class PelajaranDaoImpl extends UnicastRemoteObject implements PelajaranDao{
    private Connection conn = null;
    private String qInsert = "insert into pelajaran (id, id_kelas, id_kitab) values(?,?,?)";
    private String qUpdate = "update from pelajaran set id_kelas=?, id_kitab=? where id=?";
    private String qDelete = "delete from pelajaran where id=?";
    private String qGetAll = "select * from pelajaran";
    private String qGetPelajaran = "select * from viewpelajaran";
    private String qGetPelajaranKomplit = "select * from viewpelajaran";
    
    public PelajaranDaoImpl()throws RemoteException, PelajaranException{
        if(conn==null){
            try {
                this.conn = Koneksi.getConn();
            } catch (SQLException ex) {
                
            }
            
        }
        return;
    }

    @Override
    public void insertPelajaran(Pelajaran pelajaran) throws RemoteException, PelajaranException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, pelajaran.getId());
            pstat.setInt(2, pelajaran.getIdKelas());
            pstat.setInt(3, pelajaran.getIdKitab());
            pstat.executeQuery();
                    
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Gagal menambahkan pelajaran dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PelajaranDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updatePelajaran(int idPelajaran, Pelajaran pelajaran) throws RemoteException, PelajaranException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            pstat.setInt(1, pelajaran.getIdKelas());
            pstat.setInt(2, pelajaran.getIdKitab());
            pstat.setInt(3, idPelajaran);
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Gagal mengupdate pelajaran dengan pesan : "+ex.getMessage());
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
    public void deletePelajaran(int idPelajaran) throws RemoteException, PelajaranException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, idPelajaran);
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Gagal menghapus pelajaran dengan pesan : "+ex.getMessage());
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
    public List<Pelajaran> getPelajaran() throws RemoteException, PelajaranException {
        Statement s = null;
        ResultSet rs = null;
        List<Pelajaran> listPelajaran = new ArrayList<Pelajaran>();
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetAll);
            Pelajaran pelajaran = new Pelajaran();
            while(rs.next()){
                pelajaran.setId(rs.getInt("id"));
                pelajaran.setIdKelas(rs.getInt("id_kelas"));
                pelajaran.setIdKitab(rs.getInt("id_kitab"));
                listPelajaran.add(pelajaran);
            }
            conn.commit();
            
            return listPelajaran;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Gagal mengambil list pelajaran dengan pesan : "+ex.getMessage());
        }   
        
    }

    @Override
    public List<Pelajaran> getPelajaranKelas() throws RemoteException, PelajaranException {
        Statement s = null;
        ResultSet rs = null;
        List<Pelajaran> listPelajaran = new ArrayList<Pelajaran>();
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetPelajaranKomplit);
            Pelajaran pelajaran = new Pelajaran();
            while(rs.next()){
                pelajaran.setId(rs.getInt("id"));
                pelajaran.setNamaKelas(rs.getString("nama_kelas"));
                pelajaran.setNamaKitab(rs.getString("nama_kitab"));
                listPelajaran.add(pelajaran);
            }
            conn.commit();
            
        }catch(SQLException ex){
            try {
                conn.rollback();               
            } catch (SQLException ex1) {
                
            }
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PelajaranDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return listPelajaran;
    }
}
