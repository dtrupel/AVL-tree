package impl;

/**
 * A class for static test data.
 * This used in the main class for testing.
 */
public final class StaticData {

    /**
     * A private constructor, to avoid creating instances.
     */
    private StaticData() {

    }

    /**
     * It returns partial strings.
     *
     * @return the parts of names.
     */
    public static String[] getStringParts() {
        return new String[]{"a", "aa", "aaa", "ab", "ac", "ba", "bc", "bbb", "ccc", "cb", "ca", "bb"};
    }

    /**
     * It returns the names.
     *
     * @return names.
     */
    public static String[] getNames() {
        return new String[]{"aaa", "aab", "aac", "aba", "abb", "abc", "aca", "acb", "acc", "baa", "bab",
            "bac", "bbc", "bcc", "caa", "cab", "cac", "cba", "cbb", "cbc", "ccc" };
    }
}
