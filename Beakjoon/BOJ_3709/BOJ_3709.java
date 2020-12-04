package BOJ_3709;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3709 {

    static int X, Y, n, dir;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {
            X = 0;
            Y = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[][] grid = new int[n + 2][n + 2];
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                grid[y][x] = 4;
            }

            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (y == 0) {
                dir = 2;
            } else if (y == n + 1) {
                dir = 0;
            } else if (x == 0) {
                dir = 1;
            } else if (x == n + 1) {
                dir = 3;
            }

            fun(grid, x, y);

            System.out.println(Y + " " + X);
        }
        br.close();
    }

    private static void fun(int[][] grid, int tmpX, int tmpY) {

        int nowX = tmpX + dx[dir];
        int nowY = tmpY + dy[dir];

        if (nowX < 1 || nowY < 1 || nowX > n || nowY > n) {
            X = nowX;
            Y = nowY;
            return;
        }

        if (grid[nowY][nowX] == 0) {
            fun(grid, nowX, nowY);
        } else {
            dir = (dir + 1) % 4;
            fun(grid, nowX, nowY);
        }
    }
}
