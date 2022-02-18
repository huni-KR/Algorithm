package BOJ_2636;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] visit;
    static int X, Y, land;
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
        st = new StringTokenizer(br.readLine(), " ");
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < X; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0, last = 0;
        while (!isEmpty()) {
            visit = new boolean[Y][X];
            last = count();
            BFS(0, 0);
            change();
            time++;
        }
        System.out.println(time);
        System.out.println(last);
    }

    private static void change() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (arr[i][j] < 0) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void BFS(int x, int y) {
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

                    if (nx < 0 || ny < 0 || nx >= X || ny >= Y) {
                        continue;
                    }

                    if (arr[ny][nx] < 0) {
                        continue;
                    }

                    if (!visit[ny][nx]) {
                        if (arr[ny][nx] == 1) {
                            arr[ny][nx] -= 10;
                            continue;
                        }
                        visit[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private static int count() {
        int sum = 0;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (arr[i][j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static boolean isEmpty() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (arr[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
