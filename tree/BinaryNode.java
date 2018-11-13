package tree;

/**
 * Created by Peter Isaac
 */
public class BinaryNode<I> {

    /** Right node */
    protected BinaryNode<I> rightNode;

    /** Left node */
    protected BinaryNode<I> leftNode;

    /** Data stored in node */
    protected I data;

    /**
     * Constructor method
     * Analysis: Time - 0(1)
     * @param d is stored in data
     */
    public BinaryNode(I d){
        this.data = d;
        this.rightNode = null;
        this.leftNode = null;
    }

    /**
     * @return right node
     */
    public BinaryNode<I> getRightNode() {
        return rightNode;
    }

    /**
     * @param rightNode set as this.rightNode
     */
    public void setRightNode(BinaryNode<I> rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * @return left node
     */
    public BinaryNode<I> getLeftNode() {
        return leftNode;
    }

    /**
     * @param leftNode set as this.leftNode
     */
    public void setLeftNode(BinaryNode<I> leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * @return data - node data
     */
    public I getData() {
        return data;
    }

    /**
     * @param data set as this.data
     */
    public void setData(I data) {
        this.data = data;
    }

    // Testing
    public static void main(String[] args){
        BinaryNode<Integer> node = new BinaryNode<Integer>(42);
        if(null == node && node.leftNode != null && node.rightNode != null && node.data == 42){
            System.out.println("Error, constructor method");
        }

        node.setData(54);
        if(54 != node.getData()){
            System.out.println("Error, getData() method");
        }

        BinaryNode<Integer> l = new BinaryNode<Integer>(1);
        BinaryNode<Integer> r = new BinaryNode<Integer>(2);

        node.setLeftNode(l);
        node.setRightNode(r);
        if(l != node.getLeftNode() && r != node.getRightNode()){
            System.out.println("Error, setNode() methods");
        }


    }
}
