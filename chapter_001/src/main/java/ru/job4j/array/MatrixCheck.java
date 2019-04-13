package ru.job4j.array;

public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;

        for (int h = 0; h < data.length; h++) {
            for (int w = 0; w < data.length; w++) {
                if (h == w || h + w == data.length - 1) {
                    if (data[h][w] != data[0][0]) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
