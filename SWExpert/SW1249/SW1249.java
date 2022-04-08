package SW1249;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW1249 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N, M;
    static int[][] arr, dp;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            BFS();

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(dp[N - 1][N - 1]));
            bw.write("\n");
        }
        bw.flush();
    }

    private static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        dp[0][0] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int dic = 0; dic < 4; dic++) {
                int nx = p.x + dx[dic];
                int ny = p.y + dy[dic];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (dp[ny][nx] > dp[p.y][p.x] + arr[ny][nx]) {
                    dp[ny][nx] = dp[p.y][p.x] + arr[ny][nx];
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}