package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        BubbleSort sort = new BubbleSort();
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = sort.sort(array);
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortArrayWithZeroElThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] array = {};
        int[] result = sort.sort(array);
        int[] expected = {};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortArrayWithOneElThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] array = {1};
        int[] result = sort.sort(array);
        int[] expected = {1};
        assertThat(result, is(expected));
    }


}
