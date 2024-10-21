


import java.util.*;

public class Staircase {

    public static void main(String[] args) {
        // A staircase with n steps is given. Starting from the base,
        // return the number of ways of reaching the n’th stair.
        // [The person can climb either 1 or 2 stairs in one move].
        // https://www.geeksforgeeks.org/count-ways-reach-nth-stair/#using-space-optimized-dp-on-time-and-o1-space

        int n = 10;

//        System.out.println(countWays1(n));

//        int[] memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        System.out.println(countWays2(n, memo));

        System.out.println(countWays3(n));
    }

    // Using Recursion – O(2^n) Time and O(n) Space
    static int countWays1(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        return countWays1(n - 1) + countWays1(n - 2);
    }

    // Using Top-Down DP (Recursion) – O(n) Time and O(n) Space
    static int countWays2(int n, int[] memo) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        if (memo[n] != -1) return memo[n];

        return memo[n] = countWays2(n - 1, memo) + countWays2(n - 2, memo);
    }

    // Using Space Optimized DP – O(n) Time and O(1) Space
    static int countWays3(int n) {
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

