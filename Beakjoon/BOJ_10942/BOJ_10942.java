package BOJ_10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10942 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = fun(i, j);
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bw.write(Integer.toString(dp[s][e]));
            bw.write("\n");
        }
        bw.flush();
    }

    private static int fun(int s, int e) {
        for (int pos = 0; pos < (e - s + 1) / 2; pos++) {
            if (arr[s + pos] != arr[e - pos]) {
                return 0;
            }
        }
        return 1;
    }
}
