import java.util.*;

/** 
 * A simple Hangman game! (I get compiler errors in DrJava but it works in eclipse)
 * @author Arda Onal
 * @version 16.02.2020
 */ 
public class HangmanMain
{
   public static void  main(String[] args) 
   {
      // variables
      Hangman hangman = new Hangman();
      boolean testGameOver;
      boolean appender;
      String letter;
      char charLetter;
      Scanner scan;
      int returnedInteger;
      
      //program code
      scan = new Scanner( System.in);
      appender = true;
      
      testGameOver = hangman.isGameOver();  // CHECKS IF THE GAME IS OVER, SUPPOSED THAT isGameOver() METHOD 
      // GIVES THE RESULT "FALSE" INITIALLY SINCE THE GAME IS NOT OVER, YET EVEN STARTED :)
      
      
      System.out.println( hangman.getAllLetters());  //  SHOWS THE USER ALL POSSIBLE LETTERS IN THE ALPHABET, SUPPOSED THAT getAllLeters() METHOD
      //  RETURNS THE STRING OF ENGLISH ALPHABET
      
      System.out.print( "Hello there! ");
      
      
      while ( !testGameOver)
      {
         System.out.println( "Please use unused letter from the English Alphabet.\n Used letters are: " + hangman.getUsedLetters());
         charLetter = scan.next().charAt(0);
         letter = "" + charLetter; // converting input char to string
         
         returnedInteger = hangman.tryThis(letter); // trythis method
         
         // Adds the char to used letters at the first time
         if ( Hangman.usedLetters.length() == 0)
         {
            Hangman.usedLetters.append(letter);
            appender = false;
         }
         
         // checks if the letter has already been added to used letters
         for ( int i = 0; i < Hangman.usedLetters.length(); i++)
         {
            if ( Hangman.usedLetters.charAt(i) == letter.charAt(0))
            {
               appender = false;
            }
         }
         
         // adds the letter to usedletters if it didnt exits.
         if ( appender)
            Hangman.usedLetters.append(letter);
         appender = true;
         
         if ( returnedInteger == 0) {  //  IF tryThis() METHOD RETURNS 0, THEN IT MEANS THERE IS NO LETTER IN THE WORD MATCHES WITH THE LETTER USER ENTERED
            
            System.out.println( "The letter " + letter + " is not in this word.");
            System.out.println( hangman.getKnownSoFar(Hangman.secretWord, letter));  
         }
         
         else if ( returnedInteger == -1 ) {  //  IF tryThis() METHOD RETURNS -1, THEN IT MEANS USER ENTERED AN INVALID LETTER
            System.out.println( "Error, you have entered an invalid letter.");
         }
         
         else if ( returnedInteger == -2 ){   //  IF tryThis() METHOD RETURNS -2, THEN IT MEANS USER ENTERED A LETTER THAT HAS ALREADY BEEN ENTERED
            System.out.println( "Error, you have already tried this letter.");
         } 
         
         else if ( returnedInteger == -3 ){   //  IF tryThis() METHOD RETURNS -3, THEN IT MEANS GAME IS OVER
            System.out.println( "The game is over!");
         }
         
         else 
         {
            System.out.println( hangman.getKnownSoFar(Hangman.secretWord, letter));  
         }  
         
         testGameOver = hangman.isGameOver();  //  WE ASSUME THAT THE BOOLEAN RETURN VALUE OF isGameOver() CHANGES WHEN USER ENTERS DIFFERENT LETTERS
         //  IF ALL THE LETTERS ARE REVEALED OR MAX INCORRECT TRIES GOT REACHED, THE METHOD WILL RETURN TRUE.
         //  THE LINE CHECKS AT THE END OF EACH LOOP WHETHER GAME ENDED OR NOT.
      }
      
      if ( hangman.hasLost())
         System.out.println( "You lost!" );
      else
         System.out.println( "You win!" );
   } 
}
