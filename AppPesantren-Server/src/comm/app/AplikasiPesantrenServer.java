/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comm.app;

import com.app.api.Exception.KelasException;
import com.app.api.Exception.SantriException;
import com.app.api.services.KelasDao;
import com.app.api.services.SantriDao;
import com.app.model.KelasDaoImpl;
import com.app.model.SantriDaoImpl;
import com.app.services.KoneksiServer;
import java.rmi.RemoteException;
import java.sql.SQLException;


/**
 *
 * @author saddam
 */
public class AplikasiPesantrenServer {
    public static void main(String[]args) throws RemoteException, SQLException, SantriException, KelasException{
        KoneksiServer registry = new KoneksiServer();
    
        SantriDao santriServices = new SantriDaoImpl();
        KelasDao kelasServices = new KelasDaoImpl();
        
        KoneksiServer.getRegistry().rebind("santri", santriServices);
        KoneksiServer.getRegistry().rebind("kelas", kelasServices);
    }
    
    
}
