
// Find the median of two sorted arrays of different sizes.
//
// Example:
// arr1[] = {2, 3, 5, 8}
// arr2[] = {10, 12, 14, 16, 18, 20}
//
// Return 11 as the median

public class Q5FindTheMedianOfTwoSortedArraysOfDifferentSizes {

    // Time Complexity: O(N)
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

    // Time Complexity: log(N)
    public void call2() {
        int[] arr1 = {2, 3, 5, 8};
        int[] arr2 = {10, 12, 14, 16, 18, 20};

        double result = median(arr1, arr2);
        System.out.println(result);
    }

    private double median(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = len1 + len2;

        if (len1 > len2) return median(arr2, arr1);

        int leftArrSize = (len3 + 1) / 2;

        int low = 0;
        int high = len1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = leftArrSize - mid1;
//            System.out.println(mid1 + " " + mid2);

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < len1) r1 = arr1[mid1];
            if (mid2 < len2) r2 = arr2[mid2];
            if (mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = arr2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (len3 % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }
}