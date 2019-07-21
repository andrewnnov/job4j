package ru.job4j.tracker;

import java.util.Random;

public class Tracker {

    private final Item[] items = new Item[100];

    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Add new item to storage
     * @param item - new item
     * @return added item
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Find item in storage
     * @param id number of item
     * @return item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * get all item
     * @return list of items
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Change items in storage
     * @param id item in storage
     * @param item new item
     * @return
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item el: items) {
            if (el != null && el.getId().equals(id)) {
                el.setName(item.getName());
                el.setDesc(item.getDesc());
                el.setTime(item.getTime());
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * delete item from storage
     * @param id number of itwm
     * @return
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, position - index - 1);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * find item by name in storage
     * @param key - name of item
     * @return item
     */
    public Item[] findByName(String key) {
        int count = 0;

        Item[] tmp = new Item[position];

        for (int index = 0; index < position; index++) {
            if (items[index] != null && items[index].getName().equals(key)) {
                tmp[count++] = items[index];
            }

        }
        Item[] result = new Item[count];
        System.arraycopy(tmp, 0, result, 0, count);

        return result;
    }


    /**
     * generate id for new item
     * @return new number of item in String type
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
