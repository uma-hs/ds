package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by uhs on 11/2/18
 * https://www.youtube.com/watch?v=t1-YZ6bF-g0
 * https://www.youtube.com/watch?v=CEVDijyYiug
 */
public class Streams {

    public static void main(String[] args) {

        IntStream.range(1, 10).forEach(System.out:: print);


        IntStream.range(1, 10).skip(5).forEach(System.out:: print);

        System.out.println(IntStream.range(1, 15).sum());


        Stream.of("a", "b", "c").sorted().findFirst().ifPresent(System.out:: println);


        String[] names = {"abc", "bcd", "cde", "efg"};

        Arrays.stream(names).filter(x -> x.startsWith("a")).sorted().forEach(System.out:: println);

        int[] ints = {1, 2, 3, 4, 5, 6};

        Arrays.stream(ints).map(i-> i*i).average().ifPresent(System.out:: println);

        // Reduction

        double total = Stream.of(1.2, 2.4, 3.3).reduce(0.0, (Double a, Double b) -> a+b);
        System.out.println(total);

        List<String> input = new ArrayList<>();
        input.add("a");
        input.add("b");
        input.add("c");
        input.add("d");

        List<String> output = new ArrayList<>();
        input.parallelStream().forEach(in->{
            output.add(in);
        });

        output.forEach(System.out:: print);
    }
}
