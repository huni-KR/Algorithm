package JO1681;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1681 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, min;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N];
        visit[0] = true;

        min = Integer.MAX_VALUE;
        fun(0, 1, 0);
        System.out.println(min);

    }

    static void fun(int cur, int depth, int sum) {
        if (depth == N) {
            if (arr[cur][0] == 0) {
                return;
            }

            sum += arr[cur][0];
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < N; i++) {
            if (visit[i] == false && arr[cur][i] != 0 && sum + arr[cur][i] < min) {
                visit[i] = true;
                fun(i, depth + 1, sum + arr[cur][i]);
                visit[i] = false;
            }
        }
    }
}
