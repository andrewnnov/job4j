package ru.job4j.tracker.strategy;

public class Square implements Shape {
    @Override
    public String draw() {

        StringBuilder pic = new StringBuilder();
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        return pic.toString();
    }
}
