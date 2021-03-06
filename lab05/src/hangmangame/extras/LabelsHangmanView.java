package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple LabelsHangmanView which displays the labels in the hangmangame
 * @author Arda Onal
 * @version 15/04/2020
 */
public class LabelsHangmanView extends JPanel implements IHangmanView
{
   // properties
   JLabel numOfIncorrectTries;
   JLabel knownSoFar;
   JLabel usedLetters;
   JLabel hasLost;
   Hangman hangman;
   
   // constructors
   public LabelsHangmanView( Hangman hangman)
   {
      this.hangman = hangman;
      //setLayout( new GridLayout( 4,1));
      
      setBackground( Color.YELLOW);
      
      setPreferredSize( new Dimension( 250, 400));
      
//      numOfIncorrectTries = new JLabel( "numOfIncorrectTries: ");
//      
//      knownSoFar = new JLabel( "knownSoFar: " );
//      
//      usedLetters = new JLabel( "usedLetters: ");
//      
//      hasLost = new JLabel( "hasLost: ");
//      
//      add( numOfIncorrectTries);
//      add( knownSoFar);
//      add( usedLetters);
//      add( hasLost);  
      
   }
   
   // methods
   
   @Override
   public void updateView( Hangman hangman)
   {
//      numOfIncorrectTries.setText( "Number of incorrect tries: " + hangman.getNumOfIncorrectTries() );
//      knownSoFar.setText( "Known so far: " + hangman.getKnownSoFar() );
//      usedLetters.setText( "Used letter: " + hangman.getUsedLetters() );
//      hasLost.setText( "Lost: " + hangman.hasLost() );
      
      repaint();
   }
   
   public void paintComponent( Graphics g)
   {
      super.paintComponent(g);
      
      g.setFont( new Font("Impact", Font.PLAIN, 18));
      g.setColor( Color.BLACK);
      
      g.drawString( "Number of incorrect tries: " + hangman.getNumOfIncorrectTries(), 5, 40);
      
      g.drawString( "Known so far: " + hangman.getKnownSoFar(), 5, 120);
      
      g.drawString( "Used letters: " + hangman.getUsedLetters(), 5, 200);
      
      g.drawString( "Lost: " + hangman.hasLost(), 5, 280);
   }
   
}