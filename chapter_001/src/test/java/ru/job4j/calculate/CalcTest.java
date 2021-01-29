package ru.job4j.calculate;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalcTest {

    @Test
    public void when2And2Equal4() {
        Calc calc = new Calc();
        double expectedRes = 4d;
        double actualRes = calc.add(2d, 2d);
        assertThat(actualRes, is(expectedRes));
    }

    @Test
    public void when2And2And2Equal6() {
        Calc calc = new Calc();
        double expectedRes = 6d;
        double actualRes = calc.add(2d, 2d, 2d);
        assertThat(actualRes, is(expectedRes));
    }

    @Test
    public void when5And5And5Equal15() {
        Calc calc = new Calc();
        double expectedRes = 15d;
        double actualRes = calc.add(5d, 5d, 5d);
        assertThat(actualRes, is(expectedRes));
    }

}
