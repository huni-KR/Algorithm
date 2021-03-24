import java.io.*;
import java.util.*;

public class P02 {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long[] arr = new long[n];
        long[] result = new long[n];

        for(int i=0; i<n; i++){
            arr[i] = str.charAt(i) - '0';
        }

        if( arr[1] == 1 && arr[2] == 1 ){
            result[1] = 1;
            result[2] = 2;            
        }else if( arr[1] == 1 && arr[2] == 0 ){
            result[1] = 1;
            result[2] = 0;
        }else if( arr[1] == 0 && arr[2] == 1 ){
            result[1] = 0;
            result[2] = 1;
        }

        for(int i=3; i<n; i++){
            if( arr[i] == 1 ){
                result[i] = result[i-2] + result[i-1];
            }
        }
        System.out.println( result[arr.length-1] );
    }
}