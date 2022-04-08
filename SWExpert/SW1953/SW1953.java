package SW1953;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1953 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int T, N, M, R, C, L;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] dx = { {}, { 0, 1, 0, -1 }, { 0, 0 }, { 1, -1 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { 0, -1 } };
    static int[][] dy = { {}, { -1, 0, 1, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

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
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visit = new boolean[N][M];
            BFS();

            bw.write("#");
            bw.write(Integer.toString(tc));
            bw.write(" ");
            bw.write(Integer.toString(countVisit()));
            bw.write("\n");
        }
        bw.flush();
    }

    private static int countVisit() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(C, R));
        visit[R][C] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            if (count == L) {
                return;
            }
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Point p = queue.poll();
                int index = arr[p.y][p.x];
                for (int dic = 0; dic < dx[index].length; dic++) {
                    int nx = p.x + dx[index][dic];
                    int ny = p.y + dy[index][dic];

                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                        continue;
                    }

                    if (visit[ny][nx]) {
                        continue;
                    }

                    if (isLink(p.x, p.y, nx, ny)) {
                        visit[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            count++;
        }
    }

    private static boolean isLink(int x1, int y1, int x2, int y2) {
        return check(x1, y1, x2, y2) && check(x2, y2, x1, y1);
    }

    private static boolean check(int x1, int y1, int x2, int y2) {
        int index = arr[y1][x1];
        for (int dic = 0; dic < dx[index].length; dic++) {
            int nx = x1 + dx[index][dic];
            int ny = y1 + dy[index][dic];
            if (nx == x2 && ny == y2) {
                return true;
            }
        }
        return false;
    }
}