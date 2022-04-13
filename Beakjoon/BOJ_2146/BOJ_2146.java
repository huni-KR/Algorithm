package BOJ_2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, min;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    // 색칠하며 다른 대륙이란걸 표시
                    visit = new boolean[N][N];
                    BFS(i, j, arr[i][j]);
                    mark(count++);
                }
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0 && isSide(i, j)) {
                    visit = new boolean[N][N];
                    min = Math.min(min, link(i, j, arr[i][j]));
                }
            }
        }

        System.out.println(min);
    }

    private static int link(int y, int x, int index) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[y][x] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Point p = queue.poll();

                for (int dic = 0; dic < 4; dic++) {
                    int nx = p.x + dx[dic];
                    int ny = p.y + dy[dic];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    if (arr[ny][nx] > 0 && arr[ny][nx] != index) {
                        return count - 1;
                    }

                    if (!visit[ny][nx]) {
                        visit[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private static boolean isSide(int y, int x) {
        for (int dic = 0; dic < 4; dic++) {
            int nx = x + dx[dic];
            int ny = y + dy[dic];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (arr[ny][nx] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void mark(int index) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) {
                    arr[i][j] = index;
                }
            }
        }
    }

    private static void BFS(int y, int x, int index) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int dic = 0; dic < 4; dic++) {
                int nx = p.x + dx[dic];
                int ny = p.y + dy[dic];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (arr[ny][nx] != index) {
                    continue;
                }

                if (!visit[ny][nx]) {
                    visit[ny][nx] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}