import java.util.*;

// Given two integers representing the numerator and denominator of a fraction,
// return the fraction in string format.
// [If the fractional part is repeating, enclose the repeating part in parentheses].
//
// Examples:
// Numerator = 1, Denominator = 2
// Return "0.5"
//
// Numerator = 1, Denominator = -2
// Return "-0.5"
//
// Numerator = 50, Denominator = 22
// Return "2.(27)" [Fractional part (27) is repeating, hence enclosed in parentheses]

public class Q19FractionToRecurringDecimal {

    public void call() {
        int num = 1;
        int den = -2;

        System.out.println(solution(num, den));
    }

    private String solution(int num, int den) {
        StringBuilder ans = new StringBuilder();

        if ((num < 0) ^ (den < 0)) {
            ans.append("-");
        }
        num = Math.abs(num);
        den = Math.abs(den);

        int q = num / den;
        int r = num % den;
        ans.append(q);

        if (r == 0) {
            return ans.toString();
        }

        ans.append(".");
        Map<Integer, Integer> map = new HashMap<>();

        while (r != 0) {
            if (map.containsKey(r)) {
                int len = map.get(r);
                ans.insert(len, "(");
                ans.append(")");
                break;
            } else {
                map.put(r, ans.length());
                r *= 10;
                q = r / den;
                r = r % den;
                ans.append(q);
            }
        }

        return ans.toString();
    }

}
