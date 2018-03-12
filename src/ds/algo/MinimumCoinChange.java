package ds.algo;

/**
 * Created by uhs on 16/12/17.
 */
public class MinimumCoinChange {

    public static void main(String[] args) {
        int arr[] = new int[]{9,6,5,1,11};
        System.out.println(minRecusre(arr, arr.length-1, 17));
        System.out.println(minRecusre(arr, arr.length-1, 17));

    }

    public static int minRecusre(int[] coins, int i, int currentSum) {
        if(currentSum==0){
            return 0;
        }
        if(currentSum<0 || i<0) {
            return Integer.MAX_VALUE - 1;
        }

        return Math.min(1 + minRecusre(coins, i, currentSum - coins[i]), minRecusre(coins, i - 1, currentSum));

    }

    public static int minRecurse2(int coins[], int n, int curSum) {
        if(curSum==0)
            return 0;

        int res = Integer.MAX_VALUE-1;

        for(int i=0; i<=n; i++) {

            if(coins[i]<curSum) {
                int subres = Math.min(res, minRecurse2(coins, n, curSum-coins[i]));
                if(subres!=Integer.MAX_VALUE-1 && subres+1< res) {
                    res = subres + 1;
                }

            }


        }

        return res;



    }
}
