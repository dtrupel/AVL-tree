package impl;

/**
 * This a class for the node of the AVL Tree.
 *
 * @param <E> generic type.
 * @author Domagoj Trupeljak
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-09-20
 */
public class AVLNode<E> {

    /**
     * A private field for the value.
     */
    private final E value;
    /**
     * A private field for the left node.
     */
    private AVLNode<E> leftChild;
    /**
     * A private field for the right node.
     */
    private AVLNode<E> rightChild;
    /**
     * A private field for the height of the node.
     */
    private int height = 0;

    /**
     * A public constructor.
     *
     * @param value      generic type.
     * @param leftChild  the left node.
     * @param rightChild the right node.
     */
    public AVLNode(E value, AVLNode<E> leftChild, AVLNode<E> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * It returns the value.
     *
     * @return value.
     */
    public E getValue() {
        return value;
    }

    /**
     * It returns the height of the node.
     *
     * @return the height of the node.
     */
    public int getHeight() {
        return height;
    }

    /**
     * It returns the left node.
     *
     * @return the left node.
     */
    public AVLNode<E> getLeftChild() {
        return leftChild;
    }

    /**
     * It returns the right node.
     *
     * @return the right node.
     */
    public AVLNode<E> getRightChild() {
        return rightChild;
    }

    /**
     * It sets the left child.
     *
     * @param leftChild the left node.
     */
    public void setLeftChild(AVLNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * It sets the right child.
     *
     * @param rightChild the right node.
     */
    public void setRightChild(AVLNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * It sets the height of the node.
     *
     * @param height the height of the node.
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
