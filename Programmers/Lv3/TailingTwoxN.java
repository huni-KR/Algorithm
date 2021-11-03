package Lv3;

public class TailingTwoxN {

    public static void main(String[] args) {
        int n = 4;

        Solution s = new Solution();
        System.out.println(s.solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int[] dp = new int[n + 3];

            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++)
                dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
            return dp[n];
        }
    }
}
