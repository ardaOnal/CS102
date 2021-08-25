import java.awt.*;
import java.awt.event.*;

/**
 *  
 * @author 
 * @version 
 */ 
public class MyFrame extends Frame // implements WindowListener
{
   // properties

   // constructors
   public MyFrame()
   {
      Button b;
      Panel  p;
      
      // setSize( 400, 300);
      setLocation( 300, 300);
      setLayout( new FlowLayout() );
      
      // addWindowListener( this );
      addWindowListener( new MyWindowListener() );

      add( new MyPanel() );
      
      p = new Panel();
//      p.setBackground( Color.cyan);
//      p.setPreferredSize( new Dimension( 300, 300) );
//     
//      
      
      // add( new MyPanel() ); 
      
//      p.setLayout( new GridLayout( 2, 3) );
//      
//      p.add( new Label( "Welcome to the ONLINE world") );
//
//      p.add( new TextField( 25) );
//
//      b = new Button( "Neat");
//      p.add( b);
//      p.add( new Button( "OK, time to go!") );
      
      add( p);
      
      pack();
      setVisible( true);      
   }
   
   // methods
   
   public class MyWindowListener extends WindowAdapter // MyWindowAdapter
   {    
      @Override
      public void windowClosing( WindowEvent e)  {
         System.out.println( "Closing window!");
         dispose();
         // System.exit( 0);
      }   
   }

//   public class MyWindowAdapter implements WindowListener
//   {
//      public void windowActivated( WindowEvent e) {}
//      public void windowClosed( WindowEvent e)  {}
//      public void windowClosing( WindowEvent e)  {}
//      public void windowDeactivated( WindowEvent e)  {}
//      public void windowDeiconified( WindowEvent e)  {}
//      public void windowIconified( WindowEvent e)  {}
//      public void windowOpened( WindowEvent e)  {}   
//   }
}