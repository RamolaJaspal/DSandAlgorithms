import java.util.Iterator;

/**
 * @author Jaspal Chand Ramola
 */
public class DynamicArray implements Iterable<Integer>,Iterator<Integer>{

    private int [] array;
    final private int defaultCapacity=16;
    private int capacity;
    private int lastElementindex=-1;
    private int loadfactor=2;
    private int iteratorCounter;
    public DynamicArray()
    {
        this.array=new int[defaultCapacity];
        this.capacity=defaultCapacity;
    }

    public DynamicArray(int intialSize)
    {
        this.array=new int[intialSize];
        this.capacity=intialSize;
    }
    
    public void add(int element)
    {   
        lastElementindex++;
        if(lastElementindex==capacity)
        {
            int [] arrayNew=new int[capacity*loadfactor];
            for(int i=0;i<lastElementindex;i++)
            {
                arrayNew[i]=array[i];
            }

            this.array=arrayNew;
            capacity=capacity*loadfactor;
            this.array[lastElementindex]=element;
        }
        else
        {
            this.array[lastElementindex]=element;
        }
    }

    public int size()
    {
        return lastElementindex+1;
    }

    public int get(int i)
    {

        return array[i];
    }

    public String toString()
    {
        StringBuilder output=new StringBuilder();

        for(int i=0;i<lastElementindex+1;i++)
        {
            output=output.append(":"+get(i));
        }
        
        return output.toString();
    }

    @Override
    public boolean hasNext() {
        if(this.iteratorCounter<=lastElementindex)
        {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        iteratorCounter++;
        return this.array[this.iteratorCounter-1]; 
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Integer> iterator() {
        this.iteratorCounter=0;
        return this;
    }

}