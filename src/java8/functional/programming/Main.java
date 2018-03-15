package java8.functional.programming;

/**
 * @author uhs
 */
public class Main {

    public static void main(String [] args) {
        TestSupplierConsumer<String> getter = TestSupplierConsumer.getValue(()->{
            return "initial value";
        });
        getter.modify(d ->{
           return "Changed "+ d;
        });

        System.out.println(getter.getData());

    }

}
