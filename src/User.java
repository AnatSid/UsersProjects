import java.util.Random;

public class User {
    private Integer id;
    private String name;
    private String surName;
    private int age;
    private static int idGenerator;

    public User(String name, String surName, Integer age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        idGenerator++;
        id = idGenerator;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Имя = '" + name + '\'' +
                ", Фамилия = '" + surName + '\'' +
                ", Возраст = " + age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

