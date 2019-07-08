package ru.job4j.array;

public class Check {
    /**
     * Method defines all element in array -equals
     * @param data input array
     * @return true or false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
           if (data[i + 1] != data[0]) {
               result = false;
               break;
           }
        }
        return result;
    }
}
