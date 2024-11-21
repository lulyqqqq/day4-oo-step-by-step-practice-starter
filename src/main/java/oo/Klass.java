package oo;

import java.util.Objects;

public class Klass {
    private int id;

    public Klass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
