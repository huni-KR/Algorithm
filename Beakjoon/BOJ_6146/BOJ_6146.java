package BOJ_6146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_6146 {

	static int targetX;
	static int targetY;
	static int[][] grid;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int count = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine(), " " );
		targetX = 500 + Integer.parseInt(st.nextToken());
		targetY = 500 + Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		grid = new int[1001][1001];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer( br.readLine(), " " );
			grid[ 500 + Integer.parseInt(st.nextToken()) ][ 500 + Integer.parseInt(st.nextToken()) ] = Integer.MAX_VALUE;
		}
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++)
				if( grid[i][j] != Integer.MAX_VALUE )
					grid[i][j] = Integer.MAX_VALUE-10;
		}
		
		Queue<Point> q = new LinkedList<Point>();
		q.add( new Point( 500, 500 ) );
		while( !q.isEmpty() ) {
			
			int size = q.size();
			count++;
			for(int i=0; i<size; i++) {
				Point p = q.poll();
				int tmpX = p.x;
				int tmpY = p.y;
				
				if( tmpX == targetX && tmpY == targetY ) {
					System.out.println( grid[targetX][targetY] );
					return;
				}
				
				if( tmpX < 0 || tmpY < 0 || tmpX > 1000 || tmpY > 1000 )
					continue;
				
				for(int dic=0; dic<4; dic++) {
					int nowX = tmpX + dx[dic];
					int nowY = tmpY + dy[dic];
					if( grid[nowX][nowY] == Integer.MAX_VALUE )
						continue;
					
					if( grid[nowX][nowY] == Integer.MAX_VALUE - 10 ) {
						grid[nowX][nowY] = Math.min( grid[nowX][nowY], count );
						q.add( new Point( nowX, nowY ) );
					}
				}
			}
			
		}
		
		
	}

}
