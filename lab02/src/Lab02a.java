import cs1.SimpleURLReader;

/**
 * A program that tests my Lab02 objects
 * @author Arda Önal
 * @version 29.02.2020
 */
public class Lab02a 
{
   public static void main( String[] args)
   {
      // constants
      
      // variables
      SimpleURLReader reader;
      MySimpleURLReader myReader;
      HTMLFilteredReader htmlReader;
      
      // program code
      reader = new SimpleURLReader( "http://www.cs.bilkent.edu.tr/~david/housman.txt");
      myReader = new MySimpleURLReader( "http://www.cs.bilkent.edu.tr/~david/housman.txt");
      
      System.out.println( "Line count: " + reader.getLineCount());
      
      System.out.println();
      
      System.out.println( reader.getPageContents());
      
      // Part B
      System.out.println ( "The url: " + myReader.getURL());
      
      System.out.println( "Filename: " + myReader.getName());
      
      System.out.println();
      
      System.out.println( myReader.getPageContents());
      
      System.out.println();
      
      // Part C
      myReader = new MySimpleURLReader( "http://www.cs.bilkent.edu.tr/~david/housman.htm");
      
      System.out.println( myReader.getPageContents());
      System.out.println( "PARTC");
      
      htmlReader = new HTMLFilteredReader( "http://www.cs.bilkent.edu.tr/~david/housman.htm");
      System.out.println( htmlReader.getPageContents());
      
      // Part D
      System.out.println( "Part D");
      XHTMLFilteredReader xhtmlReader;
      xhtmlReader = new XHTMLFilteredReader( "http://www.cs.bilkent.edu.tr/~david/index.html");
      
      System.out.println ( xhtmlReader.getUnfilteredPageContents());
      
      System.out.println( xhtmlReader.getLinks());
      
      System.out.println( "Overhead is: " + xhtmlReader.overHead());
      
      // Testing D
      System.out.println( "Testing other things...");
      
//      This does not work!!!
//      XHTMLFilteredReader x;
//      x = (XHTMLFilteredReader) myReader;
//      System.out.println( x.getLinks());
      
      
      System.out.println( xhtmlReader.getURL());
      System.out.println( xhtmlReader.getName());
   }
}