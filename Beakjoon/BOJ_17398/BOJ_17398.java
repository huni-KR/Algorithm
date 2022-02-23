package BOJ_17398;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17398 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] p;
    static int[][] arr;
    static int[] visit;
    static int N, M, Q;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }

        visit = new int[M + 1];
        arr = new int[M + 1][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i + 1][0] = Integer.parseInt(st.nextToken());
            arr[i + 1][1] = Integer.parseInt(st.nextToken());
            visit[arr[i + 1][0]]++;
            visit[arr[i + 1][1]]++;

            union(arr[i + 1][0], arr[i + 1][1]);
        }

        int sum = 0;
        for (int i = 0; i < Q; i++) {
            int pos = Integer.parseInt(br.readLine());

            if (visit[arr[pos][0]] > 1 && visit[arr[pos][1]] > 1) {
                visit[arr[pos][0]]--;
                visit[arr[pos][1]]--;
                continue;
            }

            disUnion(arr[pos][0], arr[pos][1]);
            int a = find(arr[pos][0]);
            int b = find(arr[pos][1]);
            if (a != b) {
                System.out.println();
            }

        }
    }

    private static void disUnion(int a, int b) {
        if (find(a) != find(b)) {
            p[a] = a;
            p[b] = b;
        }
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