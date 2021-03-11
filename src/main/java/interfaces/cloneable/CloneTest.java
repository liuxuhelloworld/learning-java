package interfaces.cloneable;

import objects.Employee;
import objects.Manager;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee e = new Employee("steve");
        Employee ecp = e.clone();
        ecp.setHireDay(ecp.getHireDay().minusDays(1));
        System.out.println(e);
        System.out.println(ecp);

        Manager m = new Manager("andrew");
        Manager mcp = (Manager)m.clone();
        System.out.println(m);
        System.out.println(mcp);
    }
}
