package BOJ_4195;

import java.io.*;
import java.util.*;

public class BOJ_4195 {
    
    static int[] p;
    static int[] nodeCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            String[][] arr = new String[n][2];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                arr[i][0] = st.nextToken();
                arr[i][1] = st.nextToken();
            }
                        
            Map<String, Integer> map = new HashMap<String, Integer>();
            int count = 0;
            for(int i=0; i<n; i++){   
                if( !map.containsKey(arr[i][0]) ) map.put(arr[i][0], ++count);
                if( !map.containsKey(arr[i][1]) ) map.put(arr[i][1], ++count);                
            }            
            
            nodeCount = new int[map.size()+1];
            p = new int[map.size()+1];
            
            for(int i=1; i<p.length; i++){
                p[i] = i;
                nodeCount[i] = 1;
            }

            for(int i=0; i<n; i++){   
                System.out.println( union((int)map.get(arr[i][0]), (int)map.get(arr[i][1])) );
            }                        
        }
    }

    private static int union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if( x != y ){
            p[y] = x;
            nodeCount[x] += nodeCount[y];
            nodeCount[y] = 1;
        }
        return nodeCount[x];
    }

    private static int find(int x) {
        if (p[x] == x) {
            return x;
        } else {
            return p[x] = find(p[x]);
        }
    }
}