package BOJ_15486;

import java.io.*;
import java.util.*;

public class BOJ_15486 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int day = Integer.parseInt(br.readLine());
        
        int[] dp = new int[day + 50];
        
        for(int i=1; i<=day; i++){            

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            dp[i] = Math.max(dp[i - 1], dp[i]);
            dp[i + T - 1] = Math.max(dp[i + T - 1], dp[i - 1] + P);
        }

        System.out.println( dp[day]);

    }
}