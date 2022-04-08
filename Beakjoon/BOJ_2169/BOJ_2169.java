package BOJ_2169;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2169 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[0][0] = arr[0][0];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                for (int j = 1; j < M; j++) {
                    dp[0][j] = Math.max(dp[0][j], dp[0][j - 1] + arr[0][j]);
                }
            } else {
                for (int j = 0; j < M; j++) {
                    int tmp = dp[i - 1][j] + arr[i][j];
                    dp[i][j] = Math.max(dp[i][j], tmp);

                    int tmp1 = tmp;
                    for (int k = j - 1; k >= 0; k--) {
                        tmp1 += arr[i][k];
                        dp[i][k] = Math.max(dp[i][k], tmp1);
                    }
                    for (int k = j + 1; k < M; k++) {
                        tmp += arr[i][k];
                        dp[i][k] = Math.max(dp[i][k], tmp);
                    }
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}