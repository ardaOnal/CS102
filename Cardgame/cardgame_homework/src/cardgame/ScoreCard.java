package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author: Arda Onal
// date: 23.02.2020
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    public int[] getWinners()
    {
        int[] winnerIndexes;
        int length;
        int maxScore;
        int index;
        
        maxScore = 0;
        length = 0;
        
        // Finding the maximum score
        for ( int i = 0; i < scores.length; i++)
        {
           if ( scores[i] > maxScore)
           {
              maxScore = scores[i];
           }
        }
        
        // Finding the number of winners
        for ( int i = 0; i < scores.length; i++)
        {
           if ( scores[i] == maxScore)
              length++;
        }
        
        winnerIndexes = new int[length];
        index = 0;
        
        // Adding winners to the indexes array.
        for ( int i = 0; i < scores.length; i++)
        {
           if ( scores[i] == maxScore)
           {
              winnerIndexes[index] = i;
              index++;
           }
        }
        
        return winnerIndexes;
    }
    
} // end class ScoreCard
