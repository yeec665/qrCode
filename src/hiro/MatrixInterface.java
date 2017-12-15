package hiro;

public interface MatrixInterface {

    boolean read(int x, int y);

    default boolean valid(int x, int y) {
        return true;
    }
}
