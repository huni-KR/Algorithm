package BOJ_2491;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2491 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][N];// 0 min 1 max
        int min = arr[0];
        int max = arr[0];
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 1; i < N; i++) {
            if (max <= arr[i]) {
                max = arr[i];
                dp[1][i] = dp[1][i - 1] + 1;
            } else {
                max = arr[i];
                dp[1][i] = 1;
            }
        }
        for (int i = 1; i < N; i++) {
            if (min >= arr[i]) {
                min = arr[i];
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                min = arr[i];
                dp[0][i] = 1;
            }
        }

        int maxLen = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        System.out.println(maxLen);
    }
}
