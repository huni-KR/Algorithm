package BOJ_1937;

import java.io.*;
import java.util.*;

public class BOJ_1937 {

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] grid = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(DFS(grid, dp, j, i), max);
            }
        }
        System.out.println(max);
    }

    private static int DFS(int[][] grid, int[][] dp, int tmpX, int tmpY) {

        if (dp[tmpY][tmpX] != 0)
            return dp[tmpY][tmpX];

        dp[tmpY][tmpX] = 1;

        for (int dic = 0; dic < 4; dic++) {
            int nowX = tmpX + dx[dic];
            int nowY = tmpY + dy[dic];
            if (nowX < 0 || nowY < 0 || nowX >= grid.length || nowY >= grid.length) {
                continue;
            }

            if (grid[nowY][nowX] > grid[tmpY][tmpX]) {
                dp[tmpY][tmpX] = Math.max(dp[tmpY][tmpX], DFS(grid, dp, nowX, nowY) + 1);
            }
        }
        return dp[tmpY][tmpX];
    }
}