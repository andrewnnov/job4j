package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {

    @Test
    public void when120RubThen2Dollar() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(120);
        int expected = 2;
        assertThat(result, is(expected));
    }

    @Test
    public void when126RubThen2Dollar() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(126);
        int expected = 2;
        assertThat(result, is(expected));
    }


    @Test
    public void when140RubThen2Euro() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(140);
        int expected = 2;
        assertThat(result, is(expected));
    }

    @Test
    public void when10EuroThen700Rub() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(10);
        int expected = 700;
        assertThat(result, is(expected));
    }

    @Test
    public void when10DollThen600Rub() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(10);
        int expected = 600;
        assertThat(result, is(expected));
    }


}
