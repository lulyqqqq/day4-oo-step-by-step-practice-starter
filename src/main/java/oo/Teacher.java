package oo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person{
    private List<Klass> klassList = null;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        klassList = new ArrayList<>();
    }

    @Override
    public String introduce() {
        return super.introduce()+" I am a teacher."+" I teach Class "+ getKlass();
    }

    private String getKlass(){
        return klassList.stream()
                .map(klass -> String.valueOf(klass.getId()))
                .collect(Collectors.joining(", ")) + ".";
    }

    public boolean belongsTo (Klass klass){
        return klassList.contains(klass);
    }

    public void assignTo(Klass klass){
        klassList.add(klass);
    }

    public boolean isTeaching(Student student) {
        return klassList.stream()
                .anyMatch(klass -> klass.equals(student.getKlass()));
    }
}
