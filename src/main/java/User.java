

public class User {
    private final Integer id;
    private final String name;
    private final String surName;
    private final int age;
    private static int idGenerator;

    public User(String name, String surName, Integer age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        idGenerator++;
        this.id = idGenerator;

    }

    @Override
    public String toString() {
        return "Name = '" + name + '\'' +
                ", Surname = '" + surName + '\'' +
                ", Age = " + age + '\'' +
                ", Id = " + id;
    }

    public Integer getId() {
        return id;
    }
}

