/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.services;

import com.app.api.Entitas.Kamar;
import com.app.api.Exception.KamarException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author saddam
 */
public interface KamarDao extends Remote{
    public void insertKamar(Kamar kamar)throws RemoteException, KamarException;
    public void deleteKamar(int id)throws RemoteException, KamarException;
    public List<Kamar> getAllKamar() throws RemoteException, KamarException;
    public Kamar getIdKamar(String namaKamar)throws RemoteException, KamarException;
}
