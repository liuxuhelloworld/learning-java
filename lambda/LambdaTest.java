package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import javax.swing.*;

public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println("planets = " + Arrays.toString(planets));

        Arrays.sort(planets);
        System.out.println("planets sorted in dictionary order = " + Arrays.toString(planets));

        Arrays.sort(planets, new StringLengthComparator());
        System.out.println("planets sorted in length = " + Arrays.toString(planets));

        Arrays.sort(planets, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println("planets sorted in length = " + Arrays.toString(planets));

        Arrays.sort(planets, (first, second) -> second.length() - first.length());
        System.out.println("planets sorted in reverse length = " + Arrays.toString(planets));


        Timer timer = new Timer(1000, event -> System.out.println("the time is " + new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}