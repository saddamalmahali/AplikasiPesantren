/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.services;

import com.app.api.Entitas.Gedung;
import com.app.api.Exception.GedungException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author saddam
 */
public interface GedungDao extends Remote{
    public void insertGedung(Gedung gedung)throws RemoteException, GedungException;
    public void updateGedung(int id, Gedung gedung)throws RemoteException, GedungException;
    public void deleteGedung(int id)throws RemoteException, GedungException;
    public List<Gedung> getAllGedung()throws RemoteException, GedungException;
    public Gedung getIdGedung(String namaGedung)throws RemoteException, GedungException;
}
