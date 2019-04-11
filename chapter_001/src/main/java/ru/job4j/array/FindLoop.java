package ru.job4j.array;

public class FindLoop {

    /**
     * Looking for element in array
     * @param data - input int array
     * @param el - finded element
     * @return -1 - if element not found, another number - index of element
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
