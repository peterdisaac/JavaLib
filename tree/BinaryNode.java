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
}
