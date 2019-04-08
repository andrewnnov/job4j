package ru.job4j.loop;

public class Counter {
    /**
     *  Calculate summ even numbers
     * @param start first number
     * @param finish end number
     * @return summ even number
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
