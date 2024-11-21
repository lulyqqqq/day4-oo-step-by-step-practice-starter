package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int id;
    private Student leader;
    private List<Student> studentList = null;
    private List<Teacher> teacherList = null;

    public Klass(int id) {
        this.id = id;
        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
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
            notifyMembers();
        }
    }

    public boolean isLeader(Student student) {
        return Objects.equals(this.leader, student);
    }

    public void attach(Student student) {
        if (!studentList.contains(student)) {
            studentList.add(student);
        }
    }

    public void attach(Teacher teacher) {
        if (!teacherList.contains(teacher)) {
            teacherList.add(teacher);
        }
    }

    private void notifyMembers() {
        if (!teacherList.isEmpty()) {
            for (Teacher teacher : teacherList) {
                System.out.printf(
                        "I am %s, teacher of Class %d. I know %s become Leader.",
                        teacher.getName(), this.id, leader.getName()
                );
            }
        }

        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
                if (student != leader) {
                    System.out.printf(
                            "I am %s, student of Class %d. I know %s become Leader.",
                            student.getName(), this.id, leader.getName()
                    );
                }
            }

        }

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
