
public class Palindrome {
    public static void main(String[] args) {
        // Check if a String is a Palindrome using Expand from middle technique.

        // String str = "abba";
        String str = "aba";

        int len = str.length();
        int midIndex = len / 2;

        int high = midIndex;
        int low = midIndex;
        if (len % 2 == 0) {
            low = midIndex - 1;
        }

        boolean result = true;

        while (low >= 0 && high < len) {
            if (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            } else {
                result = false;
                break;
            }
        }

        System.out.println(result);
    }
}