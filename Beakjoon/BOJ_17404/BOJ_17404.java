package BOJ_17404;

import java.io.*;
import java.util.*;

public class BOJ_17404 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][3];

        int min = Integer.MAX_VALUE;

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    dp[0][i] = arr[0][i];
                } else {
                    dp[0][i] = 10000;
                }
            }

            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    continue;
                }
                min = Math.min(min, dp[n - 1][i]);
            }
        }
        
        System.out.println(min);
    }
}