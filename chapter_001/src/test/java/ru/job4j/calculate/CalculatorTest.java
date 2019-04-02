package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultTwoAndTwoThenFour() {
        Calculator calc = new Calculator();
        double result = calc.multiplication(2D, 2D);
        double expected = 4D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivTwoAndTwoThenOne() {
        Calculator calc = new Calculator();
        double result = calc.division(2D, 2D);
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubFourAndTwoThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.division(4D, 2D);
        double expected = 2D;
        assertThat(result, is(expected));
    }





}
