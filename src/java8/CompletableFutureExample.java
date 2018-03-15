package java8;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

/**
 * @author uhs
 */
public class CompletableFutureExample {

    private static Random rand = new SecureRandom();


    public static void main(String [] args) {

        List<Integer> list = new ArrayList<>();
        for (int i=1; i<100; i++) {
            list.add(i);
        }

        list.forEach( i->{
            CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
               return get(i);
            });
            future.whenComplete((result, error)->{
                System.out.println(result);
            });



        });

    }

    public static String get(int in) {

        for(int i=rand.nextInt(1000000000); i>0; i--) {
            //do nothing
        }

        return "Int value is "+in;
    }
}
