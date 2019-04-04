package ru.job4j.calculate;

/**
 * class Calculator. Calculate add, mult, div, sub
 */
public class Calculator {

    /**
     * Addition
     * @param first int number
     * @param second int number
     * @return adition two number
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * multiplication
     * @param first int number
     * @param second int number
     * @return multiplication two number(result have type int only)
     */
    public double
    multiplication(double first, double second) {
        return first * second;
    }

    /**
     * division
     * @param first int number
     * @param second int number
     * @return division two number(result have type int only)
     */
    public double division(double first, double second) {
        return first / second;
    }

    /**
     * subtraction
     * @param first int number
     * @param second int number
     * @return subtraction two number
     */
    public double subtraction(double first, double second) {
        return first - second;
    }
}
