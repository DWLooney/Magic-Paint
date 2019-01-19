package drawtools;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

/**
 * Defines behavior for a type of tool that creates a rectangle
 * when called.
 * @author Daniel Looney
 * @version 17 November 2018
 */
public final class RectangleTool extends AbstractTool {
    
    /** Shape that will be used to store the current rectangle. */
    private Shape myRectangle;
    
    /**
     * Sets the name for the current tool.
     */
    public RectangleTool() {
        super("Rectangle Tool");
    }
    
    /**
     * Returns a rectangle based on the current positions of the mouse.
     * There is seperate behavior for each case of the current position of the mouse
     * and original position of the mouse when the shape was first started to be drawn.
     * @return Shape that will be drawn by the GUI on update.
     */
    public Shape getShape() {
        if (this.getEnabled()) {
            if (getOrigX() < getCurrX() && getOrigY() < getCurrY()) { 
                //Quadrant IV (Down and right)
                myRectangle = new Rectangle2D.Double(getOrigX(), getOrigY(), 
                                                     getCurrX() - getOrigX(), 
                                                     getCurrY() - getOrigY());
            } else if (getOrigX() > getCurrX() && getOrigY() < getCurrY()) {
                //Quadrant III (Down and left)
                myRectangle = new Rectangle2D.Double(getCurrX(), getOrigY(), 
                                                     getOrigX() - getCurrX(), 
                                                     getCurrY() - getOrigY());
            } else if (getOrigX() < getCurrX() && getOrigY() > getCurrY()) {
                //Quadrant I (Up and right)
                myRectangle = new Rectangle2D.Double(getOrigX(), getCurrY(), 
                                                     getCurrX() - getOrigX(), 
                                                     getOrigY() - getCurrY());
            } else {
                //Quadrant II (Up and left)
                myRectangle = new Rectangle2D.Double(getCurrX(), getCurrY(), 
                                                     getOrigX() - getCurrX(), 
                                                     getOrigY() - getCurrY());
            }
        } else {
            myRectangle = new Path2D.Double();
        }
        return myRectangle;
    }

}
