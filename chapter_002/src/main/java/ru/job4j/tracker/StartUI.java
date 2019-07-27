package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;

public class StartUI {

    private static final String ADD_ITEM = "0";
    private static final String SHOW_ALL_ITEMS = "1";
    private static final String EDIT_ITEM = "2";
    private static final String DELETE_ITEM = "3";
    private static final String FIND_ITEM_BY_ID = "4";
    private static final String FIND_ITEM_BY_NAME = "5";
    private static final String EXIT = "6";

    //получение данных от пользователя
    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    //основной цикл программы
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD_ITEM.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL_ITEMS.equals(answer)) {
                this.showAllItems();
            } else if (EDIT_ITEM.equals(answer)) {
                this.editItem();
            } else if (DELETE_ITEM.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ITEM_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_ITEM_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                break;
            }

        }
    }

    private void findItemByName() {
        System.out.println("Поиск заявки по имени: ");
        String itemName = this.input.ask("Введите имя заявки: ");
        System.out.println(Arrays.toString(this.tracker.findByName(itemName)));
    }

    private void findItemById() {
        System.out.println("Поиск заявки по Id: ");
        String itemId = this.input.ask("Введите Id заявки: ");
        System.out.println(this.tracker.findById(itemId));
    }

    private void deleteItem() {

        System.out.println("Удаление заявки: ");
        String itemId = this.input.ask("Введите Id удаляемой заявки: ");

        boolean res = this.tracker.delete(itemId);
        if (res) {
            System.out.println("Заявка с Id " + itemId + " удалена.");
        } else {
            System.out.println("Заявки с Id " + itemId + " не существует!");
        }
    }

    private void editItem() {
        System.out.println("Редактирование заявки: ");
        String itemId = this.input.ask("Введите Id редактируемой заявки: ");
        Item findItem = this.tracker.findById(itemId);
        if (findItem == null) {
            System.out.println("Заявки с Id " + itemId + " не существует!");
        } else {
            String name = this.input.ask("Введите новое имя заявки: ");
            String desc = this.input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, desc);
            this.tracker.replace(itemId, item);
            System.out.println("Заявка с Id " + item.getId() + " отредактирована.");
        }

    }

    private void showAllItems() {
        System.out.println("Список всех заявок: ");
        Item[] items = this.tracker.getAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    private void createItem() {
        System.out.println("Добавление новой заявки ");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("New item with id " + item.getId() + " created. ");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("---------------------------");
        System.out.println("0 - Добавить новую заявку.");
        System.out.println("1 - Показать все заявки.");
        System.out.println("2 - Редактировать заявку.");
        System.out.println("3 - Удалить заявку.");
        System.out.println("4 - Найти заявку по Id.");
        System.out.println("5 - Найти заявку по Name.");
        System.out.println("6 - Выйти из программы.");
        System.out.println("---------------------------");
        System.out.println();
    }


    public static void main(String[] args) {

        new StartUI(new ConsoleInput(), new Tracker()).init();



    }
}
