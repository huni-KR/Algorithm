package BOJ_1660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1660 {
    static BufferedReader br;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[150];

        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + i;
        }
        for (int i = 2; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        int pos = 2;
        for (int i = 4; i < dp.length; i++) {
            for (int j = 1; j <= pos; j++) {
                dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
            }

            if (arr[pos + 1] == i) {
                dp[i] = 1;
                pos++;
            }
        }

        System.out.println(dp[N]);
    }
}
