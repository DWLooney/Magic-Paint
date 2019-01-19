package paintwindow;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import drawtools.AbstractTool;
import drawtools.LineTool;

/**
 * JPanel that encompasses the drawing window for the program.
 * Clicking or dragging on this panel will draw lines or shapes depending
 * on the selected tool. MouseEvent listeners determine when to draw something.
 * Also includes behavior for a clear button that is
 * attached to listeners so it can determine whether it should be enabled or not.
 * @author DWLooney
 * @version 17 November 2018
 */
public class DrawPanel extends JPanel {
    
    /** Auto-generated ID for serialization purposes.*/
    private static final long serialVersionUID = -950718375757439961L;
    
    /** Default color for a shape, set to UW Purple according to specification. */
    private static final Color DEFAULT_COLOR = new Color(51, 0, 111);
    
    /** Default width of a stroke before clicking on the thickness slider in the GUI. */
    private static final int DEFAULT_WIDTH = 5;
    
    /** Button that will clear the panel of all shapes when clicked. */
    private final JMenuItem myClearButton;
    
    /** Color of whatever tool needs to be drawn on the panel. */
    private Color myColor;
    
    /** Line thickness of whatever tool needs to be drawn on the panel. */
    private BasicStroke myStroke;
    
    /** Current type of tool that will be used for drawing on the panel. */
    private AbstractTool myCurrTool;
    
    /** 
     * Collection of previous
     * shapes that will drawn on the panel when paintComponent() is called. 
     */
    private List<PaintShape> myShapesPanel;
    
    /**
     * Constructs a DrawPanel according to default behavior.
     * Also initializes the tool type and properties according to specification.
     * Adds two MouseListeners for the purpose of drawing onto the panel.
     */
    public DrawPanel() {
        myClearButton = createClearButton();
        myCurrTool = new LineTool();
        myShapesPanel = new ArrayList<PaintShape>();
        setDefaults();
        this.addMouseListener(new MyMousePressedAdapter());
        this.addMouseMotionListener(new MyMouseMovementAdapter());
    }
    
    /**
     * Behavior for what happens when the panel needs to be updated internally or
     * when the paint() method is called. Will first draw all previous shapes that
     * were created, and then draws the current shape according to where the
     * mouse is currently at.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        
        //Iterates through the array of shapes and sets the appropriate
        //properties of the Graphics2D of the panel for each one.
        for (PaintShape shape : myShapesPanel) {
            g2d.setColor(shape.getColor());
            g2d.setStroke(shape.getStroke());
            g2d.draw(shape.getShape());
        }
        g2d.setColor(myColor);
        g2d.setStroke(myStroke);
        g2d.draw(myCurrTool.getShape());
    }
    
    /**
     * Creates a clear button with an anonymous inner class
     * that acts as the action listener. Will clear the collection
     * of shapes when pressed, and then update the panel to reflect changes.
     * @return Clear button for use in the constructor.
     */
    public JMenuItem createClearButton() {
        final JMenuItem clearButton = new JMenuItem("Clear");     
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myShapesPanel = new ArrayList<PaintShape>();
                clearButton.setEnabled(false);
                repaint();
            }
        });
        return clearButton;
    }
    
    /**
     * Gets the clear button for use by other GUI components.
     * @return Clear button attached to the current DrawPanel being used.
     */
    public JMenuItem getClearButton() {
        return myClearButton;
    }
    
    /**
     * Sets the current type of tool to be used on the DrawPanel.
     * @param theTool Type of tool the DrawPanel should be set to.
     */
    public void setCurrentTool(final AbstractTool theTool) {
        myCurrTool = theTool;
    }
    
    /**
     * Sets the color that should be used when drawing a shape.
     * @param theColor Color of the shape the tool should draw.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * Gets the current color the Panel is set to when a shape is drawn.
     * @return Color the panel is currently set to.
     */
    public Color getColor() {
        return myColor;
    }
    
    /**
     * Sets the thickness the current tool should be drawn at.
     * @param theThickness Thickness the tool should be drawn at.
     */
    public void setStroke(final int theThickness) {
        myStroke = new BasicStroke(theThickness);
    }
    
    /**
     * Helper method to set default parameters the DrawPanel should have.
     * Sets the default cursor, color, thickness, and background.
     */
    public void setDefaults() { 
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        myClearButton.setEnabled(false);
        myColor = DEFAULT_COLOR;
        myStroke = new BasicStroke(DEFAULT_WIDTH);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
    }
    
    /**
     * Listens for if the mouse is being dragged on the panel.
     * Updates appropriate parameters for the tool in use when fired,
     * and then updates the panel.
     */
    public class MyMouseMovementAdapter extends MouseMotionAdapter {
        
        /**
         * Runs whenever the action is fired. Sets the current position of the
         * mouse in the DrawTool.
         * @param theEvent Event that happens whenever the mouse is dragged.
         */
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myCurrTool.setCurrX(theEvent.getX());
            myCurrTool.setCurrY(theEvent.getY());
            repaint();
        }
        
    }
    
    /**
     * Listens for if the mouse is pressed/released on the DrawPanel.
     * Sets behavior for the current tool when the events are fired.
     */
    public class MyMousePressedAdapter extends MouseAdapter {
        
        /**
         * Enables the tool and initializes it to current values if the mouse is 
         * clicked on the panel. 
         * Only enables the tool if the specified thickness is greater than zero.
         * @param theEvent Event that happens whenever the mouse is pressed.
         */
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            //Initializes the values of the tool to current defaults in order to
            //avoid unwanted behavior.
            myCurrTool.setOrigX(theEvent.getX());
            myCurrTool.setOrigY(theEvent.getY());
            myCurrTool.setCurrX(theEvent.getX());
            myCurrTool.setCurrY(theEvent.getY());
            if (myStroke.getLineWidth() > 0) {
                myCurrTool.setEnabled(true);
            }
        }
        
        /**
         * Disables the tool and adds the shape created to a collection for future use
         * by the DrawPanel. Enables the button for clearing the panel since there are shapes
         * to clear now.
         * @param theEvent Event that happens whenever the mouse is released.
         */
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            myShapesPanel.add(new PaintShape(myCurrTool.getShape(), 
                                           new BasicStroke(myStroke.getLineWidth()), myColor));
            myClearButton.setEnabled(true);
            myCurrTool.setEnabled(false);
            repaint();
        }
    }

}
