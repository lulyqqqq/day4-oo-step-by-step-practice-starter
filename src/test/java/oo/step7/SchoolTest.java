package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testStartSchool(){
        School school = new School();
        Teacher jerry = new Teacher(1, "Jerry", 21);
        Teacher mason = new Teacher(2, "Mason", 22);
        school.addTeacher(jerry);
        school.addTeacher(mason);

        Student tom = new Student(1, "Tom", 18);
        Student alex = new Student(2, "Alex", 18);
        school.addStudent(tom);
        school.addStudent(alex);

        school.startSchool();
        assertThat(systemOut()).contains("My name is Jerry. I am 21 years old. I am a teacher.");
        assertThat(systemOut()).contains("My name is Mason. I am 22 years old. I am a teacher.");
        assertThat(systemOut()).contains("My name is Tom. I am 18 years old. I am a student.");
        assertThat(systemOut()).contains("My name is Alex. I am 18 years old. I am a student.");

    }
    private String systemOut() {
        return outContent.toString();
    }
}
