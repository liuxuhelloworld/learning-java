package concurrency.threadsafecollections.blockingqueue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonBlockingQueueExample {
    private static final int SEARCH_THREADS = 100;
    private static final Path DUMMY = Paths.get("");
    private static Queue<Path> queue = new LinkedList<>();

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter base directory: ");
            String directory = in.nextLine();
            System.out.print("Enter keyword: ");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(Paths.get(directory));
                    queue.add(DUMMY);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                }
            };
            new Thread(enumerator).start();

            for (int i = 0; i < SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            Path file = queue.poll();
                            if (file == null) {
                                done = true;
                            } else if (file == DUMMY) {
                                queue.add(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    public static void enumerate(Path directory) throws IOException, InterruptedException {
        try (Stream<Path> files = Files.list(directory)) {
            for (Path file : files.collect(Collectors.toList())) {
                if (Files.isDirectory(file)) {
                    enumerate(file);
                } else {
                    queue.add(file);
                }
            }
        }
    }

    public static void search(Path file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, String.valueOf(StandardCharsets.UTF_8))) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.printf("%s:%d:%s\n", file, lineNumber, line);
                }
            }
        }
    }
}