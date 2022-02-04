package BOJ_3085;

import java.io.*;
import java.util.*;

public class BOJ_3085_2 {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                char tmp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = tmp;

                max = Math.max(max, fun());

                tmp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = tmp;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                char tmp = arr[i][j];
                arr[i][j] = arr[i + 1][j];
                arr[i + 1][j] = tmp;

                max = Math.max(max, fun());

                tmp = arr[i][j];
                arr[i][j] = arr[i + 1][j];
                arr[i + 1][j] = tmp;
            }
        }
        System.out.println(max);
    }

    private static int fun() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                count = Math.max(count, check(i, j, arr[i][j]));
            }
        }
        return count;
    }

    private static int check(int y, int x, char c) {
        int[] count = new int[2];
        for (int i = x; i < arr.length; i++) {
            if (arr[y][i] == c) {
                count[0]++;
            } else {
                break;
            }
        }

        for (int i = y; i < arr.length; i++) {
            if (arr[i][x] == c) {
                count[1]++;
            } else {
                break;
            }
        }
        return Math.max(count[0], count[1]);
    }
}