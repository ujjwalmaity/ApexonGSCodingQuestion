public class Q10StringToIntegerWriteYourOwnAtoi {

    public void call() {
        // Implement your custom atoi function in Java.
        // Given a string, you have to convert into integer.
        // The input string may contain alphabets and special characters alongside numbers (both negative and positive).
        //
        // Examples:
        // String str1 = "123"; // Return 123 (in integer format)
        //
        // String str2 = "-123"; // Return -123
        //
        // String str3 = "1a23"; // Return -1 (Invalid entry)

        String str = "123"; // 123
//        String str = "-123"; // -123
//        String str = "1a23"; // -1

        System.out.println(atoi(str));
    }

    private int atoi(String str) {
        int result = 0;
        int sign = 1;
        int i = 0;

        if (str.charAt(0) == '-') {
            sign = -1;
            i = 1;
        }

        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                result = (result * 10) + digit;
            } else {
                return -1;
            }
        }

        return result * sign;
    }

}
