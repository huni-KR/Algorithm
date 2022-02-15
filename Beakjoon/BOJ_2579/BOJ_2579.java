package BOJ_2579;

import java.io.*;
import java.util.*;

public class BOJ_2579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(arr[n]);
        } else if (n == 2) {
            System.out.println(arr[1] + arr[2]);
        } else {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(arr[1], arr[2]) + arr[3];

            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
            }
            System.out.println(dp[n]);
        }
    }
}
