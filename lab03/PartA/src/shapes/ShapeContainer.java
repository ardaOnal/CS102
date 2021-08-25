package shapes;

import java.util.ArrayList;

/**
 * A Shape container class that holds an ArrayList of shapes.
 * @author Arda Onal
 * @version 8.3.2020
 */
public class ShapeContainer 
{
   // properties
   ArrayList<Shape> shapes;

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
   public int getSize()
   {
      return shapes.size();
   }
   
   /**
    * Finds the first shape in the given coordiantes.
    * @param int x,y are the cooridantes.
    * @return returns the shape.
    */
   public Shape findShape( int x, int y)
   {
      for ( int i = 0; i < getSize(); i++)
      {
         if ( shapes.get(i).contains( x, y))
         {
            shapes.get(i).setSelected( true);
            return shapes.get(i);
         }
      }
      
      return null;
   }
   
   /**
    * Removes all of the selected shapes.
    */
   public void removeAll()
   {
      for ( int i = 0; i < getSize(); i++)
      {
         if ( shapes.get(i).getSelected())
         {
            shapes.remove(i);
         }
      }
   }
}