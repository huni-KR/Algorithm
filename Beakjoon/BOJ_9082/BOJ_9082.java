package BOJ_9082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9082 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c = Integer.parseInt( br.readLine() );
		for(int i=0; i<c; i++) {
			int n = Integer.parseInt( br.readLine() );
			int[] arrInt = new int[n];
			String str = br.readLine();
			for(int j=0; j<arrInt.length; j++) 
				arrInt[j] = str.charAt(j) - '0';

			str = br.readLine();
			char[] arrChar = new char[n];
			for(int j=0; j<arrChar.length; j++)
				arrChar[j] = str.charAt(j);

			solve( arrInt, arrChar );
			

			System.out.println( sumMine( arrChar ) + fun( arrInt ) );
		}
	}

	private static int fun(int[] arrInt) {
		int tmp = 0;
		for(int i=0; i<arrInt.length; i++)
			if( arrInt[i] != 0 )
				tmp += arrInt[i];		
		return (int)Math.ceil( tmp / 3.0 );
	}

	private static int sumMine(char[] arrChar) {
		int count = 0;
		for(int i=0; i<arrChar.length; i++)
			if( arrChar[i] == '*' )
				count++;
		return count;
	}

	private static void solve(int[] arrInt, char[] arrChar) {

		for(int i=0; i<arrInt.length; i++) {
			if( arrInt[i] == 3 )
				fixChar( i, arrChar );
			else if( arrInt[i] == 2 && ( i == 0 || i == arrInt.length-1 ) )
				fixChar( i, arrChar );
		}

		for(int i=0; i<arrChar.length; i++) 
			if( arrChar[i] == '*' )
				fixInt( i, arrInt );

		for(int i=0; i<arrInt.length; i++) 
			if( arrInt[i] == 0 && arrChar[i] == '#' ) 
				arrChar[i] = '.';

		for(int i=0; i<arrInt.length; i++) 
			if( arrInt[i] == 2 ) {
				arrChar[i] = '*';
				fixInt( i, arrInt );
			}
		
	}

	private static void fixChar(int index, char[] arrChar) {

		if( index == 0 ) {
			arrChar[index] = '*';
			arrChar[index+1] = '*';
		}
		else if( index == arrChar.length-1 ) {
			arrChar[index] = '*';
			arrChar[index-1] = '*';
		}
		else {
			arrChar[index-1] = '*';
			arrChar[index] = '*';
			arrChar[index+1] = '*';
		}
	}

	private static void fixInt(int index, int[] arrInt) {

		if( index == 0 ) {
			arrInt[index]--;
			arrInt[index+1]--;
		}
		else if( index == arrInt.length-1 ) {
			arrInt[index-1]--;
			arrInt[index]--;
		}
		else {
			arrInt[index-1]--;
			arrInt[index]--;
			arrInt[index+1]--;
		}
	}

}
