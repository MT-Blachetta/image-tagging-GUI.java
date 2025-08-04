package GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Main entry point of the image tagging application. The class initialises the
 * graphical user interface and keeps track of global application state such as
 * the current marker position and workflow phase.
 */
public class MainClass {

        /** Stores the last clicked x-coordinate within the image. */
        private static int X;

        /** Stores the last clicked y-coordinate within the image. */
        private static int Y;

        /** Panel containing control buttons and coordinate displays. */
        private static InfoPanel controll;

        /** Component responsible for displaying the current image. */
        public static ImageComponent iC;

        /** Tracks the current phase of the application. */
        public static state phase;


        /**
         * Initialises and displays the application window.
         */
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

        /**
         * Updates the stored coordinates and reflects the new values in the
         * {@link InfoPanel}. Called by the mouse listener whenever the user
         * clicks inside the image.
         */
        public static void updateXY(int x, int y){

                X = x;
                Y = y;

                controll.x_val.setText(String.valueOf(x));
                controll.y_val.setText(String.valueOf(y));

        }

        /**
         * Handles the event of an image being loaded. During the initial phase
         * this method prepares the control panel and determines the directory
         * that contains the image sequence.
         */
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



        /** @return last clicked x-coordinate */
        public static int Xstate(){
                return X;
        }

        /** @return last clicked y-coordinate */
        public static int Ystate(){
                return Y;
        }



}

