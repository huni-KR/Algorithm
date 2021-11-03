

public class loadToSchool {

    public static void main(String[] args) {

        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };

        boolean[][] load = new boolean[m][n];

        for (int i = 0; i < puddles.length; i++) {
            load[puddles[i][0] - 1][puddles[i][1] - 1] = true;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < dp[0].length; i++) {
            if (!load[0][i]) {
                dp[0][i] += dp[0][i - 1];
            }
        } // x
        for (int i = 1; i < dp.length; i++) {
            if (!load[i][0]) {
                dp[i][0] += dp[i - 1][0];
            }
        } // y

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (!load[i][j]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    if (dp[i][j] > 1000000007)
                        dp[i][j] %= 1000000007;
                }
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
