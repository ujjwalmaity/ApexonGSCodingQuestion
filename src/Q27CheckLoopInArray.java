// Given an array of integers (positive and negative),
// return length of the loop, if it exists. Else return -1.
// [ Rules for the movement - Index to move to,
// for +ve numbers - (i + arr[i])%n
// for -ve numbers - (i - arr[i])%n ]
//
// Example:
// int[] arr = {2, -1, 1, 2, 2}
// Returns 3 [There is a loop in this array because 0 moves to 2, 2 moves to 3, and 3 moves to 0.]
//
// https://youtu.be/2hVinjU-5SA
// https://www.geeksforgeeks.org/check-loop-array-according-given-constraints/

public class Q27CheckLoopInArray {

    public void call() {
        int[] arr = {2, -1, 1, 2, 2};

        System.out.println(findLoopLength(arr));
    }

    private int findLoopLength(int[] arr) {
        int n = arr.length;
        if (n <= 1) return -1;

        // iterate over each element to find cycles
        for (int i = 0; i < n; i++) {
            int slow, fast;
            slow = fast = i;
            boolean isForward = arr[i] > 0; // determine direction of the movement

            // move until we detect a cycle or the end
            while (true) {
                slow = nextIndex(arr, slow, isForward); // move slow pointer
                if (slow == -1) break;

                fast = nextIndex(arr, fast, isForward); // move fast pointer once
                if (fast == -1) break;

                fast = nextIndex(arr, fast, isForward); // move fast pointer again
                if (fast == -1) break;

                // a cycle has been detected
                if (slow == fast) {
                    int cycleLength = 1;
                    int index = nextIndex(arr, slow, isForward);
                    while (index != slow) {
                        cycleLength++;
                        index = nextIndex(arr, index, isForward);
                    }
                    return cycleLength; // return length of the detected loop
                }
            }
        }

        return -1; // no cycle found
    }

    // helper method to get the next index based on direction
    private int nextIndex(int[] arr, int index, boolean isForward) {
        boolean direction = arr[index] > 0;
        if (direction != isForward) return -1; // change in direction

        int n = arr.length;
        int nextIndex = (index + arr[index]) % n;
        if (nextIndex < 0) nextIndex = nextIndex + n; // ensure index is positive

        if (nextIndex == index) return -1; // single-element loop, invalid
        return nextIndex;
    }

}
