package week40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Week40_03_1268 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt( br.readLine() );
		int[][] arr = new int[n][6];
		for(int i=0; i<n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++)
				arr[i][j] = Integer.parseInt( token.nextToken() );
		}	
		br.close();
				
		Set<Integer>[] set = new HashSet[n];
		for(int i=0; i<set.length; i++)
			set[i] = new HashSet<Integer>();
		for(int i=0; i<5; i++) 
			for(int j=0; j<n; j++) 
				for(int k=0; k<n; k++) 
					if( arr[j][i] == arr[k][i] && j != k )
						set[j].add(k);		
		for(int i=0; i<5; i++) 
			System.out.println( set[i].size() );
		
		
		System.out.println( fun( set ) );
	}

	private static int fun(Set<Integer>[] set) {
		
		int index = 0;
		int max = 0;
		for(int i=0; i<set.length; i++) {
			if( max < set[i].size() ) {
				max = set[i].size();
				index = i;
			}				
		}		
		return index+1;
	}
}









