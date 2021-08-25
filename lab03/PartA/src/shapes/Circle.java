package shapes;

/**
 * A Circle which is a Shape
 * @author Arda Onal
 * @version 8.3.2020
 */
public class Circle extends Shape implements Selectable
{
   // properties
   private int radius;
   private boolean selected;
   
   // constructors
   public Circle( int radius)
   {
      this.radius = radius;
      selected = false;
   }
   
   // methods
   
   /**
    * This method computes the area of a circle
    * @return returns the area.
    */
   public double getArea()
   {
      return Math.PI * radius * radius;
   }
   
   /**
    * This is the toString method.
    * @return returns the String representation of my object.
    */
   public String toString()
   {
      return "Circle with area " + getArea() + " and radius with " + radius + ", selected: " + getSelected() + ".";
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
      double distance;
      
      distance = Math.sqrt( ((this.getX() - x) * (this.getX() - x)) + ((this.getY() - y) * (this.getY() - y)));
      
      return distance <= radius;
   }
   
   
}
