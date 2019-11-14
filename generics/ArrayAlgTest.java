package generics;

public class ArrayAlgTest {
	public static void main(String[] args) {
		String[] words = {"Mary", "had", "a", "little", "lamb"};
		Pair<String> minmax = ArrayAlg.minmax(words);
		System.out.println("min = " + minmax.getFirst());
		System.out.println("max = " + minmax.getSecond());

		String mid = ArrayAlg.getMiddle(words);
		System.out.println("mid = " + mid);

		double mid2 = ArrayAlg.getMiddle(3.14, (double)18, (double)0);
		System.out.println("mid2 = " + mid2);
	}
}
