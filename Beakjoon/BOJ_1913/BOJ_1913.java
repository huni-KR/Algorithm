package BOJ_1913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1913 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static int pos;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        pos = n * n;
        setArray(n, target);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void setArray(int n, int target) {
        int[][] arr = new int[n][n];
        fun(arr, n, 0, 0, 0);
        printArray(arr);
        find(arr, target);
    }

    private static void find(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    sb.append(Integer.toString(i + 1));
                    sb.append(" ");
                    sb.append(Integer.toString(j + 1));
                    return;
                }
            }
        }
    }

    private static void fun(int[][] arr, int n, int dic, int x, int y) {
        if (pos == 1) {
            arr[y][x] = pos;
            return;
        }

        int nx = x + dx[dic];
        int ny = y + dy[dic];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[ny][nx] != 0) {
            fun(arr, n, (dic + 1) % 4, x, y);
        } else {
            arr[y][x] = pos--;
            fun(arr, n, dic, nx, ny);
        }
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(Integer.toString(arr[i][j]));
                sb.append(" ");
            }
            sb.append("\n");
        }
    }
}