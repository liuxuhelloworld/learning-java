package proxies;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import objects.Employee;

public class MethodCallCntHandlerTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();

        MethodCallCntHandler handler = new MethodCallCntHandler(staff);
        Map proxy = (Map)Proxy.newProxyInstance(
            ClassLoader.getSystemClassLoader(),
            new Class[] {Map.class}, handler);

        proxy.put("1", new Employee("Amy Lee"));
        proxy.put("2", new Employee("Harry Hacker"));
        proxy.put("3", new Employee("Gary Cooper"));
        proxy.put("4", new Employee("Francesca Cruz"));
        proxy.remove("2");
        proxy.put("4", new Employee("Francesca Miller"));
        proxy.get("3");

        handler.printMethodCallCnt();
    }
}
