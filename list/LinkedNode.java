package list;


/**
 * Created by peter on 2018-05-02.
 */
public class LinkedNode<I> {

    /** Contents of node */
    protected I item;

    /** The next node */
    protected LinkedNode<I> next;

    /**
     * Constructor
     * Analysis: Time = O(1)
     * @param item - data stored in the node
     */
    public LinkedNode(I item){
        this.item = item;
        this.next = null;
    }

    /**
     * Set this.item equal to item
     * Analysis: Time = O(1)
     * @param item - data stored in the node
     */
    public void setItem(I item){ this.item = item; }


    /**
     * Set this.next equal to next
     * Analysis: Time = O(1)
     * @param next - the next node
     */
    public void setNext(LinkedNode<I> next){ this.next = next; }


    /**
     * Analysis: Time = O(1)
     * @return item
     */
    public I getItem(){ return this.item; }

    /**
     * Analysis: Time = O(1)
     * @return next node
     */
    public LinkedNode<I> getNext(){ return this.next; }

}
