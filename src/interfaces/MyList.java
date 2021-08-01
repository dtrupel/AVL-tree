package interfaces;

public interface MyList<E> {

    E get(int index); //returns the element in index position. The first element is in position 0.
    int size(); //returns the number of elements in the list
}
