package generics.corejava;

import java.time.LocalDate;

public class PairTest {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

        LocalDate[] birthdays = {
            LocalDate.of(1906, 12, 9),
            LocalDate.of(1815, 12, 10),
            LocalDate.of(1903, 12, 3),
            LocalDate.of(1910, 6, 22),
        };
        Pair<LocalDate> mm2 = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm2.getFirst());
        System.out.println("max = " + mm2.getSecond());

        LocalDate min = ArrayAlg.min(birthdays);
        System.out.println("minBirth = " + min);

        Pair<String> p = Pair.makePair(String::new);
        System.out.println(p);

        Pair<String> p2 = Pair.makePair(String.class);
        System.out.println(p2);
    }
}
