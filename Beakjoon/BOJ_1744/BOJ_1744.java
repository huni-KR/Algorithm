package BOJ_1744;

import java.io.*;
import java.util.*;

public class BOJ_1744 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> m = new ArrayList<>();
        List<Integer> p = new ArrayList<>();

        int zero = 0, one = 0;
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if( tmp > 1 )   p.add(tmp);
            else if( tmp == 1 )     one++;
            else if( tmp < 0 )   m.add(tmp);
            else zero++;
        }

        Collections.sort(m);
        Collections.sort(p, Comparator.reverseOrder());

        Queue<Integer> queue = new LinkedList<>();
        int result = one;
        for(Integer tmp : p){
            queue.add(tmp);
        }

        while( queue.size() >= 2 ){
            result += queue.poll()*queue.poll();
        }
        if( queue.size() == 1 )
            result += queue.poll();

        for(Integer tmp : m){
            queue.add(tmp);
        }

        while( queue.size() >= 2 ){
            result += queue.poll()*queue.poll();
        }
        if( queue.size() == 1 && zero == 0 ){
            result += queue.poll();
        }

        System.out.println(result);

    }
}