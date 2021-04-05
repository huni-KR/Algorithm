package BOJ_1285;


import java.io.*;
import java.util.*;

public class BOJ_1285 {
    
    static int n;
    static int[] r, c;
    public static void main(String[] args) throws NumberFormatException, IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt( br.readLine() );
        boolean[][] table = new boolean[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                table[i][j] = ( str.charAt(j) == 'T' ? true : false );
            }
        }

        r = new int[n]; // y
        c = new int[n]; // x

        counterRC(table, r, c);
        
        while( true ){
            int i = 0;
            for(i=0; i<r.length; i++){
                if( n/2 < r[i] ){
                    // 뒤집기
                    turn( table, i, true );
                    counterRC(table, r, c);
                    break;
                }
                if( n/2 < c[i] ){
                    // 뒤집기
                    turn( table, i, false );
                    counterRC(table, r, c);
                    break;
                }
            }
            if( i == n ){
                break;
            } 
        }        
        System.out.println( counterTail(r, c) );
    }

    private static void turn(boolean[][] table, int pos, boolean flag) {
        for(int i=0; i<n; i++){
            if( flag ){
                table[i][pos] = !table[i][pos];
            }else{
                table[pos][i] = !table[pos][i];
            }
        }
    }

    private static int counterTail(int[] r, int[] c) {
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += r[i] + c[i];
        }
        return sum / 2;
    }


    private static void counterRC(boolean[][] table, int[] r, int[] c) {

        Arrays.fill(r, 0);
        Arrays.fill(c, 0);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if( table[i][j] ){
                    r[j]++;
                }
                if( table[j][i] ){
                    c[j]++;
                }
            }
        }
    }
}