
// Given a sorted array of non-negative integers of size n,
// return the smallest missing integer.
//
// Examples:
// int[] arr1 = {1, 2, 3, 4}; // Return 0
//
// int[] arr2 = {0, 1, 3, 4}; // Return 2

public class Q18FindTheSmallestMissingNumberFromSortedArray {

    public void call() {
        int[] arr = {0, 1, 3, 4};

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Left half sorted
            if (arr[mid] == mid) {
                low = mid + 1;
            }
            // Right half sorted
            else {
                high = mid - 1;
            }
        }

        System.out.println(low);
    }

}
