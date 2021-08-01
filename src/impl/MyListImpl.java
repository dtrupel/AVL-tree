package impl;

import interfaces.MyList;

/**
 * This class is for the list and it implements the interfaces.MyList interface.
 *
 * @param <E> generic type.
 * @author Domagoj Trupeljak
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-09-23
 */
public class MyListImpl<E> implements MyList<E> {

    /**
     * A private field for the list of lists.
     */
    private final ListOfLists<E> listOfLists;

    /**
     * A public constructor.
     *
     * @param listOfLists the list of lists.
     */
    public MyListImpl(ListOfLists<E> listOfLists) {
        this.listOfLists = listOfLists;
    }

    /**
     * It returns a list at a specific index.
     *
     * @param index for the position of the list.
     * @return a list of strings.
     */
    @Override
    public E get(int index) {
        return listOfLists.get(index);
    }

    /**
     * Returns the size of the list.
     *
     * @return size
     */
    @Override
    public int size() {
        return listOfLists.size();
    }
}
