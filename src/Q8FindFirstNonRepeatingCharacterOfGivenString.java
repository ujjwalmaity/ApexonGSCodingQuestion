import java.util.*;

public class Q8FindFirstNonRepeatingCharacterOfGivenString {

    public void call() {
        // Given a string,
        // return the first non-repeating character.
        //
        // Examples:
        // String str1 = "12345"
        // Return 1
        //
        // String str2 = "abbacd"
        // Return c

        String str = "abbacd"; // c

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                System.out.println(ch);
                break;
            }
        }
    }
}
