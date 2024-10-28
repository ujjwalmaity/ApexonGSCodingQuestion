
// The following is a puzzle.
// You could code this but ideally you're supposed to (or asked to) give the answer by solving it on paper.
//
// You are given 100 bulbs.
// There are going to be 100 iterations, in each iteration you toggle the switch for bulbs numbered by the multiples of the iterating variable.
// Return the number of bulbs remaining after all the 100 passes.
//
// As in, in the 1st iteration - all the bulbs with the multiples of 1 would be toggled.
// in the 2nd iteration - all the bulbs with only multiples of 2 would be toggled.

// http://puzzles.nigelcoldwell.co.uk/six.htm
// https://youtu.be/eI2Iwphxsc0
// https://youtu.be/8QzOtLNPsFY

// Multiple of Particular Number
// => Perfect Square Root or Square Number
// => Has Odd Number of Factors
// => Bulb is ON
//
// 1*1 = 2 = 1 (1 factor)
// 2*2 = 4 = 1, 2, 4 (3 factor)
// 3*3 = 9 = 1, 3, 9 (3 factor)
// 4*4 = 16 = 1, 2, 4, 8, 16 (5 factor)
// 5*5 = 25 =  1, 5, 25 (3 factor)
// 6*6 = 36 = 1, 2, 3, 4, 6, 9, 12, 18, 36 (9 factor)
// 7*7 = 49 =
// 8*8 = 64 =
// 9*9 = 81 =
// 10*10 = 100 = 1, 2, 5, 10, 20, 50, 100 (7 factor)

// For 100 bulb
// ON Bulb => 1, 4, 9, 16, 25, 36, 49, 64, 81 & 100
// Total ON Bulb => 10 => (√100)

public class Q25Switching100LightBulbs {

    public void call() {
        int n = 100; // Number of bulbs
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
//            System.out.println(i * i);
            count++;
        }

        System.out.println(count);
    }

    public void call2() {
        int n = 100;

        int count = (int) Math.sqrt(n);

        System.out.println(count);
    }

    public void call3() {
        int n = 100;

        boolean[] bulbs = new boolean[n + 1]; // false by default (all bulbs start off)

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j = j + i) {
                bulbs[j] = !bulbs[j]; // Toggle the bulb
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (bulbs[i]) {
//                System.out.println(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
