import java.awt.*;

/**
 *  A simple MyDrawingPanel Class
 * @author Arda ?nal
 * @version 29.03.2020
 */ 
public class MyDrawingPanel extends Panel
{
   // properties
   
   // constructors
   public MyDrawingPanel()
   {
      new Panel();
      
      setPreferredSize( new Dimension(300, 250));
      
      
      setBackground( Color.yellow);
   }
   
   public MyDrawingPanel( int width, int height)
   {
      new Panel();
      
      setPreferredSize( new Dimension( width, height));
      
      setBackground( Color.yellow);
   }
   
   // methods
   
   public void setColor( Color color)
   {
      setBackground( color);
   }
   
   @Override
   public void paint( Graphics g)
   {
      g.drawString( "Thats neat!", 50, 50);
      
      g.drawRect( 75, 75, 50, 50);
      
      g.drawOval( 150, 150, 30, 30);
      
      g.drawLine( 150, 150, 180, 180);
      
      
   }
}