package BOJ_9370;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9370 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, T, S, G, H;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            T = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(br.readLine());
            G = Integer.parseInt(br.readLine());
            H = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(br.readLine());
                int e = Integer.parseInt(br.readLine());
                int w = Integer.parseInt(br.readLine());
                
            }
        }

    }

}
