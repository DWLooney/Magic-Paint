package drawtools;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

/**
 * Defines behavior for a type of tool that creates a freeform pencil
 * when called.
 * @author Daniel Looney
 * @version 17 November 2018
 */
public final class PencilTool extends AbstractTool {
    
    /** Shape that will be used to store the current freeform. */
    private Path2D.Double myPencilShape;
    
    /**
     * Sets the name for the current tool.
     */
    public PencilTool() {
        super("Pencil Tool");
        myPencilShape = new Path2D.Double();
    }
    
    /**
     * Returns a dynamically created freeform curve that is added to
     * whenever the mouse moves to a new coordinate on the GUI.
     * @return Current state of the freeform shape.
     */
    public Shape getShape() {
        
        if (this.getEnabled()) {
            myPencilShape.append(new Line2D.Double(this.getPrevX(), 
                                                   this.getPrevY(), this.getCurrX(), 
                                                   this.getCurrY()), true);
        } else {
            //Resets the freeform shape when the tool is disabled.
            myPencilShape = new Path2D.Double();
        }
        return myPencilShape;
    }
    
}
