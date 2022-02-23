package SW3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW3289 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] p;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        for (int c = 1; c <= C; c++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            p = new int[N + 1];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }

            bw.write("#" + Integer.toString(c) + " ");
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int oper = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (oper == 1) {
                    bw.write(isUnion(a, b) ? "1" : "0");
                } else {
                    union(a, b);
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static boolean isUnion(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
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
}
