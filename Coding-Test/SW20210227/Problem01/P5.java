import java.io.*;
import java.util.*;

public class P5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List[] list = new ArrayList[n*n+1];
        for(int i=1; i<=n*n; i++){
            list[i] = new ArrayList<Integer>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken(); 
            while(st.hasMoreTokens()){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int max = 0;
        for(int i=1; i<list.length; i++)
            for(int j=1; j<list[i].size(); j++)
                max = Math.max(max, (int)list[i].get(j));

        int[] score = new int[max+1];
        for(int i=1; i<=max; i++){            
            for(int j=1; j<max; j++){
                if( list[j].contains(i) ){
                    score[i] = Math.max(score[i], (int)list[j].get(0));
                }                
            }
        }    
        
        int sum = 0;
        for(int i=1; i<score.length; i++){
            sum += score[i];
        }
        System.out.println( sum );   
    }
}

/*
2
1 3 1 3 5
2 2 2 4
3 2 1 2
4 1 3

*/