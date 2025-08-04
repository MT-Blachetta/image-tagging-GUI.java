package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mouse listener attached to the {@link ImageComponent}. It records the
 * coordinates of mouse clicks and requests the image to repaint so the new
 * marker becomes visible.
 */
public class ImageListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent m) {

                   int xinfo = m.getX();
               int yinfo = m.getY();

               MainClass.updateXY(xinfo,yinfo);

               ImageComponent isource = (ImageComponent) m.getSource();

               isource.repaint();


        }

        @Override
        public void mouseEntered(MouseEvent m) {
                // not used

        }

        @Override
        public void mouseExited(MouseEvent m) {
                // not used

        }

        @Override
        public void mousePressed(MouseEvent m) {
                // not used

        }

        @Override
        public void mouseReleased(MouseEvent m) {
                // not used

        }

}

