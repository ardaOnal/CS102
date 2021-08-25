import shapes.*;
import java.awt.*;

public class Balloon extends Circle implements Drawable
{
   // properties
   private int radius;
   private final int INCREASE_AMOUNT = 2;
   private final int MAX_SIZE = 150;
   private Color color;
   
   // constructors
   public Balloon( int radius)
   {
      super( radius);
      this.radius = radius;
      color = new Color( (float)Math.random(), (float)Math.random(), (float)Math.random());
   }
   
   // methods
   
   @Override
   public void draw( Graphics g)
   {
      g.drawOval( getX()-(radius/2), getY()-(radius/2), radius, radius);
      
      g.fillOval( getX()-(radius/2), getY()-(radius/2), radius, radius);
      
      g.setColor( color);

   }
   
   public void grow()
   {
      radius = radius + INCREASE_AMOUNT;
      
      if ( radius > MAX_SIZE)
      {
         setSelected( true); 
         radius = 0;
      } 
   }
   
   /**
    * Allows to select the shape.
    * @param int x,y are the coordinates.
    * @return true or false if it contains.
    */
   @Override
   public Balloon contains( int x, int y)
   {
      double distance;
      
      distance = Math.sqrt( ((this.getX()- x) * (this.getX()- x)) + ((this.getY() - y) * (this.getY()- y)));
      
      if (distance <= radius/2)
      {
         return this;
      }
      else
      {
         return null;
      }
   } 
}