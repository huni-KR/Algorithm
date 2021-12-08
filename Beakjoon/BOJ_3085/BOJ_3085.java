package BOJ_3085;

import java.io.*;

public class BOJ_3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                char tmp = arr[i][j];
                arr[i][j] = arr[i + 1][j];
                arr[i + 1][j] = tmp;

                max = Math.max(max, check(arr));

                tmp = arr[i][j];
                arr[i][j] = arr[i + 1][j];
                arr[i + 1][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                char tmp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = tmp;

                max = Math.max(max, check(arr));

                tmp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = tmp;
            }
        }

        System.out.println(max);
    }

    private static int check(char[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, checkCol(arr, j, i, arr[i][j]));
                max = Math.max(max, checkRow(arr, j, i, arr[i][j]));
            }
        }
        return max;
    }

    private static int checkCol(char[][] arr, int x, int y, char c) {
        int count = -1;
        for (int i = y; i < arr.length; i++) {
            if (arr[i][x] == c) {
                count++;
            } else {
                break;
            }
        }
        for (int i = y; i >= 0; i--) {
            if (arr[i][x] == c) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static int checkRow(char[][] arr, int x, int y, char c) {
        int count = -1;
        for (int i = x; i < arr[0].length; i++) {
            if (arr[y][i] == c) {
                count++;
            } else {
                break;
            }
        }
        for (int i = x; i >= 0; i--) {
            if (arr[y][i] == c) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}