package holding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Liuxu_EqualsMethodInList {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        Collections.addAll(strings, "abc", "def", "ghi", "abc");

        System.out.println("1: " + strings);

        String s = "abc";
        System.out.println("2: " + strings.contains(s)); // true
        System.out.println("3: " + strings.indexOf(s)); // 0

        String t = strings.get(3);
        System.out.println("4: " + strings.contains(t)); // true
        System.out.println("5: " + strings.indexOf(t)); // 0
    }
}
