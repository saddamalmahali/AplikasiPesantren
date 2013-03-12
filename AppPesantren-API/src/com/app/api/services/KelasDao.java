/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.services;

import com.app.api.Entitas.Kelas;
import com.app.api.Exception.KelasException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author saddam
 */
public interface KelasDao extends Remote{
    public void insertKelas(Kelas kelas)throws RemoteException, KelasException;
    public void updateKelas(int id, Kelas kelas)throws RemoteException, KelasException;
    public void deleteKelas(int idKelas)throws RemoteException, KelasException;
    public List<Kelas> getAllKelas()throws RemoteException, KelasException;
    public int getIdKelas(String namaKelas)throws RemoteException, KelasException;
}
