package gui;
import buttons.ColorChooserButton;
import buttons.ToolPair;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToolBar;
import paintwindow.DrawPanel;

/**
 * Creates the toolbar for the GUI that holds buttons for each type of tool.
 * @author DWLooney
 * @version 17 November 2018
 */
public final class PaintToolBar extends JToolBar {
    
    /**
     * Auto-Generated Serial UID for serialization.
     */
    private static final long serialVersionUID = 3113642693071835146L;

    /** DrawPanel for operations to be performed upon. */
    private final DrawPanel myPanel;
    
    /** Group of buttons for the drawing tools to ensure only one is selected at a time. */
    private final ButtonGroup myButtonGroup;

    /**
     * Constructs the Toolbar and adds all its necessary tools.
     * @param theToolPairs Tool buttons that will be added to the menu.
     * @param thePanel Panel for operations to be performed on.
     */
    public PaintToolBar(final ArrayList<ToolPair> theToolPairs, final DrawPanel thePanel) {
        super();
        myButtonGroup = new ButtonGroup();
        myPanel = thePanel;
        
        //Creates a button group by grabbing the JToggleButton version for each tool button
        //And adding it to the group.
        for (ToolPair pairs : theToolPairs) {
            myButtonGroup.add(pairs.getToolbarButton());
        }
        add(new ColorChooserButton(myPanel, "JToggleButton").getButton());
        
        //Adds each button in the button group to the toolbar.
        for (Enumeration<AbstractButton> e = 
                        myButtonGroup.getElements(); e.hasMoreElements();) {
            add(e.nextElement());
        }
    }

}
