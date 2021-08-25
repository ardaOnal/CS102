import java.awt.*;
import javax.swing.*;

/**
 *  A simple MyFrame Class
 * @author Arda Önal
 * @version 29.03.2020
 */ 
public class MyFrame extends JFrame
{
   // properties

   // constructors
   public MyFrame()
   {
      JButton b;
      JPanel  p;
      MyDrawingPanel p2;
      
      // f.setSize( 400, 300);
      // setBounds( 350, 250, 400, 300);
      setLayout( new BorderLayout() );
      
      p = new MyPanel();
      p2 = new MyDrawingPanel();
      
      add( new MyPanel(), BorderLayout.WEST );
      add( new MyPanel(), BorderLayout.EAST );
      add( p2, BorderLayout.SOUTH);
      add( new MyDrawingPanel(), BorderLayout.EAST);
      
//      p.add( new Label( "Welcome to ZOOM") );
//      
//      b = new Button( "OK");
//      p.add( b);
//      p.add( new Button( "Good luck with Maths! ") );
//      
//      p.add( new TextField( 25) );
      
      add( p, BorderLayout.NORTH);
      
      pack();
      setVisible( true );      
   }

   // methods
     
}