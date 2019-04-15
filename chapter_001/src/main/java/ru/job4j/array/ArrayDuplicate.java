package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    public static int countElement = 0;

    public String[] remove(String[] array) {


        for (int i = 0; i < array.length - 1 - countElement; i++) {
            for (int j = 1; j < array.length - 1 - countElement; j++) {
                if (array[i].equals(array[j + i])) {
                    String tmp = array[j + i];
                    array[j + i] = array[array.length - 1 - countElement];
                    array[array.length - 1 - countElement] = tmp;
                    j--;
                    countElement++;
                }
            }
        }

        return Arrays.copyOf(array, array.length - countElement);
    }
}
