package BOJ_11726;

import java.io.*;

public class BOJ_11726 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        if (n == 1) {
            System.out.println(1);
        }else if( n == 2){
            System.out.println(2);
        } else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
            }
            System.out.println(dp[n] % 10007);
        }
    }
}
