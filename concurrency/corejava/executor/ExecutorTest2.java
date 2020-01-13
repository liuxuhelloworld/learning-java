package concurrency.corejava.executor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutorTest2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        try (var in = new Scanner(System.in)) {
            System.out.print("Enter base directory: ");
            String start = in.nextLine();
            System.out.print("Enter keyword: ");
            String word = in.nextLine();

            Set<Path> files = FileUtil.descendants(Path.of(start));

            ExecutorService executor = Executors.newCachedThreadPool();

            var searchTasks = new ArrayList<Callable<Path>>();
            for (Path file : files) {
                searchTasks.add(searchForTask(word, file));
            }

            Path found = executor.invokeAny(searchTasks);

            System.out.println(word + " occurs in: " + found);
            if (executor instanceof ThreadPoolExecutor) {
                System.out.println("Largest pool size: " + ((ThreadPoolExecutor) executor).getLargestPoolSize());
            }

            executor.shutdown();
        }
    }

    public static Callable<Path> searchForTask(String word, Path file) {
        return () -> {
            try (var in = new Scanner(file)) {
                while (in.hasNext()) {
                    if (in.next().equals(word)) {
                        return file;
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Search in " + file + " cancelled");
                        return null;
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }
}