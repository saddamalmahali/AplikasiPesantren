/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.skin;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author saddam
 */
public class AplikasiPanel extends JPanel{
    private Image image;

    public AplikasiPanel() {
        image = new ImageIcon(getClass().getResource("/com/belajar/part1/wallpaper.jpg")).getImage();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        Graphics2D gd = (Graphics2D) g.create();
        
        gd.drawImage(image, 0, 0,getWidth(), getHeight(), null);
        
        gd.dispose();
    }
    
    
         
}
