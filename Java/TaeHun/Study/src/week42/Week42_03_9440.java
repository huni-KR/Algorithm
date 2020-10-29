package week42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Week42_03_9440 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		while( true ){
			StringTokenizer st = new StringTokenizer( br.readLine(), " " );

			int size = Integer.parseInt( st.nextToken() );
			if( size == 0 )
				break;

			int[] arr = new int[size];
			for(int i=0; i<arr.length; i++) 
				arr[i] = Integer.parseInt( st.nextToken() );				

			Arrays.sort( arr );

			int sumA = 0, sumB = 0;
			int counter = 0;
			for(int i=0; i<arr.length; i++) {

				if( arr[i] == 0 ) {
					counter++;
					continue;
				}	


				if( sumA < sumB ) {
					sumA *= 10;
					sumA += arr[i];
				}
				else {
					sumB *= 10;
					sumB += arr[i];
				}		
				
				while(  sumA > 0 && sumB > 0 && counter > 0 ) {
					if( sumA < sumB ) 
						sumA *= 10;
					else 
						sumB *= 10;
					counter--;
				}
			}
			System.out.println( sumA + sumB );			
		}
	}
}




















