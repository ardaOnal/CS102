import java.awt.*;
import javax.swing.*;

/**
 *  
 * @author 
 * @version 
 */ 
public class MyPanel extends JPanel
{
   // properties

   // constructors
   public MyPanel()
   {
      JButton b;
      // setPreferredSize( new Dimension( 100, 100) );
      setSize( 200, 200);
      setLayout( new GridLayout( 2, 3) );
      
      add( new JLabel( "Welcome to ZOOM") );
      
      b = new JButton( "OK");
      add( b);
      add( new JButton( "Good luck with Maths! ") );
      
      add( new TextField( 25) );      
   }

   // methods
     
}