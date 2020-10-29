//package bfs_dfs;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Point{
//	int x;
//	int y;
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
//
//public class BOJ_14442_N {
//
//	static int[][] grid;
//	static int[][] map;
//	static boolean[][] visitGrid;
//	static boolean[][] visitMap;
//	static int x;
//	static int y;
//	static int breaker;
//	static int[] dx = { 0, 1, 0, -1 };
//	static int[] dy = { -1, 0, 1, 0 };
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] token = br.readLine().split(" ");
//
//		x = Integer.parseInt( token[1] );
//		y = Integer.parseInt( token[0] );
//		breaker = Integer.parseInt( token[2] );
//		grid = new int[y][x];
//		map = new int[y][x];
//		visitGrid = new boolean[y][x];
//		visitMap = new boolean[y][x];
//
//		for(int i=0; i<y; i++) {
//			String str = br.readLine();
//			for(int j=0; j<x; j++) {
//				grid[i][j] = str.charAt(j) - '0';
//				map[i][j] = grid[i][j];
//			}
//		}
//
//		int result = Integer.MAX_VALUE;
//		int i = 0, j = 0, breakCounter = breaker;
//		while( true ) {
//			for(; i<y; i++) {				
//				for(j=0; j<x; j++) 
//					if( map[i][j] == 1 && breakCounter > 0 && !visitGrid[i][j] ) {
//						map[i][j] = 0;
//						breakCounter--;
//						visitGrid[i][j] = true;
//					}	
//				if( breakCounter < 1 )
//					break;
//			}
//
//			result = Math.min( BFS(), result );
//			
//			resetMap();
//			breakCounter = breaker;
//
//			if( i == y )
//				break;			
//		}		
//		System.out.println( result == Integer.MAX_VALUE ? -1 : result );
//	}
//
//	public static void resetMap() {		
//		for(int i=0; i<y; i++) 
//			for(int j=0; j<x; j++) 
//				map[i][j] = grid[i][j];
//	}
//
//	public static int BFS() {
//
//		Queue<Point> q = new LinkedList<>();
//		q.add( new Point(0, 0) );
//		visitMap[0][0] = true;
//
//		int count = 1;
//		while( !q.isEmpty() ) {
//			int size = q.size();	
//			count++;
//			for(int i=0; i<size; i++) {
//				Point p = q.poll();
//				
//				for(int dic=0; dic<4; dic++) {
//					int nowX = p.x + dx[dic];
//					int nowY = p.y + dy[dic];
//					
//					if( nowX < 0 || nowY < 0 || nowX >= x || nowY >= y )
//						continue;
//		
//					if( nowX == x-1 && nowY == y-1 ) {
//						resetVisitMap();
//						return count;
//					}
//					
//					if( map[nowY][nowX] == 1 )
//						continue;
//					
//					if( !visitMap[nowY][nowX] ) {
//						q.add( new Point( nowX, nowY) );
//						visitMap[nowY][nowX] = true;
//					}					
//				}			
//			}
//		}		
//		resetVisitMap();
//		return Integer.MAX_VALUE;
//	}
//
//	public static void resetVisitMap() {
//		for(int i=0; i<y; i++)
//			for(int j=0; j<x; j++)
//				visitMap[i][j] = false;
//	}
//}
//
//
//
//
