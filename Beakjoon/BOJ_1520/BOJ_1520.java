package BOJ_1520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class BOJ_1520 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[][] arr, dp;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
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
            Arrays.fill(dp[i], -1);
        }

        System.out.println(DFS(0, 0));
    }

    private static int DFS(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        dp[y][x] = 0;
        for (int dic = 0; dic < 4; dic++) {
            int nx = x + dx[dic];
            int ny = y + dy[dic];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                continue;
            }

            if (arr[y][x] > arr[ny][nx]) {
                dp[y][x] += DFS(nx, ny);
            }
        }
        return dp[y][x];
    }
}