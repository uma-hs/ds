package java8;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author uhs
 */
public class Java8Async {

    private static AtomicInteger counter = new AtomicInteger();


    public static void main(String [] args) {
      //  List<String> list = Arrays.asList("a","b","c","d","e","f","g","h","aa","aaaa","aaaaa","aaaaaa");

  /*      CompletableFuture<String> [] futures = new CompletableFuture[list.size()];

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
*/
    List<Integer> list = new ArrayList<>();
    for (int i=0; i<100000; i++) {
        list.add(i);
    }


    list.parallelStream().forEach(s->{
        new Thread(()->{
            System.out.println(counter.incrementAndGet()+"   "+get(s.toString()));
        }).start();
    });
    }

    public static String get(String in) {

         Random rand = new SecureRandom();


        for(int i=rand.nextInt(1000000000); i>0; i--) {
            //do nothing
        }

        return "Hello "+in;
    }
}
