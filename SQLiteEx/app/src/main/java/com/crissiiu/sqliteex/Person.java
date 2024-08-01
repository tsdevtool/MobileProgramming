package com.crissiiu.sqliteex;

public class Person {
    private long id;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
