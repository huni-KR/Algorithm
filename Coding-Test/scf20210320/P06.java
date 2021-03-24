import java.io.*;
import java.util.*;

public class P06 {
    // public static void main(String[] args) throws IOException {

    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    // int x = Integer.parseInt(st.nextToken());
    // int y = Integer.parseInt(st.nextToken());

    // int[][] arr = new int[y][x];
    // for (int i = 0; i < y; i++) {
    // st = new StringTokenizer(br.readLine());
    // for (int j = 0; j < x; j++) {
    // arr[i][j] = Integer.parseInt(st.nextToken());
    // }
    // }

    // int[][] dp = new int[y + 1][x + 1];

    // for (int i = 1; i <= y; i++) {
    // for (int j = 1; j <= x; j++) {
    // dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i - 1][j -
    // 1];
    // }
    // }
    // if (x == 1 && y == 1) {
    // System.out.println(dp[1][1]);
    // } else if (x == 1 && y != 1) {
    // System.out.println(dp[y][1]);
    // } else if (x != 1 && y == 1) {
    // System.out.println(dp[1][x]);
    // } else {
    // // System.out.println(dp[y - 1][x - 1]);
    // System.out.println(dp[y][x] - dp[y][1] - dp[1][x] + dp[0][0]);
    // }
    // }
    // }

    // public class MatrixPath {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] m = new int[y][x];
        long[][] cache = new long[y][x];
        for (int r = 0; r < y; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < x; c++) {
                m[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        cache[0][0] = m[0][0];
        System.out.println(cost(m, y - 1, x - 1, cache));

    }

    private static long cost(int[][] m, int i, int j, long[][] cache) {
        if (i == 0 && j == 0) {
            return cache[0][0];
        }

        if (i == 0) {
            cache[i][j] = (cache[0][j - 1] != 0) ? (cache[0][j - 1] + m[0][j]) : (cost(m, 0, j - 1, cache) + m[0][j]);
            return cache[i][j];
        }

        if (j == 0) {
            cache[i][j] = (cache[i - 1][0] != 0) ? (cache[i - 1][0] + m[i][0]) : (cost(m, i - 1, 0, cache) + m[i][0]);
            return cache[i][j];
        }

        long A = (cache[i - 1][j] != 0) ? (cache[i - 1][j]) : (cost(m, i - 1, j, cache));
        long B = (cache[i][j - 1] != 0) ? (cache[i][j - 1]) : (cost(m, i, j - 1, cache));
        cache[i][j] = Math.max(A, B) + m[i][j];
        return cache[i][j];
    }
}