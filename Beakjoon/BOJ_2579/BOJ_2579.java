package BOJ_2579;

import java.io.*;
import java.util.*;

public class BOJ_2579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int now = 1;
        dp[1] = arr[1];
        visit[1] = true;
        for (int i = 2; i < n; i++) {
            if (visit[i - 2] && visit[i - 1]) {
                dp[i + 1] = dp[i - 1] + arr[i];
            } else if (!visit[i - 2] && visit[i - 1]) {

            }

        }

    }
}
