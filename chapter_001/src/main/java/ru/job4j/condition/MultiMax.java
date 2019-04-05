package ru.job4j.condition;

/**
 * Maximum of 3 numbers
 */
public class MultiMax {
    /**
     *
     * @param first int number
     * @param second int number
     * @param third int number
     * @return max of 3 numbers
     */
    public int max(int first, int second, int third) {
        int maxNumber =  first > second ? first : second;
        return maxNumber > third ? maxNumber : third;
    }
}
