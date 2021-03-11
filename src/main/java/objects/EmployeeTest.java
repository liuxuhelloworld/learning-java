package objects;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeTest {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        Employee[] arr = new Employee[staff.size()];
        staff.toArray(arr);

        Arrays.sort(arr);

        for (Employee e : arr) {
            System.out.println("name=" + e.getName() + 
                    ", salary=" + e.getSalary() +
                    ", hireDay=" + e.getHireDay());
        }

        System.out.println(staff.get(0).equals(staff.get(1)));
        System.out.println(staff.get(0).equals(staff.get(2)));
        System.out.println(staff.get(0).equals(staff.get(3)));

        System.out.println(staff.get(0).hashCode());
        System.out.println(staff.get(1).hashCode());
        System.out.println(staff.get(2).hashCode());
        System.out.println(staff.get(3).hashCode());

        System.out.println(staff.get(0));
        System.out.println(staff.get(1));
        System.out.println(staff.get(2));
        System.out.println(staff.get(3));
    }
}
