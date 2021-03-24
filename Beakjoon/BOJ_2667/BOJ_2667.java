package BOJ_2667;

import java.io.*;
import java.util.*;

class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BOJ_2667 {
    
    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int max = 0;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++)
                arr[i][j] = str.charAt(j) - '0';
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                max = 0;
                if( arr[i][j] == 1 && !visit[i][j]){
                    BFS(i, j);
                    list.add(max);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i : list){
            System.out.println(i);
        }
    }

    private static void BFS(int i, int j) {
        visit[i][j] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(j, i));

        while( !q.isEmpty() ){
            Point p = q.poll();
            max++;
            for(int dic=0; dic<4; dic++){
                int nx = p.x + dx[dic];
                int ny = p.y + dy[dic];

                if( nx < 0 || ny < 0 || nx >= n || ny >= n ){
                    continue;
                }

                if( arr[ny][nx] !=0 && !visit[ny][nx] ){
                    visit[ny][nx] = true;
                    arr[ny][nx] = Math.max(max, arr[ny][nx]);
                    
                    q.add(new Point(nx, ny));
                }
            }   
        }
        
    }
}
