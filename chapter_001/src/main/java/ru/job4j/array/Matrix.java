package ru.job4j.array;

public class Matrix {

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];

        System.out.println();

        for (int h = 0; h < size; h++) {
            for (int w = 0; w < size; w++) {
                table[h][w] = (h + 1) * (w + 1);
                System.out.printf("%4d", (h + 1) * (w + 1));
            }
            System.out.printf("%n");
        }
        return table;
    }
}
