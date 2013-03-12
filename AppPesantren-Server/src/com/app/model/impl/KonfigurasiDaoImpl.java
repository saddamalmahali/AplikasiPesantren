/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model.impl;

import Entitas.User;
import com.app.model.dao.KonfigurasiDao;

/**
 *
 * @author saddam
 */
public class KonfigurasiDaoImpl implements KonfigurasiDao{
    private User user;
            
    public KonfigurasiDaoImpl(User user) {
        this.user = user;
    }
    
    
    @Override
    public void save(String username, String pass, int port, String database) {
         user.setUsername(username);
         user.setPort(port);
         user.setPass(pass);
         user.setDatabase(database);
    }

    @Override
    public User getUser() {
        return user;
    }
    
}
