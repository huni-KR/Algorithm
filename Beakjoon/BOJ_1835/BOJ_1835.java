package BOJ_1835;

import java.io.*;
import java.util.*;

public class BOJ_1835 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<Integer>();

        list.add(n);
        for(int i=n-1; i>0; i--){
            list.add(0, i);
            for(int j=0; j<i; j++){
                int tmp = list.get(list.size()-1);
                list.remove(list.size()-1);                
                list.add(0, tmp);
            }            
        }

        for(int i=0; i<list.size(); i++)
            System.out.print( list.get(i) + " ");
    }
}