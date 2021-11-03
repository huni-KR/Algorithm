package BOJ_10703;

import java.io.*;
import java.util.*;

public class BOJ_10703 {
    
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] arr = new char[y][x];
        int[][] pos = new int[2][x];
        Arrays.fill(pos[0], Integer.MIN_VALUE);
        Arrays.fill(pos[1], arr.length);

        for(int i=0; i<y; i++){
            String str = br.readLine();
            for(int j=0; j<x; j++){
                arr[i][j] = str.charAt(j);
                if( arr[i][j] == 'X' ) pos[0][j] = i+1;
                else if( arr[i][j] == '#' ) pos[1][j] = Math.min(pos[1][j], i);
            }
        }
        br.close();

        int diff = findDiff( pos );
        move( arr, diff );

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                bw.write( arr[i][j] );
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void move(char[][] arr, int diff) {
        for(int i=arr.length-1; i>=0; i--){
            for(int j=0; j<arr[0].length; j++){
                if( arr[i][j] == 'X' ){
                    arr[i+diff][j] = 'X';
                    arr[i][j] = '.';
                }
            }
        }
    }

    private static int findDiff(int[][] pos) {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<pos[0].length; i++)
            result = Math.min( result, Math.abs( pos[0][i] - pos[1][i] ) );
        return result;
    }
}
