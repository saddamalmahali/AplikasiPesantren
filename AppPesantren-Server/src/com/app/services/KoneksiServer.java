/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.services;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author saddam
 */
public class KoneksiServer {
    private static Registry registry;
    
    public static Registry getRegistry()throws RemoteException{
        if(registry == null){
            registry = LocateRegistry.createRegistry(4444);
        }
        
        return registry;
    }
}
