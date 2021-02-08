package ru.job4j.calculate;


public class Calc {

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        return third + add(first, second);
    }

    public double add(double first, double second, double third, double fourth) {
        return add(first, second, third) + fourth;
    }
}
