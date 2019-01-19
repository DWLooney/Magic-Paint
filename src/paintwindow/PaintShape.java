package paintwindow;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * Creates a shape in the form of a Path2D that holds information
 * about the color and thickness.
 * @author DWLooney
 * @version 17 November 2018
 */
public final class PaintShape {

    /** Stores the coordinates of the shape to be drawn. */
    private final Path2D.Double myShape;
    
    /** Stores the thickness of the shape. */
    private final BasicStroke myStroke;
    
    /** Stores the color of the shape. */
    private final Color myColor;
    
    /**
     * Constructs the shape based on the specified color and thickness.
     * @param theShape Shape to be stored when created.
     * @param theStroke Thickness the shape should be when drawn.
     * @param theColor Color the shape should be when drawn.
     */
    public PaintShape(final Shape theShape, 
                      final BasicStroke theStroke, final Color theColor) {
        myShape = new Path2D.Double(theShape);
        myStroke = new BasicStroke(theStroke.getLineWidth());
        myColor = theColor;
    }
    
    /**
     * Gets the coordinates of the shape to be drawn.
     * @return Coordinates of the shape to be drawn.
     */
    public Path2D.Double getShape() {
        return myShape;
    }
    
    /**
     * Gets the thickness of the shape to be drawn.
     * @return Thickness of the shape to be drawn.
     */
    public BasicStroke getStroke() {
        return myStroke;
    }
    
    /**
     * Gets the color of the shape to be drawn.
     * @return Color of the shape to be drawn.
     */
    public Color getColor() {
        return myColor;
    }
}
