import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A simple Hangman class!
 * @author Arda Onal
 * @version 16.02.2020
 */
public class Hangman{
   
   //properties
   public static StringBuffer secretWord;
   private StringBuffer allLetters;
   public  static StringBuffer usedLetters;
   private StringBuffer knownSoFar;
   private StringBuffer enteredLetter;
   int numberOfIncorrectTries;
   int maxAllowedIncorrectTries; 
   
   public  Hangman(){
      allLetters = new StringBuffer( "abcdefghijklmnopqrstuwxyz");
      maxAllowedIncorrectTries = 6;
      numberOfIncorrectTries = 0;
      usedLetters = new StringBuffer();
      secretWord = new StringBuffer( chooseSecretWord());
      knownSoFar = new StringBuffer( secretWord.length());
      for ( int i = 0; i < secretWord.length(); i++)
      {
         knownSoFar.append( "*");
      }
      
   }
   /*
    * This is a method that return all letters
    * @return allLetters
    * 
    */
   public StringBuffer getAllLetters(){
      return allLetters;
   }
   /*
    * This is a method that return all used letters
    * @return usedletters
    * 
    */
   public StringBuffer getUsedLetters(){
      return usedLetters;
   }
   
   /*
    * This is a method that return number of incorrect tries
    * @return numberOfIncorrectTries
    * 
    */
   public int getNumOfIncorrectTries(){
      return numberOfIncorrectTries;
   }
   
   /*
    * This is a method that return max allowed ýncorrect tries
    * @return maxAllowedIncorrectTries
    * 
    */
   public int getMaxAllowedIncorrectTries(){
      return maxAllowedIncorrectTries;
   }
   /*
    * This is a method that return letters known so far
    * @return knownSoFar
    * 
    */
   public StringBuffer getKnownSoFar(StringBuffer secretWord, String enteredLetter){
      
      char letter;
      letter = enteredLetter.charAt(0);
      for(int i = 0; i < secretWord.length(); i++){
         if( secretWord.charAt(i) == enteredLetter.charAt(0))
         {
            knownSoFar.deleteCharAt(i);
            knownSoFar.insert(i, letter);
            
         }
      }
      return knownSoFar;
   }
   
   public int tryThis( String letter )
   {
      //variables
      boolean existsInAllLetters;
      boolean existsInUsedLetters;
      int occurrence;
      char charLetter;
      
      //program code
      existsInAllLetters = false;
      existsInUsedLetters = false;
      occurrence = 0;
      charLetter = letter.charAt(0);
      
      //checks whether the game is over
      if ( isGameOver() )
         return -3;
      
      //checks whether the letter exists in english alphabet
      for (int n = 0; n < allLetters.length(); n++)
      {
         if ( charLetter == allLetters.charAt(n))
            existsInAllLetters = true;
      }
      if ( !existsInAllLetters )
         return -1;
      
      //checks whether the letter has been already used
      for ( int n = 0; n < usedLetters.length(); n++ )
      {
         if ( charLetter == usedLetters.charAt(n) )
            existsInUsedLetters = true;
      }
      if ( existsInUsedLetters )
         return -2;
      
      //counts the number of the occurrences of the letter in the secret word
      for ( int n = 0; n < secretWord.length(); n++ )
      {
         if ( charLetter == secretWord.charAt(n) )
            occurrence++;
      }
      
      //if it is an incorrect try increases the number of incorrrect tries
      if ( occurrence == 0 )
         numberOfIncorrectTries++;
      
      //returns the number of occurrences
      return occurrence;
   }
   
   
   /*
    * This is a method that return false if game is over
    * @return false
    * 
    */
   public boolean isGameOver(){
      
      String knownString;
      String secretString;
      knownString = knownSoFar.toString();
      secretString = secretWord.toString();
      
      if( numberOfIncorrectTries >= maxAllowedIncorrectTries || knownString.equals(secretString))
      {
         return true;
      }
      return false;
   }
   
   /*
    * This is a method that return false if game is lost
    * @return false
    * 
    */
   public boolean hasLost(){
      return numberOfIncorrectTries == maxAllowedIncorrectTries;
      
   }
   
   /**
    * choose secret word from fixed array
    * @return StrignBuffer choosen randomly from list
    */
//   public StringBuffer chooseSecretWord()
//   {
//      
//      StringBuffer[] words;
//      StringBuffer word;
//      int number;
//      
//      words = new StringBuffer[5];
//      
//      words[0] = new StringBuffer( "sudden" );
//      words[1] = new StringBuffer(  "table");
//      words[2] = new StringBuffer( "value");
//      words[3] = new StringBuffer( "right");
//      words[4] = new StringBuffer( "human");
//      
//      number= (int) ( Math.random() * words.length );
//      
//      word= words[ number ];
//      
//      return word;
//   }
   
   /**
    * choose secret word from a text
    * @return StringBuffer choosen randomly fom text
    */
   public StringBuffer chooseSecretWord()
   {
      ArrayList<String> list;
      String words;
      StringBuffer word;
      
      list = new ArrayList<String>();
      
      File testFile = new File("words.txt");
      
      // try/catch is used to prevent exception errors during compile
      try 
      {
         Scanner scan = new Scanner( testFile );
         
         while ( scan.hasNext() )
         {
            words = scan.next();
            list.add( words );
         }
      } catch ( FileNotFoundException e )
      {
         e.printStackTrace();
      }
      word = new StringBuffer ( list.get( (int) (Math.random() * list.size() ) ) );
      
      return word;
   }
   
}