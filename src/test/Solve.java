package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by umamaheshwar on 05/12/2017.
 */
public class Solve {

    public static void main(String [] args) {

        Map<Integer,String> map = new HashMap<>();

        //Consider aaa as 4th bit, bbb as 3rd and respectively. Now there are 15 possibilities(pow(2,4) -1). So iterate and populate over these values;

        map.put(0,"jjj");
        map.put(1,"eee");
        map.put(2,"bbb");
        map.put(3,"aaa");


        for(int i=15;i>0;i--) {
            List<String> list = new ArrayList<>();
            for(int j=3;j>=0;j--) {
                if(((1<<j)&i)!=0) {
                   list.add(map.get(j));
                }
            }
            if(!list.isEmpty())
                System.out.println(String.join(" ",list));
        }
    }
}
