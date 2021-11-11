package BOJ_11057;

import java.io.*;

public class BOJ_11057 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[10][n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < 10; j++) {
                    dp[j][i] = 1;
                }
            } else {
                dp[0][i] = 1;
                for (int j = 1; j < 10; j++) {
                    dp[j][i] = (dp[j][i - 1] + dp[j - 1][i]) % 10007;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[i][n - 1] % 10007;
        }
        System.out.println(result % 10007);
    }
}