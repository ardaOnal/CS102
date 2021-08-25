import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

// import java.awt.Button;

/**
 * GUIDemo1
 * @author Arda Önal
 * @version 29/03/2020
 */ 
public class GUIDemo1
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables
      JFrame  f;
      Button b;
      MyDrawingPanel p;
      MyDrawingPanel p2;

      // program code
      System.out.println( "Start...");
      
      p = new MyDrawingPanel();
      p2 = new MyDrawingPanel( 300, 400);
      p2.setColor( Color.blue);
      
      f = new MyFrame();
      f.add(p);
      f.add(p2);


      
//      // f.setSize( 400, 300);
//      f.setBounds( 350, 250, 400, 300);
//      
//      f.setLayout( new FlowLayout() );
//      
//      b = new Button( "OK");
//      f.add( b);
//      f.add( new Button( "Good luck with Maths! ") );
//      
//      f.setVisible( true );

      System.out.println( "End.");
   }

}