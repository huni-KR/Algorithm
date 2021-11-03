package BOJ_7571;

import java.io.*;
import java.util.*;

public class BOJ_7515 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dotX = new int[m];
        int[] dotY = new int[m];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            dotY[i] = Integer.parseInt(st.nextToken());
            dotX[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dotX);
        Arrays.sort(dotY);

        int posX = dotX[m/2];
        int posY = dotY[m/2];

        int move = 0;
        for(int i=0; i<m; i++){
            move += Math.abs( dotX[i] - posX );
            move += Math.abs( dotY[i] - posY );
        }       

        System.out.println( move );
    }
}