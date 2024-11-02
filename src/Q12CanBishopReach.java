// We are given a chess board and a piece with a fixed position (im-moveable).
// We also have a bishop on the board which, well of course, can only move diagonally.
// - Return "YES" if we can reach the im-moveable piece using the bishop, else return "NO".
// - If "YES", return the number of minimum steps it takes for the bishop to reach the im-moveable piece.
// Hint:
// Something to do with the number of squares on the x and y axes.

public class Q12CanBishopReach {

    public void call() {
        int bx = 1, by = 1;  // Bishop's position
        int px = 3, py = 3;  // Immovable piece's position

        System.out.println(canBishopReach(bx, by, px, py));
    }

    public static String canBishopReach(int bx, int by, int px, int py) {
        // Check if both squares are of the same color
        if ((bx + by) % 2 != (px + py) % 2) {
            return "NO";
        }

        // Check if the bishop and the immovable piece are on the same diagonal
        if (Math.abs(bx - px) == Math.abs(by - py)) {
            return "YES, 1";
        }

        // If not on the same diagonal, they are on the same color, so it's reachable in 2 moves
        return "YES, 2";
    }

}
