package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuTracker {

    private Input input;

    private Tracker tracker;

    private List<UserAction> action = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню
     * @return длину массива
     */

    public int getActionsLength() {
        return this.action.size();
    }

    /**
     * Метод заполнения массива
     */

    public void fillActions() {
        this.action.add(new AddItem());
        this.action.add(new ShowAllItem());
        this.action.add(new EditItem());
        this.action.add(new DeleteItem());
        this.action.add(new FindItemById());
        this.action.add(new FindItemByName());
    }

    public void select(int key) {
        this.action.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action: this.action) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

}

class AddItem implements UserAction {

    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Добавление новой заявки ");
        String name = input.ask("Введите имя заявки: ");
        String desc = input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("Новая заявка с id " + item.getId() + " создана.");
    }

    @Override
    public String info() {
        return "0 - Добавить новую заявку.";
    }
}

class ShowAllItem implements UserAction {

    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Список всех заявок: ");
        Item[] items = tracker.getAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }

    }

    @Override
    public String info() {
        return "1 - Показать все заявки.";
    }
}

class EditItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Редактирование заявки: ");
        String itemId = input.ask("Введите Id редактируемой заявки: ");
        Item findItem = tracker.findById(itemId);
        if (findItem == null) {
            System.out.println("Заявки с Id " + itemId + " не существует!");
        } else {
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, desc);
            tracker.replace(itemId, item);
            System.out.println("Заявка с Id " + item.getId() + " отредактирована.");
        }

    }

    @Override
    public String info() {
        return "2 - Редактировать заявку.";
    }
}

class DeleteItem implements UserAction {

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Удаление заявки: ");
        String itemId = input.ask("Введите Id удаляемой заявки: ");
        boolean res = tracker.delete(itemId);
        if (res) {
            System.out.println("Заявка с Id " + itemId + " удалена.");
        } else {
            System.out.println("Заявки с Id " + itemId + " не существует!");
        }
    }

    @Override
    public String info() {
        return "3 - Удалить заявку.";
    }
}

class FindItemById implements UserAction {

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Поиск заявки по Id: ");
        String itemId = input.ask("Введите Id заявки: ");
        System.out.println(tracker.findById(itemId));


    }

    @Override
    public String info() {
        return "4 - Найти заявку по Id.";
    }
}

class FindItemByName implements UserAction {

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Поиск заявки по имени: ");
        String itemName = input.ask("Введите имя заявки: ");
        System.out.println(Arrays.toString(tracker.findByName(itemName)));

    }

    @Override
    public String info() {
        return "5 - Найти заявку по Name.";
    }
}


