package week36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Area{
	int size;
	int number;	
}

public class Week36_19_16946 {

	static int x;
	static int y;
	static int[][] grid;
	static int[][] result;
	static boolean[][] visit;
	static Area[][] area;
	static int n = 1;
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
		area = new Area[y][x];
		for(int i=0; i<y; i++) {
			String str = br.readLine();
			for(int j=0; j<x; j++) {
				grid[i][j] = (int)( str.charAt(j) - '0');
				area[i][j] = new Area();
			}
		}	
		br.close();

		for(int i=0; i<y; i++)
			for(int j=0; j<x; j++)
				if( grid[i][j] == 0 && area[i][j].size == 0 ) {
					BFS(i, j);
					n++;
				}

		for(int i=0; i<y; i++)
			for(int j=0; j<x; j++)
				if( grid[i][j] == 1 ) 
					result[i][j] = ( 1 + sum(i, j) ) % 10;				
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) 
				bw.write( Integer.toString( result[i][j] ) );
			bw.write( "\n" );
		}		
		bw.flush();
		bw.close();
	}

	public static int sum(int tmpY, int tmpX) {

		int sum = 0;
		int pos = 0;
		int[] save = { -1, -1, -1, -1 };
		for(int dic=0; dic<4; dic++) {
			int nowX = tmpX + dx[dic];
			int nowY = tmpY + dy[dic];

			if( nowX < 0 || nowY < 0 || nowX >= x || nowY >= y )
				continue;

			if( grid[nowY][nowX] == 0 ) 
				if( check( save, pos, area[nowY][nowX].number ) ) {
					save[pos++] = area[nowY][nowX].number;
					sum += area[nowY][nowX].size;
				}
		}
		return sum;
	}

	public static boolean check(int[] save, int pos, int number) {
		for(int i=0; i<pos; i++)
			if( save[i] == number )
				return false;
		return true;
	}

	public static void BFS(int tmpY, int tmpX) {

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
		visitReset();		

		q.add( new Point( tmpX, tmpY ) );
		visit[tmpY][tmpX] = true;
		area[tmpY][tmpX].number = n;
		area[tmpY][tmpX].size = count;
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
					area[nowY][nowX].number = n;
					area[nowY][nowX].size = count;
				}				
			}
		}

	}

	public static void visitReset() {
		for(int i=0; i<y; i++)
			for(int j=0; j<x; j++)
				visit[i][j] = false;
	}
}