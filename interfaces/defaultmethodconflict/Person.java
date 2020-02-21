package interfaces.defaultmethodconflict;

public interface Person {
    default String getName() {
        return "";
    }
}
