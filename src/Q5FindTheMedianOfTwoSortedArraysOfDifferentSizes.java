
// Find the median of two sorted arrays of different sizes.
//
// Example:
// arr1[] = {2, 3, 5, 8}
// arr2[] = {10, 12, 14, 16, 18, 20}
//
// Return 11 as the median

public class Q5FindTheMedianOfTwoSortedArraysOfDifferentSizes {

    public void call() {
        int[] arr1 = {2, 3, 5, 8};
        int[] arr2 = {10, 12, 14, 16, 18, 20};

        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        int arrLen = arr1Len + arr2Len;

        int[] arr = new int[arrLen];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1Len && j < arr2Len) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < arr1Len) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2Len) {
            arr[k] = arr2[j];
            j++;
            k++;
        }

        double res;
        int midIndex = arrLen / 2;
        if (arrLen % 2 == 0) {
            res = (arr[midIndex - 1] + arr[midIndex]) / 2.0;
        } else {
            res = arr[midIndex];
        }

        System.out.println(res);
    }

    // TODO
    public void call2() {
    }

}