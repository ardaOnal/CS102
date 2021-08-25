package shapes;

import java.util.ArrayList;
import java.util.*;

/**
 * A Shape container class that holds an ArrayList of shapes.
 * @author Arda Onal
 * @version 8.3.2020
 */
public class ShapeContainer implements Iterable
{
   // properties
   public ArrayList<Shape> shapes;

   // constructors
   public ShapeContainer()
   {
      shapes = new ArrayList<Shape>();
   }
   
   // methods
   
   /**
    * Adds a shape to the arraylist
    * @param Shape s is the shape that will be added.
    */
   public void add( Shape s)
   {
      shapes.add( s);
   }
   
   /**
    * Computes the sum of all of the surface areas.
    * @return the total area.
    */
   public double getArea()
   {
      double result;
      
      result = 0;
      
      for ( int i = 0; i < shapes.size(); i++)
         result = result + shapes.get(i).getArea();
      
      return result;  
   }
   
   /**
    * This is the toString method.
    * @return returns the String representation of my object.
    */
   public String toString()
   {
      String result;
      
      result = "This container contains: \n";
      
      for ( int i = 0; i < shapes.size(); i++)
         result = result + shapes.get(i).toString() + "\n";
      
      return result;
   }
   
   /**
    * Returns the size of the arraylist.
    * @return returns the size.
    */
   public int size()
   {
      return shapes.size();
   }
   
   /**
    * Finds the shapes in the given coordiantes.
    * @param int x,y are the cooridantes.
    * @return returns the number of shapes that contain the x and y.
    */
   public int selectAllAt( int x, int y)
   {
      int count;
      count = 0;
      
      for ( int i = 0; i < size(); i++)
      {
         
         if ( ((Selectable)shapes.get(i)).contains( x, y) != null)
         {
            ((Selectable)shapes.get(i)).setSelected( true);
            count++;
         }
      }
      return count;
   }
   
   /**
    * Removes all of the selected shapes.
    */
   public void removeSelected()
   {
      Selectable tmpShape;
      
      for ( int i = 0; i < size(); i++)
      {
         tmpShape = (Selectable) shapes.get(i);
         
         if ( tmpShape.getSelected())
         {
            shapes.remove(i);
            i--;
         }
      }
   }
   
   @Override
   public Iterator iterator()
   {
      return this.shapes.iterator();
   }
   
  
}