package ds.algo;

import java.io.*;
import java.util.*;

/**
 * Created by uhs on 01/01/2018.
 *
 *  Maximum number that can be solved from n adjacent swaps of digits in the given number.
 *
 *  eg input :
 *    13645
 *    3
 *
 *  Output :
 *        63145
 *
 */
public class MaximumNumberOutOfNSwaps implements Runnable {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    static void solve() throws Exception {
        String s = next();
        int maxSwaps = nextInt();

        LinkedList<Integer> digit = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
        {
            digit.add(s.charAt(i) - '0');
        }
        int j=0;

        List<Integer> swapped= new ArrayList<>();
        while(maxSwaps>0) {
            int maxIndex = 0;
            int value = digit.get(j);

            for (int i = 0; i <= maxSwaps && i < digit.size(); i++) {
                if (digit.get(i) > digit.get(maxIndex)) {
                    maxIndex = i;
                    value =  digit.get(maxIndex);
                }
            }


            digit.remove(maxIndex);
            swapped.add(value);
            maxSwaps = maxSwaps - maxIndex;

        }

        StringBuilder sb = new StringBuilder();
        for(int d : swapped) {
            sb.append(d);
        }
        for(int d : digit) {
            sb.append(d);
        }

        out.print(sb.toString());
    }


    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }



    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static int lis(int[] a) {
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



        return max;


    }

    public static void main(String args[]) {
        new Thread(null, new MaximumNumberOutOfNSwaps(), "UMA", 1 << 28).start();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
