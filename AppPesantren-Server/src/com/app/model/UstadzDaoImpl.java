/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Ustadz;
import com.app.api.Exception.UstadzException;
import com.app.api.services.UstadzDao;
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
public class UstadzDaoImpl extends UnicastRemoteObject implements UstadzDao{
    
    
    private Connection conn;
    private String qInsert = "insert into ustadz(id, gelar_dpn, gelar_blk, nama_depan,"
            + "nama_belakang, jenis_kelamin, tempat_lahir, tanggal_lahir, alamat, "
            + "no_telp, no_hp, email, website) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String qUpdate = "update ustadz set gelar_dpn=?, gelar_blk=?, nama_depan=?,"
            + "nama_belakang=?, jenis_kelamin=?, tempat_lahir=?, tanggal_lahir=?,"
            + "alamat=?, no_telp=?, no_hp=?, email=?, website=? where id=?";
    private String qDelete = "delete from ustadz where id=?";
    private String qGetAll = "select * from ustadz";
    private String qGetByName = "select * frome ustadz where nama_depan=";
    
    public UstadzDaoImpl() throws RemoteException, SQLException{
        if(conn==null){
            this.conn = Koneksi.getConn();
        }else{
            return;
        }
    }
    
    @Override
    public void insertUstadz(Ustadz ustadz) throws RemoteException, UstadzException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, ustadz.getId());
            pstat.setString(2, ustadz.getGelarDepan());
            pstat.setString(3, ustadz.getGelarBelakang());
            pstat.setString(4, ustadz.getNamaDepan());
            pstat.setString(5, ustadz.getNamaBelakang());
            pstat.setBoolean(6, ustadz.isJenisKelamin());
            pstat.setString(7, ustadz.getTempatLahir());
            pstat.setDate(8, new Date(ustadz.getTanggalLahir().getDate()));
            pstat.setString(9, ustadz.getAlamat());
            pstat.setString(10, ustadz.getNoTelp());
            pstat.setString(11, ustadz.getNoHp());
            pstat.setString(12, ustadz.getEmail());
            pstat.setString(13, ustadz.getWebsite());
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new UstadzException("Gagal menambahkan ustadz dengan pesan = "+ex.getMessage());            
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UstadzDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateUstadz(int idUstadz, Ustadz ustadz) throws RemoteException, UstadzException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            
            pstat.setString(1, ustadz.getGelarDepan());
            pstat.setString(2, ustadz.getGelarBelakang());
            pstat.setString(3, ustadz.getNamaDepan());
            pstat.setString(4, ustadz.getNamaBelakang());
            pstat.setBoolean(5, ustadz.isJenisKelamin());
            pstat.setString(6, ustadz.getTempatLahir());
            pstat.setDate(7, new Date(ustadz.getTanggalLahir().getDate()));
            pstat.setString(8, ustadz.getAlamat());
            pstat.setString(9, ustadz.getNoTelp());
            pstat.setString(10, ustadz.getNoHp());
            pstat.setString(11, ustadz.getEmail());
            pstat.setString(12, ustadz.getWebsite());
            pstat.setInt(13, ustadz.getId());
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new UstadzException("Gagal mengupdate ustadz dengan pesan = "+ex.getMessage());
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
    public void deleteUstadz(int idUstadz) throws RemoteException, UstadzException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, idUstadz);
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new UstadzException("Gagal menghapus ustadz dengan pesan = "+ex.getMessage());
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
    public List<Ustadz> getAllUstadz() throws RemoteException, UstadzException {
        Statement s = null;
        List<Ustadz> listUstadz = new ArrayList<Ustadz>();
        ResultSet rs = null;
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetAll);
            Ustadz ustadz = new Ustadz();
            while(rs.next()){
                ustadz.setId(rs.getInt("id"));
                ustadz.setGelarDepan("gelar_dpn");
                ustadz.setGelarBelakang("gelar_blk");
                ustadz.setNamaDepan(rs.getString("nama_depan"));
                ustadz.setNamaBelakang(rs.getString("nama_belakang"));
                ustadz.setJenisKelamin(rs.getBoolean("jenis_kelamin"));
                ustadz.setTempatLahir(rs.getString("tempat_lahir"));
                ustadz.setTanggalLahir(rs.getDate("tanggal_lahir"));
                ustadz.setAlamat(rs.getString("alamat"));
                ustadz.setNoTelp(rs.getString("no_telp"));
                ustadz.setNoHp(rs.getString("no_hp"));
                ustadz.setEmail(rs.getString("email"));
                ustadz.setWebsite(rs.getString("websitte"));
                listUstadz.add(ustadz);
            }
            
            conn.commit();
            
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new UstadzException("Gagal mengambil list ustadz dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
        
        return listUstadz;
    }

    @Override
    public Ustadz getUstadz(String namaDepan, String namaBelakang) throws RemoteException, UstadzException {
        
        Statement s = null;
        Ustadz ustadz = new Ustadz();
        ResultSet rs = null;
        
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetByName+namaDepan+" && nama_belakang = "+namaBelakang);
            while(rs.next()){
                ustadz.setId(rs.getInt("id"));
                ustadz.setGelarDepan("gelar_dpn");
                ustadz.setGelarBelakang("gelar_blk");
                ustadz.setNamaDepan(rs.getString("nama_depan"));
                ustadz.setNamaBelakang(rs.getString("nama_belakang"));
                ustadz.setJenisKelamin(rs.getBoolean("jenis_kelamin"));
                ustadz.setTempatLahir(rs.getString("tempat_lahir"));
                ustadz.setTanggalLahir(rs.getDate("tanggal_lahir"));
                ustadz.setAlamat(rs.getString("alamat"));
                ustadz.setNoTelp(rs.getString("no_telp"));
                ustadz.setNoHp(rs.getString("no_hp"));
                ustadz.setEmail(rs.getString("email"));
                ustadz.setWebsite(rs.getString("websitte"));
            }
            
            conn.commit();
            return ustadz;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new UstadzException("Gagal mengambil list ustadz dengan pesan : "+ex.getMessage());
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
