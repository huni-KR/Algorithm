package BOJ_10971;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10971 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, min;
    static int[][] arr;
    static boolean[] visit;

    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    arr[i][j] = INF;
                }
            }
        }

        visit = new boolean[N];

        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            fun(i, i, 0);
            visit[i] = false;
        }

        System.out.println(min);
    }

    private static void fun(int start, int pos, int weigth) {
        if (checkVisit()) {
            min = Math.min(min, weigth + arr[pos][start]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            fun(start, i, weigth + arr[pos][i]);
            visit[i] = false;
        }
    }

    private static boolean checkVisit() {
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }
}
