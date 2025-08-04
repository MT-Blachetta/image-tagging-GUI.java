package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 * Swing component that displays the currently loaded image and paints a small
 * red marker at the last clicked position. The component is responsible only
 * for rendering; user interaction is handled by a separate mouse listener.
 */
public class ImageComponent extends JComponent {

    private static final long serialVersionUID = 8055865896136562197L;

    /** Image currently shown on screen. */
    private BufferedImage image;

    /**
     * Creates the component and positions it within the main frame.
     */
    public ImageComponent(){

    this.setBounds(6,4,696,520); }

    /**
     * Sets a new image to display and triggers a repaint so the content becomes
     * visible immediately.
     */
    public void setImage( BufferedImage image ){

        this.image = image;
        //setPreferredSize( new Dimension(image.getWidth(), image.getHeight()) );
        repaint();
        //invalidate();
    }

    /**
     * Paints the image and the red marker indicating the last clicked position.
     */
    @Override protected void paintComponent( Graphics g) {

        if(image != null){
            g.drawImage( image, 0, 0, this );
            g.setColor(Color.red);
                g.fillOval( MainClass.Xstate(), MainClass.Ystate(), 5, 5);
        }
    }
}

