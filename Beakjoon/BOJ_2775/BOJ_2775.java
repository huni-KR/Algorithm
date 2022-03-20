package BOJ_2775;

import java.io.*;

public class BOJ_2775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[15][15];
        for (int i = 1; i < arr[0].length; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                for (int b = 0; b <= j; b++) {
                    arr[i][j] += arr[i - 1][b];
                }
            }
        }

        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[K][N]);
        }
    }
}