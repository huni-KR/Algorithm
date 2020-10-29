package binarySearch;

import java.util.Scanner;

public class BOJ_1300 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		kb.close();

		long l = 1;
		long r = k;
		long result = 0;
		while( l <= r ){
			long mid = ( l + r ) / 2;
			
			long count = 0;
			for( int i=1; i<=n; i++)
				count += Math.min( mid/i, n );

			if (count < k) 
				l = mid + 1;
			else {
				result = mid; 
				r= mid - 1;
			}				
		}
		System.out.println( result );
	}
}