/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model.dao;

import Entitas.User;

/**
 *
 * @author saddam
 */
public interface KonfigurasiDao {
    public void save(String username, String pass, int port, String database);
    public User getUser();
}
