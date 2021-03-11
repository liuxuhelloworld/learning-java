package interfaces.comparator;

import java.util.Arrays;

public class StringLengthComparatorTest {
    public static void main(String[] args) {
        String[] friends = {"Peter", "Paul", "Sam", "Mary", "TestTest"};
        Arrays.sort(friends, new StringLengthComparator());
        System.out.println(Arrays.toString(friends));
    }
}
