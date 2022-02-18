package BOJ_2468;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] isSink, visit;
    static int N, land;
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
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        isSink = new boolean[N][N];
        land = 0;
        for (int h = 0; h < max; h++) {
            visit = new boolean[N][N];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] <= h) {
                        isSink[i][j] = true;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (!isSink[i][j] && !visit[i][j]) {
                        BFS(i, j);
                        sum++;
                    }
                }
            }
            land = Math.max(sum, land);
        }
        System.out.println(land);
    }

    private static void BFS(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point p = queue.poll();
                for (int dic = 0; dic < 4; dic++) {
                    int nx = p.x + dx[dic];
                    int ny = p.y + dy[dic];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    if (!visit[ny][nx] && !isSink[ny][nx]) {
                        queue.add(new Point(nx, ny));
                        visit[ny][nx] = true;
                    }
                }
            }
        }
    }
}
