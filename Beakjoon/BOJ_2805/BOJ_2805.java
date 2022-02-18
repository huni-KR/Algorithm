package BOJ_2805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long s = 0, e = arr[N - 1], m = 0;
        while (s <= e) {
            m = (s + e) / 2;
            long sum = cutTree(m, M);
            if (sum >= M) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        System.out.println(e);
    }

    private static long cutTree(long pos, long tree) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > pos) {
                sum += arr[i] - pos;
            }
        }
        return sum;
    }
}