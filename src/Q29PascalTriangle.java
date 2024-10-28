import java.util.*;

// Pascal Triangle
// generate the Pascal Triangle, OR
// generate a specified row of the Pascal Triangle, OR
// calculate the element at a specified row and column.

public class Q29PascalTriangle {

    public void call() {
        int N = 7;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            ans.add(generateRow(i));
        }

        printPascalTriangle(ans);
    }

    private List<Integer> generateRow(int row) {
        List<Integer> ansRow = new ArrayList<>();
        int ans = 1;
        ansRow.add(ans);
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add(ans);
        }
        return ansRow;
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
}
