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


//    public int max(int one, int second, int third) {
//        int compareOfTwo =  max(second, third);
//        return one > compareOfTwo ? one : compareOfTwo;
//    }

    public int max(int one, int second, int third) {
        return max(max(one, second), third);
    }

//    public int max(int one, int second, int third, int fourth) {
//        int compareOfThree =  max(second, third, fourth);
//        return one > compareOfThree ? one : compareOfThree;
//    }

    public int max(int one, int second, int third, int fourth) {
        return max(max(one, second, third), fourth);
    }



}
