package BOJ_7569;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int M, N, H;
    static int[][][] arr;
    static int[] dx = { 0, 1, 0, -1, 0, 0 };// 북서남동상하
    static int[] dy = { -1, 0, 1, 0, 0, 0 };// 북서남동상하
    static int[] dz = { 0, 0, 0, 0, -1, 1 };// 북서남동상하
    static Queue<Point> queue;

    static class Point {
        int x;
        int y;
        int z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        queue.add(new Point(k, j, i));
                    }
                }
            }
        }

        BFS();
        int max = findMax();
        System.out.println(max == -1 ? -1 : max - 1);
    }

    private static int findMax() {
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                    max = Math.max(max, arr[i][j][k]);
                }
            }
        }
        return max;
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point p = queue.poll();
                for (int dic = 0; dic < 6; dic++) {
                    int nx = p.x + dx[dic];
                    int ny = p.y + dy[dic];
                    int nz = p.z + dz[dic];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= M || ny >= N || nz >= H) {
                        continue;
                    }

                    if (arr[nz][ny][nx] == -1) {
                        continue;
                    }

                    if (arr[nz][ny][nx] == 0) {
                        queue.add(new Point(nx, ny, nz));
                        arr[nz][ny][nx] = arr[p.z][p.y][p.x] + 1;
                    } else if (arr[nz][ny][nx] > arr[p.z][p.y][p.x] + 1) {
                        queue.add(new Point(nx, ny, nz));
                        arr[nz][ny][nx] = arr[p.z][p.y][p.x] + 1;
                    }
                }
            }
        }
    }
}
