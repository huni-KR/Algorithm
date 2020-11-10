package BOJ_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int x;
    int y;

    Pos(int y, int x){
        this.x = x;
        this.y = y;
    }    
}

public class BOJ_14502 {

    static int x, y;
    static int[][] arr;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine(), " " );
        
        y = Integer.parseInt( st.nextToken() );
        x = Integer.parseInt( st.nextToken() );

        arr = new int[y][x];
        for(int i=0; i<y; i++){
            st = new StringTokenizer( br.readLine(), " " );
            for(int j=0; j<x; j++)
                arr[i][j] = Integer.parseInt( st.nextToken() );
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<x*y; i++){
            for(int j=i+1; j<x*y; j++){
                for(int k=j+1; k<x*y; k++){
                    if( arr[i/x][i%x] == 0 && arr[j/x][j%x] == 0 && arr[k/x][k%x] == 0 ){
                        arr[i/x][i%x] = 1;
                        arr[j/x][j%x] = 1;
                        arr[k/x][k%x] = 1;

                        if( i == 1 && j == 2 && k == 19)
                            max = Math.max( fun(), max );
                        max = Math.max( fun(), max );
                        
                        arr[i/x][i%x] = 0;
                        arr[j/x][j%x] = 0;
                        arr[k/x][k%x] = 0;
                    }
                }
            }
        }
        System.out.println( max );
    }

    private static int fun() {

        int[][] tmp = new int[y][x];
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                tmp[i][j] = arr[i][j];
            }
        }

        boolean[][] visit = new boolean[y][x];
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if( tmp[i][j] == 2 && !visit[i][j] ){    
                    visit[i][j] = true;            
                    bfs( tmp, visit, i, j );
                }
            }            
        }

        int count = 0;
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if( tmp[i][j] == 0 )
                    count++;
            }
        }

        return count;
    }

	private static void bfs(int[][] tmp, boolean[][] visit, int Y, int X) {

        Queue<Pos> q = new LinkedList<Pos>();
        q.add( new Pos( Y, X ) );

        while( !q.isEmpty() ){

            int size = q.size();
            for(int i=0; i<size; i++){
                Pos pos = q.poll();
                for(int dic=0; dic<4; dic++){
                    int nowX = pos.x + dx[dic];
                    int nowY = pos.y + dy[dic];

                    if( nowX < 0 || nowY < 0 || nowX >= x || nowY >= y )
                        continue;
                    
                    if( tmp[nowY][nowX] == 0 ){
                        visit[nowY][nowX] = true;
                        tmp[nowY][nowX] = 2;
                        q.add( new Pos( nowY, nowX ) );
                    }
                }
            }
        }
        

    }
    
}
