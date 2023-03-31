/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author rizki
 */
public class templateGambar extends JPanel{
     Image image;
    public void setImage(String file)throws MalformedURLException{
        URL url = null;
        image = null;
        url = new File(file).toURI().toURL();
        image = getToolkit().getImage(url);
        repaint();
    }
    
     public void setImageIcon(ImageIcon file) {
            image = file.getImage();
            repaint();
        }

    @Override
    public void paint(Graphics g) {
        try {
            double d = image.getHeight(this)/this.getHeight();
            double w = image.getWidth(this)/d;
            double x = this.getWidth()/2 - w / 2;
            g.drawImage(image, (int)x,0, (int)(w), this.getHeight(),this);
        } catch (Exception e) {
        }
        
    }
     
     
    
}
