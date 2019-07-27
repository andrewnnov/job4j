package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test1", "desk1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test1"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        Input input = new StubInput(new String[] {"2", item.getId(), "test99", "desc99", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test99"));
    }

    @Test
    public void whenFindItemByIdTrackerHasThisItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        String itemId = tracker.getAll()[0].getId();
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(itemId).getName(), is("test2"));
    }

    @Test
    public void whenFindItemByIdTrackerHasNotThisItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "desc2", 765L);
        tracker.add(item);
        String idNotInTracker = "1111222";
        Input input = new StubInput(new String[] {"4", idNotInTracker, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(idNotInTracker), is(nullValue()));
    }

    @Test
    public void whenFindItemByNameTrackerHasNotThisItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "desc2", 765L);
        Item item1 = new Item("test2", "desc3", 765L);
        tracker.add(item);
        tracker.add(item1);
        String id = tracker.getAll()[1].getId();
        Input input = new StubInput(new String[] {"5", "test2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test2")[1].getId(), is(id));
    }

    @Test
    public void whenDeleteItemByIdTrackerHasNotThisItem() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "desc2", 765L);
        Item item1 = new Item("test3", "desc3", 765L);
        tracker.add(item);
        tracker.add(item1);
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[1].getName(), is("test3"));
    }

}
