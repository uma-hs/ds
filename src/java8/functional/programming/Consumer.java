package java8.functional.programming;

/**
 * @author uhs
 */

@FunctionalInterface
public interface Consumer<T> {
    T apply(T a);
}
