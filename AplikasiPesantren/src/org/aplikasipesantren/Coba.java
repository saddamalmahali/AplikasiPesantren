/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aplikasipesantren.entiti.Gedung;
import org.aplikasipesantren.entiti.Kamar;
import org.aplikasipesantren.entiti.Kelas;
import org.aplikasipesantren.entiti.Kitab;
import org.aplikasipesantren.entiti.OrangTua;
import org.aplikasipesantren.entiti.Pelajaran;
import org.aplikasipesantren.entiti.Santri;
import org.aplikasipesantren.model.KamarModel;
import org.aplikasipesantren.model.KitabModel;
import org.aplikasipesantren.model.OrangTuaModel;
import org.aplikasipesantren.model.PelajaranModel;
import org.aplikasipesantren.model.SantriModel;


/**
 *
 * @author saddam
 *
 */
public class Coba {

    public static void main(String[] args) {
                       
        File file = new File("/home/saddam/Pictures/NengAtu/Santri.png");
        byte[] bFile = new byte[(int)file.length()];
        try {
            FileInputStream is = new FileInputStream(file);
            is.read(bFile);
            is.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Coba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Coba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SantriModel model = new SantriModel();
//        Kamar kamar = new Kamar();
//        Kelas kelas = new Kelas();
//        OrangTua orangTua = new OrangTua();
//        orangTua.setId(1001);
//        kelas.setIdKelas(100);
//        kamar.setId(101);
//        
//        model.setId(1001);
//        model.setNamaBelakang("sahrudin");
//        model.setNamaDepan("furqon");
//        model.setJenisKelamin(true);
//        model.setTempatLahir("tangerang");
//        model.setTanggalLahir(new Date());
//        model.setAlamat("nangewer");
//        model.setNoHp("0809834");
//        model.setNoTelp("026245454");
//        model.setAsalSekolah("Annajaat");
//        model.setLulusanTrk("Aliyah");
//        model.setIdKamar(kamar);
//        model.setIdOrangTua(orangTua);
//        model.setIdKelas(kelas);
//        model.setFoto(bFile);
//        model.setEmail("erttrtyr@yahoo.co.id");
//        model.insertSantri();
        List<Santri> listSantri = new ArrayList<>();
        listSantri = model.getListSantri();
        
        System.out.println(listSantri.size());
                
    }
}
