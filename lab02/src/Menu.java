import java.util.Scanner;
import java.util.ArrayList;

/**
 * A simple program that holds the urls of the user and lists them and prints them.
 * @author Arda Onal
 * @version 01.03.2020
 */
public class Menu
{
   public static void main( String[] args)
   {
      // constants 
      
      // variables
      ArrayList<MySimpleURLReader> urls;
      MySimpleURLReader myReader;
      HTMLFilteredReader htmlReader;
      Scanner scan;
      String poem;
      int input;
      int index;

      // program code
      scan = new Scanner( System.in);
      urls = new ArrayList<MySimpleURLReader>();
      index = 0;

      System.out.println( "Hello, welcome to my program!");
      System.out.println( "This is a program that holds your urls!!");

      do
      {
         // Printing the Menu
         System.out.println( "--------------------------------------------------");
         System.out.println( "(1) Enter the url of the poem to add to collection");
         System.out.println( "(2) List all poems in the collection");
         System.out.println( "(3) Quit");
         System.out.println( "--------------------------------------------------");
         System.out.println( "Pick an option: ");
         input = scan.nextInt(); // Getting the input.
         
         if ( input == 1)
         {
            System.out.println( "Enter the url of the poem:");
            poem = scan.next(); // Getting the url of the poem.
            
            for ( int i = poem.length() - 1; i > 0; i--)
            {
               // If it is an html or an htm file.
               if ( poem.charAt(i - 1) == '.' && poem.charAt( i) == 'h')
               {
                  htmlReader = new HTMLFilteredReader( poem);
                  urls.add( htmlReader);
                  i = -1; // To Break the for loop after adding it once.
               }
               // If it is an txt file.
               else if ( poem.charAt(i - 1) == '.' && poem.charAt( i) == 't')
               {
                  myReader = new MySimpleURLReader( poem);
                  urls.add( myReader);
                  i = -1; // To Break the for loop after adding it once.
               }
            }
         }
         
         else if ( input == 2)
         {
            // If the list is empty.
            if ( urls.size() <= 0)
               System.out.println( "The list is empty!");
            else
            {
               do
               {
                  System.out.println( "Listing all of the poems:");
                  
                  for ( int i = 0; i < urls.size(); i++)
                     System.out.println( i + "-" + urls.get(i).getName());
                  
                  System.out.println( "To view a poem, enter an index(last index + 1 to quit): ");
                  index = scan.nextInt(); // Getting the input index.
                  
                  // If the user does not want to quit.
                  if ( index != urls.size())
                  {
                     // Asks the user for index until it gets a valid index.
                     while ( index > urls.size() || index < 0)
                     {
                        System.out.println( "Error: index is out of bounds!");
                        System.out.println( "Enter a valid integer:");
                        index = scan.nextInt();
                     }
                     
                     // Printing the poem.
                     System.out.println( "Your poem: ");
                     System.out.println( urls.get(index).getPageContents());
                  }
                  else
                     System.out.println( "Going back to the main menu.");
                  
               } while ( index != urls.size());
            }
         }
         
         else if ( input != 3)
         {
            System.out.println( "Error: Please enter a value between 1-3");
         }
         
      } while ( input != 3);
      
      System.out.println( "Done.");
   }
} // End of Menu Class
