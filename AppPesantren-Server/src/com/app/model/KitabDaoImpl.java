/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Kitab;
import com.app.api.Exception.KitabException;
import com.app.api.services.KitabDao;
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


/**
 *
 * @author saddam
 */
public class KitabDaoImpl extends UnicastRemoteObject implements KitabDao{
    private Connection conn = null;
    private final String qInsert = "insert into kitab (id, nama_kitab) values(?,?)";
    private final String qUpdate = "update kitab set nama_kitab=? where id=?";
    private final String qDelete = "delete from kitab where id=?";
    private final String qGetAll = "select * from kitab";
    
    
    public KitabDaoImpl()throws RemoteException, SQLException{
        this.conn = Koneksi.getConn();
    }
    
    @Override
    public void insertKitab(Kitab kitab) throws RemoteException, KitabException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, kitab.getId());
            pstat.setString(2, kitab.getNamaKitab());
            pstat.executeUpdate();   
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KitabException("Gagal menambahkan kitab dengan pesan :"+ex.getMessage());
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
    public void updateKitab(int idKitab, Kitab kitab) throws RemoteException, KitabException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            pstat.setString(1, kitab.getNamaKitab());
            pstat.setInt(2, idKitab);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KitabException("Gagal mengupdate kitab dengan pesan : "+ex.getMessage());
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
    public void deleteKitab(int idKitab) throws RemoteException, KitabException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, idKitab);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KitabException("Gagal menghapus kitab dengan pesan : "+ex.getMessage());
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
    public List<Kitab> getAllKitab() throws RemoteException, KitabException {
        Statement s = null;
        List<Kitab> listKitab = new ArrayList<Kitab>();
        ResultSet rs = null;
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetAll);
            Kitab kitab = new Kitab();
            
            while(rs.next()){
            kitab.setId(rs.getInt("id"));
            kitab.setNamaKitab(rs.getString("nama_kitab"));
            listKitab.add(kitab);
            }            
            
            conn.commit();
            return listKitab;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KitabException("Gagal mengambil list kitab dengan pesan : "+ex.getMessage());
            
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
