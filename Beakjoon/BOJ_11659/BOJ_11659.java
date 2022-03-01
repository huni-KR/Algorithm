package BOJ_11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11659 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(Integer.toString(dp[e] - dp[s - 1]));
            bw.write("\n");
        }
        bw.flush();
    }
}
