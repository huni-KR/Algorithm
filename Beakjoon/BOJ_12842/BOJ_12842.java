package BOJ_12842;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12842 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer( br.readLine(), " " );
        int start = Integer.parseInt( st.nextToken() );
        int end = Integer.parseInt( st.nextToken() );

        int n = Integer.parseInt( br.readLine() );
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++)
            arr[i][0] = Integer.parseInt( br.readLine() );
    
        int count = 0;
        int pos = 0;
        while( start - end != count ){
            for(pos=0; pos<arr.length; pos++){
                if( arr[pos][1] == 0 ){
                    arr[pos][1] += arr[pos][0] - 1;                
                    count++;
                }
                else
                    arr[pos][1]--;
                if( start - end == count )
                    break;
            }
        }
        
        System.out.println( pos+1 );
    }    
}