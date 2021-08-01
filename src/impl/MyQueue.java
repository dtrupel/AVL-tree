package impl;

/**
 * This Interface is for a list of nodes.
 * It supports FIRST IN FIRST OUT.
 *
 * @author Domagoj Trupeljak
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-09-23
 */
public interface MyQueue<E> {

    /**
     * Returns the size of the Queue.
     *
     * @return the size of the Queue.
     */
    int size();

    /**
     * Returns the truth value.
     *
     * @return Whether the Queue is empty.
     */
    boolean isEmpty();

    /**
     * Adds the node to the array.
     *
     * @param node node
     */
    void enqueue(AVLNode<E> node);

    /**
     * Removes the first node from the array.
     *
     * @return node
     */
    AVLNode<E> dequeue();
}

