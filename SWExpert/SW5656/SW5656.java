package SW5656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5656 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N, W, H, min, len;
    static int[][] arr;
    static int[] visit;
    static Map<Integer, Integer> map;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Point {
        int x, y, size;

        Point(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            visit = new int[N];
            Arrays.fill(visit, -1);

            fun(0);

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(min));
            bw.write("\n");
        }
        bw.flush();
    }

    private static void fun(int depth) {
        if (depth == N) {
            int count = solve(arr);
            min = Math.min(min, count);
            return;
        }

        for (int i = 0; i < W; i++) {
            if (visit[depth] != -1) {
                continue;
            }

            visit[depth] = i;
            fun(depth + 1);
            visit[depth] = -1;
        }
    }

    private static int solve(int[][] map) {
        int[][] copy = copyMap(map);
        for (int i = 0; i < N; i++) {
            int x = visit[i];
            int y = getBottom(copy, x);

            if (y == -1) {
                continue;
            }
            bomb(copy, x, y);
            toDown(copy);
        }
        return count(copy);
    }

    private static int count(int[][] map) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void toDown(int[][] copy) {
        for (int a = 0; a < H; a++) {
            for (int i = H - 1; i > 0; i--) {
                for (int j = 0; j < W; j++) {
                    if (copy[i][j] == 0 && copy[i - 1][j] != 0) {
                        copy[i][j] = copy[i - 1][j];
                        copy[i - 1][j] = 0;
                    }
                }
            }
        }
    }

    private static void bomb(int[][] copy, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, copy[y][x] - 1));
        copy[y][x] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int dic = 0; dic < 4; dic++) {
                int nx = point.x;
                int ny = point.y;
                for (int i = 0; i < point.size; i++) {
                    nx += dx[dic];
                    ny += dy[dic];
                    if (nx < 0 || ny < 0 || nx >= W || ny >= H) {
                        continue;
                    }

                    if (copy[ny][nx] > 1) {
                        queue.add(new Point(nx, ny, copy[ny][nx] - 1));
                    }
                    copy[ny][nx] = 0;
                }
            }
        }
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copy = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    private static int getBottom(int[][] map, int pos) {
        for (int i = 0; i < H; i++) {
            if (map[i][pos] != 0) {
                return i;
            }
        }
        return -1;
    }
}
