package oo;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private Klass klass;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    public boolean isIn(Klass klass){
        if (this.klass == null){
            return false;
        }
        return this.klass.getId() == klass.getId();
    }


    @Override
    public boolean equals(Object person) {
        if (person == null) {
            return false;
        }
        Person nowPerson = (Person) person;
        return Objects.equals(this.id, nowPerson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
