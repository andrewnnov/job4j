package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;

public class StartUI {
    //получение данных от пользователя
    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    //основной цикл программы
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("select: ")));

        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {

        new StartUI(new ConsoleInput(), new Tracker()).init();
    }



}
