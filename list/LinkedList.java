package list;

/**
 * Created by peter on 2018-05-02.
 */
public class LinkedList<I> {

    /** Head node */
    protected LinkedNode<I> head;

    /** Tail node */
    protected LinkedNode<I> tail;

    /** Node at current position */
    protected LinkedNode<I> position;

    /** Node at the previous current position */
    protected LinkedNode<I> prevPosition;

    protected int numElements;

    /**
     * Constructor
     * Analysis: Time = O(1)
     */
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.position = null;
        this.prevPosition = null;
    }

    /**
     * Adds node directly after position
     * @param node - LinkedNode<I>
     */
    public void insert(LinkedNode<I> node){
        if(this.isEmpty()){
            this.append(node);
        }
    }

    /**
     * Adds node directly before position
     * @param node - LinkedNode<I>
     */
    public void insertBefore(LinkedNode<I> node){
        if(this.isEmpty()){
            this.append(node);
        }
    }

    /**
     * Adds node to the front of list
     * @param node - LinkedNode<I>
     */
    public void prepend(LinkedNode<I> node){
        if(this.isEmpty()){
            this.append(node);
        }
        else{
            this.prevPosition = position;
            node.next = this.head;
            this.head = node;
            this.position = head;
        }
        this.numElements++;
    }

    /**
     * Adds node to the end of list
     * @param node - LinkedNode<I>
     */
    public void append(LinkedNode<I> node){
        if(this.isEmpty()){
            this.head = node;
            this.tail = head;
            this.position = head;
        }
        else{
            this.prevPosition = this.position;
            this.tail.next = node;
            this.tail = node;
            this.position= this.tail;
        }
        this.numElements++;
    }

    public boolean isEmpty(){
        return this.numElements == 0;
    }

    public static void main(String[] args){
        LinkedList<Integer> l = new LinkedList<>();

    }

}
