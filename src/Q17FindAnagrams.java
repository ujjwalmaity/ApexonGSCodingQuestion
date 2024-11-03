import java.util.*;

// Given a dictionary (list of words) and a word,
// return an array of strings that can be formed from the given word.
// [Every letter in the input word can occur only once in the word to be returned].
//
// Examples:
// String[] dict = {"ab", "abcd", "bcdaf", "bcad", "acb", "acab"};
// String input = "abcd";
// Return {"abcd", "bcad"}
//
// String[] dict = {"ab", "abcd", "bcdaf", "bcad", "acaab", "acab"};
// String input = "caab";
// Return {"acab"}

public class Q17FindAnagrams {

    public void call() {
        String[] dict = {"ab", "abcd", "bcdaf", "bcad", "acb", "acab"};
        String input = "abcd";

//        String[] dict = {"ab", "abcd", "bcdaf", "bcad", "acaab", "acab"};
//        String input = "caab";

        List<String> result = new ArrayList<>();

        for (String word : dict) {
//            if (areAnagrams(word, input)) result.add(word);
            if (areAnagrams2(word, input)) result.add(word);
        }

        System.out.println(result);
    }

    // Time Complexity: O(m*log(m) + n*log(n))
    // Auxiliary Space: O(n)
    private boolean areAnagrams(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        return Arrays.equals(s1Chars, s2Chars);
    }

    // Time Complexity: O(m + n)
    // Auxiliary Space: O(MAX_CHAR) = O(26) = O(1)
    private boolean areAnagrams2(String s1, String s2) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char ch : s1.toCharArray())
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

        for (char ch : s2.toCharArray())
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

        for (var entry : charCount.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

}
