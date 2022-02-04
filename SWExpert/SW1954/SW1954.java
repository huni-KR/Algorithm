package SW1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1954 {

    static int pos;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            pos = 1;
            System.out.printf("#%d\n", (t + 1));
            printArray(setArray(n));
        }
    }

    private static int[][] setArray(int n) {
        int[][] arr = new int[n][n];
        fun(arr, n, 0, 0, 0);
        return arr;
    }

    private static void fun(int[][] arr, int n, int dic, int x, int y) {
        if (pos == n * n) {
            arr[y][x] = pos;
            return;
        }

        int nx = x + dx[dic];
        int ny = y + dy[dic];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[ny][nx] != 0) {
            fun(arr, n, (dic + 1) % 4, x, y);
        } else {
            arr[y][x] = pos++;
            fun(arr, n, dic, nx, ny);
        }
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}