package ds.algo;

import java.util.Stack;

/**
 * Created by umamaheshwar on 29/11/2017.
 */
public class LIS {

    public static void main(String[] args) {
        lis(new int[] {
                2, 4, 3, 1, 2 , 3, 4, 5, 7, 8, 9
        });
    }

    public static void lis(int[] a) {
        int size = a.length;
        int[] tillNow = new int[size];

        tillNow[0]=1;
        int max = -1;
        int maxIndex = 0;
        for(int i=1; i<size;i++) {
            int maxVal=0;
            for(int j=0;j<i;j++) {
                if(a[j]<a[i]) {
                    maxVal = Math.max(maxVal,tillNow[j]);
                }
            }
            tillNow[i] = maxVal+1;
            if(tillNow[i]>max) {
                maxIndex = i;
            }
            max= Math.max(max, tillNow[i]);
        }



        System.out.println("Max length is "+max+"  Index is : "+maxIndex);

        int res=max;

        Stack<Integer> stack = new Stack<>();
        for(int i=size-1;i>=0;i--) {
            if(tillNow[i]==res) {
                stack.push(a[i]);
                res=res-1;
            }
        }

       while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
       }
    }
}
