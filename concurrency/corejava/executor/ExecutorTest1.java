package concurrency.corejava.executor;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter base directory: ");
            String start = in.nextLine();
            System.out.print("Enter keyword: ");
            String word = in.nextLine();

            Set<Path> files = FileUtil.descendants(Path.of(start));

            var tasks = new ArrayList<Callable<Long>>();
            for (Path file : files) {
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }

            ExecutorService executor = Executors.newCachedThreadPool();
            //ExecutorService executor = Executors.newSingleThreadExecutor();

            Instant startTime = Instant.now();
            List<Future<Long>> results = executor.invokeAll(tasks);
            long total = 0;
            for (Future<Long> result : results) {
                total += result.get();
            }
            Instant endTime = Instant.now();
            System.out.println("Occurrences of " + word + ": " + total);
            System.out.println("Time elapsed: " + Duration.between(startTime, endTime).toMillis() + " ms");

            executor.shutdown();
        }
    }

    public static long occurrences(String word, Path file) {
        try (var in = new Scanner(file)) {
            int count = 0;
            while (in.hasNext()) {
                if (in.next().equals(word)) {
                    count++;
                }
            }
            return count;
        } catch (IOException e) {
            return 0;
        }
    }
}