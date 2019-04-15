package ru.job4j.array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArraysDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] inputArray = new String[]{"Ola", "Kola", "Ola", "Lala", "Kola", "Kola", "Kola"};
        System.out.println(Arrays.toString(inputArray));
        String[] result = arrayDuplicate.remove(inputArray);
        System.out.println(Arrays.toString(result));
        String[] exp = {"Ola", "Kola", "Lala"};
        assertThat(result, is(exp));
    }


}
