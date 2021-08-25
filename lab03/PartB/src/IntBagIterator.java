import java.util.Iterator;

public class IntBagIterator implements Iterator
{
    // properties
    private IntBag aBag;
    private int index;

    // constructors
    public IntBagIterator( IntBag bag)
    {
        aBag = bag;
        index = 0;
    }

    // methods

    public boolean hasNext()
    {
        return index < aBag.size();
    }

    public Integer next()
    {
        if ( hasNext())
        {
            index++;
            return aBag.get( index - 1);
        }
        else
            return null;
    }
}