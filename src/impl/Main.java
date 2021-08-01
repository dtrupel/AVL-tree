package impl;

import interfaces.Couple;
import interfaces.MyList;

public class Main {

    public static final Logger LOGGER = new Logger();

    public static void main(String[] args) {

        String[] names = StaticData.getNames();
        String[] parts = StaticData.getStringParts();
        MyAVL4StringsImpl tree = new MyAVL4StringsImpl();
        String lineFeed = "\n";
        LOGGER.print("The number of elements in the array of names is: "
                + names.length + lineFeed);
        for (String name : names) tree.insert(name);
        LOGGER.print(lineFeed);
        try {
            //Print out level by level lists to make it easier to draw a tree
            MyList<MyList<String>> list = tree.LevelByLevelLists();
            for (int i = 0; i < list.size(); i++) {
                LOGGER.print("Height: " + (list.size() - i) + "\nRow: " + (i + 1) + " = > ");
                for (int j = 0; j < list.get(i).size(); j++)
                    LOGGER.print(list.get(i).get(j) + " ");
                LOGGER.print(lineFeed);
            }

            LOGGER.print(lineFeed);
            //Print couples for multiple starting string choices
            for (String part : parts) {
                LOGGER.printLine("For string \"" + part + "\":");
                Couple<String> duple = tree.partialSearch(part);
                printMinAndMax(duple.getFirst(), duple.getLast());
            }
        } catch (NullPointerException e) {
            LOGGER.print("\t" + e.getMessage());
        }
    }

    private static void printMinAndMax(String min, String max) {
        LOGGER.printLine("\tMin: " + min);
        LOGGER.printLine("\tMax: " + max);
    }
}
