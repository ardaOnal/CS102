import cs1.SimpleURLReader;

/**
 * A simple MySimpleURLReader class.
 * @author Arda ?nal
 * @version 29.02.2020
 */
public class MySimpleURLReader extends SimpleURLReader
{
   // properties
   private String url;
   
   // constructors
   public MySimpleURLReader( String url)
   {
      super(url);
      this.url = url;
   }
   
   // methods
   public String getURL()
   {
      return url;
   }
   
   /**
    * This method takes the name of the file by extracting
    * the words after the last '/' char.
    * @return returns the name of the file.
    */
   public String getName()
   {
      String name;
      int count;
      int count2;
      
      name = "";
      count = 0;
      count2 = 0;
      
      // Finding the number of '/' chars in the url
      for ( int i = 0; i < url.length(); i++)
      {
         if ( url.charAt(i) == '/')
         {
            count++;
         }
      }
      
      // Comparing the number of '/' chars with the count and if it is the last
      // index, it extracts the name.
      for ( int i = 0; i < url.length(); i++)
      {
         if ( url.charAt(i) == '/')
         {
            count2++;
            
            if ( count2 == count)
            {
               name = url.substring( i + 1);
            }
         }
      }
      
      return name;
   }
   
   /**
    * This method overrides the bugged method.
    * @return returns page contents.
    */
   @Override
   public String getPageContents()
   {
      return super.getPageContents().substring(4);
   }
}