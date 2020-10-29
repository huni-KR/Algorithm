package week38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Week38_18_19535 {

	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int countD = 0;
	static int countG = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nV = Integer.parseInt( br.readLine() );

		visit = new boolean[nV+1];
		list = new ArrayList[nV+1];
		for(int i=0; i<list.length; i++)
			list[i] = new ArrayList<Integer>();

		String str = "";
		while( (str = br.readLine()) != null ) {
			String[] token = str.split(" ");
			int a = Integer.parseInt( token[0] );
			int b = Integer.parseInt( token[1] );

			list[a].add(b);
			list[b].add(a);
		}
		br.close();

		for(int i=1; i<nV+1; i++) {
			int size = list[i].size(); 
			if( size >= 3 )
				countG += combination( size, 3 );
		}
		
		for(int i=1; i<list.length; i++)
			if( list[i].size() == 1 )
				dfs(i, 0);
			
		countD /= 2;
						
		if( countD > countG*3 )
			System.out.print( "D" );
		else if( countD < countG*3 )
			System.out.print( "G" );
		else
			System.out.print( "DUDUDUNGA" );
	}

//	private static int find() {
//		for(int i=1; i<list.length; i++)
//			if( list[i].size() == 1 )
//				return i;
//		return -1;
//	}

	private static void dfs(int pos, int count) {
		if( !visit[pos] ) {
			visit[pos] = true;			
			count++;
			if( count >= 4 ) {
				countD++;
				count--;
			}			
			for(int i=0; i<list[pos].size(); i++)
				dfs( list[pos].get(i), count );		
		}
	}

	private static double combination(int n, int r) {
		double result = 1;
		for(int i=1; i<=n; i++) 
			result *= i;
		for(int i=1; i<=r; i++) 
			result /= i;
		for(int i=1; i<=n-r; i++) 
			result /= i;
		return result;
	}
}
