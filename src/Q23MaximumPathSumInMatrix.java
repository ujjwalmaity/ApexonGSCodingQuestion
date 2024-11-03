// Given a matrix of size n * m,
// return the maximum path sum in the matrix.
// [You start from the top-left corner of the matrix and may up, down and diagonally].
//
// Example:
// Matrix 10 10 2 0 20 4
// 1 0 0 30 2 5
// 0 10 4 0 2 0
// 1 0 2 20 0 4
//
// Return 74 [The maximum sum path is 20-30-4-20]

public class Q23MaximumPathSumInMatrix {

    public void call() {
        int[][] matrix = {
                {10, 10, 2, 0, 20, 4},
                {1, 0, 0, 30, 2, 5},
                {0, 10, 4, 0, 2, 0},
                {1, 0, 2, 20, 0, 4}};

        int row = matrix.length;
        int column = matrix[0].length;

        int maxi = Integer.MIN_VALUE; // (int) -1e9

        for (int j = 0; j < column; j++) {
            int maxPathValue = maxPath(row - 1, j, matrix, row, column);
            maxi = Math.max(maxi, maxPathValue);
        }

        System.out.println(maxi);
    }

    private int maxPath(int i, int j, int[][] matrix, int n, int m) {
        if (j < 0 || j >= m) return Integer.MIN_VALUE;
        if (i == 0) return matrix[0][j];

        int up = matrix[i][j] + maxPath(i - 1, j, matrix, n, m);
        int leftDiagonal = matrix[i][j] + maxPath(i - 1, j - 1, matrix, n, m);
        int rightDiagonal = matrix[i][j] + maxPath(i - 1, j + 1, matrix, n, m);

        return Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }
}
