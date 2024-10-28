
// Given a string,
// return the palindrome of maximum length and its length.
// (So, you return both the relevant palindrome substring and its length).
//
// Example:
// String str = "forgeeksskeegfor"; // Return {"geeksskeeg", 10}

public class Q24LongestPalindromicSubstring {

    public void call() {
        String str = "forgeeksskeegfor";

        int len = str.length();

        String result = "";

        for (int i = 0; i < len; i++) {
            int midIndex = i;

            // Odd length palindrome
            int high = midIndex;
            int low = midIndex;
            while (low >= 0 && high < len) {
                if (str.charAt(low) == str.charAt(high)) {
//                    System.out.println(str.substring(low, high + 1));
                    low--;
                    high++;
                } else {
                    break;
                }
            }
//            System.out.println(str.substring(low + 1, high));
            String palindrome = str.substring(low + 1, high);
            if (palindrome.length() > result.length()) {
                result = palindrome;
            }

            // Even length palindrome
            high = midIndex;
            low = midIndex - 1;
            while (low >= 0 && high < len) {
                if (str.charAt(low) == str.charAt(high)) {
//                    System.out.println(str.substring(low, high + 1));
                    low--;
                    high++;
                } else {
                    break;
                }
            }
//            System.out.println(str.substring(low + 1, high));
            palindrome = str.substring(low + 1, high);
            if (palindrome.length() > result.length()) {
                result = palindrome;
            }
        }

        System.out.println(result + " " + result.length());
    }

}