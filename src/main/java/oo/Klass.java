package oo;

import java.util.Objects;

public class Klass {
    private int id;
    private Student leader;
    private Student student;

    public Klass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void assignLeader(Student student) {
        if (student.getKlass() != this) {
            System.out.println("It is not one of us.");
        } else {
            this.leader = student;
        }
    }

    public boolean isLeader(Student student) {
        return Objects.equals(this.leader, student);
    }

    @Override
    public boolean equals(Object klass) {
        if (klass == null) {
            return false;
        }
        Klass nowKlass = (Klass) klass;
        return Objects.equals(this.id, nowKlass.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

}
