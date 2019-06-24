package solutions.hackerearth.airtelcrackthecode_mar_16_2018;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
/*

https://www.hackerearth.com/challenge/competitive/airtel-crack-the-code/algorithm/odd-even-subarrays-72ad69db/
 */

class P1 implements Runnable {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;


    static void solve() throws Exception {
        int n = nextInt();
        if(n==1) {
            out.print(0);
            return;
        }
        int input[] = new int[n];
        input[0] = (nextInt()&1)==0 ? 1: -1;
        for (int i=1; i<n; i++) {
            input[i] = (nextInt()&1)==0 ? 1: -1;
        }
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        sumMap.put(input[0], 1);
        for (int i=1; i<n; i++) {
            input[i] = input[i-1]+input[i];

            if(sumMap.containsKey(input[i])) {
                int cnt = sumMap.get(input[i]);
                sumMap.put(input[i], cnt+1);
            } else {
                sumMap.put(input[i], 1);
            }
        }

        //actual(input);
        BigInteger val = BigInteger.valueOf(0);

        for(int v : sumMap.values()) {
            if(v>1) {
                BigInteger v1 = BigInteger.valueOf(v);
                BigInteger v2 = BigInteger.valueOf(v-1);
                BigInteger res = v1.multiply(v2).divide(BigInteger.valueOf(2));
                val = val.add(res);
            }
        }


        out.print(val);


    }

    private static void actual(int[] input) {

        int n = input.length;

        long count =0;
        for(int j=1; j<n; j=j+2) {
            if(input[j] ==0)
                count++;
        }

        for (int i=1; i<n; i++) {
            for (int j=i+1; j<n; j=j+2) {
                if(input[j]-input[i-1] ==0) {
                    count++;
                }
            }
        }

        out.println("Actual "+count);

    }
    public static int max(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static String nextLine() throws IOException {
        tok = new StringTokenizer("");
        return in.readLine();
    }

    static boolean hasNext() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return false;
            }
            tok = new StringTokenizer(s);
        }
        return true;
    }

    public static void main(String args[]) {
        new Thread(null, new P1(), "FindMe", 1 << 28).start();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            // in = new BufferedReader(new FileReader("input.in"));
            // out = new PrintWriter(new FileWriter("output.out"));
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