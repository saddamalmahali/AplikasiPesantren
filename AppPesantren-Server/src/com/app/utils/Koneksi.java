/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author saddam
 */
public class Koneksi {
    private static Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/aplikasi_pesantren?zeroDateTimeBehavior=convertToNull";
    private static String username = "root";
    private static String password = "Bangga";

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Koneksi.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Koneksi.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Koneksi.password = password;
    }
    
    
    
    public Koneksi() {
    }
    
    public static Connection getConn() throws SQLException{
        if(conn == null){
            conn = DriverManager.getConnection(url, username, password);
        }
        return conn;
    }
    
}
