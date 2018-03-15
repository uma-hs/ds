package java8.functional.programming;

/**
 * @author uhs
 */
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
