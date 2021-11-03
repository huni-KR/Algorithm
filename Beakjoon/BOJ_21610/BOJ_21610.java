package BOJ_21610;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_21610 {

    static int n, m;
    static int[][] arr;
    static int[][] move;
    static boolean[][][] isCloud;
    static Queue<Point> cloud;
    // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        isCloud = new boolean[n][n][2];
        move = new int[m][2];

        cloud = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                move[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloudInit();
        for (int i = 0; i < move.length; i++) {
            fun(move[i][0], move[i][1], i);
        }

        System.out.println(sum(arr));
    }

    private static void fun(int dir, int dis, int pos) {

        cloudMove(dir, dis, pos);
        rain(pos);
        waterCopyBug(pos);
        cloudSetting(pos);
        cloudReset(pos);
    }

    private static void cloudReset(int pos) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isCloud[i][j][pos % 2] = false;
            }
        }
    }

    private static void cloudSetting(int pos) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] >= 2) {

                    if (isCloud[i][j][pos % 2]) {
                        continue;
                    }

                    arr[i][j] -= 2;
                    cloud.add(new Point(j, i));
                }
            }
        }
    }

    private static void waterCopyBug(int pos) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isCloud[i][j][pos % 2]) {
                    arr[i][j] += checkAcross(i, j);
                }
            }
        }
    }

    private static int checkAcross(int y, int x) {
        int count = 0;
        for (int i = 1; i < dx.length; i += 2) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if (arr[ny][nx] > 0) {
                count++;
            }
        }
        return count;
    }

    private static void rain(int pos) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isCloud[i][j][pos % 2]) {
                    arr[i][j]++;
                }
            }
        }
    }

    private static void cloudMove(int dir, int dis, int pos) {

        while (!cloud.isEmpty()) {
            Point point = cloud.poll();
            point.x = (point.x + (dx[dir - 1] * dis)) % n;
            point.y = (point.y + (dy[dir - 1] * dis)) % n;

            if (point.x < 0) {
                point.x += n;
            }

            if (point.y < 0) {
                point.y += n;
            }

            isCloud[point.y][point.x][pos % 2] = true;
        }
    }

    private static void cloudInit() {
        cloud.add(new Point(0, n - 1));
        cloud.add(new Point(1, n - 1));
        cloud.add(new Point(0, n - 2));
        cloud.add(new Point(1, n - 2));
    }

    private static int sum(int[][] arr2) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
