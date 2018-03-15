package java8.functional.programming;

/**
 * @author uhs
 */
public class TestSupplierConsumer<T> {
    private T data;

    private TestSupplierConsumer(T data) {
        this.data = data;
    }
    public static <U> TestSupplierConsumer<U> getValue(Supplier<U> supplier) {
        return new TestSupplierConsumer<>(supplier.get());
    }

    public T getData() {
        return this.data;
    }
    public void modify(Consumer<T> consumer){
        this.data =consumer.apply(this.data);
    }
}
