package hangmangame.extras;

import cs102.hangman.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Collection of UI components to form a complete Hangman game. 
 * View components implement IHangmanView, so they can automatically update
 * whenever the hangmanModel associated with changes, changes.
 * Other components are hangman controllers that update the model.
 * @author Arda Onal
 * @version 15/04/2020
 */
public class HangmanGUIPanel extends JPanel 
{
   HangmanModel hm;
   TextFieldControlPanel tf;
   LabelsHangmanView label;
   GallowsHangmanView gallow;
   NewGameButtonControl button;
   HangmanLetterButtonControls controls;
      
   public HangmanGUIPanel( HangmanModel hm) 
   {
      this.hm = hm;
      //setPreferredSize( new Dimension( 500, 350) );
      setLayout( new BorderLayout() );
      setBackground(Color.YELLOW);

      // add controls and views here...
      label = new LabelsHangmanView( hm);
      gallow = new GallowsHangmanView( hm);
      button = new NewGameButtonControl(hm);
      controls = new HangmanLetterButtonControls( hm.getAllLetters(), hm);
      tf = new TextFieldControlPanel( hm);
      
      hm.addView( gallow);
      hm.addView( label);
      hm.addView( button);
      hm.addView( controls);
      
      add( button, BorderLayout.SOUTH);
      add( label, BorderLayout.WEST);
      add( gallow, BorderLayout.CENTER);
      add( tf, BorderLayout.NORTH);
      add( controls, BorderLayout.EAST);
      
      //add( new TextFieldControlPanel(hm), BorderLayout.EAST);
      
      
      
   }
   
}
