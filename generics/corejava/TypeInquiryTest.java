package generics.corejava;

import java.time.LocalDate;

public class TypeInquiryTest {
    public static void main(String[] args) {
        Pair<String> a = new Pair<>("abc", "def");
        Class ac = a.getClass();
        System.out.println("a.getClass() = " + ac);
        //if (a instanceof Pair<String>) { //error
        //    System.out.println(a);
        //}

        Pair<Double> b = new Pair<>(123.0, 456.0);
        Class bc = b.getClass();
        System.out.println("b.getClass() = " + bc);
        if (a.getClass() == b.getClass()) { // true
            System.out.println(a + ", " + b);
        }

        LocalDate first = LocalDate.of(2019, 1, 1);
        LocalDate second = LocalDate.of(2020, 1, 1);
        DateInterval c = new DateInterval(first, second);
        Class cc = c.getClass();
        System.out.println("c.getClass() = " + cc);
        if (a.getClass() == c.getClass()) {
            System.out.println(a + ", " + c);
        }

    }
}
