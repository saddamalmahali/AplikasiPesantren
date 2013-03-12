/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.OrangTua;
import com.app.api.Exception.OrangTuaException;
import com.app.api.services.OrangTuaDao;
import com.app.utils.Koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
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

public class OrangTuaDaoImpl extends UnicastRemoteObject implements OrangTuaDao{
    private Connection conn = null;
    private String qInsert = "insert into orang_tua(id, nama_depan, nama_belakang, almarhum,"
            + "tempat_lahir, tanggal_lahir, alamat, no_telp) values(?,?,?,?,?,?,?,?,?)";
    private String qUpdate = "update from orang_tua set nama_depan=?, nama_belakang=?,"
            + "almarhum=?, tempat_lahir=?, tanggal_lahir=?, alamat=?, no_telp=? where id=?";
    private String qDelete = "delete from orang_tua where id=?";
    private String qSelectAll = "select * from orang_tua";
    private String qSelectByName = "select * from orang_tua where nama_depan=";
    
    public OrangTuaDaoImpl()throws RemoteException, OrangTuaException{
        if(conn==null){
            try {
                this.conn = Koneksi.getConn();
            } catch (SQLException ex) {
                
            }
        }
        return;
    }
    @Override
    public void insertOrangTua(OrangTua orangTua) throws RemoteException, OrangTuaException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, orangTua.getId());
            pstat.setString(2, orangTua.getNamaDepan());
            pstat.setString(3, orangTua.getNamaBelakang());
            pstat.setBoolean(4, orangTua.isAlm());
            pstat.setString(5, orangTua.getTempatLahir());
            pstat.setDate(6, new Date(orangTua.getTanggalLahir().getDate()));
            pstat.setString(7, orangTua.getAlamat());
            pstat.setString(8, orangTua.getPekerjaan());
            pstat.setString(9, orangTua.getNoTelp());
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new OrangTuaException("Gagal menambahkan orang tua dengan pesan : "+ex.getMessage());
            
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
    public void updateOrangTua(int idOrangTua, OrangTua orangTua) throws RemoteException, OrangTuaException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            
            pstat.setString(1, orangTua.getNamaDepan());
            pstat.setString(2, orangTua.getNamaBelakang());
            pstat.setBoolean(3, orangTua.isAlm());
            pstat.setString(4, orangTua.getTempatLahir());
            pstat.setDate(5, new Date(orangTua.getTanggalLahir().getDate()));
            pstat.setString(6, orangTua.getAlamat());
            pstat.setString(7, orangTua.getPekerjaan());
            pstat.setString(8, orangTua.getNoTelp());
            pstat.setInt(9, orangTua.getId());
            pstat.executeUpdate();
            
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new OrangTuaException("Gagal mengupdate orang tua dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrangTuaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deleteOrangTua(int id) throws RemoteException, OrangTuaException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, id);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new OrangTuaException("Gagal menghapus orang tua dengan pesan : "+ex.getMessage());
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
    public List<OrangTua> getAllOrangTua() throws RemoteException, OrangTuaException {
        Statement s = null;
        List<OrangTua> listOrangTua = new ArrayList<OrangTua>();
        ResultSet rs = null;
        
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qSelectAll);
            OrangTua orangTua = new OrangTua();
            
            while(rs.next()){
                orangTua.setId(rs.getInt("id"));
                orangTua.setNamaDepan(rs.getString("nama_depan"));
                orangTua.setNamaBelakang(rs.getString("nama_belakang"));
                orangTua.setAlm(rs.getBoolean("almarhum"));
                orangTua.setTempatLahir(rs.getString("tempat_lahir"));
                orangTua.setTanggalLahir(rs.getDate("tanggal_lahir"));
                orangTua.setAlamat(rs.getString("alamat"));
                orangTua.setPekerjaan(rs.getString("pekerjaan"));
                orangTua.setNoTelp(rs.getString("no_telp"));
                
                listOrangTua.add(orangTua);
            }
            
            conn.commit();
            return listOrangTua;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new OrangTuaException("Gagal mengambil list orang tua dengan pesan : "+ex.getMessage());
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
    public int getIdOrangTua(String namaDepan, String namaBelakang) throws RemoteException, OrangTuaException {
        Statement s = null;
        ResultSet rs = null;
        OrangTua orangTua = new OrangTua();
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qSelectByName+namaDepan+" && nama_belakang="+namaBelakang);
            
            while(rs.next()){
                orangTua.setId(rs.getInt("id"));
                orangTua.setNamaDepan(rs.getString("nama_depan"));
                orangTua.setNamaBelakang(rs.getString("nama_belakang"));
                orangTua.setAlm(rs.getBoolean("almarhum"));
                orangTua.setTempatLahir(rs.getString("tempat_lahir"));
                orangTua.setTanggalLahir(rs.getDate("tanggal_lahir"));
                orangTua.setAlamat(rs.getString("alamat"));
                orangTua.setPekerjaan(rs.getString("pekerjaan"));
                orangTua.setNoTelp(rs.getString("no_telp"));
            }
            
            conn.commit();
            
            return orangTua.getId();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new OrangTuaException("Gagal mengambil list orang tua dengan pesan : "+ex.getMessage());
            
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
