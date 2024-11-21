package oo;

public class Student extends Person{
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
        return super.introduce()+String.format(" I am a student. I am in class %d.",this.klass.getId());
    }
}
