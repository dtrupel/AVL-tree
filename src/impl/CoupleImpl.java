package impl;

import interfaces.Couple;

/**
 * This class is for the couple object that holds
 * the minimum value as well as the maximum value.
 *
 * @param <E>
 * @author Domagoj Trupeljak
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-09-23
 */
public class CoupleImpl<E> implements Couple<E> {

    /**
     * A private field for first.
     */
    private E first;
    /**
     * A private field for last.
     */
    private E last;

    /**
     * It returns the first value.
     *
     * @return E
     */
    @Override
    public E getFirst() {
        return first;
    }

    /**
     * It sets the value.
     *
     * @param first first value.
     */
    @Override
    public void setFirst(E first) {
        this.first = first;
    }

    /**
     * It returns the value.
     *
     * @return last value.
     */
    @Override
    public E getLast() {
        return last;
    }

    /**
     * It sets the value.
     *
     * @param last last value.
     */
    @Override
    public void setLast(E last) {
        this.last = last;
    }
}
