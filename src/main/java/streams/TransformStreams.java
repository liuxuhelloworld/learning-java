package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TransformStreams {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Stream", "Transform", "Test", "Stream", "Example"));

        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);
        StreamUtil.show("lowercaseWords", lowercaseWords);

        Stream<String> firstLetters = words.stream().map(w -> w.substring(0, 1));
        StreamUtil.show("firstLetters", firstLetters);

        Stream<Stream<String>> letters = words.stream().map(w -> letters(w));
        StreamUtil.show("stream of stream of letters", letters);

        Stream<String> flatLetters = words.stream().flatMap(w -> letters(w));
        StreamUtil.show("flat stream of letters", flatLetters);

        Stream<Double> randoms = Stream.generate(Math::random).limit(10);
        StreamUtil.show("randoms", randoms);

        Stream<String> skipFirst = words.stream().skip(1);
        StreamUtil.show("skipFirst", skipFirst);

        Stream<String> combined = Stream.concat(letters("Hello"), letters("World"));
        StreamUtil.show("combined", combined);

        Stream<String> uniqueWords = words.stream().distinct();
        StreamUtil.show("uniqueWords", uniqueWords);

        Stream<String> longestFirst = words.stream().sorted(Comparator.comparing(String::length).reversed());
        StreamUtil.show("longestFirst", longestFirst);

        Stream<Integer> powers = Stream.iterate(1, p -> p*2)
            .peek(e -> System.out.println("Fetching " + e))
            .limit(20);
        StreamUtil.show("powers", powers);
    }

    public static Stream<String> letters(String s) {
        List<String> letters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            letters.add(s.substring(i, i + 1));
        }

        return letters.stream();
    }
}
