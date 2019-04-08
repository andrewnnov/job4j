package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        int expected = 30;
        assertEquals(expected, result);
    }

    @Test
    public void whenSumEvenNumbersFromZeroToZeroThenZero() {
        Counter count = new Counter();
        int result = count.add(0, 0);
        int expected = 0;
        assertEquals(expected, result);
    }
}
