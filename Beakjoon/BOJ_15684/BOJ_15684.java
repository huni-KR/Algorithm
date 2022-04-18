package BOJ_15684;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15684 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, H, min;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new boolean[H + 1][N + 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
        }

        min = Integer.MAX_VALUE;
        fun(1, 1, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void fun(int h, int n, int depth) {
        if (min < depth || depth > 3) {
            return;
        }

        if (check()) {
            min = Math.min(min, depth);
            return;
        }

        for (int i = h; i <= H; i++) {
            for (int j = n; j < N; j++) {
                if (arr[i][j]) {
                    continue;
                }

                if (j == N - 1) {
                    n = 1;
                }

                if (!arr[i][j - 1] && !arr[i][j + 1]) {
                    arr[i][j] = true;
                    fun(i, j, depth + 1);
                    arr[i][j] = false;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            if (!checkLine(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLine(int pos) {
        int now = pos;
        for (int i = 1; i <= H; i++) {
            if (now == 1) {
                if (arr[i][now]) {
                    now++;
                }
            } else if (now == N) {
                if (arr[i][now - 1]) {
                    now--;
                }
            } else {
                if (arr[i][now - 1]) {
                    now--;
                } else if (arr[i][now]) {
                    now++;
                }
            }
        }
        return pos == now;
    }
}
