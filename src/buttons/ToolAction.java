package buttons;

import drawtools.AbstractTool;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import paintwindow.DrawPanel;

/**
 * Base Action for Paint Tool buttons.
 * Creates basic behavior for a pair of PaintTool buttons,
 * including label and icon, operating on the given DrawPanel.
 * @author DWLooney 
 * @version 17 November 2018
 */
public final class ToolAction extends AbstractAction {
    
    /**
     * Auto-Generated Serial UID for serialization.
     */
    private static final long serialVersionUID = 6168055437012233809L;
    
    /**
     * DrawPanel that the ToolAction will change the tool for when fired.
     */
    private final DrawPanel myDrawPanel;
    
    /** Tool to set the DrawPanel to when the action is fired. */
    private final AbstractTool myTool;

    /**
     * Constructs the Action given DrawPanel to perform operations on,
     * type of tool to create for the button, as well as name of the tool.
     * @param theName Name to set the label of the buttons to.
     * @param theDrawPanel DrawPanel to change the tool of.
     * @param theTool Type of Paint Tool to attach to the action.
     */
    protected ToolAction(final String theName, 
                         final DrawPanel theDrawPanel, final AbstractTool theTool) { 

        super(theName, new ImageIcon("resources/" + theName.toLowerCase() + ".gif"));
        myDrawPanel = theDrawPanel;
        myTool = theTool;
        
    }

    /**
     * 
     */
    
    /**
     * Sets the tool for the DrawPanel when the event is fired.
     * Will synchronize buttons if more than one is listening to
     * the same ToolAction.
     * @param theEvent Parent component of the ActionListener.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myDrawPanel.setCurrentTool(myTool);
        putValue(SELECTED_KEY, true);

    }


}
