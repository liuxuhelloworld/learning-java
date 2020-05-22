package optional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

public class OptionalTest {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("streams/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        Optional<String> filteredFirstWord = words.stream().filter(w -> w.contains("fred")).findFirst();
        System.out.println(filteredFirstWord.orElse("no word " + "contains fred"));

        filteredFirstWord = words.stream().filter(w -> w.contains("red")).findFirst();
        filteredFirstWord.ifPresent(s -> System.out.println(s + " contains red"));

        Set<String> sets = new HashSet<>();
        filteredFirstWord.ifPresent(sets::add);
        Optional<Boolean> added = filteredFirstWord.map(sets::add);
        System.out.println("added = " + added);

        Optional<String> empty = Optional.empty();
        String s = empty.orElse("N/A");
        System.out.println("s = " + s);

        s = empty.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("s = " + s);

        try {
            s = empty.orElseThrow(IllegalStateException::new);
            System.out.println("s = " + s);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));

        Optional<Double> d = Optional.of(4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println("d = " + d);
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
