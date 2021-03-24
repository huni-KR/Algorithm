package BOJ_7662;

import java.io.*;
import java.util.*;

public class BOJ_7662 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> que = new TreeMap<>();

            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                char operation = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());

                if( operation == 'I' ){
                    que.put(value, que.getOrDefault(value, 0) + 1);
                }else{
                    if( que.size() == 0 )
                        continue;
                    int num = value == 1 ? que.lastKey() : que.firstKey();                        
                    if( que.put(num, que.get(num) - 1 ) == 1 )
                        que.remove(num);                
                }
            }            
            System.out.println( que.size() == 0 ? "EMPTY" : que.lastKey() + " " + que.firstKey() );
        }
    }
}
