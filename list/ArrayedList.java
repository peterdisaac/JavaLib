package list;

/**
 * Created by Peter Isaac
 */
public class ArrayedList<I> {

    /**
     * Array where elements are stored *
     */
    protected I[] list;


    /**
     * Beginning and ending indices for the list
     */
    protected int head, tail;

    /**
     * Index for current position in the list
     */
    protected int position;

    /**
     * The capacity of the array
     */
    protected int capacity;

    /**
     * The number of elements currently in the list
     */
    protected int numElements;

    /**
     * Used to calculate the nex index for head or tail
     * indices.
     * @param index - index of head or tail
     * @param capacity - capacity
     * @return the next index for head or tail
     */
    private int modulo(int index, int capacity){
        return ((index % capacity) + capacity) % capacity;
    }

    /**
     * Constructor - new, empty list
     * Analysis: Time - O(1)
     * @param cap the maximum number of elements the list can hold
     */
    @SuppressWarnings("unchecked")
    public ArrayedList(int cap){
        this.head = 0;
        this.tail = 0;
        this.numElements = 0;
        this.position = 0;
        this.capacity = cap;
        this.list = (I[]) new Object[cap];
    }

    public boolean isFull(){
        return this.numElements == this.capacity;
    }

    public boolean isEmpty(){
        return this.numElements == 0;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getCount(){
        return this.numElements;
    }

    public int getPosition(){
        return this.position;
    }

    public void append(I item) throws Exception {
        if(this.isFull()) throw new Exception("Array full");

        this.tail = this.modulo(tail - 1, capacity);

        this.list[this.tail] = item;
        this.numElements++;
    }

    public void prepend(I item) throws Exception {
        if(this.isFull()) throw new Exception("Array full");

        this.head = this.modulo(head + 1, capacity);

        this.list[this.head] = item;
        this.numElements++;

    }

    public void delete(I item) throws Exception {
        if(this.isEmpty()) throw new Exception("Array empty");


    }

}
