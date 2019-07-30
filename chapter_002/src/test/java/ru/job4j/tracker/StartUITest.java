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



    @Before
    public void createItem() {
        tracker = new Tracker();
    }

    @After
    public void todoInputEqualNull() {
        this.input = null;
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test1", "desk1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test1"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        //Tracker tracker = new Tracker();
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        Input input = new StubInput(new String[] {"2", item.getId(), "test99", "desc99", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test99"));
    }

    @Test
    public void whenFindItemByIdTrackerHasThisItem() {
        //Tracker tracker = new Tracker();
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        String itemId = tracker.getAll()[0].getId();
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(itemId).getName(), is("test2"));
    }

    @Test
    public void whenFindItemByIdTrackerHasNotThisItem() {
        //Tracker tracker = new Tracker();
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        String idNotInTracker = "1111222";
        Input input = new StubInput(new String[] {"4", idNotInTracker, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(idNotInTracker), is(nullValue()));
    }

    @Test
    public void whenFindItemByNameTrackerHasNotThisItem() {
        //Tracker tracker = new Tracker();
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
        //Tracker tracker = new Tracker();
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
        //Tracker tracker = new Tracker();
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
    public void whenUserChooseShowAllItem() {
        PrintStream stdout = System.out;
        //Создаем буфер для хранения вывода
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //заменяем стандартный вывод на вывод в память
        System.setOut(new PrintStream(out));
        //Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name1", "desc1"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(true, is(out.toString().contains("id заявки - " + item.getId())));
    }

}
