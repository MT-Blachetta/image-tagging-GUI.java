package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Action responsible for opening an image file. The selected image is displayed
 * in the {@link ImageComponent} and triggers further initialisation steps in
 * {@link MainClass}.
 */
class FileOpenAction extends AbstractAction{

    private static boolean first;

    private static final long serialVersionUID = -3145474943695366063L;

    private final ImageComponent viewComponent;

    public FileOpenAction( ImageComponent viewComponent){

        first = true;

            this.viewComponent = viewComponent;

        putValue(NAME, "Öffnen");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_0, InputEvent.CTRL_DOWN_MASK) );
        putValue(MNEMONIC_KEY, (int) 'f');

    }

    /**
     * Opens a file chooser and loads the selected image asynchronously. On the
     * first invocation the mouse listener for capturing clicks is also
     * registered.
     */
    @Override public void actionPerformed( ActionEvent e){

        System.out.println("Bild wird versucht zu öffnen");

        if(first){

                ImageListener me = new ImageListener();
            MainClass.iC.addMouseListener(me);
            first = false;

        }

    JFileChooser fileDialog = new JFileChooser();
    fileDialog.setFileFilter( new FileNameExtensionFilter("*.jpg;*.gif", "jpg", "gif") );
    fileDialog.showOpenDialog( viewComponent );
    final File file = fileDialog.getSelectedFile();

    if (file != null){

        System.out.println("Es hat geklappt !");

        new SwingWorker<BufferedImage, Void>() {


            @Override protected BufferedImage doInBackground() throws IOException{
                return ImageIO.read( file );
            }
            @Override protected void done() {
                try { viewComponent.setImage( get() ); }
                catch ( InterruptedException | ExecutionException e) {}

            }

        }.execute();
    }

    System.out.println("Hauptmethode");
    MainClass.imageLoaded(file.getAbsolutePath());

    }

}

