import java.util.Scanner;

/**
 * A simple Menu class.
 * @author Arda Onal
 * @version 15.02.2020
 */
public class Menu
{
   public static void main( String[] args)
   {
      // constants
      
      // variables
      IntBag bag;
      int input;
      int index;
      int testValue;
      
      // program code
      Scanner scan = new Scanner( System.in);
      input = 0;
      testValue = 1;
      bag = new IntBag();
      
      // Printing the menu
      System.out.println( "1. Create a new empty collection with a specified maximum capacity (any previous values are lost!");
      System.out.println( "2. Read a set of positive values into the collection (use a negative value to indicate all the values have been entered.");
      System.out.println( "3. Print the collection of values.");
      System.out.println( "4. Add a value to the collection of values at a specified location.");
      System.out.println( "5. Remove the value at a specified location from the collection of values.");
      System.out.println( "6. Read a single test value.");
      System.out.println( "7. Compute the set of locations of the test value within the collection.");
      System.out.println( "8. Print the set of locations.");
      System.out.println( "9. Quit the program.");
      
      do
      {
         System.out.println( "Select an option:");
         input = scan.nextInt();
         
         // To create a bag of integers
         if ( input == 1)
         {
            System.out.println( "To create a bag of integers, please enter a value:");
            testValue = scan.nextInt();
            bag = new IntBag( testValue);
         }
         // Adding multiple 
         else if ( input == 2)
         {
            System.out.println( " Enter positive values, negative to stop.");
            while ( testValue >= 0)
            {
               if ( scan.hasNextInt())
               {
                  testValue = scan.nextInt();
                  if ( testValue >= 0)
                     bag.add( testValue);
               }
               else
                  System.out.println( "enter an INTEGER idiot.");
            }
         }
         // To print out the values.
         else if ( input == 3)
         {
            System.out.println( "The collection of integers: ");
            System.out.println( bag);
         }
         // to add a value to specific index.
         else if ( input == 4)
         {
            System.out.println( "To add a value at a specific location,");
            System.out.println( "First enter index, then enter the value:");
            index = scan.nextInt();
            input = scan.nextInt();
            
            bag.add( index, input);
         }
         // to remove a value at a specific index
         else if ( input == 5)
         {
            System.out.println( "To remove a value at a specific index, enter an index:");
            index = scan.nextInt();
            bag.remove( index);
         }
         // to read a single test value.
         else if ( input == 6)
         {
            System.out.println( "To read a single test value, enter an integer: ");
            testValue = scan.nextInt();
            
         }
         // finds the location of values in the bag
         else if ( input == 7)
         {
            bag.findAll( testValue);
         }
         // prints the location of values to the user.
         else if ( input == 8)
         {
            System.out.println( "The indexes are: " + bag.findAll( testValue));
         }
      } while ( input != 9);
      
      System.out.println( "Done!!");

   }
}