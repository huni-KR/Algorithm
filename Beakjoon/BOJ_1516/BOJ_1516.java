package BOJ_1516;

import java.io.*;
import java.util.*;

public class BOJ_1516 {
    
    public static void main(String[] args) throws IOException {

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());

        for(int i=1; i<20; i++){
            System.out.println( i + " : " + f(i));    
        }
        
        System.out.println(f(3));
        System.out.println(f(4));

    }

    private static int f(int i) {
        if( i%2 == 1 )
            return (i++);
        else
            return f(f(i-1));
    }
}
