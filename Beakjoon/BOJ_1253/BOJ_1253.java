package BOJ_1253;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1253 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static long[] arr;
    static Map<Integer, Set<Integer>> map;
    static Set<Set<Data>> set;

    static class Data {
        int s, e;

        Data(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        set = new HashSet<>();
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long sum = arr[i] + arr[j];
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            count++;
        }

        System.out.println(count);
    }

}
