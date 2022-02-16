package BOJ_2839;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2839 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        Arrays.fill(arr, 1000000);

        if (N == 1) {
            System.out.println(-1);
        } else if (N == 2) {
            System.out.println(-1);
        } else if (N == 3) {
            System.out.println(1);
        } else if (N == 4) {
            System.out.println(-1);
        } else {
            arr[0] = 0;
            arr[3] = 1;
            arr[5] = 1;
            for (int i = 6; i <= N; i++) {
                if (arr[i - 3] != -1) {
                    arr[i] = Math.min(arr[i - 3] + 1, arr[i - 5] + 1);
                } else if (arr[i - 5] != -1) {
                    arr[i] = Math.min(arr[i - 3] + 1, arr[i - 5] + 1);
                }
            }

            System.out.println(arr[N] >= 100000 ? -1 : arr[N]);
        }
    }
}