package SW2001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW2001 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i <= arr.length - m; i++) {
                for (int j = 0; j <= arr.length - m; j++) {
                    max = Math.max(max, fun(arr, i, j, m));
                }
            }
            bw.write("#" + Integer.toString(t + 1) + " " + Integer.toString(max) + "\n");
        }
        bw.flush();
    }

    private static int fun(int[][] arr, int y, int x, int m) {
        int sum = 0;
        for (int i = y; i < y + m; i++) {
            for (int j = x; j < x + m; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}