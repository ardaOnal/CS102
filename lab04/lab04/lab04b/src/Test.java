import javax.swing.*;

public class Test
{
   public static void main( String[] args)
   {
      JFrame frame = new JFrame("Balloons");
      
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
      
      frame.add( new BalloonsGamePanel());
      
      frame.pack();
      frame.setLocationRelativeTo( null);
      frame.setVisible( true);
      
      frame.setResizable( false);
   }
}