package oo;

public class Student extends Person implements Observer{
    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public boolean isIn(Klass klass){
        if (this.klass == null){
            return false;
        }
        return this.klass.getId() == klass.getId();
    }

    public void join(Klass klass){
        if (klass != null){
            this.klass = klass;
        }
    }

    @Override
    public String introduce() {
        if (this.klass!= null){
            return super.introduce()+String.format(" I am a student. I am in class %d.",this.klass.getId());
        }
        return super.introduce()+" I am a student.";
    }

    @Override
    public void notify(String leaderName) {
        if (!this.getName().equals(leaderName)) {
            System.out.printf("I am %s, student of Class %d. I know %s become Leader.%n", this.getName(), this.getKlass().getId(), leaderName);
        }
    }
}
