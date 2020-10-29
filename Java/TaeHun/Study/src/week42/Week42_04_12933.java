package week42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week42_04_12933 {

	static int[] arr = new int[5];
	static int workingDuck = 0;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		boolean flag = true;
		for(int i=0; i<input.length(); i++) {
			int pos = charToInt( input.charAt(i) );
			if( pos == 0 )
				workingDuck++;
			else if( pos == 4 )
				workingDuck--;
			max = Math.max( workingDuck, max);		
						
			arr[pos]++;
			if( !checkOrder() ) {
				flag = false;
				break;
			}				
		}

		if( flag && isSame() )
			System.out.println( max );
		else 
			System.out.println( -1 );	
	}

	private static boolean isSame() {
		if( arr[0] == arr[1] &&
			arr[1] == arr[2] &&
			arr[2] == arr[3] &&
			arr[3] == arr[4] )
			return true;
		return false;
	}

	private static boolean checkOrder() {
		for(int i=0; i<arr.length; i++) 
			for(int j=i+1; j<arr.length; j++)
				if( arr[i] < arr[j] )
					return false;
		return true;		
	}

	private static int charToInt(char c) {
		if( c == 'q' )
			return 0;
		else if( c == 'u' )
			return 1;
		else if( c == 'a' )
			return 2;
		else if( c == 'c' )
			return 3;
		else 
			return 4;
	}
}