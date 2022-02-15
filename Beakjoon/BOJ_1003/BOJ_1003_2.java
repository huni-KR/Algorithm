package BOJ_1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1003_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N + 1];

            if (N == 0) {
                System.out.println(1 + " " + 0);
            } else if (N == 1) {
                System.out.println(0 + " " + 1);
            } else {
                arr[0][0] = 1;
                arr[1][1] = 1;
                for (int i = 2; i < N + 1; i++) {
                    arr[0][i] = arr[0][i - 2] + arr[0][i - 1];
                    arr[1][i] = arr[1][i - 2] + arr[1][i - 1];
                }
                System.out.println(arr[0][N] + " " + arr[1][N]);
            }
        }
    }
}