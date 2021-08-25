package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple TextFieldControlPanel which is a big textfield on the top of the screen.
 * @author Arda Onal
 * @version 15/04/2020
 */
public class TextFieldControlPanel extends JPanel
{
   
   // properties
   private Hangman hangman;
   private JTextField text;
   
   // constructors
   public TextFieldControlPanel( Hangman hangman)
   {
      this.hangman = hangman;
      text = new JTextField(10);
      
      text.addActionListener( new ActionListener()
                                { 
         public void actionPerformed( ActionEvent e) 
         { 
            if ( !hangman.isGameOver())
            {
               String s = text.getText();
               
               for ( int i = 0; i < s.length(); i++)
               {
                  hangman.tryThis( s.charAt(i)); // Its action listener tries the chars
               }
               
               text.setText("");
            }
         }
      });
      
      add( text);
   }
   
   // methods
}