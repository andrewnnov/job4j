package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void when3x3() {
        Board board = new Board();
        String rsl = board.paintBoard(3, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(String.format("x x%s x %sx x%s", ln, ln, ln)));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String rs1 = board.paintBoard(5, 4);
        String ln = System.lineSeparator();
        assertThat(rs1, is(String.format("x x x%s x x %sx x x%s x x %s", ln, ln, ln, ln)));
    }


}
