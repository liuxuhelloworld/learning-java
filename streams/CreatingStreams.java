package streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("streams/alice.txt")), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);

        Stream<String> words2 = Pattern.compile("\\PL+").splitAsStream(contents);
        show("words2", words2);

        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);

        Stream<String> silence = Stream.empty();
        show("silence", silence);

        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, x -> x.add(BigInteger.ONE));
        show("integers", integers);
    }

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;

        List<T> elements = stream
            .limit(SIZE + 1)
            .collect(Collectors.toList());

        System.out.print(title + ": ");
        for (int i = 0; i < elements.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            if (i < SIZE) {
                System.out.print(elements.get(i));
            } else {
                System.out.print("...");
            }
        }
        System.out.println();
    }
}
