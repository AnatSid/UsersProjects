package org.example.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {
    private final Integer id;
    private final String name;
    private final String surname;
    private final Integer age;

    @JsonCreator
    public User(@JsonProperty("name") String name,
                @JsonProperty("surName") String surname,
                @JsonProperty("age") int age,
                @JsonProperty("id") int id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age);
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + "|" + surname + "|" + age + "|" + id;
    }

}

