package generics.corejava;

public interface DefeatCheckedExceptionTask {

    void run() throws Exception;

    static <T extends Throwable> void throwAs(Throwable t) throws T {
        throw (T) t;
    }

    static Runnable asRunnable(DefeatCheckedExceptionTask defeatCheckedExceptionTask) {
        return () -> {
            try {
                defeatCheckedExceptionTask.run();
            } catch (Exception e) {
                DefeatCheckedExceptionTask.<RuntimeException>throwAs(e);
            }
        };
    }
}
