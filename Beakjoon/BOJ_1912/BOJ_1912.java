package BOJ_1912;

import java.io.*;
import java.util.*;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n];
        dp[0] = arr[0];
        long max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
