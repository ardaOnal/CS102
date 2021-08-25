package shapes;

/**
 * A simple Shape class.
 * @author Arda Onal
 * @version 8.3.2020
 */
public abstract class Shape implements Locateable
{
   int x = 0; 
   int y = 0;
   
   // Abstract methods
   public abstract double getArea();
   public abstract boolean contains( int x, int y);
   public abstract void setSelected( boolean x);
   public abstract boolean getSelected();
   
   
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public void setLocation( int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
}