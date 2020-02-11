package generics.corejava;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.function.IntFunction;

public class GenericArrayTest {
    /*
    public static <T extends Comparable> T[] minmax(T... a) {
        Comparable[] mm = new Comparable[2];

        Comparable min = a[0];
        Comparable max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        mm[0] = min;
        mm[1] = max;

        return (T[])mm;
    }
    */

    public static <T extends Comparable> T[] minmax(T... a) {
        T[] mm = (T[])Array.newInstance(a.getClass().getComponentType(), 2);

        if (a == null || a.length == 0) {
            return null;
        }

        T min = a[0];
        T max = a[1];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        mm[0] = min;
        mm[1] = max;

        return mm;
    }

    public static <T extends Comparable> T[] minmax(IntFunction<T[]> constr, T... a) {
        T[] mm = constr.apply(2);

        if (a == null || a.length == 0) {
            return null;
        }

        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        mm[0] = min;
        mm[1] = max;
        return mm;
    }

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    //public static <T extends Comparable<T>> T min(T[] a) {
    public static <T extends Comparable<? super T>> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        T t = a[0];
        for (int i = 1; i < a.length; i++) {
            if (t.compareTo(a[i]) > 0) {
                t = a[i];
            }
        }

        return t;
    }

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};

        String[] mm = minmax(words);
        System.out.println(mm[0]);
        System.out.println(mm[1]);

        String[] mm2 = minmax(String[]::new, words);
        System.out.println(mm2[0]);
        System.out.println(mm2[1]);

        String mid = getMiddle(words);
        System.out.println("mid = " + mid);

        System.out.println(getMiddle("hello", 18, null));

        LocalDate[] birthdays = {
            LocalDate.of(1906, 12, 9),
            LocalDate.of(1815, 12, 10),
            LocalDate.of(1903, 12, 3),
            LocalDate.of(1910, 6, 22),
        };
        LocalDate min = min(birthdays);
        System.out.println("minBirth = " + min);
    }
}
