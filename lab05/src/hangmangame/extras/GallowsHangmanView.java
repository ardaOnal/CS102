package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * A simple GallowsHangmanView which is a JPanel that draws the hangman game
 * @author Arda Onal
 * @version 15/04/2020
 */
public class GallowsHangmanView extends JPanel implements IHangmanView
{
   // properties
   HangmanModel model;
   Timer t;
   boolean animation;
   
   // constructors
   public GallowsHangmanView( HangmanModel model)
   {
      this.model = model;
      
      animation = false;
      
      setBackground( Color.BLUE);
      
      setPreferredSize( new Dimension(250, 400));
      
      t = new Timer( 250, new ActionListener() 
                       { 
         public void actionPerformed( ActionEvent e) 
         {
            repaint();
         }
      });
      
      t.start();
   }
   
   // methods
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent(g);
      
      int numOfIncorrectTries = model.getNumOfIncorrectTries();
      
      // Typing the secret word
      if ( !model.isGameOver())
      {
         g.setFont( new Font("Impact", Font.BOLD, 20));
         g.setColor( Color.BLACK);
         g.drawString( model.getKnownSoFar(), 25, 330);
      }
      
      // Drawing the "gallow" of the hangman
      g.fillRect( 40, 40, 10, 200);
      g.fillRect( 50, 40, 50, 10);
      g.fillRect( 20, 240, 100, 15);
      
      // Drawing the rope
      if ( !model.isGameOver() && !model.hasLost())
          g.fillRect( 93, 50, 3, 20);
      
      // Drawing the head
      if ( numOfIncorrectTries >= 1)
      {
         g.drawOval( 80, 70, 30, 30);
         
         // Drawing the eyes, if the hangman dies, its eyes becomes cross.
         if ( !model.hasLost())
         {
            g.drawOval( 85, 80, 8, 8);
            g.drawOval( 97, 80, 8, 8);
         } 
         else
         {
            g.drawLine( 87, 80, 92, 90);
            g.drawLine( 87, 90, 92, 80);
            
            g.drawLine( 98, 80, 102, 90);
            g.drawLine( 98, 90, 102, 80);
            
         }
         
      }
      
      // Drawing the body
      if ( numOfIncorrectTries >= 2)
         g.drawLine( 95, 100, 95, 160);
      
      // Drawing the legs
      if ( numOfIncorrectTries >= 3)
      {
         g.drawLine( 95, 160, 125, 200);
      }
      
      // Drawing the legs
      if ( numOfIncorrectTries >= 4)
         g.drawLine( 95, 160, 65, 200);
      
      // Drawing the right arm with an animation
      if ( numOfIncorrectTries >= 5)
      {
         // It causes the hangman to move its arm.
         if ( animation )
         {
            g.drawLine( 95, 125, 120, 135);
            
            if ( !model.isGameOver())
               animation = false;
         }
         else 
         {
            g.drawLine( 95, 125, 120, 110);
            animation = true;
         }
      }
      
      // Drawing the left arm
      if ( numOfIncorrectTries >= 6)
         g.drawLine( 95, 125, 70, 135);
      
      // Displaing "You won!" text messege.
      if ( model.isGameOver() && !model.hasLost())
      {
         g.setFont( new Font("Impact", Font.BOLD, 20));
         g.setColor( Color.GREEN);
         g.drawString( "You won!", 65, 225);
         
         
         g.setFont( new Font("Impact", Font.BOLD, 20));
         g.setColor( Color.BLACK);
         g.drawString( model.getKnownSoFar(), 25, 330);
         
      }
      
      // Displaying "You lose" text messege.
      if ( model.isGameOver() && model.hasLost())
      {
         g.setFont( new Font("Impact", Font.BOLD, 16)); 
         g.setColor( Color.RED);
         g.drawString( "You lose!", 65, 225);
         
         g.setFont( new Font("Impact", Font.BOLD, 20)); 
         g.setColor( Color.BLACK);
         g.drawString( model.getKnownSoFar(), 25, 330);
         
      }
   }
   
   @Override
   public void updateView( Hangman hm)
   {
      repaint();
   }
}