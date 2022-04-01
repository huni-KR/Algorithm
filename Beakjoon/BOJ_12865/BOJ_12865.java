package BOJ_12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static Data[] data;
    static int[] dp;

    static class Data {
        int w, v;

        Data(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new Data[N];
        for (int i = 0; i < data.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            data[i] = new Data(w, v);
        }

        dp = new int[K + 1];
        for (int i = 0; i < data.length; i++) {
            for (int j = K; j >= 1; j--) {
                if (j - data[i].w >= 0) {
                    dp[j] = Math.max(dp[j - data[i].w] + data[i].v, dp[j]);
                }
            }
        }

        System.out.println(dp[K]);
    }
}
