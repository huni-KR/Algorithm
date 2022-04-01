package BOJ_1806;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1806 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                min = Math.min(min, e - s);
                sum -= arr[s++];
            } else {
                if (e >= N) {
                    break;
                }
                sum += arr[e++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

}
