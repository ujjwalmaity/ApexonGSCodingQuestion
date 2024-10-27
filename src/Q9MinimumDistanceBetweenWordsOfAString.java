public class Q9MinimumDistanceBetweenWordsOfAString {

    public void call() {
        // Given a sentence/phrase and two words,
        // return the minimum distance between the words.
        //
        // Example:
        // String str = "the quick the brown quick brown the frog"
        // String word1 = "quick"
        // String word2 = "frog"
        //
        // Return 2

        String str = "the quick the brown quick brown the frog";
        String word1 = "quick";
        String word2 = "frog";

        String[] words = str.split(" ");

        int position1 = -1;
        int position2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String text = words[i];
            if (text.equals(word1)) {
                position1 = i;
            }
            if (text.equals(word2)) {
                position2 = i;
            }
            if (position1 != -1 && position2 != -1) {
                int distance = Math.abs(position1 - position2) - 1;
                minDistance = Math.min(distance, minDistance);
            }
        }

        System.out.println(minDistance);
    }
}
