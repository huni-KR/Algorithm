package BOJ_9095;

import java.io.*;
import java.util.*;

public class BOJ_9095 {
    
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] arr = solve();

        for(int t=0; t<T; t++){
            System.out.println( arr[Integer.parseInt(br.readLine())] );
        }
    }

    private static int[] solve() {
        int[] arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i=4; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr;
    }    
}