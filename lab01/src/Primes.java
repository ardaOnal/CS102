
/**
 * A simple Primes class that contains a bag of 100 primes.
 * @author Arda Onal
 * @version 15.02.2020
 */
public class Primes
{
   public static void main( String[] args)
   {
      // constants
      
      // variables
      IntBag intBag;
      int primeTest;
      
      // program code
      intBag = new IntBag();
      
      // adding the prime to our bag.
      intBag.add(2);
      primeTest = 3;
      
      
      while ( intBag.size() < 100)
      {
         for ( int k = 0; k < intBag.size(); k++)
         {
            if ( primeTest % intBag.get( k) == 0)
            {
               primeTest += 2; // adds 2 to the candidate to make it more efficient.
               k = -1; // this makes the loop continue until it finds a prime number.
            }
         }
         
         intBag.add( primeTest);
      }
      
      System.out.println( intBag);

   }
}
