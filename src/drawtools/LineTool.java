package drawtools;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

/**
 * Defines behavior for a type of tool that creates a line
 * when called.
 * @author Daniel Looney
 * @version 17 November 2018
 */
public final class LineTool extends AbstractTool {
    
    /** Shape that will be used to store the current line. */
    private Shape myLine;
    
    /**
     * Sets the name for the current tool.
     */
    public LineTool() {
        super("Line Tool");
    }
    
    /**
     * Returns a line from the origin of when the mouse was pressed to
     * the current position of the mouse.
     * @return Shape that will be drawn by the GUI on update.
     */
    public Shape getShape() {
        if (this.getEnabled()) {
            myLine = new Line2D.Double(this.getOrigX(), 
                                       this.getOrigY(), this.getCurrX(), this.getCurrY());
        } else {
            myLine = new Path2D.Double();
        }
        return myLine;
    }
    
}
