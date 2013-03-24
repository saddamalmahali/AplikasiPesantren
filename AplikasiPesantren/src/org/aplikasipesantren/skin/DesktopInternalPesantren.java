/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.skin;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author saddam
 */
public class DesktopInternalPesantren extends JDesktopPane{
    
    private Image image;

    public DesktopInternalPesantren() {
        
        image = new ImageIcon(getClass().getResource("/wallpaper-islam.jpg")).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if(image == null){
            super.paintComponent(g);
        }else{
            try{
                int scrW = this.getWidth();
                int scrH = this.getHeight();
        
                g.drawImage(image, 0, 0, scrW, scrH, null);
            }catch(NullPointerException ex){
                
            }
        }
            
    }
    
    
    
}
