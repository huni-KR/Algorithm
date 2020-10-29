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
//public class BOJ_4991_2 {
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
//			int loop = trash;
//			for(int i=0; i<loop; i++) {
//				BFS( robot );
//				if( !flag )
//					break;
//			}
//			System.out.println( trash > 0 ? -1 : result );	
//			trash = 0;
//			result = 0;		
//			flag = true;
//		}		
//	}
//
//	private static void BFS(Point pos) {
//		int count = 0;
//
//		Queue<Point> q = new LinkedList<>();
//		q.add( pos );
//
//		while( !q.isEmpty() ) {
//
//			int size = q.size();
//			count++;
//			for(int i=0; i<size; i++) {
//				Point p = q.poll();
//
//				for(int dic=0; dic<4; dic++) {
//					int nowX = p.x + dx[dic];
//					int nowY = p.y + dy[dic];
//
//					if( nowX < 0 || nowY < 0 || nowX >= X || nowY >= Y )
//						continue;
//
//					if( grid[nowY][nowX] == '*' ) {
//						result += count;
//						trash--;
//						clean( nowX, nowY );
//						return;
//					}
//
//					if( grid[nowY][nowX] != '.' ) 
//						continue;
//
//					else if( grid[nowY][nowX] == '.' ) {
//						grid[nowY][nowX] = (char)count;
//						q.add( new Point( nowX, nowY ) );	
//					}
//				}				
//			}			
//		}		
//		flag = false;
//	}
//
//	private static void clean(int tmpX, int tmpY) {	
//		grid[robot.y][robot.x] = '.';
//		grid[tmpY][tmpX] = 'o';
//		robot.x = tmpX;
//		robot.y = tmpY;
//		for(int i=0; i<Y; i++) 
//			for(int j=0; j<X; j++) 
//				if( !( grid[i][j] == '.' || grid[i][j] == 'o' || grid[i][j] == 'x' || grid[i][j] == '*' ) )
//					grid[i][j] = '.';	
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
//
//
