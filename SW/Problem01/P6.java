import java.io.*;
import java.util.*;

public class P6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(divide(arr, 0, arr.length/2, arr.length));
    }

    private static int divide(int[] arr, int l, int m, int r) {
        
        if( Math.abs(l-r) == 1){
            return 0;
        }

        int leftSum = calc(arr, l, m);
        int rightSum = calc(arr, m, r);

        if( leftSum > rightSum ){
            return leftSum + divide(arr, m, (m+r)/2, r);
        }else{
            return rightSum + divide(arr, l, m/2, m);
        }        
    }

    private static int calc(int[] arr, int start, int end) {
        int max = 0;
        for(int i=start; i<end; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}

/*
8
1 3 10 9 6 2 3 2

*/