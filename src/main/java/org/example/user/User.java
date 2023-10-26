package org.example.user;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surName, user.surName) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, age);
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

