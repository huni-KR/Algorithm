package BOJ_11909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11909 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = 0;
                } else if (i == 0) {
                    if (arr[i][j] < arr[i][j - 1]) {
                        result[i][j] = result[i][j - 1];
                    } else {
                        result[i][j] = result[i][j - 1] + (arr[i][j] - arr[i][j - 1] + 1);
                    }
                } else if (j == 0) {
                    if (arr[i][j] < arr[i - 1][j]) {
                        result[i][j] = result[i - 1][j];
                    } else {
                        result[i][j] = result[i - 1][j] + (arr[i][j] - arr[i - 1][j] + 1);
                    }
                } else {
                    int a = 0, b = 0;
                    if (arr[i][j] < arr[i][j - 1]) {
                        result[i][j] = result[i][j - 1];
                    } else {
                        a = (arr[i][j] - arr[i][j - 1] + 1);
                    }

                    if (arr[i][j] < arr[i - 1][j]) {
                        result[i][j] = result[i - 1][j];
                    } else {
                        b = (arr[i][j] - arr[i - 1][j] + 1);
                    }
                    result[i][j] = Math.min(result[i][j - 1] + a, result[i - 1][j] + b);
                }
            }
        }
        System.out.print(result[n - 1][n - 1]);
    }
}