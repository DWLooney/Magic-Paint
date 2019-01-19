package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import buttons.ToolPair;
import drawtools.EllipseTool;
import drawtools.LineTool;
import drawtools.PencilTool;
import drawtools.RectangleTool;
import paintwindow.DrawPanel;

/**
 * Encompassing JFrame class that hold all components of the GUI.
 * @author DWLooney
 * @version 17 November 2018
 */
public final class PaintFrame extends JFrame {
    
    /**
     * Auto-Generated Serial UID for serialization.
     */
    private static final long serialVersionUID = -1669148806574221826L;
    
    /** List of all tools and their associated buttons. */
    private ArrayList<ToolPair> myToolPairs;
    
    /** Panel that will be used for drawing. */
    private DrawPanel myPanel;

    /**
     * Constructs the JFrame based on default specifications.
     * Adds all components and their associated buttons.
     * @param theName Name the GUI should be set to.
     */
    public PaintFrame(final String theName) {
        super(theName);

        myToolPairs = new ArrayList<ToolPair>();
        myPanel = new DrawPanel();
        createToolPairs();
        setDefaults();
        addComponents();
    }
    
    /**
     * Helper method to Create a pair of buttons for all tools that will be added to the GUI.
     * Any tools added to this method will be reflected in the appropriate GUI components.
     * This is the only place where tools should be added.
     */
    public void createToolPairs() {
        myToolPairs.add(new ToolPair("Line", new LineTool(), myPanel, true));
        myToolPairs.add(new ToolPair("Pencil", new PencilTool(), myPanel, false));
        myToolPairs.add(new ToolPair("Rectangle", new RectangleTool(), myPanel, false));
        myToolPairs.add(new ToolPair("Ellipse", new EllipseTool(), myPanel, false));
    }
    
    /**
     * Sets default behavior for the GUI based on assignment specifications.
     * Will set the default screen size, icon, centers the program, and makes sure
     * the program closes properly on exit.
     */
    public void setDefaults() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth() / 3, (int) screenSize.getHeight() / 3);
        setIconImage(new ImageIcon("resources/PaintIcon_Small.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Helper method to add the drawing panel, toolbar, and menu to the GUI.
     */
    public void addComponents() {
        add(myPanel, BorderLayout.CENTER);
        add(new PaintToolBar(myToolPairs, myPanel), BorderLayout.SOUTH);
        setJMenuBar(new PaintMenuBar(myToolPairs, myPanel));
    }
    
    /**
     * Returns the drawing panel in use by the GUI that operations
     * will be performed upon.
     * @return DrawPanel that operations will be performed on.
     */
    public DrawPanel getPanel() {
        return myPanel;
    }

}
