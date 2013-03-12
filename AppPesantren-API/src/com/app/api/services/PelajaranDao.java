/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.services;

import com.app.api.Entitas.Pelajaran;
import com.app.api.Exception.PelajaranException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author saddam
 */
public interface PelajaranDao extends Remote{
    public void insertPelajaran(Pelajaran pelajaran)throws RemoteException, PelajaranException;
    public void updatePelajaran(int idPelajaran, Pelajaran pelajaran)throws RemoteException, PelajaranException;
    public void deletePelajaran(int idPelajaran)throws RemoteException, PelajaranException;
    public List<Pelajaran> getPelajaran()throws RemoteException, PelajaranException;
    public List<Pelajaran> getPelajaranKelas()throws RemoteException, PelajaranException;
}
