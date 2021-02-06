package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {

    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expect));
    }

    @Test
    public void whenThreeList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {0, 1});
        in.add(new int[] {2, 3, 6});
        in.add(new int[] {4, 5, 6, 7, -1});
        List<Integer> expect = Arrays.asList(0, 1, 2, 3, 6, 4, 5, 6, 7, -1);
        assertThat(ConvertList.convert(in), is(expect));
    }








}
