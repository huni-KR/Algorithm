

public class tailing {

    public static void main(String[] args) {

        int n = 5;

        int[] dp = new int[n + 3];

        dp[1] = 1;   
        dp[2] = 2;
               
        for(int i=3; i<=n; i++)
            dp[i] = (dp[i-2] + dp[i-1] ) % 1000000007;
            


    }

}
