package buttons;

import drawtools.AbstractTool;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import paintwindow.DrawPanel;

/**
 * Holder class for an set of interconnected GUI buttons that
 * both set the same type of tool.
 * @author DWLooney
 * @version 17 November 2018
 */
public final class ToolPair {
    
    /** Button that will be added to the toolbar on the GUI. */
    private final JToggleButton myToolbarButton;
    
    /** Button that will be added to the menu on the GUI. */
    private final JRadioButtonMenuItem myMenuButton;
    
    /** Action that defines shared behavior for both types of buttons. */
    private final ToolAction myAction;

    /**
     * Constructs the pair of tool buttons based on specified values.
     * @param theName Name displayed by the buttons on the GUI.
     * @param theTool Type of tool the buttons should use.
     * @param thePanel DrawPanel that the buttons will perform operations on.
     * @param theSelectedStatus Whether or not the buttons should be selected by default.
     */
    public ToolPair(final String theName, 
                    final AbstractTool theTool, final DrawPanel thePanel,
                    final boolean theSelectedStatus) {
        myAction = new ToolAction(theName, thePanel, theTool);
        myMenuButton = new JRadioButtonMenuItem(myAction);
        myToolbarButton = new JToggleButton(myAction);
        myMenuButton.setSelected(theSelectedStatus);
        myToolbarButton.setSelected(theSelectedStatus);
    }
    
    /**
     * Returns a JToggleButton representation of the tool button.
     * @return Button to be used on a toolbar.
     */
    public JToggleButton getToolbarButton() {
        return myToolbarButton;
    }

    /**
     * Returns a radio button representation of the tool button.
     * @return Radio Button to be used on a menu.
     */
    public JRadioButtonMenuItem getMenuButton() {
        return myMenuButton;
    }
}
