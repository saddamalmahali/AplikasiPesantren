/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.services;

import com.app.api.Entitas.Ustadz;
import com.app.api.Exception.UstadzException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author saddam
 */
public interface UstadzDao extends Remote{
    public void insertUstadz(Ustadz ustadz)throws RemoteException, UstadzException;
    public void updateUstadz(int idUstadz, Ustadz ustadz)throws RemoteException, UstadzException;
    public void deleteUstadz(int idUstadz)throws RemoteException, UstadzException;
    public List<Ustadz> getAllUstadz()throws RemoteException, UstadzException;
    public Ustadz getUstadz(String namaDepan, String namaBelakang)throws RemoteException, UstadzException;
}
