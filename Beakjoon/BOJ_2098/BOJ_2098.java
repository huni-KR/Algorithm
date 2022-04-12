package BOJ_2098;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2098 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[][] arr, dp;

    static final int INF = 100000000; // 100,000,000

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = (1 << N) - 1;

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }

        bw.write(Integer.toString(DFS(0, 1)));
        bw.flush();
    }

    private static int DFS(int pos, int mask) {
        if (mask == (1 << N) - 1) {
            return arr[pos][0] == 0 ? INF : arr[pos][0];
        }

        if (dp[pos][mask] != INF) {
            return dp[pos][mask];
        }

        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0 && arr[pos][i] != 0) {
                dp[pos][mask] = Math.min(dp[pos][mask], DFS(i, mask | (1 << i)) + arr[pos][i]);
            }
        }

        return dp[pos][mask];
    }
}
// 모든 경로 방문
// 최소값 검출
//