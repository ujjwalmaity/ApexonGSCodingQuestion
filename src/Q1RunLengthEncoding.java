
// Run Length Encoding
// Convert a string as given in the format below:
// Example:
// aabbb into a2b3
// aaaa into a4
// a into a1

public class Q1RunLengthEncoding {

    public void call() {
        String text = "aabbb"; // a2b3

        StringBuilder str = new StringBuilder();

        char lastChar = text.charAt(0);
        int count = 1;

        for (int i = 1; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (lastChar == ch) {
                count++;
            } else {
                str.append(lastChar);
                str.append(count);
                lastChar = ch;
                count = 1;
            }
        }

        str.append(lastChar);
        str.append(count);

        System.out.println(str);
    }

}
