import java.io.*;
import java.util.*;

public class P2 {

    static int p, n, h;
    static int[] result;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        p = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        result = new int[p+1];
        list = new ArrayList[p+1];        
        for(int i=1; i<list.length; i++)
            list[i] = new ArrayList();
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int pc = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());

            if( h >= hour )
                list[pc].add(hour);
        }

        clac();

        for(int i=1; i<result.length; i++){
            System.out.println(i + " " + result[i]);
        }        
    }

    static void clac(){
        for(int i=1; i<result.length; i++){
            int max = 0;
            for(List j : list){
                                
            }
            result[i] = max * 1000;
        }
    }
}


/*
2 7 4
1 10
1 5
1 7
2 10
2 1
2 3
2 7
*/

/*
1 0
2 4000
*/