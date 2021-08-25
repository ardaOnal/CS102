import java.util.Scanner;
import shapes.Circle;
import shapes.Square;
import shapes.Rectangle;
import shapes.Shape;
import shapes.ShapeContainer;

/**
 * A ShapeTester menu with a given menu.
 * @author Arda Onal
 * @version 8.3.2020
 */
public class ShapeTester
{
   public static void main( String[] args)
   {
      // constants
      
      // variables
      String input, input2;
      int radius;
      int width;
      int length;
      int side;
      int x,y;
      ShapeContainer shapes;
      
      // program code
      Scanner scan = new Scanner( System.in);
      shapes = null;
      radius = 0;
      width = 0;
      length = 0;
      side = 0;
      x = 0;
      y = 0;
      input = "0";
      input2 = "0";
      
      System.out.println( "Hello, welcome to my program.");
      do
      {
         System.out.println();
         System.out.println( "(1) Create an empty set of shapes.");
         System.out.println( "(2) To add shapes.");
         System.out.println( "(3) Compute & print out the total surface area of the entire set of shapes.");
         System.out.println( "(4) Print out information about all of the shapes in the container");
         System.out.println( "(5) Find the first Shape that contains a given x, y point");
         System.out.println( "(6) Remove all selected shapes from the set of shapes");
         System.out.println( "(7) To quit.");
         System.out.println( "Pick an option: ");
         input = scan.next();
         
         // (1) Create an empty set of shapes (ShapeContainer).
         if ( input.equals( "1"))
         {
            System.out.println( "Creating a new ShapeContainer...");
            
            shapes = new ShapeContainer();
         }
         
         // (2) To add shapes.
         else if ( input.equals( "2"))
         {
            if ( shapes == null)
               System.out.println( "Error, container is not initialized.");
            else
            {
               do
               {
                  System.out.println();
                  System.out.println( "|Adding shape menu|");
                  System.out.println( "(1)Add a circle.");
                  System.out.println( "(2)Add a rectangle.");
                  System.out.println( "(3)Add a square.");
                  System.out.println( "(4)Go to main menu.");
                  System.out.println( "Pick an option: ");
                  input2 = scan.next();
                  
                  // Adding a circle
                  if ( input2.equals( "1"))
                  {
                     System.out.println( "Enter a radius:");
                     radius = scan.nextInt();
                     
                     if ( radius <= 0)
                     {
                        System.out.println( "Error, enter a valid radius.");
                     }
                     else
                     {
                        shapes.add( new Circle( radius));
                        System.out.println( "Circle with radius " + radius  + " has been added.");
                     }
                  }
                  
                  // Adding a rectangle
                  else if ( input2.equals( "2"))
                  {
                     System.out.println( "Enter a width.");
                     width = scan.nextInt();
                     
                     System.out.println( "Enter a length.");
                     length = scan.nextInt();
                     
                     if ( width <= 0 || length <= 0)
                     {
                        System.out.println( "Error, enter valid sides.");
                     }
                     else
                     {
                        shapes.add( new Rectangle( width, length));
                        System.out.println( "Rectangle with sides " + width + ", " + length + " has been added.");
                     }
                  }
                  
                  // Adding a square
                  else if ( input2.equals( "3"))
                  {
                     System.out.println( "Enter a side.");
                     side = scan.nextInt();
                     
                     if ( side <= 0)
                     {
                        System.out.println( "Error, enter a valid side.");
                     }
                     else
                     {
                        shapes.add( new Square( side));
                        System.out.println( "Square with side " + side + " has been added.");
                     }
                  }
                  
                  // If the input is invalid
                  else if ( !input2.equals( "4"))
                  {
                     System.out.println( "Error: Enter a valid input.");
                  }
                  
               } while ( !input2.equals("4"));
            }
         }
         
         // (3) Compute & print out the total surface area of the entire set of shapes.
         else if ( input.equals( "3"))
         {
            if ( shapes == null)
               System.out.println( "Error, container is not initialized.");
            else
            {
               System.out.println( "Total surface area of the entire set of shapes:");
               System.out.println( shapes.getArea());
            }
            
         }
         
         // (4) Print out information about all of the shapes in the container
         else if ( input.equals( "4"))
         {
            if ( shapes == null)
               System.out.println( "Error, container is not initialized.");
            else
            {
               System.out.println( shapes.toString());
            }
         }
         
         else if ( input.equals( "5"))
         {
            if ( shapes == null)
               System.out.println( "Error, container is not initialized.");
            else
            {
               System.out.println( "To find the first Shape that contains a given x, y point, enter 2 integers:");
               x = scan.nextInt();
               y = scan.nextInt();
               
               if ( shapes.findShape( x,y) == null)
                  System.out.println( "No shape is in that coordiantes.");
               else
               {
                  System.out.println( "The shape is: " + shapes.findShape( x,y));
               }
            }
         }
         
         else if ( input.equals( "6"))
         {
            if ( shapes == null)
               System.out.println( "Error, container is not initialized.");
            else
            {
               System.out.println( "Removing all selected shapes...");
               shapes.removeAll();
            }
         }
         
         // If the input is invalid.
         else if ( !input.equals( "7"))
         {
            System.out.println( "Error: Enter a valid input.");
         }
         
      } while( !input.equals( "7"));
      
      System.out.println( "Done.");
   }
} // end of class ShapeTester.