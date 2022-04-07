package BOJ_2239;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int[][] check;
    static boolean flag;
    static List<Point> list;

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

        N = 9;
        arr = new int[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 0) {
                    list.add(new Point(j, i));
                }
            }
        }

        fun(0);
        print();
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void fun(int depth) {
        if (depth == list.size()) {
            flag = true;
            return;
        }

        Point p = list.get(depth);
        int nx = p.x;
        int ny = p.y;

        boolean[] visit = new boolean[10];
        checkRow(visit, ny, nx);
        checkCol(visit, ny, nx);
        checkArea(visit, ny, nx);
        for (int k = 1; k <= 9; k++) {
            if (!visit[k]) {
                arr[ny][nx] = k;
                fun(depth + 1);

                if (flag) {
                    return;
                }
                arr[ny][nx] = 0;
            }
        }
    }

    private static void checkRow(boolean[] visit, int y, int x) {
        for (int i = 0; i < N; i++) {
            if (arr[y][i] != 0) {
                visit[arr[y][i]] = true;
            }
        }
    }

    private static void checkCol(boolean[] visit, int y, int x) {
        for (int i = 0; i < N; i++) {
            if (arr[i][x] != 0) {
                visit[arr[i][x]] = true;
            }
        }
    }

    private static void checkArea(boolean[] visit, int y, int x) {
        int nx = x / 3;
        int ny = y / 3;
        nx *= 3;
        ny *= 3;

        for (int i = ny; i < ny + 3; i++) {
            for (int j = nx; j < nx + 3; j++) {
                if (arr[i][j] != 0) {
                    visit[arr[i][j]] = true;
                }
            }
        }
    }
}