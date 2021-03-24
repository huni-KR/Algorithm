package BOJ_20003;

import java.io.*;
import java.util.*;

public class BOJ_20003 {
    
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][2];        

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = (int)gcd((long)a, (long)b);

            a = a / gcd;
            b = b / gcd;

            arr[i][0] = a;
            arr[i][1] = b;
        }

        System.out.println( calcUp(arr) + " " + calcDown(arr) );   
    }

    private static long calcUp(long[][] arr) {
        long result = arr[0][0];        
        for(int i=1; i<arr.length; i++)
            result = gcd( result, arr[i][0]);                    
        return result;
    }

    private static long calcDown(long[][] arr) {
        long result = arr[0][1];        
        for(int i=1; i<arr.length; i++)
            result = lcm( result, arr[i][1]);                    
        return result;
    }

    private static long lcm(long a, long b) {
        return a*b/gcd(a ,b);
    }

    private static long gcd(long a, long b) {
        while(b!=0) {
            long r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
