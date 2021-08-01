package test;

import impl.MyAVL4StringsImpl;
import interfaces.Couple;
import interfaces.MyList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestMyAVL4StringsPart2 {

	private MyAVL4StringsImpl tree;

    @Test
    public void TestLevelsOfSingleElementShort() {

		tree = new MyAVL4StringsImpl();

		tree.insert("Alice");
		tree.insert("Bob");
		tree.insert("Jon");
		tree.insert("Jonatan");
		tree.insert("Jonna");
		tree.insert("Jones");
		tree.insert("Jonny");
		tree.insert("Jonty");
		tree.insert("Xabier");

		MyList<MyList<String>> byLevels = tree.LevelByLevelLists();

		Assertions.assertTrue(byLevels.get(0).get(0).equals("Jonatan"));
		Assertions.assertTrue(byLevels.get(1).get(0).equals("Bob"));
		Assertions.assertTrue(byLevels.get(1).get(1).equals("Jonny"));
		Assertions.assertTrue(byLevels.get(2).get(0).equals("Alice"));
		Assertions.assertTrue(byLevels.get(2).get(1).equals("Jon"));
		Assertions.assertTrue(byLevels.get(2).get(2).equals("Jonna"));
		Assertions.assertTrue(byLevels.get(2).get(3).equals("Jonty"));
		Assertions.assertTrue(byLevels.get(3).get(0).equals("Jones"));
		Assertions.assertTrue(byLevels.get(3).get(1).equals("Xabier"));

    }

    @Test
	public void testLevelsOfSingleElementLong() {

    	tree = new MyAVL4StringsImpl();

		tree.insert("Ana");
		tree.insert("Blaine");
		tree.insert("Charles");
		tree.insert("Danny");
		tree.insert("Earl");
		tree.insert("Frank");
		tree.insert("George");
		tree.insert("Hillary");
		tree.insert("Ian");
		tree.insert("Jane");
		tree.insert("Kendrick");
		tree.insert("Lory");
		tree.insert("Miriam");
		tree.insert("Nelson");
		tree.insert("Otto");
		tree.insert("Pamela");
		tree.insert("Quentin");
		tree.insert("Ruby");
		tree.insert("Simona");
		tree.insert("Trent");
		tree.insert("Usain");
		tree.insert("Vivian");
		tree.insert("Walter");
		tree.insert("Xavier");
		tree.insert("Yin");
		tree.insert("Zaire");

		/*
		* testlevelbylevellistlong.jpg -> for reference
		* The number of letters (26) does not match potentials of 2 (..16, 32..)
		* which makes the tree less evenly distributed among left and right
		* subtrees of the root.
		* */

		MyList<MyList<String>> listOfLists = tree.LevelByLevelLists();
		Assertions.assertTrue(listOfLists.get(0).get(0).equals("Pamela"));
		Assertions.assertTrue(listOfLists.get(1).get(0).equals("Hillary"));
		Assertions.assertTrue(listOfLists.get(1).get(1).equals("Trent"));
		Assertions.assertTrue(listOfLists.get(2).get(0).equals("Danny"));
		Assertions.assertTrue(listOfLists.get(2).get(1).equals("Lory"));
		Assertions.assertTrue(listOfLists.get(2).get(2).equals("Ruby"));
		Assertions.assertTrue(listOfLists.get(2).get(3).equals("Vivian"));
		Assertions.assertTrue(listOfLists.get(3).get(0).equals("Blaine"));
		Assertions.assertTrue(listOfLists.get(3).get(1).equals("Frank"));
		Assertions.assertTrue(listOfLists.get(3).get(2).equals("Jane"));
		Assertions.assertTrue(listOfLists.get(3).get(3).equals("Nelson"));
		Assertions.assertTrue(listOfLists.get(3).get(4).equals("Quentin"));
		Assertions.assertTrue(listOfLists.get(3).get(5).equals("Simona"));
		Assertions.assertTrue(listOfLists.get(3).get(6).equals("Usain"));
		Assertions.assertTrue(listOfLists.get(3).get(7).equals("Xavier"));
		Assertions.assertTrue(listOfLists.get(4).get(0).equals("Ana"));
		Assertions.assertTrue(listOfLists.get(4).get(1).equals("Charles"));
		Assertions.assertTrue(listOfLists.get(4).get(2).equals("Earl"));
		Assertions.assertTrue(listOfLists.get(4).get(3).equals("George"));
		Assertions.assertTrue(listOfLists.get(4).get(4).equals("Ian"));
		Assertions.assertTrue(listOfLists.get(4).get(5).equals("Kendrick"));
		Assertions.assertTrue(listOfLists.get(4).get(6).equals("Miriam"));
		Assertions.assertTrue(listOfLists.get(4).get(7).equals("Otto"));
		Assertions.assertTrue(listOfLists.get(4).get(8).equals("Walter"));
		Assertions.assertTrue(listOfLists.get(4).get(9).equals("Yin"));
		Assertions.assertTrue(listOfLists.get(5).get(0).equals("Zaire"));
	}

	@Test
	public void testPartialSearchShort() {

		tree = new MyAVL4StringsImpl();

		tree.insert("Alice");
		tree.insert("Bob");
		tree.insert("Jon");
		tree.insert("Jonatan");
		tree.insert("Jonna");
		tree.insert("Jones");
		tree.insert("Jonny");
		tree.insert("Jonty");
		tree.insert("Xabier");

		Couple<String> duple = tree.partialSearch("Jon");
		Assertions.assertTrue(duple.getFirst().equals("Jon"));
		Assertions.assertTrue(duple.getLast().equals("Jonty"));

		duple = tree.partialSearch("Jonn");
		Assertions.assertTrue(duple.getFirst().equals("Jonna"));
		Assertions.assertTrue(duple.getLast().equals("Jonny"));

		duple = tree.partialSearch("A");
		Assertions.assertTrue(duple.getFirst().equals("Alice"));
		Assertions.assertTrue(duple.getLast().equals("Alice"));

		duple = tree.partialSearch("Jones");
		Assertions.assertTrue(duple.getFirst().equals("Jones"));
		Assertions.assertTrue(duple.getLast().equals("Jones"));

		duple = tree.partialSearch("B");
		Assertions.assertTrue(duple.getFirst().equals("Bob"));
		Assertions.assertTrue(duple.getLast().equals("Bob"));

		duple = tree.partialSearch("Xabi");
		Assertions.assertTrue(duple.getFirst().equals("Xabier"));
		Assertions.assertTrue(duple.getLast().equals("Xabier"));

		Assertions.assertThrows(NullPointerException.class, () ->
				tree.partialSearch("Y"));

	}

    @Test
    public void testPartialSearchLong() {

	tree = new MyAVL4StringsImpl();

		tree.insert("Alice");
		tree.insert("Bob");
		tree.insert("Jonas");
		tree.insert("Simon");
		tree.insert("Saul");
		tree.insert("Sarmed");
		tree.insert("Penny");
		tree.insert("Christina");
		tree.insert("Luther");

		tree.insert("Franky");
		tree.insert("Mark");
		tree.insert("Mike");
		tree.insert("Michael");
		tree.insert("Aaron");
		tree.insert("Augustine");
		tree.insert("Kenny");
		tree.insert("Kendrick");

		tree.insert("Blake");
		tree.insert("William");
		tree.insert("Wilson");
		tree.insert("James");
		tree.insert("Johnson");
		tree.insert("Carl");
		tree.insert("Clyde");
		tree.insert("Pam");

		tree.insert("Isaac");
		tree.insert("Albert");
		tree.insert("Chris");
		tree.insert("Lenny");
		tree.insert("Lue");
		tree.insert("Anton");
		tree.insert("Angela");
		tree.insert("Rudy");

		tree.insert("Ruben");
		tree.insert("Socrates");
		tree.insert("Kimmy");
		tree.insert("Colin");
		tree.insert("Jamie");
		tree.insert("Bowie");
		tree.insert("Dan");
		tree.insert("Dom");
		tree.insert("Jacob");

		Couple<String> duple = tree.partialSearch("A");
		Assertions.assertTrue(duple.getFirst().equals("Aaron"));
		Assertions.assertTrue(duple.getLast().equals("Augustine"));

		duple = tree.partialSearch("An");
		Assertions.assertTrue(duple.getFirst().equals("Angela"));
		Assertions.assertTrue(duple.getLast().equals("Anton"));

		duple = tree.partialSearch("B");
		Assertions.assertTrue(duple.getFirst().equals("Blake"));
		Assertions.assertTrue(duple.getLast().equals("Bowie"));

		duple = tree.partialSearch("Bo");
		Assertions.assertTrue(duple.getFirst().equals("Bob"));
		Assertions.assertTrue(duple.getLast().equals("Bowie"));

		duple = tree.partialSearch("C");
		Assertions.assertTrue(duple.getFirst().equals("Carl"));
		Assertions.assertTrue(duple.getLast().equals("Colin"));

		duple = tree.partialSearch("D");
		Assertions.assertTrue(duple.getFirst().equals("Dan"));
		Assertions.assertTrue(duple.getLast().equals("Dom"));

		duple = tree.partialSearch("J");
		Assertions.assertTrue(duple.getFirst().equals("Jacob"));
		Assertions.assertTrue(duple.getLast().equals("Jonas"));

		duple = tree.partialSearch("K");
		Assertions.assertTrue(duple.getFirst().equals("Kendrick"));
		Assertions.assertTrue(duple.getLast().equals("Kimmy"));

		duple = tree.partialSearch("Ken");
		Assertions.assertTrue(duple.getFirst().equals("Kendrick"));
		Assertions.assertTrue(duple.getLast().equals("Kenny"));

		duple = tree.partialSearch("L");
		Assertions.assertTrue(duple.getFirst().equals("Lenny"));
		Assertions.assertTrue(duple.getLast().equals("Luther"));

		duple = tree.partialSearch("Lu");
		Assertions.assertTrue(duple.getFirst().equals("Lue"));
		Assertions.assertTrue(duple.getLast().equals("Luther"));

		duple = tree.partialSearch("M");
		Assertions.assertTrue(duple.getFirst().equals("Mark"));
		Assertions.assertTrue(duple.getLast().equals("Mike"));

		duple = tree.partialSearch("Mi");
		Assertions.assertTrue(duple.getFirst().equals("Michael"));
		Assertions.assertTrue(duple.getLast().equals("Mike"));

		duple = tree.partialSearch("S");
		Assertions.assertTrue(duple.getFirst().equals("Sarmed"));
		Assertions.assertTrue(duple.getLast().equals("Socrates"));

		duple = tree.partialSearch("Sa");
		Assertions.assertTrue(duple.getFirst().equals("Sarmed"));
		Assertions.assertTrue(duple.getLast().equals("Saul"));
    }
}
