package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "test Description", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenWeHaveIdInTrackerIsGood() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "Desc1", 123L);
        Item item2 = new Item("test2", "Desc2", 123L);
        Item item3 = new Item("test3", "Desc3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        String itemIdZero = tracker.getAll()[0].getId();
        String itemIdOne = tracker.getAll()[1].getId();
        assertThat(tracker.findById(itemIdZero).getName(), is("test1"));
        assertThat(tracker.findById(itemIdOne).getName(), is("test2"));
    }

    @Test
    public void whenTrackerAdd3ItemThenLengthEquals3() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "Desc1", 123L);
        Item item2 = new Item("test2", "Desc2", 123L);
        Item item3 = new Item("test3", "Desc3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.getAll().length, is(3));
    }

    @Test
    public void whenReplaceElementThenTrue() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "Desc1", 123L);
        Item item2 = new Item("test2", "Desc2", 123L);
        Item item99 = new Item("test99", "desc99", 555L);
        tracker.add(item1);
        tracker.add(item2);
        String itemIdZero = tracker.getAll()[0].getId();
        assertThat(tracker.replace(itemIdZero, item99), is(true));
    }

    @Test
    public void whenReplaceElementThenOldElementNameEqualNewElement() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "Desc1", 123L);
        Item item2 = new Item("test2", "Desc2", 123L);
        Item item99 = new Item("test99", "desc99", 555L);
        tracker.add(item1);
        tracker.add(item2);
        String itemIdZero = tracker.getAll()[0].getId();
        tracker.replace(itemIdZero, item99);
        assertThat(tracker.findById(itemIdZero).getName(), is("test99"));
    }

    @Test
    public void whenDeleteElementThenTrackerLessOnOneElement() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "Desc1", 123L);
        Item item2 = new Item("test2", "Desc2", 123L);
        tracker.add(item1);
        tracker.add(item2);
        String itemIdZero = tracker.getAll()[0].getId();
        tracker.delete(itemIdZero);
        assertThat(tracker.getAll().length, is(1));
    }

    @Test
    public void whenDeleteElementThenNameZeroElEqualsOneElement() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "Desc1", 123L);
        Item item2 = new Item("test2", "Desc2", 123L);
        tracker.add(item1);
        tracker.add(item2);
        String itemIdZeroBefore = tracker.getAll()[0].getId();
        tracker.delete(itemIdZeroBefore);
        assertThat(tracker.getAll()[0].getName(), is("test2"));
    }

    @Test
    public void whenFindByNameThenReturnElementWithName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "Desc1", 123L);
        Item item2 = new Item("test2", "Desc2", 123L);
        Item item3 = new Item("test2", "Desc3", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("test2").length, is(2));
    }















}
