package concurrency.corejava.executor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

public class ExecutorTest2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter base directory: ");
            String start = in.nextLine();
            System.out.print("Enter keyword: ");
            String word = in.nextLine();

            Set<Path> files = FileUtil.descendants(Paths.get(start));

            ExecutorService executor = Executors.newCachedThreadPool();

            List<Callable<Path>> searchTasks = new ArrayList<>();
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
            try (Scanner in = new Scanner(file)) {
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