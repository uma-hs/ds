package ds.algo;

/**
 * Created by umamaheshwar on 12/12/2017.
 */
public class MinSquareSum {


    public static int minSquareSum(int n) {
        if(n==1)
            return 1;
        if(n<1)
            return 0;

        int min = Integer.MAX_VALUE;

        for(int i=1; i<=Math.sqrt(n); i++) {
            min= Math.min(min, 1+minSquareSum(n-i*i));
        }
        return min;
    }

    public static int minSquareSumDP(int n) {
        int dp [] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i= 2; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=Math.sqrt(i); j++) {
                min = Math.min(min, 1+ dp[i-j*j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        for(int i=1; i<25; i++) {
            System.out.print(i+" ");
            System.out.print(minSquareSum(i)+" ");
            System.out.print(minSquareSumDP(i)+"\n");
        }


    }
}
