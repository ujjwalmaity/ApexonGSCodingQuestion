
// Given a string,
// return the starting index & length of the longest substring containing the same character.
//
// Example:
// String[] str = "aabbbbCCddd"; // Return 2 (index) and substring "bbbb"

// Minor variation of the standard Run Length Encoding problem.

public class Q20LargestSubstringWithSameCharacters {

    public void call() {
        String str = "aabbbbCCddd";

        int maxIndex = 0;
        int currentIndex = 0;

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < str.length(); i++) {
            char chPrev = str.charAt(i - 1);
            char ch = str.charAt(i);
            if (ch == chPrev) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxIndex = currentIndex;
                }
                currentLength = 1;
                currentIndex = i;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxIndex = currentIndex;
        }

        System.out.println("Starting index: " + maxIndex);
        System.out.println("Length: " + maxLength);
        System.out.println("Substring: " + str.substring(maxIndex, maxIndex + maxLength));
    }

}
