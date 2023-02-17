package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub

	}

}
