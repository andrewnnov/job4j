package ru.job4j.tracker.strategy;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square sq = new Square();
        assertThat(sq.draw(), is(new StringBuilder()
                                 .append("++++").append(System.lineSeparator())
                                 .append("++++").append(System.lineSeparator())
                                 .append("++++").append(System.lineSeparator())
                                 .append("++++").append(System.lineSeparator()).toString()));
    }
}
