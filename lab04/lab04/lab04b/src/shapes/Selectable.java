package shapes;

public interface Selectable
{
   boolean getSelected();
   
   void setSelected( boolean x);
   
   Shape contains( int x, int y);
}