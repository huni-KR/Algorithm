import java.io.*;
import java.util.*;

public class P01 {

    static int index;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(st.nextToken(), ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        int limit = h * 3600 + m * 60 + s;

        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            st = new StringTokenizer(br.readLine(), ":");
            arr[i] = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        }

        fun(limit, arr);

        System.out.println( max + " " + index );
    }

    private static void fun(int limit, int[] arr) {

        for(int i=0; i<arr.length; i++){
            int count = 0;
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                if( sum >= limit )
                    break;
                count++;
                sum += arr[j];
            }
            if( max < count ){
                index = i+1;
                max = count;
            }  
        }
    }
}