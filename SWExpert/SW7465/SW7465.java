package SW7465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SW7465 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        for (int t = 1; t <= C; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            p = new int[N + 1];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            bw.write("#" + Integer.toString(t) + " " + Integer.toString(group()) + "\n");
        }
        bw.flush();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            p[b] = a;
        }
    }

    private static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        return p[a] = find(p[a]);
    }

    private static int group() {
        int cnt = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }
}