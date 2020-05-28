package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class StreamReductions {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Stream", "Transform", "Test", "Stream", "Example",
            "Question"));

        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
        System.out.println("largest: " + largest.orElse(""));

        Optional<String> startsWithQ = words.stream().filter(x -> x.startsWith("Q")).findFirst();
        System.out.println("startsWithQ: " + startsWithQ.orElse(""));

        boolean aWordStartWithQ = words.stream().anyMatch(x -> x.startsWith("Q"));
        System.out.println("aWordStartWithQ: " + aWordStartWithQ);

        List<Integer> values = new ArrayList<>(Arrays.asList(123, 456, 789));
        Optional<Integer> sum = values.stream().reduce((x, y) -> x+y);
        System.out.println("sum: " + sum);

        sum = values.stream().reduce(Integer::sum);
        System.out.println("sum: " + sum);

        Integer sum2 = values.stream().reduce(0, (x, y) -> x+y);
        System.out.println("sum2: " + sum2);
    }
}
