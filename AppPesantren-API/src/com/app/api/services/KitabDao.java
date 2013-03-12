/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.services;

import com.app.api.Entitas.Kitab;
import com.app.api.Exception.KitabException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author saddam
 */
public interface KitabDao extends Remote{
    public void insertKitab(Kitab kitab)throws RemoteException, KitabException;
    public void updateKitab(int idKitab, Kitab kitab)throws RemoteException, KitabException;
    public void deleteKitab(int idKitab)throws RemoteException, KitabException;
    public List<Kitab> getAllKitab()throws RemoteException, KitabException;
}
