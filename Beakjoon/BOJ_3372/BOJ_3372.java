package BOJ_3372;

import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ_3372 {
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

        BigInteger[][] dp = new BigInteger[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == n - 1) {
                    if (arr[i][j] + j == n - 1) {
                        dp[i][j] = BigInteger.ONE;
                    } else {
                        dp[i][j] = BigInteger.ZERO;
                    }
                } else if (j == n - 1) {
                    if (arr[i][j] + i == n - 1) {
                        dp[i][j] = BigInteger.ONE;
                    } else {
                        dp[i][j] = BigInteger.ZERO;
                    }
                } else {
                    dp[i][j] = BigInteger.ZERO;
                }
            }
        }
        dp[n - 1][n - 1] = BigInteger.ZERO;

        for (int i = n - 2; i >= 0; i--) {
            if (i + arr[i][n - 1] < n) {
                dp[i][n - 1] = dp[i][n - 1].add(dp[i + arr[i][n - 1]][n - 1]);
            }
            if (i + arr[n - 1][i] < n) {
                dp[n - 1][i] = dp[n - 1][i].add(dp[n - 1][i + arr[n - 1][i]]);
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (i + arr[i][j] < n) {
                    dp[i][j] = dp[i][j].add(dp[i + arr[i][j]][j]);
                }
                if (j + arr[i][j] < n) {
                    dp[i][j] = dp[i][j].add(dp[i][j + arr[i][j]]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}