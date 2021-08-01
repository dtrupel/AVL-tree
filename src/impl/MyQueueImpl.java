package impl;

/**
 * This class is a data structure for processing nodes in order.
 * It implements the MyQueue interface.
 * The approach of this class is First In First Out.
 * The implementation is based on a circular array,
 * using the modulo-operation to move circularly around the array
 * to avoid shifting in terms of removing.
 * In this approach, there is no need to shift.
 *
 * @param <E> generic type.
 * @author Domagoj Trupeljak
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-09-23
 */
public class MyQueueImpl<E> implements MyQueue<E> {
    /**
     * A private field for the initial length of the Queue.
     */
    private int length = 50;
    /**
     * A private field for the size.
     */
    private int size = 0;
    /**
     * A private field for the nodes.
     */
    private AVLNode<E>[] nodes;
    /**
     * A private field for the pointer of the first node.
     */
    private int headIndex = 0;
    /**
     * A private field for the pointer of the last node.
     */
    private int tailIndex = 0;

    /**
     * A public constructor.
     */
    public MyQueueImpl() {
        nodes = new AVLNode[length];
    }

    /**
     * It returns the size of the Queue.
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * It returns the truth value of the Queue.
     *
     * @return whether it is empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds the node to the array.
     * If the queue is full, it will perform resize.
     * Chooses the location in the array based on modulo counting,
     * and moves the pointer one step forward.
     *
     * @param node node
     */
    @Override
    public void enqueue(AVLNode<E> node) {
        if (size < length) {
            tailIndex = tailIndex % length;
            nodes[tailIndex++] = node;
        } else {
            nodes = resize();
            nodes[tailIndex] = node;
            tailIndex = (tailIndex + 1) % length;
        }
        size++;
    }

    /**
     * Removes the first node from the array.
     * The removal is based on modulo counting,
     * After removal, the the pointer will be moved one step forward.
     */
    @Override
    public AVLNode<E> dequeue() {
        if (isEmpty())
            return null;
        else {
            AVLNode<E> node;
            headIndex = headIndex % length;
            node = nodes[headIndex];
            nodes[headIndex++] = null;
            size--;
            return node;
        }
    }

    /**
     * Doubles the size of the array and returns it.
     *
     * @return the new array of nodes.
     */
    private AVLNode<E>[] resize() {

        headIndex = 0;
        tailIndex = size;
        length = length * 2 + 1;

        AVLNode<E>[] tempNodes = new AVLNode[length];
        return copyArray(nodes, tempNodes);
    }

    private AVLNode<E> [] copyArray(AVLNode<E> [] src, AVLNode<E> [] dest) {

        for(int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }

        return dest;
    }
}