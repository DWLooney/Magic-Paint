package buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import paintwindow.DrawPanel;

/**
 * Creates a button that when pressed returns
 * a color chosen by the user. Will create two types
 * of buttons depending on the param when constructed.
 * @author DWLooney 
 * @version 17 November 2018
 */
public final class ColorChooserButton implements ActionListener {
    
    /** Constant storing the default label of the button. */
    private static final String DEFAULT_LABEL = "Color...";
    
    /** Stores the actual button used by the class. */
    private AbstractButton myButton;

    /** DrawPanel for the button to perform operations on. */
    private final DrawPanel myPanel;
    
    /**
     * Constructs a new ColorChooserButton that operates on the
     * given panel and is of the given type. If given an invalid button type,
     * will default to JButton.
     * @param thePanel DrawPanel for the button to perform operations on.
     * @param theButtonType Type of button to create when constructed.
     */
    public ColorChooserButton(final DrawPanel thePanel, final String theButtonType) {
        
        myPanel = thePanel;
        myButton = new JButton();
        if ("JMenuItem".equals(theButtonType)) {
            myButton = new JMenuItem(DEFAULT_LABEL);
        } else if ("JToggleButton".equals(theButtonType)) {
            myButton = new JButton(DEFAULT_LABEL);
        }
        myButton.addActionListener(this);
        
    }
    
    /**
     * Returns a button of the chosen type that contains a Color Chooser.
     * @return Button that will allow the user to choose a color from a color picker.
     */
    public AbstractButton getButton() {
        return myButton;
    }
    
    /**
     * Behavior for when the button is pressed.
     * Will open a JColorChooser dialog that returns the color
     * to set the operations for the given panel to.
     * @param theEvent parent component for the ActionListener method.
     */
    public void actionPerformed(final ActionEvent theEvent) {
        final Color colorToSet = JColorChooser.showDialog(myButton, 
                                                    "Simple Paint", myPanel.getColor());
        if (colorToSet != null) {
            myPanel.setColor(colorToSet);
        }
    }

}
