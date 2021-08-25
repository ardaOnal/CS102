
/**
 * A simple HTMLFilteredReader class
 * @author Arda Onal
 * @version 01.03.2020
 */
public class HTMLFilteredReader extends MySimpleURLReader
{
   // properties
   
   // constructors
   public HTMLFilteredReader( String url)
   {
      super( url);
   }
   
   // program code
   
   /**
    * This method uses the getPageContents method of 
    * MySimpleURLReader class.
    * @return returns html code of the page
    */
   public String getUnfilteredPageContents()
   {
      return super.getPageContents();
   }
   
   /**
    * This method filters the html code of page contents
    * @return returns filtered html code of the page
    */
   @Override
   public String getPageContents()
   {
      String result;
      int tmp;
      
      result = "";
      
      for ( int i = 0; i < super.getPageContents().length() - 2; i++)
      {
         if ( super.getPageContents().charAt(i) == '>' )
         {
            tmp = i;
            
            while ( super.getPageContents().charAt(i + 1) != '<')
            {
               result += super.getPageContents().charAt(i + 1);
               i++;
            }
            i = tmp;
            
         }
      }
      
      result = result.substring(35);

      return result;
   }
   
}