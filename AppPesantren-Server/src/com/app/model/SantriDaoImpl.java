/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.api.Entitas.Santri;
import com.app.api.Exception.SantriException;
import com.app.api.services.SantriDao;
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
public class SantriDaoImpl extends UnicastRemoteObject implements SantriDao{
    private Connection conn = null;
    private String qInsert = "insert into santri (id, id_kelas, nama_depan, nama_belakang,"
            + "jenis_kelamin, tempat_lahir, tanggal_lahir, alamat, id_orangtua, no_telp,"
            + "no_hp, email, id_kamar, asal_sekolah, lulusan_trk, foto) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String qUpdate = "update from santri set id_kelas=?, nama_depan=?, nama_belakang=?, jenis_kelamin=?, "
            + "tempat_lahir=?, tanggal_lahir=?, alamat=?, id_orangtua=?, no_telp=?, "
            + "no_hp=?, email=?, id_kamar=?, asal_sekolah=?, lulusan_trk=?, foto=? where id=?";
    private String qDelete = "delete from santri where id = ?";
    private String qGetAll = "select * from santri";

    public SantriDaoImpl() throws RemoteException, SantriException{
        if(conn==null){
            try {
                this.conn = Koneksi.getConn();
            } catch (SQLException ex) {
                
            }
        }
    }
    
    
    
    public SantriDaoImpl(Connection conn) throws SQLException, RemoteException{
        if(conn==null){
            this.conn = Koneksi.getConn();
        }
    }
    
    
    
    @Override
    public void insertSantri(Santri santri) throws RemoteException, SantriException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, santri.getId());
            pstat.setInt(2, santri.getIdKelas());
            pstat.setString(3, santri.getNamaDepan());
            pstat.setString(4, santri.getNamaBelakang());
            pstat.setBoolean(5, santri.isJenisKelamin());
            pstat.setString(6, santri.getTempatLahir());
            pstat.setDate(7, new Date(santri.getTanggalLahir().getDate()));
            pstat.setString(8, santri.getAlamat());
            pstat.setInt(9, santri.getIdOrangTua());
            pstat.setString(10, santri.getNoTelp());
            pstat.setString(11, santri.getNoHp());
            pstat.setString(12, santri.getEmail());
            pstat.setInt(13, santri.getIdKamar());
            pstat.setString(14, santri.getAsalSekolah());
            pstat.setString(15, santri.getLulusanTerakhir());
            pstat.setBlob(16, santri.getFoto());
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
                
            } catch (SQLException ex1) {
                
            }
            throw new SantriException("Gagal menambahkan santri dengan pesan : "+ex.getMessage());
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
    public void updateSantri(int idSantri, Santri santri) throws RemoteException, SantriException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            
            pstat.setInt(1, santri.getIdKelas());
            pstat.setString(2, santri.getNamaDepan());
            pstat.setString(3, santri.getNamaBelakang());
            pstat.setBoolean(4, santri.isJenisKelamin());
            pstat.setString(5, santri.getTempatLahir());
            pstat.setDate(6, new Date(santri.getTanggalLahir().getDate()));
            pstat.setString(7, santri.getAlamat());
            pstat.setInt(8, santri.getIdOrangTua());
            pstat.setString(9, santri.getNoTelp());
            pstat.setString(10, santri.getNoHp());
            pstat.setString(11, santri.getEmail());
            pstat.setInt(12, santri.getIdKamar());
            pstat.setString(13, santri.getAsalSekolah());
            pstat.setString(14, santri.getLulusanTerakhir());
            pstat.setBlob(15, santri.getFoto());
            pstat.setInt(16, santri.getId());
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new SantriException("Gagal mengupdate santri dengan pesan = "+ex.getMessage());
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
    public void deleteSantri(int idSantri) throws RemoteException, SantriException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, idSantri);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new SantriException("Gagal menghapus santri dengan pesan : "+ex.getMessage());
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
    public List<Santri> getAllSantri() throws RemoteException, SantriException {
        Statement s = null;
        ResultSet rs = null;
        List<Santri> listSantri = new ArrayList<Santri>();
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetAll);
            Santri santri = new Santri();
            while(rs.next()){
                santri.setId(rs.getInt("id"));
                santri.setIdKelas(rs.getInt("id_kelas"));
                santri.setNamaDepan(rs.getString("nama_depan"));
                santri.setNamaBelakang(rs.getString("nama_belakang"));
                santri.setJenisKelamin(rs.getBoolean("jenis_kelamin"));
                santri.setTempatLahir(rs.getString("tempat_lahir"));
                santri.setTanggalLahir(rs.getDate("tanggal_lahir"));
                santri.setAlamat(rs.getString("alamat"));
                santri.setIdOrangTua(rs.getInt("id_orangtua"));
                santri.setNoTelp(rs.getString("no_telp"));
                santri.setNoHp(rs.getString("no_hp"));
                santri.setEmail(rs.getString("email"));
                santri.setIdKamar(rs.getInt("id_kamar"));
                santri.setAsalSekolah(rs.getString("asal_sekolah"));
                santri.setLulusanTerakhir(rs.getString("lulusan_trk"));
                santri.setFoto(rs.getBlob("foto"));
                
                listSantri.add(santri);
            }
            conn.commit();
            return listSantri;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new SantriException("Gagal mengambil list santri dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                
                
            } catch (SQLException ex) {
                
            }
        }
    }
    
}
