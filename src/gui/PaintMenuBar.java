package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import buttons.ColorChooserButton;
import buttons.PaintThicknessSlider;
import buttons.ToolPair;
import paintwindow.DrawPanel;

/**
 * Creates the menu bar for the GUI and all its related components.
 * Includes buttons for color, thickness, clearing, the tools, and an about button.
 * @author DWLooney
 * @version 17 November 2018
 */
public final class PaintMenuBar extends JMenuBar {
    
    /**
     * Auto-Generated Serial UID for serialization.
     */
    private static final long serialVersionUID = 2993161445581846877L;
    
    /** Group of buttons for the drawing tools to ensure only one is selected at a time. */
    private final ButtonGroup myToolButtonGroup;
    
    /** Drawing panel for the menu to perform operations on. */
    private final DrawPanel myDrawPanel;

    /**
     * Constructs the MenuBar and adds all its necessary components.
     * @param theToolPairs Tool buttons that will be added to the menu.
     * @param thePanel Panel for operations to be performed on.
     */
    public PaintMenuBar(final ArrayList<ToolPair> theToolPairs, final DrawPanel thePanel) {
        myDrawPanel = thePanel;

        //Creates a button group by grabbing the JMenuItem version for each tool button
        //And adding it to the group.
        myToolButtonGroup = new ButtonGroup();
        for (ToolPair pair : theToolPairs) {
            myToolButtonGroup.add(pair.getMenuButton());
        }
        add(createOptionsDropDown());
        add(createToolsDropDown());
        add(createHelpDropDown());
        
    }
    
    /**
     * Creates a drop-down that holds various options for the GUI.
     * Includes a slider for thickness, a clear button, and a color chooser button.
     * @return Drop-down that holds all the options buttons.
     */
    public JMenu createOptionsDropDown() {
        final JMenu options = new JMenu("Options");
        final JMenu thicknessSliderContainer = new JMenu("Thickness");
        thicknessSliderContainer.add(new PaintThicknessSlider(myDrawPanel));
        options.add(thicknessSliderContainer);
        options.addSeparator();
        //Will create a new color chooser dialogue each time the button is pressed.
        options.add(new ColorChooserButton(myDrawPanel, "JMenuItem").getButton());
        options.addSeparator();
        options.add(myDrawPanel.getClearButton());
        return options;
    }
    
    /**
     * Creates a drop-down of radio buttons that holds each type of tool necessary.
     * @return Drop-down that holds all the tool buttons.
     */
    public JMenu createToolsDropDown() {
        final JMenu tools = new JMenu("Tools");
        //Grabs each button from the ButtonGroup and adds it to the drop-down.
        for (Enumeration<AbstractButton> e = 
                        myToolButtonGroup.getElements(); e.hasMoreElements();) {
            tools.add(e.nextElement());
        }
        return tools;
    }
    
    /**
     * Creates a drop-down that holds an about button.
     * When the about button is pressed, a dialogue window will be shown with the icon
     * of the program and basic information about it.
     * @return Drop-down that holds an about button.
     */
    public JMenuItem createHelpDropDown() {
        final JMenu help = new JMenu("Help");
        final JMenuItem helpButton = new JMenuItem("About...");
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(helpButton, 
                                              "Created By:\n Daniel Looney", 
                                              "Magic Paint", 
                                              JOptionPane.OK_OPTION, 
                                              new ImageIcon("resources/PaintIcon_Large.png"));
            }
        });
        help.add(helpButton);
        return help;
    }
}
