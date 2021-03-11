package objects;

import java.util.Objects;

public abstract class Person {
    private String name;

    public abstract String getDescription();

    public Person(String name) {
        Objects.requireNonNull(name, "the name cannot be null");
        this.name = name;
    }
        
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + "]";
    }
}
