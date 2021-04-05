package BOJ_12015;

import java.io.*;
import java.util.*;

public class BOJ_12015 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<Integer>();
        int n = Integer.parseInt(br.readLine());
        
        list.add(0);
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");        
        for(int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            
            if( list.get(list.size()-1) < value ){
                list.add(value);
            }else{
                int l = 1;
                int r = list.size() - 1;
                
                while( l < r ){
                    int m = ( l + r ) / 2;
                    if( list.get(m) < value ){
                        l = m + 1;
                    }else{
                        r = m;
                    }
                }
                list.set( r, value );
            }
        }
        System.out.println( list.size() - 1 );
    }
}
