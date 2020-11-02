import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18229 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine(), " " );
        int n = Integer.parseInt( st.nextToken() );
        int m = Integer.parseInt( st.nextToken() );
        int k = Integer.parseInt( st.nextToken() );

        int[][] grid = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer( br.readLine(), " " );
            for(int j=0; j<m; j++)
                grid[i][j] = Integer.parseInt( st.nextToken() );
        }

        int[] sum = new int[n];
        int i = 0, j = 0;
        boolean flag = true;
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                sum[j] += grid[j][i];
                if( sum[j] >= k ){
                    flag = false;
                    break;
                }   

            }
            if( !flag )
                break;
        }
        System.out.println( (j+1) + " " + (i+1) );

    }

}