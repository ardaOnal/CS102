import java.util.Iterator;
/**
 * A simple Integer class that contains a bag of integers
 * @author Arda Onal
 * @version 14.02.2020
 */
public class IntBag
{
    // properties
    private int valid;
    private int[] bag;

    // constructors
    public IntBag()
    {
        valid = 0;
        bag = new int[100];
    }

    public IntBag( int maxElements)
    {
        valid = 0;
        bag = new int[maxElements];
    }

    // methods

    /**
     * This method adds an input value to the last location in the array.
     * @param  inputValue
     */
    public void add( int inputValue)
    {
        bag[valid] = inputValue;
        valid++;
    }

    /**
     * This method adds an input value to a specific index.
     * @param  inputValue is the value that will be added to the array.
     * @param  index is the location where it will be added to the array.
     * @return returns true or false if it is able to add to array.
     */
    public boolean add( int index, int inputValue)
    {
        if ( valid < index)
            return false;

        valid++;

        // shifting all elements one upwards.
        for ( int i = valid; i > index; i--)
            bag[i] = bag[i - 1];

        bag[index] = inputValue;
        return true;
    }

    /**
     * This method removes a value at a specific index.
     * @param  index is the index that the value will be removed.
     */
    public void remove( int index)
    {
        for ( int i = index; i < valid - 1; i++)
            bag[i] = bag[i + 1];

        valid--;
    }

    /**
     * This method checks if a specific value is in our bag.
     * @param  inputValue will be checked if it is in the array or not.
     */
    public boolean contains( int inputValue)
    {
        for ( int i = 0; i < valid; i++)
        {
            if ( bag[i] == inputValue)
                return true;
        }
        return false;
    }

    /**
     * This is the toString method.
     * @return returns the string representation of our object.
     */
    public String toString()
    {
        String s;
        s = "This bag contains: ";

        for ( int i = 0; i < valid; i++)
            s = s + bag[i] + " ";


        return s;
    }

    /**
     * This method returns the number of valid elements in the array.
     * @return returns the valid integers.
     */
    public int size()
    {
        return valid;
    }

    /**
     * This method returns the number int a specific index.
     * @return returns the desired int at the specific location.
     */
    public int get( int index)
    {
        return bag[index];
    }

    /**
     * This method finds all of the indexes of a user entered value.
     * @param inputValue is an integer.
     * @return returns the desired int at the specific location.
     */
    public IntBag findAll( int inputValue)
    {
        IntBag indexes;
        indexes = new IntBag();

        for ( int i = 0; i < valid; i++)
        {
            if ( bag[i] == inputValue)
                indexes.add(i);
        }

        return indexes;
    }

    public Iterator iterator()
    {
        IntBagIterator x;
        x = new IntBagIterator( this);

        return x;
    }

}