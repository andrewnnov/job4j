package ru.job4j.calculate;


/**
 * ideal weight calculation
 */
public class Fit {
    /**
     * ideal weight for man
     * @param height in centimeters
     * @return ideal weight for man
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15D;
    }

    /**
     * ideal weight for woman
     * @param height in centimeters
     * @return ideal weight for woman
     */
    public double womanWeght(double height) {
        return (height - 110) * 1.15D;
    }
}
