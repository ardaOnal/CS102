import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import shapes.*;

public class BalloonsGamePanel extends JPanel 
{
   // properties
   private ShapeContainer balloons;
   private int points;
   private int elapsedTime;
   private JLabel pointLabel;
   private JLabel timeLabel;
   private Timer t;
   private int highScore;
   private final int HEIGHT = 500;
   private final int WIDTH = 600;
   private final int TIME = 15000;
   private final int TICKRATE = 100;// Time takes until the game is over (15 secs)
   private final int INITIAL_RADIUS = 25;
   private final int NUMBER_OF_BALLOONS = 25;
   private final int NUMBER_OF_BALLOONS_TO_GENERATE_NEW_BALLOONS = 15;
   
   // constructors
   public BalloonsGamePanel()
   {
      points = 0;
      elapsedTime = 0;
      
      balloons = new ShapeContainer();
      
      setPreferredSize( new Dimension( WIDTH, HEIGHT));
      
      addMouseListener( new MyMouseListener());
      
      pointLabel = new JLabel( "Points: " + points);
      pointLabel.setForeground( Color.WHITE);
      
      timeLabel = new JLabel( "Points: " + elapsedTime);
      timeLabel.setForeground( Color.WHITE);
      
      add( pointLabel);
      add( timeLabel);
      
      for ( int i = 0; i < NUMBER_OF_BALLOONS; i++)
      {
         Balloon tmp;
         
         tmp = new Balloon( INITIAL_RADIUS);
         
         tmp.setLocation( (int)(Math.random() * WIDTH), (int)(Math.random() * HEIGHT));
         
         balloons.add( tmp);
      }
      
      t = new Timer( TICKRATE, new ActionListener() { public void actionPerformed( ActionEvent e)
         {
         
         //setBackground( new Color( (float)Math.random(), (float) Math.random(), (float)Math.random()));
         
         elapsedTime += TICKRATE;
         
         timeLabel.setText( "Time: " + elapsedTime / 1000);
         timeLabel.setForeground( Color.WHITE);
         
         repaint();
         
         if ( balloons.size() <= NUMBER_OF_BALLOONS_TO_GENERATE_NEW_BALLOONS)
         {
            Balloon tmp;
            
            tmp = new Balloon( INITIAL_RADIUS);
            
            tmp.setLocation( (int)(Math.random() * WIDTH), (int)(Math.random() * HEIGHT));
            
            balloons.add( tmp);
            
         }
         
         balloons.removeSelected();
         
         if ( elapsedTime > TIME)
         {
            t.stop();
            int again = JOptionPane.showConfirmDialog(BalloonsGamePanel.this, "Play again?", "GameOver", 0);
            
            if ( again == 0)
            {
               elapsedTime = 0;
               points = 0;
               pointLabel.setText("Points: " + points);
               pointLabel.setForeground( Color.WHITE);
               
               timeLabel.setText("Time: " + elapsedTime);
               timeLabel.setForeground( Color.WHITE);
               
               balloons = new ShapeContainer();
               
               for ( int i = 0; i < NUMBER_OF_BALLOONS; i++)
               {
                  Balloon tmp;
                  
                  tmp = new Balloon( INITIAL_RADIUS);
                  
                  tmp.setLocation( (int)(Math.random() * WIDTH), (int)(Math.random() * HEIGHT));
                  
                  balloons.add( tmp);
               }
               
               t.start();
            }
         }
         
         Iterator it = balloons.iterator();
         while (it.hasNext()) 
         {
            ((Balloon)it.next()).grow();
         }
         
//         for ( int i = 0; i < balloons.size(); i++)
//         {
//            ((Balloon)balloons.shapes.get(i)).grow();
//         }
      }});
      
      
      t.start();
      
      setBackground(Color.BLACK);
   }
   
   // methods
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent(g);
      
      Iterator it = this.balloons.iterator();
      while (it.hasNext()) 
      {
         ((Drawable)((Object)it.next())).draw(g);
         
          //g.setColor( new Color( (float)Math.random(), (float) Math.random(), (float)Math.random()));
      }
      
//      for ( int i = 0; i < balloons.size(); i++)
//      {
//         ((Drawable)balloons.shapes.get(i)).draw(g);
//      }
   }
   
   
   class MyMouseListener extends MouseAdapter
   {
      @Override
      public void mousePressed( MouseEvent e)
      {
         int tmp = balloons.selectAllAt( e.getX(), e.getY());
         if ( tmp >= 2 )
         {
            points = points + tmp;
         }
         
         pointLabel.setText( "Points: " + points);
         balloons.removeSelected();
         
      }
   }
}