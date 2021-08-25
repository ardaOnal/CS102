package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;


/**
 * A simple HangmanLetterButtonControls which is a LetterButtonControls
 * @author Arda Onal
 * @version 15/04/2020
 */
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView
{
   // propeties
   
   // constructors
   public HangmanLetterButtonControls( String letters, HangmanModel hm)
   {
      super( letters, hm);
   }
   
   // methods
   @Override
   public void updateView( Hangman hm)
   {
      if ( !hm.isGameOver())
         super.setEnabledAll( true);
      
      super.setDisabled( hm.getUsedLetters());
   }
   
}