package BOJ_2961;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2961 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] arr;
    static boolean[] visit;
    static int min;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            fun(i, 0);
        }
        System.out.println(min);
    }

    private static void fun(int total, int count) {
        if (total == count) {
            min = Math.min(min, calc());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            fun(total, count + 1);
            visit[i] = false;
        }
    }

    private static int calc() {
        int S = 1;
        int B = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) {
                S *= arr[i][0];
                B += arr[i][1];
            }
        }
        return Math.abs(S - B);
    }
}