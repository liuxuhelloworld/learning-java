package generics.corejava;

public class GenericArrayTest {
    public static void main(String[] args) {
        //Pair<String>[] arr = new Pair<String>[10]; // error
        //Pair<String>[] arr = new Pair<>[10]; // error
        //System.out.println(arr.length);

        Pair<String>[] arr = new Pair[10];
        System.out.println(arr.length);
    }
}
