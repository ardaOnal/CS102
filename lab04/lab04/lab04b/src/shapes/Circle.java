package shapes;

import java.awt.*;

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
      return Math.round(100 * Math.PI * radius * radius) / 100.0;
   }
   
   /**
    * This is the toString method.
    * @return returns the String representation of my object.
    */
   public String toString()
   {
      return "Circle with area " + getArea() + " and radius with " + radius + " that is on (" + getX() + "," + getY() + ") selected: " + getSelected() + ".";
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
   public Shape contains( int x, int y)
   {
      double distance;
      
      distance = Math.sqrt( ((this.getX() - x) * (this.getX() - x)) + ((this.getY() - y) * (this.getY() - y)));
      
      if (distance <= radius)
      {
         return this;
      }
      else
      {
         return null;
      }
   }
   
}
