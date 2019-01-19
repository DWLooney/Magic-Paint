package drawtools;

import java.awt.Shape;

/**
 * @author Daniel Looney
 * @version 17 November 2018
 */
public interface PaintTool {

    /** 
     * Sets the X value of where the cursor currently is.
     * @param theX X value to set where the cursor is.
     */
    void setCurrX(int theX);
    
    /** 
     * Sets the Y value of where the cursor currently is.
     * @param theY Y value to set where the cursor is.
     */
    void setCurrY(int theY);
    
    /** 
     * Sets the original X value of where the cursor started dragging.
     * @param theX X value set when the DrawPanel is pressed at a location.
     */
    void setOrigX(int theX);
    
    /** 
     * Sets the original Y value of where the cursor started dragging.
     * @param theY Y value set when the DrawPanel is pressed at a location.
     */
    void setOrigY(int theY);
    
    /** 
     * gets the original X value of where the cursor started dragging.
     * @return X value of where the cursor started dragging.
     */
    int getOrigX();
    
    /** 
     * gets the original Y value of where the cursor started dragging.
     * @return Y value of where the cursor started dragging.
     */
    int getOrigY();
    
    /** 
     * Gets the X value of where the cursor currently is.
     * @return X value of where the cursor currently is.
     */
    int getCurrX();
    
    /** 
     * Gets the Y value of where the cursor currently is.
     * @return Y value of where the cursor currently is.
     */
    int getCurrY();
    
    /** 
     * Gets the X coordinate of where the cursor was 
     * directly before where it is currently at. 
     * @return X coordinate of directly previous point from cursor.
     */
    int getPrevX();
    
    /** 
     * Gets the Y coordinate of where the cursor was 
     * directly before where it is currently at. 
     * @return Y coordinate of directly previous point from cursor.
     */
    int getPrevY();
    
    /** 
     * Gets whether the tool will currently draw something or not. 
     * @return Whether the tool is enabled or not.
     */
    boolean getEnabled();
    
    /** 
     * Sets whether the tool will draw something or not. 
     * Will draw an empty shape if disabled. 
     * @param theEnabled Boolean to set the enabled status to.
     */
    void setEnabled(boolean theEnabled);
    
    /**
     * Returns a shape drawn by the tool given the cursor's original coordinates,
     * current coordinates, and directly previous coordinates.
     * @return Shape Drawn by the tool given cursor coordinates.
     */
    Shape getShape();
}
