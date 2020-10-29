package week42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Week42_09_2461 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer( br.readLine(), " " );
		int y = Integer.parseInt( st.nextToken() );
		int x = Integer.parseInt( st.nextToken() );
		
		int[][] arr = new int[y][x];		
		for(int i=0; i<y; i++) {
			st = new StringTokenizer( br.readLine(), " " );
			for(int j=0; j<x; j++) 
				arr[i][j] = Integer.parseInt( st.nextToken() );
		}
		
		for(int i=0; i<y; i++)
			Arrays.sort( arr[i] );
		
		int value = Integer.MAX_VALUE;
		for(int i=0; i<x; i++) {
			for(int j=0; j<x; j++) {
				for(int k=0; k<x; k++) {
					value = fun( arr[0][i], arr[1][j], arr[2][k] );
							Math.abs( arr[0][i] - arr[1][j] );
					
					
				}
				
			}
		}
		
		System.out.println();
		
		
	}

	private static int fun(int i, int j, int k) {


		
		return 0;
	}
	
}
