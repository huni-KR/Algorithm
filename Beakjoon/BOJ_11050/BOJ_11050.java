package BOJ_11050;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11050 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        System.out.println(binomial(N, K));
    }

    static int binomial(int n, int r) {
        if (r == 0 || n == r)
            return 1;
        if (dp[n][r] == 0)
            dp[n][r] = binomial(n - 1, r - 1) + binomial(n - 1, r);
        return dp[n][r];
    }
}