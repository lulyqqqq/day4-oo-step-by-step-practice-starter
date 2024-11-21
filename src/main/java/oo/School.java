package oo;

import java.util.ArrayList;
import java.util.List;

public class School {
    public List<Teacher> teachers = null;
    public List<Student> students = null;

    public School() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void startSchool() {
        if (!teachers.isEmpty()){
            teachers.forEach(teacher -> System.out.println(teacher.introduce()));
        }

        if (!students.isEmpty()){
            students.forEach(student->System.out.println(student.introduce()));
        }
    }
}
