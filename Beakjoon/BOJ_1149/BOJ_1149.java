package BOJ_1149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1149 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                data[i][j] = Integer.parseInt(tmp[j]);
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + data[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + data[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + data[i][2];
        }

        int min = Math.min(dp[n][0], dp[n][1]);
        min = Math.min(dp[n][2], min);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
