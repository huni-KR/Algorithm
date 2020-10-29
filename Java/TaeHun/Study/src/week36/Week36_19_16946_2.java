package week36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//class Point{
//	int x;
//	int y;
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}

public class Week36_19_16946_2 {

	static int x;
	static int y;
	static int[][] grid;
	static int[][] result;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] token = br.readLine().split(" ");
		x = Integer.parseInt( token[1] );
		y = Integer.parseInt( token[0] );
		grid = new int[y][x];
		result = new int[y][x];
		visit = new boolean[y][x];
		for(int i=0; i<y; i++) {
			String str = br.readLine();
			for(int j=0; j<x; j++) 
				grid[i][j] = (int)( str.charAt(j) - '0');			
		}	
		br.close();

		for(int i=0; i<y; i++)
			for(int j=0; j<x; j++)
				if( grid[i][j] == 1 )
					result[i][j] = BFS(i, j);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String output = "";
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++)
				output += Integer.toString( result[i][j] );
			output += "\n";
		}
		bw.write( output );
		bw.flush();
		bw.close();
	}
	//210.125.112.213
	public static int BFS(int tmpY, int tmpX) {

		Queue<Point> q = new LinkedList<Point>();
		q.add( new Point( tmpX, tmpY ) );			
		visit[tmpY][tmpX] = true;

		int count = 1;
		while( !q.isEmpty() ) {
			Point p = q.poll();			
			for(int dic=0; dic<4; dic++) {
				
				int nowX = p.x + dx[dic];
				int nowY = p.y + dy[dic];
				
				if( nowX < 0 || nowY < 0 || nowX >= x || nowY >= y )
					continue;
				
				if( grid[nowY][nowX] == 0 && !visit[nowY][nowX] ) {
					q.add( new Point( nowX, nowY ) );				
					visit[nowY][nowX] = true;
					count++;
				}
			}
		}
		resetVisit();
		return count%10;
	}
	
	public static void resetVisit() {
		for(int i=0; i<y; i++)
			for(int j=0; j<x; j++)
				visit[i][j] = false;
	}
}