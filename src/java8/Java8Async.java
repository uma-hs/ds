package java8;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author uhs
 */
public class Java8Async {
    private static Random rand = new SecureRandom();


    public static void main(String [] args) {
        List<String> list = Arrays.asList("a","b","c","d","e","f","g","h");

        CompletableFuture<String> [] futures = new CompletableFuture[list.size()];

        for(int i= list.size()-1; i>=0; i--) {
            String in = list.get(i);
            CompletableFuture<String> future = CompletableFuture.supplyAsync(()->
                    get(in)
            ).whenComplete((result,error)->{
                System.out.println(result);
            });

            futures[i]=future;
        }

        CompletableFuture.allOf(futures).join();

    }

    public static String get(String in) {

        for(int i=rand.nextInt(1000000000); i>0; i--) {
            //do nothing
        }

        return "Hello "+in;
    }
}
