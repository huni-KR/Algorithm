package BOJ_4913;

import java.io.*;
import java.util.*;

public class BOJ_4913 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] prime = findPrime();

        while( true ){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if( s == -1 && e == -1 ) break;

            int a = 0, b = 0;

            for(int i=Math.max(0, s); i<=e; i++){
                if( prime[i] ){
                    a++;
                    if( (i-1)%4 == 0 ) b++;                        
                } 
            }
            bw.write( Integer.toString(s) + " " + Integer.toString(e) + " " + Integer.toString(a) + " " + Integer.toString(b) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean[] findPrime() {
        boolean[] result = new boolean[1000001];        
 
        Arrays.fill(result, true);

        result[0] = result[1] = false;

        for(int i=2; i*i<result.length; i++) {
            for(int j=i*i; j<result.length; j+=i) {
                result[j] = false;
            }
        }
        return result;
    }
}
