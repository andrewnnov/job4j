package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class TriangleTest {

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 2);
        Point third = new Point(2, 0);
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenAreaSetThreePointsNotCorrectThenTriangleAreaIsNotExist() {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        Point third = new Point(2, 0);
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.area();
        double expected = -1.0;
        assertThat(result, is(expected));
    }
}
