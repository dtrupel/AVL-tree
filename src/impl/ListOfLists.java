package impl;

import interfaces.MyList;

public class ListOfLists<E> implements MyList<E> {

    /**
     * A private field for the size of the list.
     */
    private static final int DEFAULT_SIZE = 20;
    /**
     * A private field for the size of the list.
     */
    private int currentSize;
    /**
     * A private field for the array of the objects.
     */
    private Object[] list;

    /**
     * A private field for the full size of the list
     */
    private int fullSize;

    /**
     * A public constructor.
     * Initializes the list with a default size.
     */
    public ListOfLists() {
        this(DEFAULT_SIZE);
    }

    /**
     * A private constructor.
     * Initializes the list with a given custom size.
     */
    private ListOfLists(int size) {
        list = new Object[size];
        fullSize = size;
        currentSize = 0;
    }

    /**
     * Returns the element at a given position.
     *
     * @param index the index of the element.
     * @return element.
     */
    @Override
    public E get(int index) {
        if (index > currentSize-1)
            return null;
        return (E) list[index];
    }

    /**
     * Appends the element to the end of a list.
     * Resizes the list when it is full.
     *
     * @param newElement element.
     */
    public void add(E newElement) {
        if (newElement == null)
            return;
        if (currentSize == fullSize)
            list = resize();
        list[currentSize++] = newElement;
    }

    /**
     * Returns the size of the list.
     *
     * @return size
     */
    @Override
    public int size() {
        return currentSize;
    }

    /**
     * Doubles the size of the list and returns it.
     *
     * @return new array - double in size, with the same elements.
     */
    private Object[] resize() {
        fullSize += DEFAULT_SIZE;
        Object[] temp = new Object[fullSize];
        System.arraycopy(list, 0, temp, 0, list.length);
        return temp;
    }
}
