package GUI;



import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class InfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 420610414217171451L;

	public JTextField cellNr_gui;
	public JTextField frameIndex_gui;
	
	public JLabel x_val;
	public JLabel y_val;

	public JButton mark_button;

	public JButton back_button;
	public JButton next_button;
	public JButton save_button;
	
	public InfoPanel() {
		
	    this.setBounds(50, 550, 600, 150);
	    
	    
	    //Komponenten Objekte erzeugen mit Konstruktor
	    
	    JLabel x_label = new JLabel("x:");
	    x_val = new JLabel("000");
	    JLabel y_label = new JLabel("y:");
	    y_val = new JLabel("000");
	    
	    cellNr_gui = new JTextField("cellNr",10);
	    frameIndex_gui = new JTextField("1",10);
	    

	    
	    
	    back_button = new JButton("Back");
	    next_button = new JButton("NEXT");
	    mark_button = new JButton("START");
	    save_button = new JButton("Save");
	    
	    mark_button.setEnabled(false);
	    
	    back_button.setEnabled(false);
	    next_button.setEnabled(false);
	    save_button.setEnabled(false);
	    
	    JLabel frameNrLabel = new JLabel("  time:");
	    JLabel place = new JLabel("  ");
	    JLabel placexy = new JLabel("  ");
	    JLabel place3 = new JLabel("  ");
	    
	    //Zum Gui-Container per add-Methode hinzufügen
	    
	    this.add(x_label);
	    this.add(x_val);
	    this.add(placexy);
	    this.add(y_label);
	    this.add(y_val);
	    this.add(place);
	    this.add(cellNr_gui);
	    this.add(frameNrLabel);
	    this.add(frameIndex_gui);
	    this.add(place3);
	    this.add(back_button);
	    this.add(next_button);
	    this.add(mark_button);
	    this.add(save_button);
	
	
	}
	
	public void init(ButtonEvent action){
		
		mark_button.setName("mark");
		back_button.setName("back");
		next_button.setName("next");
		save_button.setName("save");
		
		
		mark_button.addActionListener(action);
		
		back_button.addActionListener(action);
		next_button.addActionListener(action);
		save_button.addActionListener(action);
		
		
		
		next_button.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "next");
		back_button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "back");
		//JComponent.WHEN_IN_FOCUSED_WINDOW
		
		next_button.getActionMap().put("next", action);
		back_button.getActionMap().put("back", action);
		
		
		
		mark_button.setEnabled(true);
		//save_button.setEnabled(true);
		next_button.setEnabled(true);
		
	}
	
}

