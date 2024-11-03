import java.util.*;

// Given an array of integers,
// sort it in a wave form.
// [ The order of elements in a wave form:
// arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= ….. ]
//
// Example:
// int[] arr = {10, 5, 6, 3, 2, 20, 100, 80};
// Answer : arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR {20, 5, 10, 2, 80, 6, 100, 3}
//
// https://youtu.be/8oR5OBW5buk

public class Q28SortAnArrayInWaveForm {

    public void call() {
        int[] arr = {10, 5, 6, 2, 20, 3, 100, 80};

        int n = arr.length;

        for (int i = 0; i < n; i += 2) {
            // If current even index element is smaller than the previous element, swap
            if (i > 0 && arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }

            // If current even index element is smaller than the next element, swap
            if (i < n - 1 && arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        System.out.println(Arrays.toString(arr)); // {10, 5, 6, 2, 20, 3, 100, 80}
    }

    @Deprecated
    public void call2() {
        int[] arr = {10, 5, 6, 3, 2, 20, 100, 80};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i += 2) {
            if (i + 1 >= arr.length) break;

            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

}
