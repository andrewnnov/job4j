package ru.job4j.loop;

public class Factorial {
    /**
     * Calculating factorial
     * @param n int number
     * @return factorial
     */
    public int calcFactorial(int n) {
        int result = 1;
        if (n == 0) {
            return result;
        } else {
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        }
        return result;
    }
}
