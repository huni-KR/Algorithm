package BOJ_2563;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2563 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static boolean[][] arr = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int i = y; i < y + 10; i++) {
                for (int j = x; j < x + 10; j++) {
                    arr[i][j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
