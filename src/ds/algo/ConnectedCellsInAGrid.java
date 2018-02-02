package ds.algo;

/**
 * Created by uhs on 23/10/2018.
 *
 * Solution for https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
 */
public class ConnectedCellsInAGrid {
    int [][] grid;
    int n,m;
    boolean [][] visited;

    public ConnectedCellsInAGrid(int [][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
    }

    public void findLargestConnectedRegion() {

    }

    int dfs(int i, int j) {
        if(i<0||j<0||i>m-1||j>n-1) {
            return 0;
        }


        return 0;
    }


    public static void main(String[] args) {
        int grid[][] = new int [][]{
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
        new ConnectedCellsInAGrid(grid).findLargestConnectedRegion();
    }
}
