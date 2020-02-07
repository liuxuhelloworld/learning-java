package generics.corejava;

import java.time.LocalDate;

public class ArrayAlgTest {
	public static void main(String[] args) {
		String[] words = {"Mary", "had", "a", "little", "lamb"};

		String[] minMaxWordArr = ArrayAlg.minmax(String[]::new, words);
		System.out.println(minMaxWordArr[0]);
		System.out.println(minMaxWordArr[1]);



		String mid = ArrayAlg.getMiddle(words);
		System.out.println("mid = " + mid);

		//double mid2 = ArrayAlg.getMiddle(new Double[] {3.14, (double)18, (double)0});
		//System.out.println("mid2 = " + mid2);
		System.out.println(ArrayAlg.getMiddle("hello", 18, null));
	}
}
