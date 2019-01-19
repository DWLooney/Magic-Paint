package gui;

/**
 * Wrapper class that holds the GUI and all of its associated behavior.
 * Also makes sure that the GUI is only set to be visible after everything else
 * has been constructed.
 * Also sets the name of the program when called by the driver.
 * @author DWLooney
 * @version 17 November 2018
 */
public final class GUI {  
    
    /** Stores the GUI of the program. */
    private PaintFrame myFrame;
    
    /**
     * Constructs the GUI of the program with the specified name.
     */
    public GUI() {
        myFrame = new PaintFrame("Magic Paint");
    }
    
    /**
     * Sets the GUI to be enabled only when everything else is finished loading.
     */
    public void start() {
        myFrame.setVisible(true);
    }
}
    