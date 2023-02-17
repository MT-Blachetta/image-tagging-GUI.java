package GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainClass {
	
	
	private static int X;
	private static int Y;
	
	private static InfoPanel controll;
	public static ImageComponent iC;
	
	public static state phase;
	
	
	public static void main(String[] args) {
		
		
		X = 0;
		Y = 0;
		
		phase = state.INIT;
		
		controll = new InfoPanel();
		
		iC = new ImageComponent();
	
		
		JFrame app = new JFrame("Image Tagger");
		app.setSize(708,708);
		
        
        app.setLayout(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Menü
        
 		 JMenuBar menuBar = new JMenuBar();
         JMenu menu = new JMenu("Datei");
         menu.setMnemonic('D');
         menu.add(new JMenuItem(new FileOpenAction(iC)));
         menuBar.add(menu);
         app.setJMenuBar(menuBar);
        
         app.add(iC);
         app.add(controll);
         app.setVisible(true);
        
       
	}
	
	public static void updateXY(int x, int y){
		
		X = x;
		Y = y;
		
		controll.x_val.setText(String.valueOf(x));
		controll.y_val.setText(String.valueOf(y));
		
	}
	
	public static void imageLoaded(String fname){
		
		switch (phase){
		
		case INIT:
			ButtonEvent action = new ButtonEvent(controll);
			action.openDirectory(fname);
			controll.init(action);
			phase = state.WAIT;
			break;
			
		case WAIT:
			break;
			
		case MARK:
			break;
			
		default: 	
		
		}
		
	}
	
	
	
	public static int Xstate(){
		return X;
	}
	
	public static int Ystate(){
		return Y;		
	}


	

}
