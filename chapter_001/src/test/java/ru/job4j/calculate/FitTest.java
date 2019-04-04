package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {

    @Test
    public void manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    @Test
    public void wommanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeght(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }

}
