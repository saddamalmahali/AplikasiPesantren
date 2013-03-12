/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.services;

import com.app.api.Entitas.Santri;
import com.app.api.Exception.SantriException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author saddam
 */
public interface SantriDao extends Remote{
    public void insertSantri(Santri santri)throws RemoteException, SantriException;
    public void updateSantri(int idSantri, Santri santri)throws RemoteException, SantriException;
    public void deleteSantri(int idSantri)throws RemoteException, SantriException;
    public List<Santri> getAllSantri()throws RemoteException, SantriException;
}
