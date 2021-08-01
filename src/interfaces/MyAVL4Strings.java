package interfaces;

public interface MyAVL4Strings {

    void insert(String element); //Insertion in AVL operation seen during the lectures.
    Couple<String> partialSearch(String beginning); //See description in the assignment
    MyList<MyList<String>> LevelByLevelLists(); //See description in the assignment
}
