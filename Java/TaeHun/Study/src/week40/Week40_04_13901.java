package week40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Week40_04_13901 {

	static int X;
	static int Y;
	static int[][] grid;	
	static int[] path; 
	static Point robot;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int count = 0;
	static boolean flag = true;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine(), " " );
		Y = Integer.parseInt( st.nextToken() );
		X = Integer.parseInt( st.nextToken() );
		grid = new int[Y][X];
		path = new int[4];
		for(int i=0; i<Y; i++)
			for(int j=0; j<X; j++)
				grid[i][j] = -1; 

		int n = Integer.parseInt( br.readLine() );
		for(int i=0; i<n; i++) {
			st = new StringTokenizer( br.readLine(), " " );
			grid[Integer.parseInt( st.nextToken() )][Integer.parseInt( st.nextToken() )] = Integer.MAX_VALUE;
		}
		st = new StringTokenizer( br.readLine(), " " );
		robot = new Point( Integer.parseInt( st.nextToken() ), Integer.parseInt( st.nextToken() ) );
		grid[robot.y][robot.x] = count++;		

		st = new StringTokenizer( br.readLine(), " " );
		for(int i=0; i<path.length; i++)
			path[i] = Integer.parseInt( st.nextToken() ) - 1;		
		br.close();

		fun();

		System.out.println( robot.y + " " + robot.x );		
	}

	private static void fun() {

		int dic = 0;
		int tmp = 0;
		while( flag ) {
			int nowX = robot.x + dx[path[dic%4]];
			int nowY = robot.y + dy[path[dic%4]];
			
			if( nowX < 0 || nowY < 0 || nowX >= X || nowY >= Y ) {
				dic++;
				tmp++;
				if( tmp == 4 )
					flag = false;
				continue;
			}
			
			if( grid[nowY][nowX] == -1 ) {
				grid[nowY][nowX] = count++;
				robot.x = nowX;
				robot.y = nowY;
				tmp = 0;
				continue;
			}			
			dic++;	
			tmp++;
			if( tmp == 4 )
				flag = false;
		}
		
	}
}






