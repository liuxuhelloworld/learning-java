package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SimpleReductions {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Stream", "Transform", "Test", "Stream", "Example",
            "Question"));

        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
        System.out.println("largest: " + largest.orElse(""));

        Optional<String> startsWithQ = words.stream().filter(x -> x.startsWith("Q")).findFirst();
        System.out.println("startsWithQ: " + startsWithQ.orElse(""));

        boolean aWordStartWithQ = words.stream().anyMatch(x -> x.startsWith("Q"));
        System.out.println("aWordStartWithQ: " + aWordStartWithQ);
    }
}
