

public class User {
    private Integer id;
    private String name;
    private String surName;
    private int age;
    private static int idGenerator;

    public User() {
        this.id = idGenerator;
        idGenerator++;

    }

    public User(String name, String surName, Integer age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        idGenerator++;
        this.id = idGenerator;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name = '" + name + '\'' +
                ", Surname = '" + surName + '\'' +
                ", Age = " + age;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

