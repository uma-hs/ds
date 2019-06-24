package solutions.hackerearth.airtelcrackthecode_mar_16_2018;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
https://www.hackerearth.com/challenge/competitive/airtel-crack-the-code/algorithm/robot-in-grid-b7d391f7/
 */

class P2 implements Runnable {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	private static final int[][] CORNERS_INCLUDED = {
			{-1,-1},{-1, 0},{-1, 1},
			{ 0,-1},        { 0, 1},
			{ 1,-1},{ 1, 0},{ 1, 1}
	};

    private static final int[][] CORNERS_EXCLUDED= {
                    {-1, 0},
            { 0,-1},        { 0, 1}
                   ,{ 1, 0},
    };
	static int n;
	static int m;

	static boolean visited[][];
	static boolean input[][];


	static class Point {

		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void solve() throws Exception {
		 n = nextInt();
		 m = nextInt();
		int q = nextInt();
		boolean input[][] = new boolean[n][m];
		visited = new boolean[n][m];
		int dp[][] = new int[n][m];


		for (int i=0; i<n; i++) {
			String line = next();
			for(int j=0; j<m; j++) {
				input[i][j] = line.charAt(j) == 'O' ? true : false;
				if(input[i][j] == false) {
					visited[i][j] = true;
					dp[i][j] = -1;
				}
			}
		}

		Point src = new Point(nextInt()-1, nextInt()-1);

		dp[src.x][src.y] = 0;

		visited[src.x][src.y] = true;

		Queue<Point> queue = new LinkedList<>();
		queue.add(src);

		while (!queue.isEmpty()) {
			Point point = queue.remove();

			if(isVisited(point)) {

				List<Point> adjs = getAdjacents(point);
				int dist = dp[point.x][point.y];
				for(Point p : adjs) {
					if(!isVisited(p)) {

						int x = p.x;
						int y = p.y;

						dp[x][y] = dist+1;
						visited[x][y] = true;

						queue.add(p);
					}
				}

			}
		}

		for(int i=0; i<q; i++) {
			int desi =nextInt()-1;
			int desj = nextInt() -1;
            if(visited[desi][desj]) {
                out.println(dp[desi][desj]);
            } else {
                out.println("-1");
            }
		}




	}

	public static List<Point> getAdjacents(Point p) {
		List<Point> adjacents = new ArrayList<>();
		for(int i=0; i<4; i++) {
			int[] a = CORNERS_EXCLUDED[i];
			int x = p.x + a[0];
			int y = p.y + a[1];

			if(isValid(x,y) && !visited[x][y]) {
				adjacents.add(new Point(x,y));
			}

		}

		return adjacents;
	}

	static public boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}

	static boolean isVisited(Point p) {
		return visited[p.x][p.y];
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
		new Thread(null, new P2(), "FindMe", 1 << 28).start();
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