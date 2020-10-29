package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1976 {

	static int[] p;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int nV = Integer.parseInt( br.readLine() );
		int n = Integer.parseInt( br.readLine() );
		
		p = new int[nV+1];
		for(int i=1; i<=p.length; i++)
			p[i] = i;
		
		for(int i=1; i<=nV; i++) {
			String[] token = br.readLine().split(" ");			
			for(int j=1; j<=token.length; j++) 
				if( i > j && token[j].equals("1") ) 
					union( i, j );
		}
		
		int[] way = new int[n];
		String[] token = br.readLine().split(" ");
		for(int i=0; i<way.length; i++) 
			way[i] = Integer.parseInt( token[i] );

		boolean flag = true;
		for(int i=1; i<way.length; i++) 
			if( find(way[i-1])!= find(way[i]) ) 
				flag = false;
		
		System.out.println( flag ? "YES" : "NO" );		
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if( a < b )
			p[b] = a;
		else
			p[a] = b;		
	}
	
	private static int find(int n) {
		if(p[n] == n)
			return n;
		return p[n] = find( p[n] ); 
	}
}
