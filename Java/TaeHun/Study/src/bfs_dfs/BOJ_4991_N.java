//package bfs_dfs;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Point{
//	int x, y;
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
//
//public class BOJ_4991_N {
//
//	static int X;
//	static int Y;
//	static char[][] grid;
//	static Point robot;
//	static int trash = 0;
//	static int result = 0;
//	static int[] dx = { 0, 1, 0, -1 };
//	static int[] dy = { -1, 0, 1, 0 };
//	static boolean flag = true;
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		while( true ) {
//			String[] token = br.readLine().split(" ");
//			X = Integer.parseInt( token[0] );
//			Y = Integer.parseInt( token[1] );
//			if( X == 0 && Y == 0 )
//				break;
//
//			grid = new char[Y][X];
//
//			for(int i=0; i<Y; i++) {
//				String str = br.readLine();
//				for(int j=0; j<X; j++) {
//					grid[i][j] = str.charAt(j);
//					if( grid[i][j] == 'o' )
//						robot = new Point( i, j );
//					else if( grid[i][j] == '*' )
//						trash++;
//				}
//			}
//
//		}
//	}
//}
//
//
//
//
//
//
//
//
