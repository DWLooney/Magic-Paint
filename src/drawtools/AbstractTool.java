package drawtools;

/**
 * Abstract class that stores common behavior all Paint Tools have.
 * Includes coordinates for where the cursor is/was at various useful locations,
 * as well as getters and setters for all of them.
 * @author DWLooney
 * @version 17 November 2018
 */
public abstract class AbstractTool implements PaintTool {
    
    /** Stores the name of the current tool. */
    private final String myToolName;
    
    /** Stores whether the tool is enabled or not. */
    private boolean myEnabled;
    
    /** Stores the original x value of where the cursor started dragging. */
    private int myOrigX;
    
    /** Stores the original y value of where the cursor started dragging. */
    private int myOrigY;
    
    /** Stores the current x value of the cursor. */
    private int myCurrX;
    
    /** Stores the current y value of the cursor. */
    private int myCurrY;
    
    /** Stores the directly previous x value of the cursor. */
    private int myPrevX;
    
    /** Stores the directly previous y value of the cursor. */
    private int myPrevY;
    
    /**
     * Parent constructor for a Paint Tool. Sets the name and enables it.
     * @param theToolName Name of the Paint Tool passed from subclass constructor.
     */
    public AbstractTool(final String theToolName) {
        
        myToolName = theToolName;
        myEnabled = true;
        myOrigX = -100;
        myOrigY = -100;
        myCurrX = -100;
        myCurrY = -100;
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrX(final int theX) {
        myPrevX = myCurrX;
        myCurrX = theX;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrY(final int theY) {
        myPrevY = myCurrY;
        myCurrY = theY;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOrigX(final int theX) {
        myOrigX = theX;
        myCurrX = theX;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setOrigY(final int theY) {
        myOrigY = theY;
        myCurrY = theY;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getOrigX() {
        return myOrigX;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getOrigY() {
        return myOrigY;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrX() {
        return myCurrX;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrY() {
        return myCurrY;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getPrevX() {
        return myPrevX;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int getPrevY() {
        return myPrevY;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getEnabled() {
        return myEnabled;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnabled(final boolean theEnabled) {
        myEnabled = theEnabled;
    }
    
    /**
     * Returns the name of the tool for debugging purposes.
     * @return Name of the tool for debugging purposes.
     */
    @Override
    public String toString() {
        return myToolName;
    }
    
}
