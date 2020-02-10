package generics.corejava;

import java.util.ArrayList;
import java.util.Collection;

public class GenericVarargsTest {
    public static <T> void addAll(Collection<T> coll, T... args) {
        for (T t : args) {
            coll.add(t);
        }
    }

    public static <E> E[] array(E... args) {
        return args;
    }

    public static void main(String[] args) {
        Collection<Pair<String>> coll = new ArrayList<>();
        Pair<String> pair1 = new Pair<>("abc", "def");
        Pair<String> pair2 = new Pair<>("ghi", "jkl");
        addAll(coll, pair1, pair2);
        for (Pair<String> pair : coll) {
            System.out.println(pair);
        }

        Pair<String>[] pairArr = array(pair1, pair2);
        for (Pair<String> pair : pairArr) {
            System.out.println(pair);
        }
    }
}
