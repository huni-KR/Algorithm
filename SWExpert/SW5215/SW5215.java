package SW5215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW5215 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int n, l, max;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            arr = new int[n][2];
            visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            dfs(0, 0, 0);

            System.out.printf("#%d %d\n", (t + 1), max);
        }
    }

    private static void dfs(int cnt, int w, int c) {
        if (c > l) {
            return;
        }
        if (cnt == n) {
            max = Math.max(max, w);
            return;
        }

        dfs(cnt + 1, w + arr[cnt][0], c + arr[cnt][1]);
        dfs(cnt + 1, w, c);
    }

    private static int fun(int size, int cnt) {

        int max = 0;
        if (size == cnt) {
            return calc();
        }

        for (int i = cnt; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                max = Math.max(max, fun(size, cnt + 1));
                visit[i] = false;
            }
        }
        return max;
    }

    private static int calc() {
        int cal = 0;
        int sum = 0;
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                cal += arr[i][1];
                sum += arr[i][0];
            }
        }

        return cal <= l ? sum : -1;
    }
}