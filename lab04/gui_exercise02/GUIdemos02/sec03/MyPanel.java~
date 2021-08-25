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
   Label     label;
   TextField tf;
   Panel     p;

   // constructors
   public MyPanel()
   {
      Button b;
      
      // setPreferredSize( new Dimension( 100, 100) );
      setSize( 200, 200);
      setLayout( new FlowLayout() );
      
      label = new Label( "Welcome to ZOOM");
      add( label);
      
      // add( new Button( "Good luck with Maths! ") );

      b = new Button( "OK");
      add( b);
      
      b.addActionListener( this );
      b.addActionListener( new MyActionListener() );
      b.addActionListener( new MyOtherActionListener() );
      
      b.addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            System.out.println( "Button pressed! ~ AL-Annon" );
         }
      });      
      b.addActionListener( 
          e -> System.out.println( "Button pressed! ~ LAMBDA" ) );
      
      tf = new TextField( 25);
      add( tf );      
      tf.addActionListener( this);
      
      p = new Panel();
      p.setBackground( Color.cyan);
      p.setPreferredSize( new Dimension( 200, 150) );
      add(p);
   }

   // methods
   public void actionPerformed(ActionEvent e)
   {
      if ( e.getSource() != tf ) 
         System.out.println( "Button pressed!" );
      else
         System.out.println( "TF pressed!" );
      
      label.setText( tf.getText() );
   }
   
   // named inner class
   class MyActionListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.out.println( "Button pressed! ~ ALNIC" );
         
         // right way is to override paint
         
         // wrong way to do it
         Graphics g;
         g = p.getGraphics();
         g.drawString( "OK?", 100, 50);
      }
   }
     
}