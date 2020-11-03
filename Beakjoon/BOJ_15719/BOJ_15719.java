import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15719 {

	public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong( br.readLine() );
        StringTokenizer st = new StringTokenizer( br.readLine(), " " );
        
        boolean[] flag = new boolean[(int) n];
        int pos = 0;
        for(int i=0; i<n; i++){
            pos = Integer.parseInt( st.nextToken() );
            if( flag[pos] )
                break;
            flag[pos] = true; 
        }  
        System.out.println( pos );
 
    }
}