
// Check whether a number is a power of 10

public class Q14CheckWhetherANumberIsAPowerOfAGivenNumber {

    public void call() {
        System.out.println(checkNumberIsPowerOf10(1000));

        System.out.println(checkNumberIsPowerOf5(125));

        System.out.println(checkNumberIsPowerOf2(32));
    }

    private boolean checkNumberIsPowerOf10(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 10 != 0) return false;
            n = n / 10;
        }
        return true;
    }

    private boolean checkNumberIsPowerOf5(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 5 != 0) return false;
            n = n / 5;
        }
        return true;
    }

    private boolean checkNumberIsPowerOf2(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }
}
