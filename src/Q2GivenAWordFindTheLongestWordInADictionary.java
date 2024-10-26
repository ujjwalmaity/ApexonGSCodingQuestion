public class Q2GivenAWordFindTheLongestWordInADictionary {
    public void call() {
        // Given a dictionary (list of words) and a substring,
        // you have to return the length of the longest word in the dictinary containing the substring.
        //
        // Example:
        // String[] dict = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"}
        // String toSearch = "ODG";
        //
        // Returns 9 (LODGESSSS)

        String[] dict = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"};
        String toSearch = "ODG"; // LODGESSSS

        String res = "";
        int resLength = 0;

        for (String str : dict) {
            int strLength = str.length();
            if (str.contains(toSearch) && strLength >= resLength) {
                res = str;
                resLength = strLength;
            }
        }

        System.out.println(res);
    }
}
