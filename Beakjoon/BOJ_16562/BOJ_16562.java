package BOJ_16562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16562 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] arr, p, min;
    static boolean[] visit;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        p = new int[N + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        min = new int[N + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 1; i < min.length; i++) {
            if (min[i] == Integer.MAX_VALUE) {
                min[find(i)] = Math.min(min[find(i)], clac(Integer.MAX_VALUE, i));
            }
        }
        int sum = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] == i) {
                sum += min[i];
            }
        }

        System.out.println(sum > K ? "Oh no" : sum);
    }

    private static int clac(int min, int i) {
        if (min > arr[i]) {
            min = arr[i];
            return clac(min, p[i]);
        }
        return min;
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
