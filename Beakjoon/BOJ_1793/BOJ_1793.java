package BOJ_1793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1793 {
    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine() );

        if( n == 1 )
            System.out.println( 1 );
        else{
            long[] dp = new long[n+1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<dp.length; i++){
                dp[i] = dp[i-1] + dp[i-2];
                dp[i] %= 10007;
            }
    
            System.out.println( dp[n]%10007);
        }        
    }     
}
