package arrays;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayLengthWithVariableValue {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] arr = new int[n];
		System.out.println(Arrays.toString(arr));
	}
}
