package impl;

import interfaces.Couple;
import interfaces.MyAVL4Strings;
import interfaces.MyList;

/**
 * The class for the AVL Tree.
 * It implements the interfaces.MyAVL4Strings interface.
 *
 * @author Domagoj Trupeljak
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-09-20
 */
public class MyAVL4StringsImpl implements MyAVL4Strings {

    /**
     * The limited for value for imbalance.
     */
    private static final int ALLOWED_IMBALANCE = 1;


    /**
     * A private field for the root node.
     */
    private AVLNode<String> root;

    /**
     * A public constructor.
     * Assigns the root node.
     */
    public MyAVL4StringsImpl() {
        root = null;
    }

    /**
     * It inserts the elements.
     */
    @Override
    public void insert(String element) {
        root = insert(element, root);
    }

    /**
     * Adds the string to a node.
     * This method is a private method and does its
     * operation recursively.
     * Balances the tree after insertion.
     * If there is a node that contains the same value
     * then the insert call will be ignored, because the AVL Tree
     * is a BST tree and that implies that it does not allow
     * duplicates.
     * O(logN)
     *
     * @param value the string.
     * @param node  the root node.
     * @return AVLNode, the new root.
     */
    private AVLNode<String> insert(String value, AVLNode<String> node) {
        if (node == null)
            return new AVLNode<>(value, null, null);
        int compareResult = value.compareTo(node.getValue());
        if (compareResult < 0)
            node.setLeftChild(insert(value, node.getLeftChild()));
        else if (compareResult > 0)
            node.setRightChild(insert(value, node.getRightChild()));

        return balance(node);
    }

    /**
     * Balances the tree based on the heights of the sub-trees.
     * O(1)
     *
     * @param node the node.
     * @return the new root.
     */
    private AVLNode<String> balance(AVLNode<String> node) {

        if (node == null)
            return null;

        if (height(node.getLeftChild()) - height(node.getRightChild()) > ALLOWED_IMBALANCE) {
            if (height(node.getLeftChild().getLeftChild()) >= height(node.getLeftChild().getRightChild()))
                node = rotateWithLeftChild(node);
            else
                node = doubleWithLeftChild(node);
        } else if (height(node.getRightChild()) - height(node.getLeftChild()) > ALLOWED_IMBALANCE) {
            if (height(node.getRightChild().getRightChild()) >= height(node.getRightChild().getLeftChild()))
                node = rotateWithRightChild(node);
            else
                node = doubleWithRightChild(node);
        }

        setHeight(node);

        return node;
    }

    /**
     * Returns the height of a given node.
     * O(1)
     *
     * @param node specified node.
     * @return height of the node.
     */
    private int height(AVLNode<String> node) {
        return node == null ? 0 : node.getHeight();
    }

    /**
     * Sets height of a given node by
     * inspecting its children heights.
     * O(1)
     *
     * @param node specified node.
     */
    private void setHeight(AVLNode<String> node) {
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    }

    /**
     * Sets height of two nodes by
     * overriding setHeight(node).
     * O(1)
     *
     * @param node1 first node.
     * @param node2 second node.
     */
    private void setHeight(AVLNode<String> node1, AVLNode<String> node2) {
        setHeight(node1);
        setHeight(node2);
    }

    /**
     * Performs single right - left rotation of a given node.
     * O(1)
     *
     * @param k node to rotate.
     * @return node around which rotation occurs.
     */
    private AVLNode<String> rotateWithRightChild(AVLNode<String> k) {

        AVLNode<String> k1 = k.getRightChild();
        k.setRightChild(k1.getLeftChild());
        k1.setLeftChild(k);
        setHeight(k, k1);
        return k1;
    }

    /**
     * Performs double right - left rotation of a given node.
     * O(1)
     *
     * @param k node to rotate.
     * @return node around which rotation occurs.
     */
    private AVLNode<String> doubleWithRightChild(AVLNode<String> k) {
        k.setRightChild(rotateWithLeftChild(k.getRightChild()));
        return rotateWithRightChild(k);
    }

    /**
     * Performs single left - right rotation of a given node.
     * O(1)
     *
     * @param k node to rotate.
     * @return node around which rotation occurs.
     */
    private AVLNode<String> rotateWithLeftChild(AVLNode<String> k) {

        AVLNode<String> k1 = k.getLeftChild();
        k.setLeftChild(k1.getRightChild());
        k1.setRightChild(k);
        setHeight(k, k1);
        return k1;
    }

    /**
     * Performs double left - right rotation of a given node.
     * O(1)
     *
     * @param k node to rotate.
     * @return node around which rotation occurs.
     */
    private AVLNode<String> doubleWithLeftChild(AVLNode<String> k) {
        k.setLeftChild(rotateWithRightChild(k.getLeftChild()));
        return rotateWithLeftChild(k);
    }

    /**
     * Takes a string and searches a binary tree for the
     * minimum and the maximum value containing the string.
     * Method executes in 3 steps:
     * 1) Find the first node in the tree
     * containing the string. ( O(logN) ).
     * 2) Look at the found node's left subtree to
     * search for a minimum value. ( O(logN) ).
     * 3) Look at the found node's right subtree to
     * search for a maximum value. ( O(logN) ).
     * logN + logN + logN = 3logN =>
     * O(logN).
     *
     * @param beginning partial textual value to search for.
     * @return interfaces.Couple object with min and max values.
     */
    @Override
    public Couple<String> partialSearch(String beginning) {

        Couple<String> minMax = new CoupleImpl<>();
        AVLNode<String> theNode = searchNode(root, beginning);

        if (theNode == null)
            throw new NullPointerException("null");

        String min = findMinimum(theNode.getLeftChild(), beginning, theNode.getValue());
        if (min == null)
            minMax.setFirst(theNode.getValue());
        else
            minMax.setFirst(min);

        String max = findMaximum(theNode.getRightChild(), beginning, theNode.getValue());
        if (max == null)
            minMax.setLast(theNode.getValue());
        else
            minMax.setLast(max);

        return minMax;
    }

    /**
     * Searches for the first node in the tree
     * containing a given partial textual value.
     * O(logN)
     *
     * @param node      the node from which the search begins.
     * @param beginning partial textual value to search for.
     * @return the first node containing the partial textual value.
     */
    private AVLNode<String> searchNode(AVLNode<String> node, String beginning) {

        if (node == null || node.getValue().startsWith(beginning))
            return node;

        if (beginning.compareTo(node.getValue()) < 0)
            return searchNode(node.getLeftChild(), beginning);
        else
            return searchNode(node.getRightChild(), beginning);
    }

    /**
     * Searches for a minimum value starting from
     * the left child of the first node containing
     * the partial textual value.
     * O(logN)
     *
     * @param node      starting node.
     * @param beginning partial textual value to search for.
     */

    private String findMinimum(AVLNode<String> node, String beginning, String currentMin) {

        if(node == null) {
            return null;
        }

        String value = node.getValue();
        AVLNode<String> leftChild = node.getLeftChild();
        AVLNode<String> rightChild = node.getRightChild();

        if(value.startsWith(beginning)) {
            currentMin = value;
            if(leftChild != null) {
                return findMinimum(leftChild, beginning, currentMin);
            }
        }else {
            if(rightChild != null) {
                return findMinimum(rightChild, beginning, currentMin);
            }
        }
        return currentMin;
    }

    /**
     * Searches for a maximum value starting from
     * the right child of the first node containing
     * the partial textual value.
     * (Mirrors the findMin method)
     * O(logN)
     *
     * @param node      starting node.
     * @param beginning partial textual value to search for.
     */
    private String findMaximum(AVLNode<String> node, String beginning, String currentMax) {

        if(node == null) {
            return null;
        }

        String value = node.getValue();
        AVLNode<String> leftChild = node.getLeftChild();
        AVLNode<String> rightChild = node.getRightChild();

        if(value.startsWith(beginning)) {
            currentMax = value;
            if(rightChild != null) {
                return findMaximum(rightChild, beginning, currentMax);
            }
        }else {
            if(leftChild != null) {
                return findMaximum(rightChild, beginning, currentMax);
            }
        }
        return currentMax;
    }

    /**
     * Returns the root node.
     *
     * @return root
     */
    public AVLNode<String> getRoot() {
        return root;
    }

    /**
     *
     * This method returns a list of lists.
     * Performs scanning of elements in order.
     *
     * Places the root in a list-under-process that its nodes should
     * be processed in order. Then, the children of the nodes in the
     * list-under-process will be placed into a waiting list. Always, the left
     * child will be placed first into the waiting list and then the right child.
     * When the list-under-process is processed and it is empty, its result will be added
     * to the list of the lists.
     *
     * Then, the elements in the waiting list will be moved
     * to the list-under-process. The same process will be repeated till the
     * tree is processed entirely and that is when the waiting list
     * is empty and has no element to be processed.
     *
     * Number of iterations always equals to the number of elements. Hence:
     * O(n)
     *
     * @return list of lists of strings.
     */
    @Override
    public MyList<MyList<String>> LevelByLevelLists() {
        if (getRoot() == null)
            return null;
        ListOfLists<MyList<String>> listOfLists = new ListOfLists<>();
        ListOfLists<String> tempList = new ListOfLists<>();
        MyQueue<String> nodesUnderProcess = new MyQueueImpl<>();
        MyQueue<String> nodesInLine = new MyQueueImpl<>();
        nodesUnderProcess.enqueue(getRoot());
        while (true) {
            AVLNode<String> tempNode = nodesUnderProcess.dequeue();
            if (tempNode.getLeftChild() != null)
                nodesInLine.enqueue(tempNode.getLeftChild());
            if (tempNode.getRightChild() != null)
                nodesInLine.enqueue(tempNode.getRightChild());
            tempList.add(tempNode.getValue());
            if (nodesUnderProcess.isEmpty()) {
                listOfLists.add(tempList);
                if (nodesInLine.isEmpty())
                    break;
                else {
                    tempList = new ListOfLists<>();
                    nodesUnderProcess = nodesInLine;
                    nodesInLine = new MyQueueImpl<>();
                }
            }
        }
        return new MyListImpl<>(listOfLists);
    }
}
