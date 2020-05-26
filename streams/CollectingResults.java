package streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return getClass().getName() + "[id=" + id + ", name=" + name + "]";
        }
    }

    public static class City {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public int getPopulation() {
            return population;
        }
    }

    public static Stream<City> readCities(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .map(l -> l.split(", "))
                .map(e -> new City(e[0], e[1], Integer.parseInt(e[2])));
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"),
            new Person(1002, "Paul"),
            new Person(1003, "Mary"));
    }
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

        Integer[] numbers2 = Stream.iterate(0, n -> n+1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array: " + numbers2);


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

        Map<Integer, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);

        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(
            Person::getId, Function.identity()));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

        idToPerson = people().collect(Collectors.toMap(
            Person::getId,
            Function.identity(),
            (existingValue, newValue) -> {throw new IllegalStateException();},
            TreeMap::new
        ));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
            Collectors.toMap(
                Locale::getDisplayLanguage,
                l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> existingValue
            )
        );
        System.out.println("languageNames: " + languageNames);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> coutryLanguageSets = locales.collect(
            Collectors.toMap(
                Locale::getDisplayCountry,
                l -> Collections.singleton(l.getDisplayLanguage()),
                (existingValue, newValue) -> {
                    Set<String> union = new HashSet<>(existingValue);
                    union.addAll(newValue);
                    return union;
                }
            )
        );
        System.out.println("coutryLanguageSets: " + coutryLanguageSets);

        locales = Stream.of(Locale.getAvailableLocales());
        coutryLanguageSets = locales.collect(
            Collectors.groupingBy(
                Locale::getDisplayCountry,
                Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())
            )
        );
        System.out.println("coutryLanguageSets: " + coutryLanguageSets);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry));
        System.out.println("countryToLocales: " + countryToLocales);
        List<Locale> chinaLocales = countryToLocales.get("CN");
        System.out.println("chinaLocales: " + chinaLocales);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
            Collectors.partitioningBy(e -> e.getLanguage().equals("en"))
        );
        System.out.println("englishAndOtherLocales: " + englishAndOtherLocales);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(
            Collectors.groupingBy(Locale::getDisplayCountry, Collectors.toSet())
        );
        System.out.println("countryToLocaleSet: " + countryToLocaleSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(
            Collectors.groupingBy(Locale::getDisplayCountry, Collectors.counting())
        );
        System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);

        Stream<City> cities = readCities("streams/cities.txt");
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(
            Collectors.groupingBy(
                City::getState,
                Collectors.mapping(
                    City::getName,
                    Collectors.maxBy(
                        Comparator.comparing(String::length)
                    )
                )
            )
        );
        System.out.println("stateToLongestCityName: " + stateToLongestCityName);

        cities = readCities("streams/cities.txt");
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(
            Collectors.groupingBy(
                City::getState,
                Collectors.summarizingInt(City::getPopulation)
            )
        );
        System.out.println("stateToCityPopulationSummary: " + stateToCityPopulationSummary);

        cities = readCities("streams/cities.txt");
        Map<String, String> stateToCityNames = cities.collect(
            Collectors.groupingBy(
                City::getState,
                Collectors.mapping(City::getName, Collectors.joining(", "))
            )
        );
        System.out.println("stateToCityNames: " + stateToCityNames);

        cities = readCities("streams/cities.txt");
        stateToCityNames = cities.collect(
            Collectors.groupingBy(
                City::getState,
                Collectors.reducing(
                    "",
                    City::getName,
                    (s, t) -> s.length() == 0 ? t : s + ", " + t
                )
            )
        );
        System.out.println("stateToCityNames: " + stateToCityNames);
    }
}
