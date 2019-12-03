package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TransformStreams {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Stream", "Transform", "Test"));

        Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);
        CreatingStreams.show("lowercaseWords", lowercaseWords);

        Stream<String> firstLetters = words.stream().map(w -> w.substring(0, 1));
        CreatingStreams.show("firstLetters", firstLetters);

        Stream<Stream<String>> letters = words.stream().map(w -> letters(w));
        CreatingStreams.show("stream of stream of letters", letters);

        Stream<String> flatLetters = words.stream().flatMap(w -> letters(w));
        CreatingStreams.show("flat stream of letters", flatLetters);
    }

    public static Stream<String> letters(String s) {
        List<String> letters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            letters.add(s.substring(i, i + 1));
        }

        return letters.stream();
    }
}
