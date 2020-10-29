package unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class BOJ_4195 {

	static int[] p;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt( br.readLine() );

		for(int t=0; t<T; t++) {
			int n = Integer.parseInt( br.readLine() );
			String[] str = new String[n];
			for(int i=0; i<n; i++) 
				str[i] = br.readLine();
						
			HashSet<String> set = new HashSet<>();
			for(int i=0; i<n; i++) {
				String[] token = str[i].split(" ");
				set.add( token[0] );
				set.add( token[1] );				
			}
			
			HashMap<String, Integer> map = new HashMap<>();
			int count = 0;
			for(String tmp : set) 
				map.put(tmp, count++);
			
			p = new int[count];
			for(int i=0; i<p.length; i++)
				p[i] = i;
			
			for(int i=0; i<str.length; i++) {				
				String[] token = str[i].split(" ");		
				int a = map.get(token[0]);
				int b = map.get(token[1]);	
				union( a, b );
				
				System.out.println( counter( p[a] ) );
			}						
		}		
		br.close();	
	}

	private static int counter(int n) {
		int result = 0;
		for(int i=0; i<p.length; i++)
			if( p[i] == n )
				result++;
		return result;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b) {
			int tmp = p[b];
			for(int i=0; i<p.length; i++)
				if( p[i] == tmp )
					p[i] = a;		
		}
		else {
			int tmp = p[a];
			for(int i=0; i<p.length; i++)
				if( p[i] == tmp )
					p[i] = b;
		}
	}

	private static int find(int n) {
		if(p[n] == n)
			return n;
		return p[n] = find( p[n] ); 
	}
}
