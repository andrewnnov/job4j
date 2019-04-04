package ru.job4j.condition;

/**
 * distance between two points
 */
public class Point {

    /**
     * distance between two points
     * @param x1 coordinate first point
     * @param y1 coordinate second point
     * @param x2 coordinate first point
     * @param y2 coordinate second point
     * @return distance between two points
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        double distanceBetweenPoints = Math.sqrt(first + second);
        return distanceBetweenPoints;
    }
}
