package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnArrayTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        TurnArray turner = new TurnArray();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        TurnArray turner = new TurnArray();
        int[] input = new int[] {4, 1, 6, 2, 7};
        int[] result = turner.back(input);
        int[] expect = new int[] {7, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}
