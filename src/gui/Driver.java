package gui;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Runs the program by creating and starting the GUI.
 * @author Daniel Looney
 * @version 17 November 2018
 */
public final class Driver {

    /** Private constructor to prevent external creation of the class.*/
    private Driver() {
        throw new IllegalStateException();
    }
    /**
     * Main method that invokes the GUI. 
     * @param theArgs Command line paramaters.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (final ClassNotFoundException 
                                | InstantiationException | IllegalAccessException
                                | UnsupportedLookAndFeelException e) {
                    System.err.println("Metal Look and Feel is unsupported. Using defaults!");
                }
                new GUI().start();
            }
        });

    }

}
