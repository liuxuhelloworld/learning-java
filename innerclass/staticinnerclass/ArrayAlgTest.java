package innerclass.staticinnerclass;

public class ArrayAlgTest {
    public static void main(String[] args) {
        double[] vals = new double[20];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = 100 * Math.random();
        }

        ArrayAlg.Pair p = ArrayAlg.minmax(vals);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}
