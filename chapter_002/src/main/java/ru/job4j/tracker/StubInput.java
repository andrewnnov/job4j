package ru.job4j.tracker;

public class StubInput implements Input {

    private final String[] value;

    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        System.out.println(question);
        return this.value[this.position++];
    }
}
