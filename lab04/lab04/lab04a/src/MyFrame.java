import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;

/**
 * A simple Pot Luck game
 * @author Arda Onal
 * @version 01.04.2020
 */
public class MyFrame extends JFrame
{
   // properties
   private  JFrame frame;
   private  JFrame winPopUP;
   private  JPanel boxes;
   private  JPanel statusBar;
   private  JLabel label;
   private  JButton button;
   private  JButton reset;
   private  JButton exit;
   private  int random;
   private  int tmp;
   private  int attemptNumber;
   private  JButton[] buttons;
   private boolean gameOver;
   
   // constructors
   public MyFrame()
   {
      // constants
      final int ROW = 5;
      final int COLUMN = 5;
      
      // Creating a button number
      int buttonNumber;
      buttonNumber = ROW * COLUMN;
      
      
      // Initializing the variables and objects.
      gameOver = false;
      random = (int) (Math.random() * buttonNumber) + 1; // Finding the random index for the prize button.
      tmp = 0;
      attemptNumber = 0;
      
      boxes = new JPanel();
      boxes.setLayout( new GridLayout( ROW, COLUMN));
      
      buttons = new JButton[buttonNumber];
      
      exit = new JButton( "EXIT");
      
      
      statusBar = new JPanel();
      label = new JLabel( "Number of attempts: " + attemptNumber);
      statusBar.add( label);
      reset = new JButton( "RESET");
      statusBar.add( reset);
      statusBar.add( exit);
      
      exit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent e) 
            {
               System.exit(0);
            }
         });
      
      // Adding actionlistener to the reset button which recreates everyting.
      reset.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent e)
         {
         statusBar.setVisible( false);
         boxes.setVisible( false);
         gameOver = false;
         random = (int) (Math.random() * buttonNumber) + 1;
         tmp = 0;
         attemptNumber = 0;
         boxes = new JPanel();
         boxes.setLayout( new GridLayout( ROW, COLUMN));
         buttons = new JButton[buttonNumber];
         statusBar = new JPanel();
         label = new JLabel( "Number of attempts: " + attemptNumber);
         exit = new JButton( "EXIT");
         
         statusBar.add( label);
         statusBar.add( reset);
         statusBar.add( exit);
         
         exit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent e) 
            {
               System.exit(0);
            }
         });
         
         System.out.println( random);
         
         // Initializing all of the buttons and adding them actionlistener.
         for ( int i = 0; i < buttonNumber; i++)
         {
            tmp = i + 1;
            
            buttons[i] = new JButton( "" + tmp);
            
            boxes.add( buttons[i]);
            
            buttons[i].addActionListener( new ActionListener(){public void actionPerformed( ActionEvent e)
               {
               
               if ( !gameOver)
               {
                  attemptNumber++;
                  
                  if ( !((JButton)e.getSource()).getText().equals( "" + random)) 
                  {
                     ((JButton)e.getSource()).setEnabled( false);
                     label.setText( "Number of attemps: " + attemptNumber);
                  }
                  else
                  {
                     label.setText( "You got it in " + attemptNumber + "attempts!");
                     gameOver = true;
                     
                     winPopUP = new JFrame( "Congratulations");
                     winPopUP.add( new JLabel( "Congratualitions, you won!"));
                     //winPopUP.setPreferredSize( new Dimension( 200, 200));
                     winPopUP.pack();
                     winPopUP.setLocationRelativeTo( null);
                     winPopUP.setVisible( true);
                  }
               }
            }});
            
         }
         
         frame.add( statusBar, BorderLayout.NORTH);
         frame.add( boxes, BorderLayout.CENTER);
         
      }
      });
                // Pritinging out the random on the console
                System.out.println( random);
                
                // Initializing all of the buttons and adding them actionlistener.
                for ( int i = 0; i < buttonNumber; i++)
                   {
                   tmp = i + 1;
                   
                   buttons[i] = new JButton( "" + tmp);
                   
                   boxes.add( buttons[i]);
                   
                   buttons[i].addActionListener( new ActionListener(){public void actionPerformed( ActionEvent e)
                      {
                      
                      if ( !gameOver)
                      {
                         attemptNumber++;
                         
                         if ( !((JButton)e.getSource()).getText().equals( "" + random)) 
                         {
                            ((JButton)e.getSource()).setEnabled( false);
                            label.setText( "Number of attemps: " + attemptNumber);
                         }
                         else
                         {
                            label.setText( "You got it in " + attemptNumber + "attempts!");
                            gameOver = true;
                            
                            winPopUP = new JFrame( "Congratulations");
                            winPopUP.add( new JLabel( "Congratualitions, you won!"));
                            //winPopUP.setPreferredSize( new Dimension( 200, 200));
                            winPopUP.pack();
                            winPopUP.setLocationRelativeTo( null);
                            winPopUP.setVisible( true);
                         }
                      }
                   }});
                   
                }
                
                // Making the frame look pretty
                frame = new JFrame( "PotLuck");
                
                
                
                frame.setLayout( new BorderLayout());
                
                frame.add( statusBar, BorderLayout.NORTH);
                frame.add( boxes, BorderLayout.CENTER);
                
                frame.setPreferredSize( new Dimension(700, 700));
                
                frame.pack();
                frame.setLocationRelativeTo( null);
                frame.setVisible( true);
                
                }
}