package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax5To2Then2() {
        Max max = new Max();
        int result = max.max(5, 2);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax4To2Then4() {
        Max max = new Max();
        int result = max.max(4, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenMax4To2And1Then4() {
        Max max = new Max();
        int result = max.max(4, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenMax10To3And5And9Then10() {
        Max max = new Max();
        int result = max.max(3, 10, 5, 9);
        assertThat(result, is(10));
    }

    @Test
    public void whenMax10To10And10And10Then10() {
        Max max = new Max();
        int result = max.max(10, 10, 10, 10);
        assertThat(result, is(10));
    }

    @Test
    public void whenMax10ThenMinus10And0AndMinus100Less10() {
        Max max = new Max();
        int result = max.max(-100, 0, -10, 10);
        assertThat(result, is(10));
    }





}
