package objects;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person implements Comparable<Employee>, Cloneable{
    private static int nextId = 1;

    private int id;
    private double salary;
    private LocalDate hireDay;

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee(String name) {
        this(name, 0.0);
    }

    public Employee(double salary) {
        this("Employee #" + nextId, salary);
    }

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.now();
    }

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }


    public static int getNextId() {
        return nextId;
    }


    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate date) {
        this.hireDay = date;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with salary of $%.2f", salary);
    }

    public double raiseSalary(double percent) {
        double raise = salary * percent / 100;
        salary += raise;

        return raise;
    }

    @Override 
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }

        if (otherObject == null) {
            return false;
        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }

        Employee other = (Employee)otherObject;

        return Objects.equals(getName(), other.getName())
            && salary == other.salary
            && Objects.equals(hireDay, other.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), salary, hireDay);
    }

    @Override
    public String toString() {
        return super.toString() + 
            "[id=" + id +
            ", salary=" + salary +
            ", hireDay=" + hireDay + "]";
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(getSalary(), other.getSalary());
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee)super.clone();
    }
}
