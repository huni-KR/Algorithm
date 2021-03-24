package BOJ_1463;

import java.io.*;
import java.util.*;

public class BOJ_1463 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+10];
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for(int i=4; i<arr.length; i++){
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            
            a = arr[i-1]+1;

            if( i%2 == 0 ){
                b = arr[i/2]+1;
            }
            
            if( i%3 == 0 ){
                c = arr[i/3]+1;
            }
            
            arr[i] = calc(a, b, c);
        }

        System.out.println(arr[n]);
    }

    private static int calc(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

}
