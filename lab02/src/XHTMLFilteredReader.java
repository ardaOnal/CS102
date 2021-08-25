import java.util.ArrayList;

/**
 * A simple XHTMLFilteredReader class
 * @author Arda Onal
 * @version 01.03.2020
 */
public class XHTMLFilteredReader extends HTMLFilteredReader
{
   // properties
   
   // constructors
   public XHTMLFilteredReader( String url)
   {
      super( url);
   }
   
   // methods
   public ArrayList<String> getLinks()
   {
      ArrayList<String> links;
      int index;
      String html;
      
      links = new ArrayList<String>();
      html = super.getUnfilteredPageContents();
      index = html.indexOf( "href=");
      
      
      while ( index != -1)
      {
         links.add( html.substring( index + 6, html.indexOf( "\"", index + 6)));
         index = html.indexOf( "href=", index + 5);
      }
      
      return links;
   }
   
   /**
    * This method returns the overHead from the html code
    * @return returns the overHead value.
    */
   public double overHead()
   {
      return (double) (super.getUnfilteredPageContents().length() - super.getPageContents().length()) / super.getPageContents().length() * 100;
   }
}