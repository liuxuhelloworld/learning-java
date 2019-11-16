package generics;

public class PairTest {
    public static void main(String[] args) {
        // array of generic type
        Pair<String>[] arr = (Pair<String>[]) new Pair<?>[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Pair("abc", "def");
        }
        for (Pair<String> e : arr) {
            System.out.println(e);
        }

        // makePair test
        Pair<String> p = Pair.makePair(String::new);
        System.out.println(p);

        Pair<String> p2 = Pair.makePair(String.class);
        System.out.println(p2);
    }
}