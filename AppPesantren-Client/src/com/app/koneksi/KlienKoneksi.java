/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.koneksi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 * @author saddam
 */
public class KlienKoneksi {
    private Registry registry;
    
    public Registry getKoneksi(String host, int port){
        try {
            registry = LocateRegistry.getRegistry(host, port);
        } catch (RemoteException ex) {
            
        }        
        return registry;
    }
}
