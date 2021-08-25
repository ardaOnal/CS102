import java.awt.*;
import java.awt.event.*;

/**
 *  
 * @author 
 * @version 
 */ 
public class MyPanel extends Panel implements ActionListener
{
   // properties
   Label      label;
   TextField  tf;
   Panel p;
      
   // constructors
   public MyPanel()
   {
      Button b;
      
      setLayout( new FlowLayout() );
      
      label = new Label( "Welcome to the ONLINE world");
      add( label);

      tf = new TextField( 25);
      tf.addActionListener( this);
      add( tf );

      b = new Button( "Neat");
      add( b);
      b.addActionListener( this );
      b.addActionListener( new MyActionListener() );
      b.addActionListener( new ActionListener() {
         public void actionPerformed( ActionEvent e)
         {
            System.out.println( "Button Pressed! in MALAnon");
         }    
      });
//      b.addActionListener( 
//         e -> System.out.println( "Button Pressed! in Lambda")  
//      );
      
      // add( new Button( "OK, time to go!") );
      
      
      p = new Panel();
      p.setBackground( Color.cyan);
      p.setPreferredSize( new Dimension( 300, 300) );
      add( p);
      
      
   }

   // methods
   public void actionPerformed( ActionEvent e)
   {
      if ( e.getSource() != tf ) 
         System.out.println( "Button Pressed! in MPAL");
      else
         System.out.println( "TextField enter Pressed! in MPAL");
      
      label.setText( tf.getText() );
   }
   
   // Named Inner class
   public class MyActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         System.out.println( "Button Pressed! in MALNIL");
         
         // wrong way to do it!
         // proper way is overriding the paint method.
         Graphics g;
         g = p.getGraphics();
         g.drawString( "Pressed!", 100, 100 );
      }
   }

     
}