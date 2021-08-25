package shapes;

/**
 * A Rectangle class which is a Shape.
 * @author Arda Onal
 * @version 8.3.2020
 */
public class Rectangle extends Shape implements Selectable
{
   // properties
   private int width;
   private int length;
   private boolean selected;
   
   // constructors
   public Rectangle( int width, int length)
   {
      this.width = width;
      this.length = length;
      selected = false;
      
   }
   
   // methods
   public double getArea()
   {
      return width * length;
   }
   
   /**
    * This is the toString method.
    * @return returns the String representation of my object.
    */
   public String toString()
   {
      return "Rectangle with area " + getArea() + " and sides with " + width + ", " + length + ", selected: " + getSelected() + ".";
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
      
      semiDiagonal = Math.sqrt((width/2)*(width/2) + (length/2)*(length/2));
      
      return distance <= semiDiagonal;
   }
   
   
   
}