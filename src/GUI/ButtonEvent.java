package GUI;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;




public class ButtonEvent extends AbstractAction {

	
	private static final long serialVersionUID = -6253845228618335747L;
	private String pathdir;
	private int filepointer;
	
	private int seq;
	
	private File table;
	private PrintWriter link;
	
	private InfoPanel data;
	
	private long timer;

	
	public ButtonEvent(InfoPanel field){
		
		this.data = field;
		seq = 0;
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent op) {
		
		JButton jsource = (JButton)op.getSource();
		
		String ButtonId = jsource.getName();
		
		if(MainClass.phase == state.MARK){
				
					if(ButtonId.equals("save")){
						link.flush();
						link.close();
						table = null;
						link = null;
						data.save_button.setEnabled(false);
						data.mark_button.setEnabled(true);
						data.cellNr_gui.setEditable(true);
						
						System.out.println(timer - System.currentTimeMillis());
						
						filepointer = 0;
						seq = 0;
						data.frameIndex_gui.setText(String.valueOf(seq));
						final File Img = new File(pathdir + "cell000" + ".jpg");
						
						if(Img.exists()){
							
							new SwingWorker<BufferedImage, Void>() {

						           
					            @Override protected BufferedImage doInBackground() throws IOException{ 
					                return ImageIO.read( Img );
					            } 
					            @Override protected void done() {
					                try { MainClass.iC.setImage( get() ); }
					                catch ( InterruptedException | ExecutionException e) {}
					                
					            }
					            
					        }.execute(); }
						
					        MainClass.phase = state.WAIT;
						
					} else if(ButtonId.equals("next")){
							
							data.back_button.setEnabled(true);
							link.print(seq + "\t" + MainClass.Xstate() + "\t" + MainClass.Ystate() +"\n");
							
							filepointer++;
							seq++;
							
							data.frameIndex_gui.setText(String.valueOf(seq));
							
							final File nextImg = new File(pathdir + "cell" + String.format("%03d", filepointer) + ".jpg");
							
								if(nextImg.exists()){
									
									new SwingWorker<BufferedImage, Void>() {
		
								           
							            @Override protected BufferedImage doInBackground() throws IOException{ 
							                return ImageIO.read( nextImg );
							            } 
							            @Override protected void done() {
							                try { MainClass.iC.setImage( get() ); }
							                catch ( InterruptedException | ExecutionException e) {}
							                
							            }
							            
							        }.execute();    
									
								                    } else { JOptionPane.showMessageDialog(null,"last existing file reached", "Ende", JOptionPane.WARNING_MESSAGE);
								                    			pos(true);		}
								                    	
							                    
						
						
						
						
				     }  else { //ButtonId.equals("back");
				    	 		if(ButtonId.equals("save"))
								return;
				    	         backButton();
						
						
					}
			
			
			
			
		}  else { //WAIT------------------------------------------------------------------------------------------------------------------------------
			
								if(ButtonId.equals("mark")){
									
									timer = System.currentTimeMillis(); 
									
									String cellNr = data.cellNr_gui.getText();
									table = new File("track_" + cellNr + ".txt" );
									
										if(table.exists()) {
											try {
												BufferedWriter puffer = new BufferedWriter(new FileWriter(table, true));
												link = new PrintWriter( puffer );
											
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										} else {
											
											try {
												table.createNewFile();
												BufferedWriter puffer = new BufferedWriter(new FileWriter(table, true));
												link = new PrintWriter( puffer );
												//link.print("FRAME\tX\tY\tID: "+cellNr+"\n\n");
												
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
										}
										
										data.mark_button.setEnabled(false);
										data.save_button.setEnabled(true);
										data.cellNr_gui.setEditable(false);
										MainClass.phase = state.MARK;
										
									
								} else if(ButtonId.equals("next")) {
									
									filepointer++;
									seq++;
									
									data.back_button.setEnabled(true);
									
									data.frameIndex_gui.setText(String.valueOf(seq));
									
									final File nextImg = new File(pathdir + "cell" + String.format("%03d", filepointer) + ".jpg");
									
										if(nextImg.exists()){
											
											new SwingWorker<BufferedImage, Void>() {
				
										           
									            @Override protected BufferedImage doInBackground() throws IOException{ 
									                return ImageIO.read( nextImg );
									            } 
									            @Override protected void done() {
									                try { MainClass.iC.setImage( get() ); }
									                catch ( InterruptedException | ExecutionException e) {}
									                
									            }
									            
									        }.execute();
											
										                    } else { JOptionPane.showMessageDialog(null,"last existing file reached", "Ende", JOptionPane.WARNING_MESSAGE);
										                    			pos(true);		}
									
								} else  {
									
									if(ButtonId.equals("save"))
										return;
									//ButtonId.equals("back");
									backButton();
					    		        }
								
			
		}
		

	}
	
	public void backButton(){
		
		filepointer--;
		seq--;
		pos(false);
		
		data.frameIndex_gui.setText(String.valueOf(seq));
		
		final File lastImg = new File(pathdir + "cell" + String.format("%03d", filepointer) + ".jpg");
		
		if(lastImg.exists()){
			
			new SwingWorker<BufferedImage, Void>() {

		           
	            @Override protected BufferedImage doInBackground() throws IOException{ 
	                return ImageIO.read( lastImg );
	            } 
	            @Override protected void done() {
	                try { MainClass.iC.setImage( get() ); }
	                catch ( InterruptedException | ExecutionException e) {}
	                
	            }
	            
	        }.execute();
			
		                    }
	}
	
	public void openDirectory(String path){
		
		this.pathdir = path.substring(0, path.length()-11);
		this.filepointer = Integer.parseInt(path.substring(path.length()-7, path.length()-4));
		
		}
	
	private void pos(boolean s){
		if(s){data.next_button.setEnabled(false);} else
		{data.next_button.setEnabled(true); }
			
	}

}
