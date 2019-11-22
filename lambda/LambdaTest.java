package lambda;

import java.util.Arrays;
import java.util.Date;

import javax.swing.*;

public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println("planets = " + Arrays.toString(planets));

        Arrays.sort(planets);
        System.out.println("planets sorted in dictionary order = " + Arrays.toString(planets));

        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println("planets sorted in length = " + Arrays.toString(planets));


        Timer timer = new Timer(1000, event -> System.out.println("the time is " + new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}
