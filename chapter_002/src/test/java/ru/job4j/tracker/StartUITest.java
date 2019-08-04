package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    Tracker tracker;
    Input input;

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    static final StringBuilder MENU = new StringBuilder()
            .append("Меню.").append(System.lineSeparator())
            .append("---------------------------").append(System.lineSeparator())
            .append("0 - Добавить новую заявку.").append(System.lineSeparator())
            .append("1 - Показать все заявки.").append(System.lineSeparator())
            .append("2 - Редактировать заявку.").append(System.lineSeparator())
            .append("3 - Удалить заявку.").append(System.lineSeparator())
            .append("4 - Найти заявку по Id.").append(System.lineSeparator())
            .append("5 - Найти заявку по Name.").append(System.lineSeparator())
            .append("6 - Выйти из программы.").append(System.lineSeparator())
            .append("---------------------------").append(System.lineSeparator())
            .append(System.lineSeparator()).append("Введите пункт меню: ")
            .append(System.lineSeparator());

    @Before
    public void createItem() {
        tracker = new Tracker();
    }


    @After
    public void todoInputEqualNull() {
        this.input = null;
    }

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream((this.out)));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test1", "desk1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test1"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        Input input = new StubInput(new String[] {"2", item.getId(), "test99", "desc99", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test99"));
    }

    @Test
    public void whenFindItemByIdTrackerHasThisItem() {
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        String itemId = tracker.getAll()[0].getId();
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(itemId).getName(), is("test2"));
    }

    @Test
    public void whenFindItemByIdTrackerHasNotThisItem() {
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        String idNotInTracker = "1111222";
        Input input = new StubInput(new String[] {"4", idNotInTracker, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(idNotInTracker), is(nullValue()));
    }

    @Test
    public void whenFindItemByNameTrackerHasNotThisItem() {
        Item item = new Item("test2", "desc2", 765L);
        Item item1 = new Item("test2", "desc3", 765L);
        tracker.add(item);
        tracker.add(item1);
        Item[] expectedItem = {item, item1};
        String id = tracker.getAll()[1].getId();
        Input input = new StubInput(new String[] {"5", "test2", "6"});
        new StartUI(input, tracker).init();
        Item[] resultItem = tracker.findByName("test2");
        assertThat(resultItem, is(expectedItem));
    }

    @Test
    public void whenDeleteItemByIdTrackerHasNotThisItem() {
        Item item = new Item("test2", "desc2", 765L);
        Item item1 = new Item("test3", "desc3", 765L);
        tracker.add(item);
        tracker.add(item1);
        String id = tracker.getAll()[0].getId();
        Input input = new StubInput(new String[] {"3", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test3"));
    }


    @Test
    public void whenShowAllItemsTrackerShowAllItem() {
        Item item = new Item("test2", "desc2", 765L);
        Item item1 = new Item("test3", "desc3", 765L);
        tracker.add(item);
        tracker.add(item1);
        Item[] expectedItem = {item, item1};
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        Item[] resultItem = tracker.getAll();
        assertThat(resultItem, is(expectedItem));
    }

    @Test
    public void whenShowMenu() {
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(MENU.toString()));
    }

    @Test
    public void whenUserChooseShowAllItem() {
        Item item = new Item("name1", "desc1");
        tracker.add(item);
        input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        StringBuilder showAllItem = new StringBuilder()
                .append("Список всех заявок: ").append(System.lineSeparator())
                .append("id заявки - " + item.getId() + ", ")
                .append("имя заявки - " + item.getName() + ", ")
                .append("описание заявки - " + item.getDesc()).append(System.lineSeparator());

        assertThat(new String(out.toByteArray()), is(MENU.toString() + showAllItem.toString() + MENU.toString()));
    }

//    @Test
//    public void whenUserChooseAddNewItem() {
//        Item item = new Item("name1", "desc1");
//        tracker.add(item);
//        input = new StubInput(new String[]{"0", "name1", "desc1", "6"});
//        new StartUI(input, tracker).init();
//        StringBuilder addNewItem = new StringBuilder()
//                .append("Добавление новой заявки ").append(System.lineSeparator())  //.append("id заявки - " + item.getId() + ", ")
//                .append("Введите имя заявки: ").append(System.lineSeparator())
//                .append("Введите описание заявки: ").append(System.lineSeparator())
//                .append("Новая заявка с id " + item.getId() + " создана.").append(System.lineSeparator());
//
//        assertThat(new String(out.toByteArray()), is(MENU.toString() + addNewItem.toString() + MENU.toString()));
//    }

    @Test
    public void whenUserChooseEditItem() {
        Item item = new Item("name1", "desc1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "name2", "desc2", "6"});
        new StartUI(input, tracker).init();
        StringBuilder editItem = new StringBuilder()
                .append("Редактирование заявки: ").append(System.lineSeparator())
                .append("Введите Id редактируемой заявки: ").append(System.lineSeparator())
                .append("Введите новое имя заявки: ").append(System.lineSeparator())
                .append("Введите новое описание заявки: ").append(System.lineSeparator())
                .append("Заявка с Id "  +  item.getId() + " отредактирована.").append(System.lineSeparator());

        assertThat(new String(out.toByteArray()), is(MENU.toString() + editItem.toString() + MENU.toString()));
    }

    @Test
    public void whenUserChooseDeleteItem() {
        Item item = new Item("name1", "desc1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        StringBuilder deleteItem = new StringBuilder()
                .append("Удаление заявки: ").append(System.lineSeparator())
                .append("Введите Id удаляемой заявки: ").append(System.lineSeparator())
                .append("Заявка с Id "  +  item.getId() + " удалена.").append(System.lineSeparator());

        assertThat(new String(out.toByteArray()), is(MENU.toString() + deleteItem.toString() + MENU.toString()));
    }

    @Test
    public void whenUserChooseFindItemById() {
        Item item = new Item("name1", "desc1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        StringBuilder findItemById = new StringBuilder()
                .append("Поиск заявки по Id: ").append(System.lineSeparator())
                .append("Введите Id заявки: ").append(System.lineSeparator())
                .append("id заявки - " + item.getId() + ", ")
                .append("имя заявки - " + item.getName() + ", ")
                .append("описание заявки - " + item.getDesc()).append(System.lineSeparator());

        assertThat(new String(out.toByteArray()), is(MENU.toString() + findItemById.toString() + MENU.toString()));
    }

    @Test
    public void whenUserChooseFindItemByName() {
        Item item = new Item("name1", "desc1");
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        StringBuilder findItemById = new StringBuilder()
                .append("Поиск заявки по имени: ").append(System.lineSeparator())
                .append("Введите имя заявки: ").append(System.lineSeparator())
                .append("[id заявки - " + item.getId() + ", ")
                .append("имя заявки - " + item.getName() + ", ")
                .append("описание заявки - " + item.getDesc() + "]").append(System.lineSeparator());

        assertThat(new String(out.toByteArray()), is(MENU.toString() + findItemById.toString() + MENU.toString()));
    }












}
