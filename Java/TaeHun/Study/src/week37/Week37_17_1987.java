package week37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week37_17_1987 {

	static int X;
	static int Y;
	static boolean[] arr = new boolean[26];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static char[][] grid;
	static int count = 0;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] token = br.readLine().split(" ");
		X = Integer.parseInt( token[1] );
		Y = Integer.parseInt( token[0] );
		grid = new char[Y][X];
		
		for(int i=0; i<Y; i++) {
			String str = br.readLine();
			for(int j=0; j<X; j++) 
				grid[i][j] = str.charAt(j);
		}	
		
		DFS( 0, 0 );		
		System.out.println( result );
	}

	private static void DFS(int x, int y) {

		if( arr[grid[y][x] - 'A'] )
			return;
		arr[ grid[y][x] - 'A' ] = true;
		result = Math.max( result, ++count );	
		
		for(int dic=0; dic<4; dic++) {			
			int nowX = x + dx[dic];
			int nowY = y + dy[dic];
			
			if( nowX < 0 || nowY < 0 || nowX >= X || nowY >= Y )
				continue;
			
			DFS(nowX, nowY);			
		}		
		arr[ grid[y][x] - 'A' ] = false;
		count--;
	}
}
