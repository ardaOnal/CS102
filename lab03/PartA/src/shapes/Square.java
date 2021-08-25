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
      return "Square with area " + getArea() + " and side with " + side + ", selected: " + getSelected() + ".";
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
   
   /**
    * Allows to select the shape.
    * @param int x,y are the coordinates.
    * @return true or false if it contains.
    */
   public boolean contains( int x, int y)
   {
      double semiDiagonal;
      double distance;
      
      distance = Math.sqrt( ((this.getX() - x) * (this.getX() - x)) + ((this.getY() - y) * (this.getY() - y)));
      
      semiDiagonal = Math.sqrt(2 * (side/2)*(side/2));
      
      return distance <= semiDiagonal;
   }
}