package SW3234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW3234 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, count;
    static int[] arr, result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[N];
            result = new int[N];
            count = 0;
            fun(0);

            bw.write("#" + Integer.toString(t) + " " + Integer.toString(count) + "\n");
        }
        bw.flush();
    }

    private static void fun(int pos) {
        if (pos == N) {
            check(0, 0, 0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            result[pos] = i;
            visit[i] = true;
            fun(pos + 1);
            visit[i] = false;
        }
    }

    private static void check(int index, int left, int right) {
        if (index == N) {
            count++;
            return;
        }

        check(index + 1, left + arr[result[index]], right);

        if (right + arr[result[index]] <= left) {
            check(index + 1, left, right + arr[result[index]]);
        }
    }
}