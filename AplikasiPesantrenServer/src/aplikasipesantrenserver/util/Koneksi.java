/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Saddam
 */
public class Koneksi {
    private static Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/aplikasi_pesantren?zeroDateTimeBehavior=convertToNull";
    private static String userName = "root";
    private static String password = "";
    
    public Koneksi(){
        
    }
    public static Connection getConn() throws SQLException {
        if(conn==null){
            conn = DriverManager.getConnection(url,userName, password);
        }
        return conn;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Koneksi.url = url;
    }
    
    
    
}
