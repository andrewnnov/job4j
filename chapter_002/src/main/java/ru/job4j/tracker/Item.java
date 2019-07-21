package ru.job4j.tracker;

import java.util.Objects;

public class Item {

    private String id;
    private String name;
    private String desc;
    private long time;

    public Item(String name, String desc, long time) {
        this.name = name;
        this.desc = desc;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return getTime() == item.getTime() && Objects.equals(getId(), item.getId()) && Objects.equals(getName(),
                item.getName()) && Objects.equals(getDesc(), item.getDesc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDesc(), getTime());
    }
}
