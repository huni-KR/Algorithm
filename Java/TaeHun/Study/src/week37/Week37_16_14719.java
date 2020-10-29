package week37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week37_16_14719 {

	static int sum = 0;
	static int[] grid;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] token = br.readLine().split(" ");
		int x = Integer.parseInt( token[1] );	
		grid = new int[x];

		token = br.readLine().split(" ");
		for(int i=0; i<token.length; i++)
			grid[i] = Integer.parseInt( token[i] );
		
		int result = 0;
		for(int i=1; i<grid.length-1; i++) {
			int maxL = maxLeft(i);
			int maxR = maxRight(i);
			
			int h = Math.min( maxL, maxR );
			
			if( h > grid[i] )
				result += h - grid[i];			
		}
		System.out.println( result );		
	}

	private static int maxRight(int n) {
		int max = 0;		
		for(int i=n+1; i<grid.length; i++)
			max = Math.max( max, grid[i] );		
		return max;
	}

	private static int maxLeft(int n) {
		int max = 0;		
		for(int i=n-1; i>=0; i--)
			max = Math.max( max, grid[i] );		
		return max;
	}
}