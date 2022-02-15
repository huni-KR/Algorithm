package BOJ_11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727 {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(3);
        } else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 3;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = dp[i - 1] % 10007 + (2 * dp[i - 2]) % 10007;
            }
            System.out.println(dp[n] % 10007);
        }
    }
}
