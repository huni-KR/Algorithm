package BOJ_1339;

import java.io.*;
import java.util.*;

public class BOJ_1339 {
    
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];
        int[] arr = new int[26];
        for(int i=0; i<n; i++){
            str[i] = br.readLine();
            
            int pos = 1;
            for(int j=str[i].length()-1; j>=0; j--){
                arr[str[i].charAt(j) - 'A'] += pos;
                pos *= 10;
            }
        }

        Arrays.sort(arr);

        int num = 9, result = 0;        
        for(int i=arr.length-1; i>=0; i--){
            result += arr[i]*num--;
        }

        System.out.println(result);
    }
}
