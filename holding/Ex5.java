package holding;

import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class Ex5 {
    public static void main(String[] args) {
        List<Integer> ints = RandInteger.listOfRandInteger(7, 10);
        System.out.println("1: " + ints);

        Integer h = RandInteger.randInteger(10);
        ints.add(h);
        System.out.println("2: " + ints);
        System.out.println("3: " + ints.contains(h));
        ints.remove(h);

        Integer p = ints.get(2);
        System.out.println("4: " + p + " " + ints.indexOf(p));

        Integer cymric = RandInteger.randInteger(10);
        System.out.println("5: " + ints.indexOf(cymric));
        System.out.println("6: " + ints.remove(cymric));
        System.out.println("7: " + ints.remove(p));
        System.out.println("8: " + ints);

        ints.add(3, RandInteger.randInteger(10));
        System.out.println("9: " + ints);

        List<Integer> sub = ints.subList(1, 4);
        System.out.println("subList: " + sub);

        System.out.println("10: " + ints.containsAll(sub));

        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);
        System.out.println("11: " + ints.containsAll(sub));

        Collections.shuffle(sub);
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + ints.containsAll(sub));

        List<Integer> copy = new ArrayList<>(ints);

        sub = Arrays.asList(ints.get(1), ints.get(4));
        System.out.println("sub: " + sub);

        copy.retainAll(sub);
        System.out.println("13: " + copy);

        copy = new ArrayList<>(ints);
        copy.remove(2);
        System.out.println("14: " + copy);

        copy.removeAll(sub);
        System.out.println("15: " + copy);

        copy.set(1, RandInteger.randInteger(10));
        System.out.println("16: " + copy);

        copy.addAll(2, sub);
        System.out.println("17: " + copy);

        System.out.println("18: " + ints.isEmpty());
        ints.clear();
        System.out.println("19: " + ints);
        System.out.println("20: " + ints.isEmpty());

        ints.addAll(RandInteger.listOfRandInteger(4, 10));
        System.out.println("21: " + ints);

        Object[] o = ints.toArray();
        System.out.println("22: " + o[3]);

        Integer[] pa = ints.toArray(new Integer[0]);
        System.out.println("23: " + pa[3]);
    }

}

class RandInteger {
    private static Random rand = new Random();

    public static List<Integer> listOfRandInteger(int len, int bound) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ints.add(rand.nextInt(bound));
        }

        return ints;
    }

    public static Integer randInteger(int bound) {
        return rand.nextInt(bound);
    }
}
