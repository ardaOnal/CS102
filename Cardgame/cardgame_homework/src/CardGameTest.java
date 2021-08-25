import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Arda Onal
// date: 28.02.2020
public class CardGameTest
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      System.out.println( "Start of CardGameTest\n");
      
      // CONSTANTS
      
      // VARIABLES
      Card       c;
      Cards      cards;
      ScoreCard  scores;
      Player     p;
      Player     p1;
      Player     p2;
      Player     p3;
      CardGame   game;
      
      // PROGRAM CODE
      
      // test Card class
      c = new Card( 1);
      System.out.println( c);
      System.out.println();
      
      // test Cards class
      cards = new Cards( true);
      cards.addTopCard( c);
      // cards.testOnlyPrint();
      
      // test ScoreCard class
      scores = new ScoreCard( 4);
      scores.update( 3, 1);
      scores.update( 1, 2);
      System.out.println( "\n" + scores );
      
      for ( int x : scores.getWinners())
         System.out.println(x);
      
      // test Player class
      p = new Player( "David");
      System.out.println( p.getName());
      p.add( c);
      System.out.println( p.playCard());
      
      
      
      // test CardGame class too?
      p1 = new Player("b");
      p2 = new Player("c");
      p3 = new Player("d");
      
      game = new CardGame( p, p1, p2, p3);
      System.out.println( "Testing CardGame class");
      System.out.println( game.getRoundNo());
      System.out.println( game.showScoreCard());
      System.out.println( game.getTurnOfPlayerNo());
      System.out.println( game.getScore( 2));
      System.out.println( game.isGameOver());
      System.out.println( game.isTurnOf(p));
      System.out.println();
      
      //TESTING PLAYTURN
      System.out.println( game.playTurn( p));
      System.out.println( game.playTurn( p1));
      System.out.println( game.playTurn( p2));
      System.out.println( game.playTurn( p3));
      
      System.out.println( game.playTurn( p));
      System.out.println( game.playTurn( p1));
      System.out.println( game.playTurn( p2));
      System.out.println( game.playTurn( p3));
      
      System.out.println( game.playTurn( p));
      System.out.println( game.playTurn( p1));
      System.out.println( game.playTurn( p2));
      System.out.println( game.playTurn( p3));
      
      System.out.println( game.playTurn( p));
      System.out.println( game.playTurn( p1));
      System.out.println( game.playTurn( p2));
      System.out.println( game.playTurn( p3));
      
      System.out.println( game.playTurn( p));
      System.out.println( game.playTurn( p1));
      System.out.println( game.playTurn( p2));
      System.out.println( game.playTurn( p3));
      
      
      System.out.println( game.showScoreCard());
      
      // testing getwinners:
      Player[] winners = game.getWinners();
      for ( int i = 0; i < winners.length; i++)
         System.out.println( winners[i].getName());
      
      
      
      
      
      
      
      
      // Once you have all the bits working, complete the MyCardGame program
      // that provides a menu allowing any of the players to play their card,
      // an option to see the score card, and one to quit the game at any time.
      // When the game is over it should print out the winners.
      
      System.out.println( "\nEnd of CardGameTest\n" );
   }
   
} // end of class CardGameTest
