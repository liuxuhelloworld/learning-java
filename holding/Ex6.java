package holding;

import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;

public class Ex6 {
    public static void main(String[] args) {
        List<String> strs = RandString.listOfRandString(7, 10);
        System.out.println("1: " + strs);

        String h = RandString.randString(10);
        strs.add(h);
        System.out.println("2: " + strs);
        System.out.println("3: " + strs.contains(h));
        strs.remove(h);

        String p = strs.get(2);
        System.out.println("4: " + p + " " + strs.indexOf(p));

        String cymric = RandString.randString(10);
        System.out.println("5: " + strs.indexOf(cymric));
        System.out.println("6: " + strs.remove(cymric));
        System.out.println("7: " + strs.remove(p));
        System.out.println("8: " + strs);

        strs.add(3, RandString.randString(10));
        System.out.println("9: " + strs);

        List<String> sub = strs.subList(1, 4);
        System.out.println("subList: " + sub);

        System.out.println("10: " + strs.containsAll(sub));

        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);
        System.out.println("11: " + strs.containsAll(sub));

        Collections.shuffle(sub);
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + strs.containsAll(sub));

        List<String> copy = new ArrayList<>(strs);

        sub = Arrays.asList(strs.get(1), strs.get(4));
        System.out.println("sub: " + sub);

        copy.retainAll(sub);
        System.out.println("13: " + copy);

        copy = new ArrayList<>(strs);
        copy.remove(2);
        System.out.println("14: " + copy);

        copy.removeAll(sub);
        System.out.println("15: " + copy);

        copy.set(1, RandString.randString(10));
        System.out.println("16: " + copy);

        copy.addAll(2, sub);
        System.out.println("17: " + copy);

        System.out.println("18: " + strs.isEmpty());
        strs.clear();
        System.out.println("19: " + strs);
        System.out.println("20: " + strs.isEmpty());

        strs.addAll(RandString.listOfRandString(4, 10));
        System.out.println("21: " + strs);

        Object[] o = strs.toArray();
        System.out.println("22: " + o[3]);

        String[] pa = strs.toArray(new String[0]);
        System.out.println("23: " + pa[3]);
    }

}

class RandString {
    private static Random rand = new Random();

    public static List<String> listOfRandString(int len, int bound) {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            strs.add(String.valueOf(rand.nextInt(bound)));
        }

        return strs;
    }

    public static String randString(int bound) {
        return String.valueOf(rand.nextInt(bound));
    }
}
