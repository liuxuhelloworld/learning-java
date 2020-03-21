package concurrency.completablefuture;

public class CompletableFutureTest {
//    private static ExecutorService executor = Executors.newSingleThreadExecutor();
//
//    public static CompletableFuture<String> readPage(URL url) {
//        return CompletableFuture.supplyAsync(
//            () -> {
//                try {
//                    return new String(url.openStream().readAllBytes(), "UTF-8");
//                } catch (IOException e) {
//                    throw new UncheckedIOException(e);
//                }
//            },
//            executor
//        );
//    }
//
//    public static void main(String[] args) throws UncheckedIOException {
//        try {
//            CompletableFuture<String> page = readPage(new URL("http://localhost:3000"));
//            //page.thenAccept(x -> System.out.print(x));
//            page.whenComplete((s, t) -> {
//                if (t == null) {
//                    System.out.print(s);
//                } else {
//                    t.printStackTrace();
//                }
//            });
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
}
