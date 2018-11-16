package tree;

import java.util.NoSuchElementException;

/**
 * Created by Peter Isaac
 */
public class BinaryTree<I extends Comparable<? super I>>{

    /** Root node */
    protected BinaryNode<I> root;

    /**
     * Constructor method
     * Analysis: Time - O(1)
     */
    public BinaryTree(){
        this.root = null;
    }


    /**
     * Return reference to the root node
     * @return root node
     */
    public BinaryNode<I> getRoot() {
        return root;
    }

    /**
     * Set root to the root node of the tree
     * @param root set as this.root
     */
    public void setRoot(BinaryNode<I> root) {
        this.root = root;
    }

    /**
     * Wrapper Function:
     * Calls insert(node, data)
     * @param data inserted into tree
     */
    public void insert(I data){
        this.root = insert(this.root, data);
    }

    /**
     * Insert Function
     * Time Analysis - O(log n)
     *
     * @param node - Root node, or current node when recursing tree
     * @param data - Data to be inserted into tree
     * @return - the new node created
     */
    private BinaryNode<I> insert(BinaryNode<I> node, I data){
        if(node == null){
            node = new BinaryNode<I>(data);
        }
        else{
            if(data.compareTo(node.data) <= 0){
                node.leftNode = insert(node.leftNode, data);
            }
            else{
                node.rightNode = insert(node.rightNode, data);
            }
        }
        return node;
    }

    /**
     * Wrapper Function
     * Calls delete(root, data)
     * @param data - Data to remove from the tree
     * @return the node that has been removed
     */
    public BinaryNode<I> delete(I data) {
        return delete(this.root, data);
    }

    /**
     * Delete Function
     * Time Analysis - O(log n)
     *
     * @param root - root node, current node when recursing tree
     * @param data - the data to remove from the tree
     * @return the node that has been removed
     */
    private BinaryNode<I> delete(BinaryNode<I> root, I data){
        // Base Case: Tree is Empty
        if(root == null)
            return root;

        // Traverse the tree
        if (data.compareTo(root.data) < 0) {
            root.leftNode = delete(root.leftNode, data);
        } else if (data.compareTo(root.data) > 0) {
            root.rightNode = delete(root.rightNode, data);
        }
        // Found the node to delete
        else{
            if (root.leftNode == null)
                return root.rightNode;
            if (root.rightNode == null)
                return root.leftNode;

            // Two children
            root.data = this.findInOrder(root.rightNode);
            root.rightNode = this.delete(root.rightNode, root.data);
        }
        return root;
    }

    /**
     * Helper function for delete()
     * - Finds the inorder successor
     * Time Analysis: O(log n)
     *
     * @param root - starting node
     * @return the value of the successor node
     */
    private I findInOrder(BinaryNode<I> root){
        I successor = root.data;
        while(root.leftNode != null){
            successor = root.data;
            root = root.leftNode;
        }
        return successor;
    }

    /**
     * Wrapper Function
     * Calls itemExists(data, node)
     * @param data - data to search for
     * @return true if the data is in the tree, false otherwise
     */
    public boolean itemExists(I data){
        return itemExists(data, root);
    }

    /**
     * Searches the tree for data
     * Time Analysis - O(log n)
     *
     * @param data - data to search the tree for
     * @param node - current node
     * @return true if the data is in the tree, false otherwise
     */
    private boolean itemExists(I data, BinaryNode<I> node){
        if(node == null){
            return false;
        }
        else {
            if (data.compareTo(node.data) == 0) {
                return true;
            } else if (data.compareTo(node.data) < 0) {
                return itemExists(data, node.leftNode);
            } else {
                return itemExists(data, node.rightNode);
            }
        }
    }

    /**
     * Search Function
     * Time Analysis - O(log n)
     *
     * @param data - data to search the tree for
     * @param node - current node
     * @return the node that was found
     * @throws NoSuchElementException
     */
    private BinaryNode<I> search(I data, BinaryNode<I> node) throws NoSuchElementException {
        if(node == null){
            throw new NoSuchElementException("Element doesn't exists in Binary Tree");
        }
        else {
            if (data.compareTo(node.data) == 0) {
                return node;
            } else if (data.compareTo(node.data) < 0) {
                return search(data, node.leftNode);
            } else {
                return search(data, node.rightNode);
            }
        }
    }

    /**
     * Wrapper Function
     * Calls maxValue(this.root)
     * @return maximum value in the tree
     */
    public I maxValue(){
        return maxValue(this.root);
    }

    /**
     * Traverse the tree to find the maximum value in the tree
     * Time Analysis - O(log n)
     *
     * @param node - current node
     * @return the maximum value in the tree
     */
    private I maxValue(BinaryNode<I> node){
        if(node.rightNode == null)
            return node.data;
        else
            return maxValue(node.rightNode);
    }

    /**
     * Wrapper Function
     * Calls minValue(this.root)
     * @return minimum value in the tree
     */
    public I minValue(){
        return minValue(this.root);
    }

    /**
     * Traverse the tree to find the minimum value in the tree
     * Time Analysis - O(log n)
     *
     * @param node - current node
     * @return the minimum value in the tree
     */
    private I minValue(BinaryNode<I> node){
        if(node.leftNode == null)
            return node.data;
        else
            return minValue(node.leftNode);
    }

    /**
     * Wrapper Function
     * Calls preOrder(root)
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * Prints out the current tree in pre order traversal
     * @param node - current node
     */
    private void preOrder(BinaryNode<I> node){
        if(node != null) {
            System.out.print(node.data + ", ");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    // Testing
    public static void main(String[] args){
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        // Testing insert()
        assert(tree != null);
        for (int i = 0; i < 20; i++){
            tree.insert(i);
        }
        // Testing minValue and maxValue
        assert(tree.minValue() == 0);
        assert(tree.maxValue() == 19);
        
        // Testing itemExists()
        for (int i = 0, i < 20; i++){
            assert(tree.itemExists(i);   
        }
        
        // Testing delete
        tree.delete(5);
        tree.delete(10);
        assert(tree.itemExists(5) == False);
        assert(tree.itemExists(10) == False);
                  
        System.out.println("Tests have passed\n");
    }
}
