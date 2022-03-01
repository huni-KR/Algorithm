package BOJ_1654;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int max = 0;
        arr = new int[K];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(fun(max));
    }

    private static long fun(int max) {
        long s = 1, e = max;
        while (s <= e) {
            long m = (s + e) / 2;
            int cnt = calc(m);
            if (cnt >= N) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return e;
    }

    private static int calc(long target) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / target;
        }
        return sum;
    }
}