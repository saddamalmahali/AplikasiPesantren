/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.services;

import com.app.api.Entitas.OrangTua;
import com.app.api.Exception.OrangTuaException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author saddam
 */
public interface OrangTuaDao extends Remote{
    public void insertOrangTua(OrangTua orangTua)throws RemoteException, OrangTuaException;
    public void updateOrangTua(int idOrangTua, OrangTua orangTua)throws RemoteException, OrangTuaException;
    public void deleteOrangTua(int id)throws RemoteException, OrangTuaException;
    public List<OrangTua> getAllOrangTua()throws RemoteException, OrangTuaException;
    public int getIdOrangTua(String namaDepan, String namaBelakang)throws RemoteException, OrangTuaException;
}
