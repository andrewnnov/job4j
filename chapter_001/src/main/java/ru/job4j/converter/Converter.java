package ru.job4j.converter;

/**
 * Convert money
 */
public class Converter {
    /**
     * Convert ruble to euro
     * if result is a fractional number - You will use a whole part of number
     * @param ruble ruble
     * @return converted ruble - euro
     */
    public int rubleToEuro(int ruble) {
        return ruble / 70;
    }
    /**
     * Convert ruble to dollar
     * if result is a fractional number - You will use a whole part of number
     * @param ruble ruble
     * @return converted ruble - dollar
     */
    public int rubleToDollar(int ruble) {
        return ruble / 60;
    }

    /**
     * Convert euro to ruble
     * @param euro euro
     * @return converted euro - ruble
     */
    public int euroToRuble(int euro) {
        return euro * 70;
    }

    /**
     * Converted dollar to ruble
     * @param dollar dollar
     * @return converted dollar - ruble
     */
    public int dollarToRuble(int dollar) {
        return dollar * 60;
    }
}
