package SW1247;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class SW1247 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, value;
    static Point[] path;
    static Point home, company;
    static int[][] arr;
    static int[] result;
    static boolean[] visit;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            path = new Point[N + 2];

            st = new StringTokenizer(br.readLine(), " ");
            path[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            path[N + 1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 1; i < N + 1; i++) {
                path[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            value = Integer.MAX_VALUE;
            visit = new boolean[N + 2];
            result = new int[N + 2];

            result[0] = 0;
            visit[0] = true;

            result[N + 1] = N + 1;
            visit[N + 1] = true;
            dfs(1);

            bw.write("#" + Integer.toString(t) + " " + Integer.toString(value) + "\n");
        }
        bw.flush();
    }

    private static void dfs(int pos) {
        if (pos == N + 1) {
            int sum = calc();
            value = Math.min(value, sum);
            return;
        }

        for (int i = 1; i < visit.length; i++) {
            if (visit[i]) {
                continue;
            }
            result[pos] = i;
            visit[i] = true;
            dfs(pos + 1);
            visit[i] = false;
        }
    }

    private static int calc() {
        int sum = 0;
        for (int i = 0; i < N + 1; i++) {
            sum += Math.abs(path[result[i]].x - path[result[i + 1]].x)
                    + Math.abs(path[result[i]].y - path[result[i + 1]].y);
        }
        return sum;
    }
}
