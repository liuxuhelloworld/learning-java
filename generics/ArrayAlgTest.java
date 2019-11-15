package generics;

import java.time.LocalDate;

public class ArrayAlgTest {
	public static void main(String[] args) {
		String[] words = {"Mary", "had", "a", "little", "lamb"};
		Pair<String> minMaxWord = ArrayAlg.minmax(words);
		System.out.println("min = " + minMaxWord.getFirst());
		System.out.println("max = " + minMaxWord.getSecond());

        LocalDate[] birthdays = {
            LocalDate.of(1906, 12, 9),
            LocalDate.of(1815, 12, 10),
			LocalDate.of(1903, 12, 3),
			LocalDate.of(1910, 6, 22),
		};
        Pair<LocalDate> minMaxBirth = ArrayAlg.minmax(birthdays);
        System.out.println("minBirth = " + minMaxBirth.getFirst());
		System.out.println("maxBirth = " + minMaxBirth.getSecond());

		String mid = ArrayAlg.getMiddle(words);
		System.out.println("mid = " + mid);

		double mid2 = ArrayAlg.getMiddle(new Double[] {3.14, (double)18, (double)0});
		System.out.println("mid2 = " + mid2);
	}
}
