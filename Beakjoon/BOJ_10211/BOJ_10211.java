package BOJ_10211;

import java.io.*;
import java.util.*;

public class BOJ_10211 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(fun(arr));
        }
    }

    private static int fun(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i];
            if (arr[i] + dp[i - 1] > dp[i]) {
                dp[i] = dp[i - 1] + arr[i];
            }
        }

        return findMax(dp);
    }

    private static int findMax(int[] dp) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
