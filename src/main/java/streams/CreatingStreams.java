package streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("streams/alice.txt")), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        StreamUtil.show("words", words);

        Stream<String> words2 = Pattern.compile("\\PL+").splitAsStream(contents);
        StreamUtil.show("words2", words2);

        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        StreamUtil.show("song", song);

        Stream<String> silence = Stream.empty();
        StreamUtil.show("silence", silence);

        Stream<String> echos = Stream.generate(() -> "Echo");
        StreamUtil.show("echos", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        StreamUtil.show("randoms", randoms);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, x -> x.add(BigInteger.ONE));
        StreamUtil.show("integers", integers);
    }

}
