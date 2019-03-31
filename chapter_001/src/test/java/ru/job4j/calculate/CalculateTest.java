package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test
 *
 * @author
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {
    /**
     * test echo
     */
    @Test
    public void whenTakeNameThenThreeEchoPlusName() {
        String input = "Andrew";
        String expect = "Echo, echo, echo : Andrew";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}
