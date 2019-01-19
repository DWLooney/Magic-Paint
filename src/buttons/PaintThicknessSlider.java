package buttons;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import paintwindow.DrawPanel;

/**
 * Creates a slider that will set the tools for a DrawPanel to a chosen thickness.
 * @author DWLooney 
 * @version 17 November 2018
 */
public final class PaintThicknessSlider extends JSlider implements ChangeListener {
    
    /**
     * Auto-Generated Serial UID for serialization.
     */
    private static final long serialVersionUID = -6937068013647503782L;
    
    /**
     * DrawPanel for operations to be performed upon.
     */
    private final DrawPanel myDrawPanel;

    /**
     * Constructs the slider and sets up the listener and behavior.
     * @param thePanel DrawPanel for operations to be performed upon.
     */
    public PaintThicknessSlider(final DrawPanel thePanel) {
        myDrawPanel = thePanel;
        addChangeListener(this);
        setParams();
    }

    /**
     * Sets the default behavior for the JSlider
     * according to assignment instructions.
     */
    public void setParams() {
        setMinimum(0);
        setMaximum(15);
        setMajorTickSpacing(5);
        setMinorTickSpacing(1);
        setPaintTicks(true);
        setPaintLabels(true);
        setValue(5);
    }
    
    /**
     * State listener for the JSlider. Will change the thickness
     * of the given DrawPanel on state change.
     * @param theEvent parent component for the StateListener.   
     */
    public void stateChanged(final ChangeEvent theEvent) {
        myDrawPanel.setStroke(getValue());
    }

}
