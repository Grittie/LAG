import edu.princeton.cs.algs4.StdDraw;

import java.util.Random;
import java.awt.Color;

public class PercolationSimulation {
    public static boolean[][] opgave1000() {
        final int n = 1000;
        double p = 0.593;
        Random random = new Random();
        random.setSeed(218); // so not really random anymore
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = (random.nextDouble() < p); // bernoulli true if random less than p
        return a;
    }

    public static boolean[][] test() {
        return new boolean[][]{
                {false, true, false, true, false, true, true, false, true, false},
                {true, true, false, true, false, false, false, false, true, false},
                {false, true, false, false, false, false, true, false, true, true},
                {false, true, true, false, false, false, false, true, true, false},
                {true, true, true, true, false, true, false, true, false, false},
                {false, false, false, true, false, true, true, true, false, false},
                {false, true, false, true, false, false, true, true, true, true},
                {false, false, false, true, false, true, false, true, true, false},
                {false, false, false, true, false, false, true, true, false, true},
                {true, false, false, true, true, true, false, true, false, false}};
    }

    public static void flow(boolean[][] isOpen, int[][] isFull, int mark, int row, int col) {
        int n = isOpen.length;
        // base cases
        if (row < 0 || row >= n) return;    // invalid row
        if (col < 0 || col >= n) return;    // invalid column
        if (!isOpen[row][col]) {
            isFull[row][col] = -1; // brick
            return;      // not an open site
        }
        if (isFull[row][col] != 0) return;     // already marked as full
        // mark [i,j] as full
        isFull[row][col] = mark;
        flow(isOpen, isFull, mark, row, col + 1);   // right
        flow(isOpen, isFull, mark, row, col - 1);   // left
        flow(isOpen, isFull, mark, row - 1, col);   // up
        flow(isOpen, isFull, mark, row + 1, col);   // down
    }

    public static void show(int[][] a, int mark, Color markerColor) {
        final int N = a.length;
        StdDraw.setScale(-1, N);
        StdDraw.enableDoubleBuffering();  // speed up drawing off-screen
        for (int row = 0; row < N; row++) // row=y, col=x
            for (int col = 0; col < N; col++) {
                int m = a[row][col];
                if (m == mark) {  // the color we want to draw
                    StdDraw.setPenColor(markerColor);
                    StdDraw.filledSquare(col, N - row - 1, 0.5);
                }
            }
        StdDraw.show(); // show double buffered image
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(600, 600); //window frame size in pixels
        boolean[][] grid = opgave1000();
        final int N = grid.length;
        int[][] map = new int[N][N];
        int kleur = 1;
        final int row = 0;
        for (int col = 0; col < N; col++) {
            if (grid[row][col] && map[row][col] == 0) { // free top cell not visited
                flow(grid, map, kleur, row, col);
                kleur++;
            }
        }
        // find top and bottom row with identical color markers
        String tops = "", bots = ""; // answer outputs
        int mark = 0;
        for (int col = 0; col < N; col++) {
            if (map[N - 1][col] > mark) { //new bottom leak found
                mark = map[N - 1][col];
                bots += col + " ";
                tops += findIndex(map[0], mark) + " "; // add top leak index
                System.out.println("found color " + mark + " on lowest row, column=" + col);
            }
        }
        System.out.println("Solution: " + tops + bots); // "Solution: 34 309 159 577" for opgave1000

        // show colors on big map:
        show(map, 5, Color.YELLOW); // 5 and 38 are solutions to the opgave1000 map
        show(map, 38, Color.BLUE);
    }

    static int findIndex(int[] row, int value) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == value) return i;
        }
        return -1; // not found
    }

}

