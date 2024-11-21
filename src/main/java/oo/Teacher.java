package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements Observer{
    private List<Klass> klassList ;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        klassList = new ArrayList<>();
    }

    @Override
    public String introduce() {
        if (!this.klassList.isEmpty()){
            return super.introduce()+" I am a teacher."+" I teach Class "+ getKlass();
        }
        return super.introduce()+" I am a teacher.";
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

    @Override
    public void notify(String leaderName) {
        for (Klass klass : klassList){
            System.out.printf("I am %s, teacher of Class %d. I know %s become Leader.%n", this.getName(), klass.getId(), leaderName);
        }

    }
}
