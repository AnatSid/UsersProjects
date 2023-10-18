package org.example.user;

public class User {
    private final Integer id;
    private final String name;
    private final String surName;
    private final Integer age;

    public User(String name, String surName, int age, int id) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + "|" + surName + "|" + age + "|" + id;
    }

}

