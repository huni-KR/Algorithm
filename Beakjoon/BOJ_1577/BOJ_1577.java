package BOJ_1577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1577 {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, K;
    static int[][] arr;
    static long[][] dp;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        arr = new int[K][4];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        dp = new long[N + 1][M + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (!isWork(i - 1, 0, i, 0)) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < dp[0].length; i++) {
            if (!isWork(0, i - 1, 0, i)) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (!isWork(i - 1, j, i, j)) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (!isWork(i, j - 1, i, j)) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[N][M]);
    }

    private static boolean isWork(int y1, int x1, int y2, int x2) {
        for (int i = 0; i < K; i++) {
            if (check(arr[i], y1, x1, y2, x2) || check(arr[i], y2, x2, y1, x1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(int[] row, int y1, int x1, int y2, int x2) {
        if (row[0] == y1 && row[1] == x1 && row[2] == y2 && row[3] == x2) {
            return true;
        }
        return false;
    }
}
