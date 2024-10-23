import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public void call(int N) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            ans.add(generateRow(i));
        }

        for (int i = 0; i < ans.size(); i++) {
            for (int j = 1; j < N - i; j++) {
                System.out.print(" ");
            }
            List<Integer> ansRow = ans.get(i);
            for (int j = 0; j < ansRow.size(); j++) {
                System.out.print(ansRow.get(j) + " ");
            }
            System.out.println();
        }
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
}
