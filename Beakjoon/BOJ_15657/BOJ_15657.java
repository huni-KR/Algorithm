package BOJ_15657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M;
    static int[] arr;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        visit = new int[N];
        Arrays.fill(visit, -1);
        sb = new StringBuilder();
        fun(0, 0);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void fun(int pos, int depth) {
        if (depth == M) {
            print();
            return;
        }

        for (int i = pos; i < N; i++) {
            visit[depth] = arr[i];
            fun(i, depth + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < M; i++) {
            sb.append(Integer.toString(visit[i]));
            sb.append(" ");
        }
        sb.append("\n");
    }

}
