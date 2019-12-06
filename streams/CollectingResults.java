package streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
    public static Stream<String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("streams/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        return words.stream().map(w -> w.replaceAll("[aeiouAEIOU]]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.println(label + ": " + set.getClass().getName());
        System.out.println("["
            + set.stream().limit(10).map(Objects::toString).collect(Collectors.joining(", "))
            + "]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n+1).limit(10).iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array: " + numbers);

        try {
            Integer number = (Integer) numbers[0];
            System.out.println("number: " + number);

            Integer[] numbers2 = (Integer[]) numbers;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        Integer[] numbers3 = Stream.iterate(0, n -> n+1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array: " + numbers3);


        Set<String> noVowelsSet = noVowels().collect(Collectors.toSet());
        show("noVowelsSet", noVowelsSet);

        TreeSet<String> noVowelsTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelsTreeSet", noVowelsTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining: " + result);

        result = noVowels().limit(10).collect(Collectors.joining(", "));
        System.out.println("Joining with comma: " + result);

        IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
        System.out.println("average word length: " + summary.getAverage());
        System.out.println("max word length: " + summary.getMax());
    }
}
