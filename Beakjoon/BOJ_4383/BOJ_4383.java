package BOJ_4383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4383 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "";
        while( (str = br.readLine()) != null ){
            StringTokenizer st = new StringTokenizer( str, " " );
            int n = Integer.parseInt( st.nextToken() );
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt( st.nextToken() );
            
            boolean[] check = new boolean[n];
            for(int i=0; i<n-1; i++){
                int num = Math.abs( arr[i] - arr[i+1] );
                if( num < check.length )
                    check[num] = true;
            }

            boolean flag = fun( check );

            System.out.println( flag ? "Jolly" : "Not jolly");
        }
        br.close();
    }

    private static boolean fun(boolean[] check) {

        for(int i=1; i<check.length; i++)
            if( !check[i] )
                return false;

        return true;
    }
}
