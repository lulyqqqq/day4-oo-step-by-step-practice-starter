package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int id;
    private Student leader;
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Observer> observers;

    public Klass(int id) {
        this.id = id;
        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.notify(leader.getName());
        }
    }

    public void assignLeader(Student student) {
        if (student.getKlass() != this) {
            System.out.println("It is not one of us.");
        } else {
            this.leader = student;
            notifyObservers();
        }
    }

    public boolean isLeader(Student student) {
        return Objects.equals(this.leader, student);
    }

    public void attach(Student student) {
        if (!studentList.contains(student) && student != leader) {
            studentList.add(student);
        }
        addObserver(student);
    }

    public void attach(Teacher teacher) {
        if (!teacherList.contains(teacher)) {
            teacherList.add(teacher);
        }
        addObserver(teacher);
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
