package drawtools;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

/**
 * Defines behavior for a type of tool that creates an ellipse
 * when called.
 * @author DWLooney
 * @version 17 November 2018
 */
public final class EllipseTool extends AbstractTool {
    
    /** Shape that will be used to store the current ellipse. */
    private Shape myEllipse;
    
    /**
     * Sets the name for the current tool.
     */
    public EllipseTool() {
        super("Ellipse Tool");
    }
    
    /**
     * Returns an ellipsoid based on the current positions of the mouse.
     * There is seperate behavior for each case of the current position of the mouse
     * and original position of the mouse when the shape was first started to be drawn.
     * @return Shape that will be drawn by the GUI on update.
     */
    public Shape getShape() {
        if (this.getEnabled()) {
            if (getOrigX() < getCurrX() && getOrigY() < getCurrY()) { 
                //Quadrant IV (Down and right)
                myEllipse = new Ellipse2D.Double(getOrigX(), 
                                                 getOrigY(), getCurrX() - getOrigX(), 
                                                 getCurrY() - getOrigY());
            } else if (getOrigX() > getCurrX() && getOrigY() < getCurrY()) { 
                //Quadrant III (Down and left)
                myEllipse = new Ellipse2D.Double(getCurrX(), 
                                                 getOrigY(), getOrigX() - getCurrX(), 
                                                 getCurrY() - getOrigY());  
            } else if (getOrigX() < getCurrX() && getOrigY() > getCurrY()) { 
                //Quadrant I (Up and right)
                myEllipse = new Ellipse2D.Double(getOrigX(), 
                                                 getCurrY(), getCurrX() - getOrigX(), 
                                                 getOrigY() - getCurrY());
            } else { 
                //Quadrant II (Up and left)
                myEllipse = new Ellipse2D.Double(getCurrX(), 
                                                 getCurrY(), getOrigX() - getCurrX(), 
                                                 getOrigY() - getCurrY());
            }
        } else {
            return new Path2D.Double();
        }
        return myEllipse;
    }

}
