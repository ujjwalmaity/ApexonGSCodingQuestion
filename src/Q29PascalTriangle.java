import java.util.*;

// Pascal Triangle
// generate the Pascal Triangle, OR
// generate a specified row of the Pascal Triangle, OR
// calculate the element at a specified row and column.

public class Q29PascalTriangle {

    // Generate the Pascal Triangle
    // Time Complexity: O(N^2)
    public void call() {
        int N = 7;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0) list.add(1);
                else if (j == i) list.add(1);
                else {
                    List<Integer> prevList = result.get(i - 1);
                    int item1 = prevList.get(j);
                    int item2 = prevList.get(j - 1);
                    list.add(item1 + item2);
                }
            }

            result.add(list);
        }

        printPascalTriangle(result);
    }

    private void printPascalTriangle(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size() - i; j++) {
                System.out.print(" ");
            }
            List<Integer> listRow = list.get(i);
            for (int j = 0; j < listRow.size(); j++) {
                System.out.print(listRow.get(j) + " ");
            }
            System.out.println();
        }
    }

    // Calculate the element at a specified row and column
    // Time Complexity: O(N)
    // nCr formula = n ! / (n–r)! r!
    // (row-1)C(column-1) = (5-1)C(3-1) = 4C2
    // 4! / (4-2)! 2!
    // = 4! / 2! 2!
    // = 4*3*2! / 2! 2!
    // = 4*3 / 2!
    // = 4*3 / 2*1
    public void call2() {
        int row = 5;
        int column = 3;

        // nCr
        int n = row - 1; // 4
        int r = column - 1; // 2

        int tempN = n;
        int numerator = 1;
        int denominator = 1;
        for (int i = 1; i <= r; i++) {
            numerator = numerator * (tempN--);
            denominator = denominator * i;
        }

        int result = numerator / denominator;

        System.out.println("\nElement at row " + row + " and column " + column + ": " + result);

        // OR
        // nCr
        // = n! / (n-r)! r!
        result = fact(n) / (fact(n - r) * fact(r));
        System.out.println("\nElement at row " + row + " and column " + column + ": " + result);
    }

    int fact(int n) {
        if (n == 1) return 1;
        // if (n < 1) return -1;

        return n * fact(n - 1);
    }

    // Generate a specified row of the Pascal Triangle
    // Time Complexity: O(N)
    // n = row-1 = 5-1 = 4
    // 4C0, 4C1, 4C2, 4C3, 4C4
    // 1, 4/1, 4*3/2*1, 4*3*2/3*2*1, 4*3*2*1/4*3*2*1
    // 1, 4/1, 4*3/1*2, 4*3*2/1*2*3, 4*3*2*1/1*2*3*4
    // 1, prev*(4/1), prev*(3/2), prev*(2/3), prev*(1/4)
    public void call3() {
        int row = 5;

        int n = row - 1;

        List<Integer> result = new ArrayList<>();
        result.add(1);

        int tempN = n;
        for (int i = 1; i <= n; i++) {
            int prev = result.get(i - 1);
            int curr = prev * tempN / i;
            result.add(curr);
            tempN--;
        }

        System.out.println("\nRow " + row + ": " + result);
    }
}
