/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aplikasipesantren.skin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author saddam
 */
public class DesktopPaneEdit extends JDesktopPane{
    private Color warna;

    public DesktopPaneEdit() {    
        setOpaque(false);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 127);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg); //To change body of generated methods, choose Tools | Templates.
        
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 127);
        
        repaint();
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        Graphics2D gd = (Graphics2D) g.create();
        gd.setColor(warna);
        gd.fillRect(0, 0, getWidth(), getHeight());
        
        gd.dispose();
    }
    
    
    
}
