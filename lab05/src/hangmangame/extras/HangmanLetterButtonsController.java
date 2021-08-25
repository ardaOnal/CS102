package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * A simple HangmanLetterButtonController which is an ActionListener
 * @author Arda Onal
 * @version 15/04/2020
 */
public class HangmanLetterButtonsController implements ActionListener
{
   // properties
   HangmanModel model;
   
   // constructors
   public HangmanLetterButtonsController( HangmanModel model)
   {
      this.model = model;
   }
   
   // methods
   public void actionPerformed( ActionEvent e)
   {
      if ( !model.isGameOver())
         model.tryThis( ((JButton)e.getSource()).getText().charAt(0));
   }
}