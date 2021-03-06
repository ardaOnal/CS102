package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Arda Onal
// date: 23.02.2020
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        fullPack = new Cards( true);
        
        players = new ArrayList<Player>();
        players.add( p1);
        players.add( p2);
        players.add( p3);
        players.add( p4);
       
        scoreCard = new ScoreCard( players.size());
        
        cardsOnTable = new Cards[ players.size()];
        
        // Create empty Cards set for every player
        for (int i = 0; i < cardsOnTable.length; i++)
        {
           cardsOnTable[i] = new Cards(false);
        }

        roundNo = 0;
        turnOfPlayer = 0;
        
        // Dealing all cards to the players
        for ( int i = 0; i < 13; i++)
        {
           for ( int j = 0; j < players.size(); j++)
           {
              players.get(j).add( fullPack.getTopCard());
           }
        }
    }
    
    // methods
    public boolean playTurn( Player p)
    {
       Card c;
       
       // if game is over returns false
       // if it's not p's turn returns false
       if ( isGameOver() || !isTurnOf( p))
          return false;
       
       c = p.playCard();
       
       // p's turn so take p's card & put on table
       cardsOnTable[turnOfPlayer].addTopCard( c);
       System.out.println( "Player " + p.getName() + " has played " + c + ".");
       
       // If it is not the last players turn
       if ( turnOfPlayer < 3)
       {
          turnOfPlayer++;
          return true;
       }
       // If it is the last turn
       else
       {
          updateScores(); // Updating scores
          
          if ( !isGameOver()) // If game is not over
          {
             roundNo++;
             turnOfPlayer = 0;
          }
          
          return true;
       }
    }
    
    public boolean isTurnOf( Player p)
    {
       int indexOfPlayer;
       indexOfPlayer = 0;
       
       for ( int i = 0; i < 4; i++)
       {
          if ( players.get(i).getName().equals( p.getName()))
             indexOfPlayer = i;
       }
       
       return indexOfPlayer == turnOfPlayer;
    }
    
    public boolean isGameOver()
    {
        return roundNo >= 13;
    }
    
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore( playerNumber);
    }
    
    public String getName( int playerNumber)
    {
        return players.get( playerNumber).getName();
    }
    
    public int getRoundNo()
    {
        return roundNo;
    }
    
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer;
    }
    
    public Player[] getWinners()
    {
        int[] winnerIndexes;
        Player[] winners;
        
        winnerIndexes = scoreCard.getWinners();
        winners = new Player[winnerIndexes.length];
        
        for ( int i = 0; i < winnerIndexes.length; i++)
           winners[i] = players.get( winnerIndexes[i]);
        
        return winners; 
    }
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
    private void updateScores()
    {
       Card highest;
       highest = new Card(0);
       
       // Finding the highest valued card.
       for ( int i = 0; i < players.size(); i++)
       {
          if ( cardsOnTable[i].cards[cardsOnTable[i].valid - 1].getFaceValue() >= highest.getFaceValue())
             highest = cardsOnTable[i].cards[ cardsOnTable[i].valid - 1];
       }
       
       // Updating the scores of players
       for (int j = 0; j < players.size(); j++) 
       {
          if ( cardsOnTable[j].cards[cardsOnTable[j].valid - 1].getFaceValue() == highest.getFaceValue()) 
            scoreCard.update(j,1); 
       }
    }
}