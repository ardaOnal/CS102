package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple NewGameButtonControl which is a big new game button 
 * @author Arda Onal
 * @version 15/04/2020
 */
public class NewGameButtonControl extends JButton implements IHangmanView 
{
   
   // properties
   
   // constructors
   public NewGameButtonControl( HangmanModel hm)
   {
      setText( "New Game");
      
      setEnabled( false);
     
      addActionListener( new ActionListener() 
                           { 
         public void actionPerformed( ActionEvent E)
         {
            setEnabled( false);
            hm.initNewGame();
         }
      });
   }
   
   // methods
   @Override
   public void updateView( Hangman hm)
   {
      if ( hm.isGameOver())
         setEnabled( true);
   }
}