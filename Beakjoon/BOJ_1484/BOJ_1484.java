package BOJ_1484;

import java.io.*;
import java.util.*;

public class BOJ_1484 {
    
    static List<Long> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Long.parseLong(br.readLine());
        list = new ArrayList<Long>();
        solve( G );

        Collections.sort( list );
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if( list.isEmpty() ){
            bw.write("-1");
        }else{
            for(long i : list){
                bw.write(Long.toString(i) + "\n");
            }            
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solve(long G) {
        long start = 1, end = 1;
        while( end <= 50001 ){
            if( Math.pow(end, 2) - Math.pow(start, 2) == G ){
                list.add(end);
            }
            if( Math.pow(end, 2) - Math.pow(start, 2) <= G ){
                end++;
            }else{
                start++;
            }
        }        
    }
}
