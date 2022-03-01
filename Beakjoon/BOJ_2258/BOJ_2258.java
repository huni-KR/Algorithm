package BOJ_2258;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2258 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[][] arr;
    static Data[] data;

    static class Data {
        int w;
        int v;

        Data(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new Data[N];
        for (int i = 0; i < args.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            data[i] = new Data(w, v);
        }
    }
}