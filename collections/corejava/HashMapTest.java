package collections.corejava;

import java.util.HashMap;
import java.util.Map;

import objects.Employee;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("1", new Employee("Amy Lee"));
        staff.put("2", new Employee("Harry Hacker"));
        staff.put("3", new Employee("Gary Cooper"));
        staff.put("4", new Employee("Francesca Cruz"));

        System.out.println(staff);

        staff.remove("2");

        staff.put("4", new Employee("Francesca Miller"));

        System.out.println(staff.get("3"));

        staff.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
    }
}
