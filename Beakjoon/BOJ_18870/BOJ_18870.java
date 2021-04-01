package BOJ_18870;

import java.io.*;
import java.util.*;

public class BOJ_18870 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        
        long[] arr = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] tmp = Arrays.copyOf(arr, arr.length);

        Arrays.sort(tmp);

        Map<Long, Long> map = new HashMap<>();

        Long count = 0L;
        for(int i=0; i<tmp.length; i++){
            if( !map.containsKey(tmp[i]) ){
                map.put(tmp[i], count++);                
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<arr.length; i++){
            bw.write(Long.toString(map.get(arr[i])) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
