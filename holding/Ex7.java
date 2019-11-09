package holding;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;


public class Ex7 {
    public static void main(String[] args) {
        Tester[] tester = new Tester[10];
        for (int i = 0; i < 10; i++) {
            tester[i] = new Tester();
         }

        List<Tester> list = new ArrayList<>();
        Collections.addAll(list, tester);
        System.out.println("list: " + list);

        List<Tester> sub = list.subList(1, 5);
        System.out.println("sub: " + sub);
        
        list.removeAll(sub);
        System.out.println("list: " + list);
    }
}

class Tester {
    private static int counter = 0;

    private int id = counter++;

    public String toString() {
        return String.valueOf(id);
    }
}
