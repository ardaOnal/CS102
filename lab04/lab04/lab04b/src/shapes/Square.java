package shapes;

/**
 * A Square class which is a Shape.
 * @author Arda Onal
 * @version 8.3.2020
 */
public class Square extends Rectangle implements Selectable
{
   // properties
   private int side;
   private boolean selected;
   
   
   // constructors
   public Square( int side)
   {
      super( side, side);
      this.side = side;
      selected = false;
   }
   
   // methods
   
   // getArea is inherited from Rectangle.
   
   /**
    * This is the toString method.
    * @return returns the String representation of my object.
    */
   public String toString()
   {
      return "Square with area " + getArea() + " and side with " + side + " that is on (" + getX() + "," + getY() + ") selected: " + getSelected() + ".";
   }
   
   /**
    * Checks if it is selected.
    * @return returns if it is selected or not.
    */
   public boolean getSelected()
   {
      return selected;
   }
   
   /**
    * Allows to select the shape.
    * @param boolean x to select the object.
    */
   public void setSelected( boolean x)
   {
      selected = x;
   }
}