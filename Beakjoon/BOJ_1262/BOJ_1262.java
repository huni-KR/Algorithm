package BOJ_1262;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int x;
    int y;
    
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BOJ_1262 {

    static int n, rSize, cSize;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine(), " " );
        n = Integer.parseInt( st.nextToken() );
        int r1 = Integer.parseInt( st.nextToken() );
        int c1 = Integer.parseInt( st.nextToken() );
        int r2 = Integer.parseInt( st.nextToken() );
        int c2 = Integer.parseInt( st.nextToken() );

        int size = 2 * n - 1;
        rSize = ( r2 - r1 + 1 );
        cSize = ( c2 - c1 + 1 );

        int rStart = n - (r1 % size) - 1;
        int cStart = n - (c1 % size) - 1;

        char[][] arr = new char[rSize*3][cSize*3];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if( (i % size) == rStart  && (j % size) == cStart)
                    arr[i][j] = 'a';
                else
                    arr[i][j] = '.';
            }
        }

        for(int i=0; i<rSize*3; i++)
            for(int j=0; j<cSize*3; j++)
                if( arr[i][j] == 'a' )
                    fun( arr, i, j); 

        for(int i=rSize+1; i<rSize*2+1; i++){
            for(int j=cSize-2; j<cSize*2-2; j++)
                System.out.print( arr[i][j] );
            System.out.println();
        }
    }

    private static void fun(char[][] arr, int y, int x) {
        Queue<Pos> q = new LinkedList<Pos>();
        q.add(new Pos(x,y));

        int count = 0;
        while( !q.isEmpty()  ){

            count++;
            int size = q.size();
            for(int i=0; i<size; i++){
                Pos pos = q.poll();
                for(int dic=0; dic<4; dic++){
                    int nowX = pos.x + dx[dic];
                    int nowY = pos.y + dy[dic];
    
                    if( nowX < 0 || nowY < 0 || nowY >= rSize*3 || nowX >= cSize*3 )
                        break;
    
                    if( arr[nowY][nowX] == '.' ) {

                        char c = (char) (arr[pos.y][pos.x] + 1);
                        if( c == '{' )
                            c = 'a';
                        arr[nowY][nowX] = c;
                        q.add( new Pos( nowX, nowY) );
                    }
                }

            }
            if( count == n - 1 )
                break;

        }
        
    }
    
}
