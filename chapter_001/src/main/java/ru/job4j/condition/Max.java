package ru.job4j.condition;

/**
 * Define max number
 */
public class Max {
    /**
     * Method defines max number
     * @param left int number
     * @param right int number
     * @return max number
     */
    public int max(int left, int right) {

        return left > right ? left : right;
    }
}
