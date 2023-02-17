/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author user
 */

//import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImageComponent extends JComponent {

    
    private static final long serialVersionUID = 8055865896136562197L;
    
    private BufferedImage image;
    
    
    public ImageComponent(){
    
    this.setBounds(6,4,696,520); }
    
    public void setImage( BufferedImage image ){
    
        this.image = image;
        //setPreferredSize( new Dimension(image.getWidth(), image.getHeight()) );
        repaint();
        //invalidate();
    }
    
    @Override protected void paintComponent( Graphics g) {
    
        if(image != null){
            g.drawImage( image, 0, 0, this );
            g.setColor(Color.red);
	        g.fillOval( MainClass.Xstate(), MainClass.Ystate(), 5, 5);
        }
    } 
}
